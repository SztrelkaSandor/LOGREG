package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button belep,regisztral;
    EditText etFelhasznalo,etJelszo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        belep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean kitoltve = true;
                if (etFelhasznalo.getText().toString().trim().length() == 0) {
                    etFelhasznalo.setError("Adja meg a felhasználót helyesen!");
                    toast("felhasználó");
                    kitoltve = false;
                    return;
                } else if (etJelszo.getText().toString().trim().length() == 0) {
                    etFelhasznalo.setError("Adja meg a jelszót helyesen!");
                    toast("jelszó");
                    kitoltve = false;
                    return;

                }
                if (kitoltve) {

                    etFelhasznalo.getText().clear();
                    etJelszo.getText().clear();

                    if (RegisterActivity.adatbazis.login(etFelhasznalo.getText().toString(),
                            etJelszo.getText().toString())){
                        toastSikertelen();
                    } else {
                        Intent logActivityre = new Intent(MainActivity.this, LoggedInActivity.class);
                        startActivity(logActivityre);
                        finish();
                        toastSikeres();
                    }


                }
            }
        });

        regisztral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regActivityre = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(regActivityre);
                finish();
            }
        });
    }

    private void init() {
    belep=findViewById(R.id.logingomb);
    regisztral=findViewById(R.id.reggomb);
    etFelhasznalo = findViewById(R.id.felhasznalo);
    etJelszo = findViewById(R.id.jelszo);

    }
    public void toast(String hiba) {
        Toast.makeText(this, "Kötelező a(z) " + hiba + " megadása!", Toast.LENGTH_SHORT).show();
    }

    public void toastSikeres() {
        Toast.makeText(this, "Sikeres bejelentkezés", Toast.LENGTH_SHORT).show();
    }

    public void toastSikertelen() {
        Toast.makeText(this, "Sikertelen sikertelen bejelentkezés", Toast.LENGTH_SHORT).show();
    }
}