package com.example.basketballscoretablemvc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //先写一遍纯mvc
    TextView textScoreTeamA,textScoreTeamB;
    Button buttonAdd1TeamA,buttonAdd2TeamA,buttonAdd3TeamA,
            buttonAdd1TeamB,buttonAdd2TeamB,buttonAdd3TeamB;
    int UiDataTeamA,UiDataTeamB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //findview非常麻烦，稍有疏漏有可能就需要排查半天，因为报错有可能是五花八门的，但是其实只是find没找到
        buttonAdd1TeamA =findViewById(R.id.buttonAdd1TeamA);
        buttonAdd2TeamA =findViewById(R.id.buttonAdd2TeamA);
        buttonAdd3TeamA =findViewById(R.id.buttonAdd3TeamA);
        buttonAdd1TeamB =findViewById(R.id.buttonAdd1TeamB);
        buttonAdd2TeamB =findViewById(R.id.buttonAdd2TeamB);
        buttonAdd3TeamB =findViewById(R.id.buttonAdd3TeamB);
        textScoreTeamA = findViewById(R.id.textTeamA);
        textScoreTeamB = findViewById(R.id.textTeamB);
        UiDataTeamA=0;
        UiDataTeamB=0;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textScoreTeamA.setText(String.valueOf(0));
        textScoreTeamB.setText(String.valueOf(0));
        buttonAdd1TeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiDataTeamA++;
                textScoreTeamA.setText(String.valueOf(UiDataTeamA));
            }
        });
        buttonAdd2TeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiDataTeamA+=2;
                textScoreTeamA.setText(String.valueOf(UiDataTeamA));
            }
        });
        buttonAdd3TeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiDataTeamA+=3;
                textScoreTeamA.setText(String.valueOf(UiDataTeamA));
            }
        });
        buttonAdd1TeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiDataTeamB++;
                textScoreTeamB.setText(String.valueOf(UiDataTeamB));
            }
        });
        buttonAdd2TeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiDataTeamB+=2;
                textScoreTeamB.setText(String.valueOf(UiDataTeamB));
            }
        });
        buttonAdd3TeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiDataTeamB+=3;
                textScoreTeamB.setText(String.valueOf(UiDataTeamB));
            }
        });
    }
}