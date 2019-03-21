package com.yevhenii.to_do_list.model;

public class OutputTask {
    private int id;
    private String listId;
    private String text;
    private boolean complete;

    public OutputTask(int id, String listId, String text, boolean complete) {
        this.id = id;
        this.listId = listId;
        this.text = text;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "OutputTask{" +
                "id=" + id +
                ", listId='" + listId + '\'' +
                ", text='" + text + '\'' +
                ", complete=" + complete +
                '}';
    }
}
