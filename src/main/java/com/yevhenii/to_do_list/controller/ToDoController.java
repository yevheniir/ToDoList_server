package com.yevhenii.to_do_list.controller;

import com.yevhenii.to_do_list.exception.ListAlreadyExistException;
import com.yevhenii.to_do_list.model.List;
import com.yevhenii.to_do_list.model.Task;
import com.yevhenii.to_do_list.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping(value="/lists")
    java.util.List<com.yevhenii.to_do_list.model.List> getLists() {
        return toDoService.getLists();
    }

    @PostMapping(value="/lists")
    List addlist(@RequestBody List list) throws ListAlreadyExistException {
        try {
            return toDoService.addList(list);
        } catch(ListAlreadyExistException e) {
            throw e;
        }
    }

    @PutMapping(value="/lists/{id}")
    List changeList(@RequestBody List list) {
        return toDoService.changeList(list);
    }

    @DeleteMapping(value="/lists/{id}")
    void deleteList(@PathVariable String id) {
        toDoService.deleteList(id);
    }

    @GetMapping(value="/tasks")
    java.util.List<Task> getTasks() {
        return toDoService.getTasks();
    }

    @PostMapping(value="/tasks")
    Task addTask(@RequestBody Task task) {
        return toDoService.addTask(task);
    }

    @PutMapping(value="/tasks/{id}")
    Task changeTask(@RequestBody Task task) {
        return toDoService.changeTask(task);
    }

    @DeleteMapping(value="/tasks/{id}")
    void deleteTask(@PathVariable int id) throws Exception {
        try {
            toDoService.deleteTask(id);
        } catch (Exception e) {
            throw e;
        }

    }

    @GetMapping(value="/lists_and_not_solved_tasks")
    java.util.List<List> getListsAndNotSolvedTasks() {
        return toDoService.getListsAndNotSolvedTasks();
    }
}
