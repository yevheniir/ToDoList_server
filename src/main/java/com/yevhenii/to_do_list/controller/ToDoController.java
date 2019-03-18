package com.yevhenii.to_do_list.controller;

import com.yevhenii.to_do_list.List;
import com.yevhenii.to_do_list.Task;
import com.yevhenii.to_do_list.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@CrossOrigin
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping(value="/string")
    @ResponseBody
    String hi() {
        return "hello world";
    }

    @GetMapping(value="/lists")
    @ResponseBody
    java.util.List<com.yevhenii.to_do_list.model.List> getLists() {
        return toDoService.getLists();
    }

    @PostMapping(value="/lists")
    @ResponseBody
    List addlist(@RequestBody List list) {
        return toDoService.addList(list);
    }

    @PutMapping(value="/lists/{id}")
    @ResponseBody
    List changeList(@RequestBody List list, @PathVariable String id) {
        return toDoService.changeList(id, list);
    }

    @DeleteMapping(value="/lists/{id}")
    @ResponseBody
    List deleteList(@PathVariable String id) {
        return toDoService.deleteList(id);
    }

    @GetMapping(value="/tasks")
    @ResponseBody
    ArrayList<Task> getTasks() {
        return toDoService.getTasks();
    }

    @PostMapping(value="/tasks")
    @ResponseBody
    Task addTask(@RequestBody Task task) {
        return toDoService.addTask(task);
    }

    @PutMapping(value="/tasks/{id}")
    @ResponseBody
    Task changeTask(@RequestBody Task task, @PathVariable int id) {
        return toDoService.changeTask(id, task);
    }

    @DeleteMapping(value="/tasks/{id}")
    @ResponseBody
    Task deleteTask(@PathVariable int id) {
        return toDoService.deleteTask(id);
    }

}
