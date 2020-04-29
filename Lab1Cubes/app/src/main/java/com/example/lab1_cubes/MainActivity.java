package com.example.lab1_cubes;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public TextView name;
    public TextView YourScore;
    public TextView RobotScore;
    public Button Play;
    public TextView RobotCube1;
    public TextView RobotCube2;
    public TextView YourCube1;
    public TextView YourCube2;
    public TextView rules;
    int ScoreY = 0;
    int ScoreR = 0;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.GameName);
        YourScore = findViewById(R.id.YouS);
        RobotScore = findViewById(R.id.RobotS);
        RobotCube1 = findViewById(R.id.RobotC1);
        RobotCube2 = findViewById(R.id.RobotC2);
        YourCube1 = findViewById(R.id.YourC1);
        YourCube2 = findViewById(R.id.YourC2);
        Play = findViewById(R.id.Play);
        rules = findViewById(R.id.Rules);

        name.setText("КОСТИ");
        Play.setText("Бросить кубики");
        YourScore.setText(String.valueOf(ScoreY));
        RobotScore.setText(String.valueOf(ScoreR));
        rules.setText("Правила: Бросая кости наберите 100 очков раньше соперника");
    }
    public void PlayGame(View view) {
    int Ycube1 =random.nextInt(6)+1;;
    int Ycube2 = random.nextInt(6)+1;;
    int Rcube1 = random.nextInt(6)+1;;
    int Rcube2 =random.nextInt(6)+1;;
    RobotCube1.setText(String.valueOf(Rcube1));
    RobotCube2.setText(String.valueOf(Rcube2));
    YourCube1.setText(String.valueOf(Ycube1));
    YourCube2.setText(String.valueOf(Ycube2));
    while (Ycube1 == Ycube2) {
        Ycube1 = random.nextInt(6)+1;;
        Ycube2 = random.nextInt(6)+1;;
    }
    while (Rcube1 == Rcube2) {
        Rcube1 = random.nextInt(6)+1;;
        Rcube2 = random.nextInt(6)+1;;
    }
    RobotCube1.setText(String.valueOf(Rcube1));
    RobotCube2.setText(String.valueOf(Rcube2));
    YourCube1.setText(String.valueOf(Ycube1));
    YourCube2.setText(String.valueOf(Ycube2));
    ScoreY +=(Ycube1 + Ycube2);
    ScoreR +=(Rcube1 + Rcube2);
    YourScore.setText(String.valueOf(ScoreY));
    RobotScore.setText(String.valueOf(ScoreR));
    if (ScoreY >= 100 || ScoreR >= 100 ) {
        if (ScoreR >= 100 && ScoreY >=100) {
            name.setText("Ничья!");
            Intent intent= new Intent(this, Stalemate.class);
            startActivity(intent);
        }else
            if(ScoreR >= 100) {
                name.setText("Поражение!");
                Intent intent= new Intent(this, Loose.class);
                startActivity(intent);
            }else {
                name.setText("Победа!");
                Intent intent= new Intent(this, Victory.class);
                startActivity(intent);
            }


    }
    }
}
