package com.yevhenii.to_do_list.model;


import javax.persistence.*;

@Entity
@Table(name = "lists")
public class List {

    @Id
    private String id;

    private boolean pin;

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
