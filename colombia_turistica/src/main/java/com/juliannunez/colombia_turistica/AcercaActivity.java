package com.juliannunez.colombia_turistica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Usuario on 04/04/2016.
 */
public class AcercaActivity extends AppCompatActivity {

    Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.probando);

        atras = (Button)findViewById(R.id.atras4);

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
