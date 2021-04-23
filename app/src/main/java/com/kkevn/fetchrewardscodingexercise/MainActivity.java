/**
 * MainActivity is the activity containing the "home page" for this coding exercise application. It
 * contains a brief overview of the project, a hyperlink to view the original instructions, and a
 * button to navigate to the JsonListActivity.
 *
 * @author Kevin Kowalski
 */

package com.kkevn.fetchrewardscodingexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.kkevn.fetchrewardscodingexercise.jsonlist.JsonListActivity;

public class MainActivity extends AppCompatActivity {

    // declare variables for elements to interact with
    private TextView tv_instructions_link, tv_repository_link;
    private Button b_start;

    /**
     * Creates the activity by initializing and setting up the hyperlinks and start button.
     *
     * @param {Bundle} savedInstanceState: Bundle object containing activity's previous state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find and allow instruction link to act as hyperlink
        tv_instructions_link = findViewById(R.id.tv_instructions_link);
        tv_instructions_link.setMovementMethod(LinkMovementMethod.getInstance());

        // find and allow code repository link to act as hyperlink
        tv_repository_link = findViewById(R.id.tv_repository_link);
        tv_repository_link.setMovementMethod(LinkMovementMethod.getInstance());

        // find and allow start button to load activity that loads and displays the JSON file
        b_start = findViewById(R.id.b_start);
        b_start.setOnClickListener(e -> loadJsonAcitivty());

        Log.i(this.getClass().getSimpleName(), "created MainActivity");
    }

    /**
     * Attempts to change the current activity to the JsonListActivity and logs the event. Called
     * when the 'START' button is pressed from this MainActivity.
     */
    private void loadJsonAcitivty() {

        // log the event
        Log.i(this.getClass().getSimpleName(), "changing activity to JSON list activity");

        // start new intent to change activity to JSON list activity
        Intent intent = new Intent(this, JsonListActivity.class);
        startActivity(intent);
    }
}