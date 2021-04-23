package com.kkevn.fetchrewardscodingexercise.jsonlist;

public class Entry {

    // declare variables for an Entry object
    private int id;
    private int listId;
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
}
