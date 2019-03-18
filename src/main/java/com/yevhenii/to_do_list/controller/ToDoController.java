package com.yevhenii.to_do_list.controller;

import com.yevhenii.to_do_list.exception.ListAlreadyExistException;
import com.yevhenii.to_do_list.model.List;
import com.yevhenii.to_do_list.model.Task;
import com.yevhenii.to_do_list.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping(value="/lists")
    @ResponseBody
    java.util.List<com.yevhenii.to_do_list.model.List> getLists() {
        return toDoService.getLists();
    }

    @PostMapping(value="/lists")
    @ResponseBody
    List addlist(@RequestBody List list) throws ListAlreadyExistException {
        try {
            return toDoService.addList(list);
        } catch(ListAlreadyExistException e) {
            throw e;
        }

    }

    @PutMapping(value="/lists/{id}")
    @ResponseBody
    List changeList(@RequestBody List list) {
        return toDoService.changeList(list);
    }

    @DeleteMapping(value="/lists/{id}")
    @ResponseBody
    void deleteList(@PathVariable String id) {
        toDoService.deleteList(id);
    }

    @GetMapping(value="/tasks")
    @ResponseBody
    java.util.List<Task> getTasks() {
        return toDoService.getTasks();
    }

    @PostMapping(value="/tasks")
    @ResponseBody
    Task addTask(@RequestBody Task task) {
        return toDoService.addTask(task);
    }

    @PutMapping(value="/tasks/{id}")
    @ResponseBody
    Task changeTask(@RequestBody Task task) {
        return toDoService.changeTask(task);
    }

    @DeleteMapping(value="/tasks/{id}")
    @ResponseBody
    void deleteTask(@PathVariable int id) throws Exception {
        try {
            toDoService.deleteTask(id);
        } catch (Exception e) {
            throw e;
        }

    }
}
