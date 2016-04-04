package com.juliannunez.notasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText eExpo, eProy, eNotafinal, eLab;
    Button bCalcular, bLimpiar;
    int notaExpo, notaPra, notaPro;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eExpo = (EditText)findViewById(R.id.eExpo);
        eProy = (EditText)findViewById(R.id.eProy);
        eNotafinal = (EditText)findViewById(R.id.eFinal);
        eLab = (EditText)findViewById(R.id.ePrac);
        bCalcular = (Button)findViewById(R.id.bCalcular);
        bLimpiar = (Button)findViewById(R.id.Limpiar1);
        display = (TextView)findViewById(R.id.prueba);
        notaExpo = 15;
        notaPra = 50;
        notaPro = 35;

        display.setText(getResources().getString(R.string.expo)+" = "+notaExpo+"%"+getResources().getString(R.string.practicas)+" = "+notaPra+"%"+ getResources().getString(R.string.proyecto)+" = "+notaPro+"%");

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double exp, prac, pro, nfinal;

                if (eExpo.getText().toString().equals("") || eProy.getText().toString().equals("") || eLab.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "@string/error1", Toast.LENGTH_SHORT).show();
                } else {

                    exp = Double.parseDouble(eExpo.getText().toString());
                    prac = Double.parseDouble(eLab.getText().toString());
                    pro = Double.parseDouble(eProy.getText().toString());

                    if ((exp < 0 || exp > 5) || (prac < 0 || prac > 5) || (pro < 0 || pro > 5)) {

                        Toast.makeText(getApplicationContext(), "El rango de notas debe ir de 0 a 5", Toast.LENGTH_LONG).show();
                    } else {

                        nfinal = exp * (notaExpo / 100) + prac * (notaPra / 100) + pro * (notaPro / 100);

                        eNotafinal.setText(String.valueOf(nfinal));
                    }

                }
            }
        });

        bLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eExpo.setText("");
                eLab.setText("");
                eProy.setText("");
                eNotafinal.setText("");
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_configurar){
            Toast.makeText(this, "Ha presionado opcion configurar", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,SettingsActivity.class);
            i.putExtra("pProy", notaPro);
            i.putExtra("pExp", notaExpo);
            i.putExtra("pPrac", notaPra);
            startActivityForResult(i, 1234);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK){

            String proy,e,prac;

            proy = data.getExtras().getString("prPro");
            e = data.getExtras().getString("prExpo");
            prac = data.getExtras().getString("prPrac");
            notaExpo = Integer.parseInt(e);
            notaPro = Integer.parseInt(proy);
            notaPra = Integer.parseInt(prac);
            display.setText(getResources().getString(R.string.expo) + " = " + notaExpo + "%" + getResources().getString(R.string.practicas) + " = " + notaPra + "%" + getResources().getString(R.string.proyecto) + " = " + notaPro + "%");

        }
    }
}
