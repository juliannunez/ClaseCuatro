package com.juliannunez.colombia_turistica;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ViewPager slider;
    TextView textoppal;
    Adaptador_deSlider adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slider = (ViewPager) findViewById(R.id.view_pager);
        adaptador = new Adaptador_deSlider(this);
        textoppal = (TextView) findViewById(R.id.ppal);
        textoppal.setMovementMethod(new ScrollingMovementMethod());

        slider.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_turisticos) {
            Intent i = new Intent(this, TuristicoActivity.class);
            startActivityForResult(i, 1235);
            return true;
        }
        if (id == R.id.menu_bares) {
            Intent i = new Intent(this, BarActivity.class);
            startActivityForResult(i, 1236);
            return true;
        }
        if (id == R.id.menu_hoteles) {
            Intent i = new Intent(this, HotelActivity.class);
            startActivityForResult(i, 1237);
            return true;
        }
        if(id == R.id.menu_demografico){
            Intent i = new Intent(this, DemografiaActivity.class);
            startActivityForResult(i, 1238);
            return true;

        }
        if(id == R.id.acercade){
            Intent i = new Intent(this, AcercaActivity.class);
            startActivityForResult(i, 1239);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1235 && resultCode == RESULT_OK) {

        }
        if (requestCode == 1236 && resultCode == RESULT_OK) {


        }
        if (requestCode == 1237 && resultCode == RESULT_OK) {


        }
        if (requestCode == 1238 && resultCode == RESULT_OK) {


        }
        if (requestCode == 1239 && resultCode == RESULT_OK) {


        }
    }
}
