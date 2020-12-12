package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button vissza,reg;
    EditText etJelszo,etFelhasznalo,etEmail,etTeljesnev;

    public static dbhelper adatbazis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean kitoltve = true;
                if (etEmail.getText().toString().trim().length() == 0) {
                    etEmail.setError("Adjon meg e-mailt!");
                    toast("e-mail");
                    kitoltve = false;
                    return;
                } else if (etFelhasznalo.getText().toString().trim().length() == 0) {
                    etFelhasznalo.setError("Adjon meg felhasználónevet!");
                    toast("felhasználónév");
                    kitoltve = false;
                    return;
                } else if (etJelszo.getText().toString().trim().length() == 0) {
                    etJelszo.setError("Adjon meg jelszót!");
                    toast("jelszó");
                    kitoltve = false;
                    return;
                } else if (etTeljesnev.getText().toString().trim().length() == 0) {
                    etTeljesnev.setError("Adja meg a teljes nevét!");
                    toast("teljes név");
                    kitoltve = false;
                    return;
                }

                if (kitoltve) {
                    etEmail.getText().clear();
                    etFelhasznalo.getText().clear();
                    etJelszo.getText().clear();
                    etTeljesnev.getText().clear();
                    if (adatbazis.regisztracio( etEmail.getText().toString(),
                            etFelhasznalo.getText().toString(),
                            etJelszo.getText().toString(),
                            etTeljesnev.getText().toString())) {
                        toastSikertelen();
                    } else {
                        toastSikeres();
                    }


                }
            }
        });
        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visszaActivityre = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(visszaActivityre);
                finish();
            }
        });
    }

    private void init() {
        vissza=findViewById(R.id.vissza);
        reg=findViewById(R.id.registracio);
        etFelhasznalo = findViewById(R.id.et_Felhasznalonev);
        etJelszo = findViewById(R.id.et_Jelszo);
        etEmail = findViewById(R.id.et_Email);
        etTeljesnev = findViewById(R.id.et_Teljesnev);
        adatbazis = new dbhelper(RegisterActivity.this);

    }
    public void toast(String hiba) {
        Toast.makeText(this, "Kötelező a(z) " + hiba + " megadása!", Toast.LENGTH_SHORT).show();
    }

    public void toastSikeres() {
        Toast.makeText(this, "Sikeres regisztráció", Toast.LENGTH_SHORT).show();
    }

    public void toastSikertelen() {
        Toast.makeText(this, "Sikertelen regisztráció", Toast.LENGTH_SHORT).show();
    }
}