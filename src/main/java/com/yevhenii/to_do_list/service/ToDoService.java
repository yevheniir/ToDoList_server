package com.yevhenii.to_do_list.service;

import com.yevhenii.to_do_list.List;
import com.yevhenii.to_do_list.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ToDoService {
    private static ArrayList<List> lists = new ArrayList<List>();
    private static ArrayList<Task> tasks = new ArrayList<Task>();
    private static int taskId = 0;

    static {
        lists.add(new List("mainlist", false));
        lists.add(new List("newList", false));

        tasks.add(new Task("mainList", taskId++, "first task", false));
        tasks.add(new Task("mainList", taskId++, "second task", false));
    }

    public ToDoService() {

    }

    public ArrayList<List> getLists() {
        return lists;
    }

    public List addList(List list) {
        lists.add(list);
        return list;
    }

    public List changeList(String id, List list) {
        for (List l : lists) {
            if (l.id.equals(id)) {
                l.pin = list.pin;
                return l;
            }
        }
        return null;
    }

    public List deleteList(String id) {
        lists.removeIf(l -> l.id.equals(id));
        return null;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task addTask(Task task) {
        task.id = taskId++;
        tasks.add(task);
        return task;
    }

    public Task changeTask(int id, Task task) {
        for (Task t : tasks) {
            if (t.id == id) {
                t.text = task.text;
                t.complete = task.complete;
                return t;
            }
        }
        return null;
    }

    public Task deleteTask(int id) {
        tasks.removeIf(t -> t.id == id);
        return null;
    }
}
