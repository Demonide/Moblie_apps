package com.example.lab1_cubes;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class Loose extends AppCompatActivity {
    public  TextView Defeated;
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loose);
        Defeated = findViewById(R.id.Defeat);
        Defeated.setText("Поражение");
        button = findViewById(R.id.playAgain);
        button.setText("Новая Игра");
    }
    public void PlayAgain(View view) {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
