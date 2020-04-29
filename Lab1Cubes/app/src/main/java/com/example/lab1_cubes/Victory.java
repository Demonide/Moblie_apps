package com.example.lab1_cubes;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class Victory extends AppCompatActivity {

    public TextView win;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);
        win = findViewById(R.id.Victory);
        win.setText("ПОБЕДА");
        button = findViewById(R.id.playAgain);
        button.setText("Новая Игра");
    }

    public void PlayAgain(View view) {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
