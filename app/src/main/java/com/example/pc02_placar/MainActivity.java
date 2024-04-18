package com.example.pc02_placar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int team;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        Desativa o botão de último ponto no início
        Button btnLastPoint = (Button) findViewById(R.id.btnLastPoint);
        btnLastPoint.setEnabled(false);

//        Atribui cada variável ao ser valor
        TextView tvScore1 = (TextView) findViewById(R.id.tvScore1);
        TextView tvScore2 = (TextView) findViewById(R.id.tvScore2);
        Button btnFreeThrow1 = (Button) findViewById(R.id.btnFreeThrow1);
        Button btnFreeThrow2 = (Button) findViewById(R.id.btnFreeThrow2);
        Button btnTwoPoints1 = (Button) findViewById(R.id.btnTwoPoints1);
        Button btnTwoPoints2 = (Button) findViewById(R.id.btnTwoPoints2);
        Button btnThreePoints1 = (Button) findViewById(R.id.btnThreePoints1);
        Button btnThreePoints2 = (Button) findViewById(R.id.btnThreePoints2);

        tvScore1.setText(String.format("%02d", 0));
        tvScore2.setText(String.format("%02d", 0));

        btnFreeThrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(tvScore1.getText().toString()) + 1;
                tvScore1.setText(String.format("%02d", score));
                btnLastPoint.setEnabled(true);
                points = 1;
                team = 1;
            }
        });
        btnFreeThrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(tvScore2.getText().toString()) + 1;
                tvScore2.setText(String.format("%02d", score));
                btnLastPoint.setEnabled(true);
                points = 1;
                team = 2;
            }
        });
        btnTwoPoints1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(tvScore1.getText().toString()) + 2;
                tvScore1.setText(String.format("%02d", score));
                btnLastPoint.setEnabled(true);
                points = 2;
                team = 1;
            }
        });
        btnTwoPoints2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(tvScore2.getText().toString()) + 2;
                tvScore2.setText(String.format("%02d", score));
                btnLastPoint.setEnabled(true);
                points = 2;
                team = 2;
            }
        });
        btnThreePoints1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(tvScore1.getText().toString()) + 3;
                tvScore1.setText(String.format("%02d", score));
                btnLastPoint.setEnabled(true);
                points = 3;
                team = 1;
            }
        });
        btnThreePoints2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(tvScore2.getText().toString()) + 3;
                tvScore2.setText(String.format("%02d", score));
                btnLastPoint.setEnabled(true);
                points = 3;
                team = 2;
            }
        });
        btnLastPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score;
                if (team == 1) {
                    score = Integer.parseInt(tvScore1.getText().toString()) - points;
                    tvScore1.setText(String.format("%02d", score));
                } else {
                    score = Integer.parseInt(tvScore2.getText().toString()) - points;
                    tvScore2.setText(String.format("%02d", score));
                }
                btnLastPoint.setEnabled(false);
            }
        });
    }
}