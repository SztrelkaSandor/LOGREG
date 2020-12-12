package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class LoggedInActivity extends AppCompatActivity {
    //public SQLiteDatabase db;
    Button kilep;
    TextView nev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
    init();
        kilep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kilepActivityre = new Intent(LoggedInActivity.this, MainActivity.class);
                startActivity(kilepActivityre);
                finish();
            }
        });
        /*public void onSelect(SQLiteDatabase db, int i, int i1) {
            String sql = "SELECT '"+teljesnev+"' FROM felhasznalo WHERE name = '"+nev+"'";
            db.execSQL(sql);
            onCreate(db);
        }

        Cursor c = db.rawQuery("SELECT '"+teljesnev+"' FROM felhasznalo WHERE name = '"+nev+"'", null);

        c.moveToNext();

        nev.setText(c.getString(c.getColumnIndex("teljesnev")));

    */
    }

    private void init() {
        kilep=findViewById(R.id.kilepes);
        nev=findViewById(R.id.felhasznaloNeve);

    }
}