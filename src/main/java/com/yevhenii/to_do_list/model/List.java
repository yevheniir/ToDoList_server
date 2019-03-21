package com.yevhenii.to_do_list.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lists")
public class List {

    @Id
    @NotNull
    private String id;

    @NotNull
    private boolean pin;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="list")
//    @JoinColumn(name="tasks")
    private Set<Task> tasks = new HashSet<>();

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public List() {
    }

    public List(String id, boolean pin) {
        this.id = id;
        this.pin = pin;
    }

    public String getId() {
        return id;
    }

    public boolean isPin() {
        return pin;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPin(boolean pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "List{" +
                "id=" + id +
                ", pin=" + pin +
                '}';
    }
}
