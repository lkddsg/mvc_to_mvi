package com.example.basketballscoretablemvp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

//import com.example.basketballscoretable.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;
    private TextView textTeamA, textTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //p和v的联系
        presenter = new MainPresenter(this);

        textTeamA = findViewById(R.id.textTeamA);
        textTeamB = findViewById(R.id.textTeamB);

        findViewById(R.id.buttonAdd1TeamA).setOnClickListener(v -> presenter.addScoreToATeam(1));
        findViewById(R.id.buttonAdd2TeamA).setOnClickListener(v -> presenter.addScoreToATeam(2));
        findViewById(R.id.buttonAdd3TeamA).setOnClickListener(v -> presenter.addScoreToATeam(3));

        findViewById(R.id.buttonAdd1TeamB).setOnClickListener(v -> presenter.addScoreToBTeam(1));
        findViewById(R.id.buttonAdd2TeamB).setOnClickListener(v -> presenter.addScoreToBTeam(2));
        findViewById(R.id.buttonAdd3TeamB).setOnClickListener(v -> presenter.addScoreToBTeam(3));

        // 设置窗口插入监听器
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //这一个接口就需要在presenter和activity中回调
    @Override
    public void updateATeamScore(int score) {
        textTeamA.setText(String.valueOf(score));
    }

    @Override
    public void updateBTeamScore(int score) {
        textTeamB.setText(String.valueOf(score));
    }
}