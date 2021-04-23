/**
 * JsonListActivity is the activity containing the project requirements. This activity simply loads
 * the specified JSON file (using Gson) from the app's \assets\ folder into a List object for
 * display in a RecyclerView. The list is also both validated and sorted prior to being displayed.
 *
 * @author Kevin Kowalski
 */

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
import com.google.gson.reflect.TypeToken;
import com.kkevn.fetchrewardscodingexercise.R;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JsonListActivity extends AppCompatActivity {

    // initialize filename for JSON file to use
    private final String jsonFileName = "hiring.json";

    // declare relevant list variables
    private RecyclerView rv_list;
    private EntryAdapter adapter;
    private static ArrayList<Entry> entries;

    // declare relevant entry variables
    private boolean entriesFound = true;
    private TextView tv_no_entries;

    // declare Gson object
    private Gson gson;

    /**
     * Creates the activity by initializing the Entry list, Gson object, and UI elements such as the
     * RecyclerView. Also loads and processes the populated Entry list and sets up the RecyclerView.
     *
     * @param {Bundle} savedInstanceState: Bundle object containing activity's previous state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_list);

        // initialize the Entry ArrayList
        entries = new ArrayList<>();

        // initialize the Gson object
        gson = new Gson();


        // parse the JSON entries at the specified file
        entriesFound = parseEntriesList(jsonFileName);

        // process (i.e. validate and sort) the obtained entries if they exist
        if (entriesFound) {
            processEntriesList();

            // check if processing resulted in empty list
            if (entries.isEmpty()) {
                entriesFound = false;
            }
        }


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

        Log.i(this.getClass().getSimpleName(), "created JsonListActivity");
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
     * Processes the Entry list object to be both valid and sorted, per the project requirements.
     * The list is first purged of any invalid entries and then sorted. Sorting first groups by an
     * entry's listId and then each subgroup by their name, in ascending order.
     */
    private void processEntriesList() {

        /* ======== Validation ======== */

        // remove each invalid entry in the Entry list and log the event
        entries.removeIf(e -> !isValidName(e.getName()));
        Log.i(this.getClass().getSimpleName(), "validated Entry list");

        /* ======== Sorting ======== */

        // create Comparator object to compare entries against their listId
        Comparator<Entry> comparator = Comparator.comparing(Entry::getListId);

        // secondary sort was to compare entries by their name
        comparator = comparator.thenComparing(Entry::getName);

        // swap the above secondary sort for this one IF need to sort by entry Id value rather than
        // by name (as this will return a slightly different sort than when sorting by name)
        //comparator = comparator.thenComparing(Entry::getId);

        // sort the list with the given Comparator and log the event
        entries.sort(comparator);
        Log.i(this.getClass().getSimpleName(), "sorted Entry list");
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