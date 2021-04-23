package com.kkevn.fetchrewardscodingexercise.jsonlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kkevn.fetchrewardscodingexercise.R;

public class JsonListActivity extends AppCompatActivity {

    private RecyclerView rv_list;

    private boolean entriesFound = false;
    private TextView tv_no_entries;

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_list);

        // find and reveal the empty list message if no entries available
        tv_no_entries = findViewById(R.id.tv_no_entries);
        tv_no_entries.setVisibility(entriesFound ? View.INVISIBLE : View.VISIBLE);

        rv_list = findViewById(R.id.rv_list);
    }
}