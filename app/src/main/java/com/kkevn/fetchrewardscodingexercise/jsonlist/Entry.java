/**
 * Entry is a wrapper class for the Entry objects stored in the JSON file to be parsed. Each entry
 * contains just an Id, listId, and name.
 *
 * @author Kevin Kowalski
 */

package com.kkevn.fetchrewardscodingexercise.jsonlist;

import com.google.gson.annotations.SerializedName;

public class Entry {

    // declare serializable variables for an Entry object
    @SerializedName("id")
    private int id;
    @SerializedName("listId")
    private int listId;
    @SerializedName("name")
    private String name;

    /**
     * Constructor for an entry parsed from the JSON file.
     *
     * @param {int} id: ID of this entry.
     * @param {int} listId: List ID of this entry.
     * @param {String} name: Name of this entry.
     */
    public Entry(int id, int listId, String name) {
        this.id = id;
        this.listId = listId;
        this.name = name;
    }

    /**
     * Returns the integer ID of this entry.
     *
     * @return {int} ID of this entry.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the integer list ID of this entry.
     *
     * @return {int} List ID of this entry.
     */
    public int getListId() {
        return listId;
    }

    /**
     * Returns the String name of this entry.
     *
     * @return {String} Name of this entry.
     */
    public String getName() {
        return name;
    }

    /**
     * Overrides the toString() method to output this Entry's data as a single String object. Used
     * for debugging purposes.
     *
     * @return {String} Output of Entry's data.
     */
    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", listId=" + listId +
                ", name='" + name + '\'' +
                '}';
    }
}
