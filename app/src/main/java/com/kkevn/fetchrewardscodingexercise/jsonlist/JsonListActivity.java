package com.kkevn.fetchrewardscodingexercise.jsonlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.kkevn.fetchrewardscodingexercise.R;

public class JsonListActivity extends AppCompatActivity {

    private RecyclerView rv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_list);

        rv_list = findViewById(R.id.rv_list);
    }
}