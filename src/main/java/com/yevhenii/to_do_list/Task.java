package com.yevhenii.to_do_list;

public class Task {

    public String listId;
    public int id;
    public String text;
    public boolean complete;

    public Task() {}

    public Task(String listId, int id, String text, boolean complete) {
        this.listId = listId;
        this.id = id;
        this.text = text;
        this.complete = complete;
    }
}
