package com.juliannunez.notasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    EditText eExp, ePra, ePro;
    Button bSave, bLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        eExp = (EditText)findViewById(R.id.eExpo1);
        ePro = (EditText)findViewById(R.id.eProy1);
        ePra = (EditText)findViewById(R.id.ePrac1);
        bSave = (Button)findViewById(R.id.bCalcular1);
        bLimpiar = (Button)findViewById(R.id.Limpiar2);

        Bundle extras = getIntent().getExtras();

        eExp.setText(String.valueOf(extras.getInt("pExp")));
        ePra.setText(String.valueOf(extras.getInt("pPrac")));
        ePro.setText(String.valueOf(extras.getInt("pProy")));

        bLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eExp.setText("");
                ePra.setText("");
                ePro.setText("");
            }
        });

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dato1, dato2, dato3;

                if (ePra.getText().toString().equals("") || eExp.getText().toString().equals("") || ePro.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    dato1 = Integer.parseInt(ePra.getText().toString());
                    dato2 = Integer.parseInt(eExp.getText().toString());
                    dato3 = Integer.parseInt(ePro.getText().toString());

                    if (dato1 + dato2 + dato3 != 100) {

                        Toast.makeText(getApplicationContext(), "Los valores ingresados no suman 100%", Toast.LENGTH_SHORT).show();
                    } else {

                        Intent i = new Intent();
                        i.putExtra("prPro", ePro.getText().toString());
                        i.putExtra("prExpo", eExp.getText().toString());
                        i.putExtra("prPrac", ePra.getText().toString());
                        setResult(RESULT_OK, i);
                        finish();
                    }
                }
            }
        });

    }
}
