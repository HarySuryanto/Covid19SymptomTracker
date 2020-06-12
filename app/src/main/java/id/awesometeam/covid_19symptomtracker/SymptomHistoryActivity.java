package id.awesometeam.covid_19symptomtracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SymptomHistoryActivity extends AppCompatActivity {

    String[] data_id;
    protected Cursor cursor;
    DataHelper dbHelper;

    // For custom listView layout
    ListView listView;
    SimpleAdapter adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] day; //deklarasi judul iem
    String[] month_year; //deklarasi keterangan item
    String[] probability; //deklarasi image item

    SymptomHistoryActivity sha = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_history);

        listView = findViewById(R.id.listView);
        dbHelper = new DataHelper(this);

        // dbHelper.insertDummyData();
        showList();
    }

    public void showList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + DataHelper.TABLE_NAME, null);

        data_id = new String[cursor.getCount()];
        day = new String[cursor.getCount()];
        month_year = new String[cursor.getCount()];
        probability = new String[cursor.getCount()];

        cursor.moveToFirst();
        for (int cc=0; cc<cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);

            String day_only = cursor.getString(4).substring(8, 10);
            String month_only = cursor.getString(4).substring(5, 7);
            String year_only = cursor.getString(4).substring(2, 4);

            data_id[cc] = cursor.getString(0);
            day[cc] = day_only;
            month_year[cc] = month_only + "/" + year_only;

            int demam_score = (cursor.getString(1).equals("true")) ? dbHelper.DEMAM_SCORE : 0;
            int batuk_kering_score = (cursor.getString(2).equals("true")) ? dbHelper.BATUK_KERING_SCORE : 0;
            int sesak_napas_score = (cursor.getString(3).equals("true")) ? dbHelper.SESAK_NAPAS_SCORE : 0;

            int result = demam_score + batuk_kering_score + sesak_napas_score;
            probability[cc] = result + "%";
        }

        mylist = new ArrayList<HashMap<String, String>>();

        for (int i=0; i<day.length; i++) {
            map = new HashMap<String, String>();
            map.put("day", day[i]);
            map.put("month_year", month_year[i]);
            map.put("probability", probability[i]);
            mylist.add(map);
        }

        adapter = new SimpleAdapter(this, mylist, R.layout.item_list, new String[]{ "day", "month_year", "probability" }, new int[]{ R.id.day, R.id.month_year, R.id.probability });
        listView.setAdapter(adapter);

        listView.setSelected(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                final String id = data_id[i];
                final CharSequence[] dialogitem = {"Lihat", "Ubah", "Hapus"};

                AlertDialog.Builder builder = new AlertDialog.Builder(SymptomHistoryActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                // Akan memanggil activity detail data
                                Intent intent_detail = new Intent(getApplicationContext(), DetailSymptomHistoryActivity.class);
                                intent_detail.putExtra("id", id);
                                startActivity(intent_detail);
                                break;
                            case 1:
                                // Akan memanggil activity update data
                                Intent intent_update = new Intent(getApplicationContext(), SymptomHistoryEditActivity.class);
                                intent_update.putExtra("id", id);
                                startActivity(intent_update);
                                break;
                            case 2:
                                // Akan menghapus data
                                dbHelper.delete(id);
                                Toast.makeText(getApplicationContext(), "Data dihapus", Toast.LENGTH_SHORT).show();
                                showList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        showList();
    }

}