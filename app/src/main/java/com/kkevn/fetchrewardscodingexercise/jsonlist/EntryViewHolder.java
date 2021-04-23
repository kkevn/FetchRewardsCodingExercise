/**
 * EntryViewHolder is a custom ViewHolder used to contain the relevant fields for the item that will
 * be adapted by the EntryAdapter.
 *
 * @author Kevin Kowalski
 */

package com.kkevn.fetchrewardscodingexercise.jsonlist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kkevn.fetchrewardscodingexercise.R;

public class EntryViewHolder extends RecyclerView.ViewHolder {

    // declare relevant variables
    private TextView tv_id;
    private TextView tv_listId;
    private TextView tv_name;

    /**
     * Constructor for a custom view holder for a single Entry item from the JSON list.
     *
     * @param {View} itemView: The view of a single item in the list.
     */
    public EntryViewHolder(@NonNull View itemView) {
        super(itemView);

        // find the TextView objects from the itemView's layout
        tv_id = itemView.findViewById(R.id.tv_id);
        tv_listId = itemView.findViewById(R.id.tv_listId);
        tv_name = itemView.findViewById(R.id.tv_name);
    }

    /**
     * Updates the String contents of the Entry ID TextView.
     *
     * @param {String} input: String content to update TextView with.
     */
    public void setEntryIdText(String input) {
        tv_id.setText(input);
    }

    /**
     * Updates the String contents of the Entry list ID TextView.
     *
     * @param {String} input: String content to update TextView with.
     */
    public void setEntryListIdText(String input) {
        tv_listId.setText(input);
    }

    /**
     * Updates the String contents of the Entry name TextView.
     *
     * @param {String} input: String content to update TextView with.
     */
    public void setEntryNameText(String input) {
        tv_name.setText(input);
    }
}
