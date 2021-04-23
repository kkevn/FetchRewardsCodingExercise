package com.kkevn.fetchrewardscodingexercise.jsonlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kkevn.fetchrewardscodingexercise.R;

import java.util.ArrayList;
import java.util.List;

public class JsonListActivity extends AppCompatActivity {

    private RecyclerView rv_list;
    private EntryAdapter adapter;
    private static ArrayList<Entry> entries;

    private boolean entriesFound = true;
    private TextView tv_no_entries;

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_list);

        entries = new ArrayList<>();

        Entry a = new Entry(55, 4, "Item 55");
        Entry b = new Entry(999, 3, "Item 999");
        Entry c = new Entry(0, 1, "Item 0");
        entries.add(a);
        entries.add(b);
        entries.add(c);
        //Entry d = new Entry(0, 1, null);

        // find and reveal the empty list message if no entries available
        tv_no_entries = findViewById(R.id.tv_no_entries);
        tv_no_entries.setVisibility(entriesFound ? View.INVISIBLE : View.VISIBLE);

        // find the RecyclerView object in this activity's layout
        rv_list = findViewById(R.id.rv_list);

        // apply a LayoutManager and Adapter for the RecyclerView
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EntryAdapter(getApplicationContext());
        rv_list.setAdapter(adapter);

        // apply divider decoration between entries in RecyclerView to easier see separated
        rv_list.addItemDecoration(new DividerItemDecoration(rv_list.getContext(), DividerItemDecoration.VERTICAL));
    }

    /**
     * Returns a static reference to the list of Entry objects parsed.
     *
     * @return {List<Entry>} List of Entry objects.
     */
    protected static List<Entry> getEntriesList() {
        return entries;
    }
}