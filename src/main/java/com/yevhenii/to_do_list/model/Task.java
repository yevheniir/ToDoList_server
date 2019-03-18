package com.yevhenii.to_do_list.model;

import lombok.Data;

import javax.persistence.*;

//@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "list_id")
    private String listId;

    @Column(name = "text")
    private String text;

    @Column(name = "complete")
    private boolean complete;

    public Task() {
    }

    public Task(String listId, String text, boolean complete) {
        this.listId = listId;
        this.text = text;
        this.complete = complete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Task{" +
                "id='" + id + '\'' +
                ", listId='" + listId + '\'' +
                ", text='" + text + '\'' +
                ", complete=" + complete +
                '}';
    }
}
