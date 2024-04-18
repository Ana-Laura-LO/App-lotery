package com.example.applotery;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import com.google.android.material.internal.EdgeToEdgeUtils;

public class MainActivity extends AppCompatActivity {

    private boolean isNumerosVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonDisplay = findViewById(R.id.button_display);
        buttonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirNumeros();
            }
        });
    }
    public void exibirNumeros() {
        TextView Number1 = findViewById(R.id.Number1);
        TextView Number2 = findViewById(R.id.Number2);
        TextView Number3 = findViewById(R.id.Number3);
        TextView Number4 = findViewById(R.id.Number4);
        TextView Number5 = findViewById(R.id.Number5);
        TextView Number6 = findViewById(R.id.Number6);

        Numbers numeros = new Numbers();

        numeros.createNumbers(Number1, Number2, Number3, Number4, Number5, Number6);

    }

}

