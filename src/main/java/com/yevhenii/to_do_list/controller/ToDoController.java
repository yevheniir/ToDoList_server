package com.yevhenii.to_do_list.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yevhenii.to_do_list.exception.ListAlreadyExistException;
import com.yevhenii.to_do_list.model.List;
import com.yevhenii.to_do_list.model.OutputTask;
import com.yevhenii.to_do_list.model.Task;
import com.yevhenii.to_do_list.model.View;
import com.yevhenii.to_do_list.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @JsonView(View.Common.class)
    @GetMapping(value="/lists")
    java.util.List<com.yevhenii.to_do_list.model.List> getLists() {
        return toDoService.getLists();
    }

    @JsonView(View.Common.class)
    @PostMapping(value="/lists")
    List addlist(@RequestBody List list) throws ListAlreadyExistException {
        try {
            return toDoService.addList(list);
        } catch(ListAlreadyExistException e) {
            throw e;
        }
    }

    @JsonView(View.Common.class)
    @PutMapping(value="/lists/{id}")
    List changeList(@RequestBody List list) {
        return toDoService.changeList(list);
    }

    @JsonView(View.Common.class)
    @DeleteMapping(value="/lists/{id}")
    void deleteList(@PathVariable String id) {
        toDoService.deleteList(id);
    }

    @JsonView(View.Common.class)
    @GetMapping(value="/tasks")
    ArrayList<OutputTask> getTasks() {
        return toDoService.getTasks();
    }

    @JsonView(View.Common.class)
    @PostMapping(value="/tasks")
    OutputTask addTask(@RequestBody Task task) {
        OutputTask t = toDoService.addTask(task);
        return t;
    }

    @JsonView(View.Common.class)
    @PutMapping(value="/tasks/{id}")
    OutputTask changeTask(@RequestBody Task task) {
        return toDoService.changeTask(task);
    }

    @JsonView(View.Common.class)
    @DeleteMapping(value="/tasks/{id}")
    void deleteTask(@PathVariable int id) throws Exception {
        try {
            toDoService.deleteTask(id);
        } catch (Exception e) {
            throw e;
        }

    }

    @JsonView(View.ListsTasks.class)
    @GetMapping(value="/lists_and_not_solved_tasks")
    java.util.List<List> getListsAndNotSolvedTasks() {
        return toDoService.getListsAndNotSolvedTasks();
    }
}
