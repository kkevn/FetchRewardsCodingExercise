package com.kkevn.fetchrewardscodingexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_instructions_link;
    private Button b_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find and allow instruction link to act as hyperlink
        tv_instructions_link = findViewById(R.id.tv_instructions_link);
        tv_instructions_link.setMovementMethod(LinkMovementMethod.getInstance());

        // find and allow start button to load activity that loads and displays the JSON file
        b_start = findViewById(R.id.b_start);
        b_start.setOnClickListener(e -> loadJsonAcitivty());

    }

    private void loadJsonAcitivty() {

    }
}