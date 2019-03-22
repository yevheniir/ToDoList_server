package com.yevhenii.to_do_list.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class Task {

    @JsonView(View.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @JsonView(View.Common.class)
    @NotNull
//    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn
    private List list;

    @JsonView(View.Public.class)
    @NotNull
    private String text;

    @JsonView(View.Public.class)
    @NotNull
    private boolean complete;

    public Task() {
    }

    public Task(List list, String text, boolean complete) {
        this.list = list;
        this.text = text;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
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
                ", listId='" + list + '\'' +
                ", text='" + text + '\'' +
                ", complete=" + complete +
                '}';
    }
}
