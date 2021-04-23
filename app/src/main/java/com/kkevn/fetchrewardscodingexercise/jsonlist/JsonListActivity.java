package com.kkevn.fetchrewardscodingexercise.jsonlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kkevn.fetchrewardscodingexercise.R;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonListActivity extends AppCompatActivity {

    private final String jsonFileName = "hiring.json";
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

        // initialize the Gson object
        //gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        gson = new Gson();


        // parse the JSON entries at the specified file
        entriesFound = parseEntriesList(jsonFileName);


        // find and reveal the empty list message if no entries available
        tv_no_entries = findViewById(R.id.tv_no_entries);
        tv_no_entries.setVisibility(entriesFound ? View.INVISIBLE : View.VISIBLE);


        // find the RecyclerView object in this activity's layout
        rv_list = findViewById(R.id.rv_list);

        // apply a LayoutManager and Adapter for the RecyclerView
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EntryAdapter(getApplicationContext());
        rv_list.setAdapter(adapter);

        // apply divider decoration between entries in RecyclerView to easier differentiate entries
        rv_list.addItemDecoration(new DividerItemDecoration(rv_list.getContext(),
                DividerItemDecoration.VERTICAL));
    }

    /**
     * Determines if the given name is a valid one. A valid name is determined as one that is
     * neither null nor empty.
     *
     * @param {String} name: Name to determine validity of.
     *
     * @return {boolean} Validity of name.
     */
    private boolean isValidName(String name) {
        return !(name == null || name.isEmpty());
    }

    /**
     * Attempts to parse the specified JSON file and populate the list of Entry objects with each
     * new entry found in this file. Returns a status flag denoting whether or not the process
     * was successful.
     *
     * @param {String} filename: Name of JSON file to parse.
     *
     * @return {boolean} Success status flag.
     */
    private boolean parseEntriesList(String filename) {

        // attempt to load the specified JSON file into a list
        try {

            // check if the specified file even exists
            // *note: the file must be in root of \assets\ folder
            if (!Arrays.asList(getAssets().list("")).contains(filename)) {
                return false;
            }

            // find the InputStream of the specified file in the app's \assets\ folder
            InputStream inputStream = getAssets().open(filename);

            // create a buffer to accommodate the contents of the InputStream
            int size = inputStream.available();
            byte[] buffer = new byte[size];

            // read the stream to the buffer and make a String from this buffer
            inputStream.read(buffer);
            String fileContents = new String(buffer);

            // read the JSON list contents into an object list of type Entry
            Type entryType = new TypeToken<List<Entry>>(){}.getType();
            entries = gson.fromJson(fileContents, entryType);

            // close the stream to prevent potential issues
            inputStream.close();

            // log the event
            Log.i(this.getClass().getSimpleName(), "parsed JSON file");

            // set return status as successful
            return true;

        } catch (IOException e) {

            // log the error
            Log.e(this.getClass().getSimpleName(), "error reading file", e);

            // return status as failure
            return false;
        }
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