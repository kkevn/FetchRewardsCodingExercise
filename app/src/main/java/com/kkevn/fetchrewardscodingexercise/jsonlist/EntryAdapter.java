package com.kkevn.fetchrewardscodingexercise.jsonlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kkevn.fetchrewardscodingexercise.R;

import java.util.List;

public class EntryAdapter extends RecyclerView.Adapter<EntryViewHolder> {

    // declare relevant variables
    private static List<Entry> entries;
    private LayoutInflater layoutInflater;

    /**
     * Constructor for this EntryAdapter. Retrieves the LayoutInflater object from the given context
     * and obtains a reference to the list of Entry objects from JsonListActivity.
     *
     * @param {Context} context: Reference to context of the current activity.
     */
    public EntryAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.entries = JsonListActivity.getEntriesList();
    }

    /**
     * Returns a new EntryViewHolder with an inflated view.
     *
     * @param {ViewGroup} parent: ViewGroup which the created View will be added to.
     * @param {int} viewType: The view type of the created View.
     *
     * @return {EntryViewHolder} ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public EntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // inflate a View with the specified layout resource for an entry item
        View view = layoutInflater.inflate(R.layout.entry_item, parent, false);

        // return an EntryViewHolder with this view
        return new EntryViewHolder(view);
    }

    /**
     * Binds the contents of the EntryViewHolder with updated contents.
     *
     * @param {EntryViewHolder} holder: The ViewHolder that should have its contents updated.
     * @param {int} position: The position of this item within the RecyclerView list.
     */
    @Override
    public void onBindViewHolder(@NonNull EntryViewHolder holder, int position) {

        // get a reference to the current Entry item at the specified position
        Entry entry = entries.get(position);

        // update the TextView contents of the current Entry item
        holder.setEntryIdText("ID=" + entry.getId());
        holder.setEntryListIdText("" + entry.getListId());
        holder.setEntryNameText(entry.getName());
    }

    /**
     * Returns the count of Entry objects.
     *
     * @return {int} Count of Entry objects.
     */
    @Override
    public int getItemCount() {
        return entries.size();
    }
}
