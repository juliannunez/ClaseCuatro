package com.juliannunez.colombia_turistica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Usuario on 03/04/2016.
 */
public class TuristicoActivity extends AppCompatActivity {

    Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.turisticos);

        atras = (Button)findViewById(R.id.atras1);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                setResult(RESULT_OK, i);
                finish();

            }
        });
    }
}
