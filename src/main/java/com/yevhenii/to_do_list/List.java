package com.yevhenii.to_do_list;

public class List {

    public final String id;
    public boolean pin;

    public List() {
        this.id = "new";
    }

    public List(String id, boolean pin) {
        this.id = id;
        this.pin = pin;
    }
}

