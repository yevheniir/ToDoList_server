package com.yevhenii.to_do_list.service;

import com.yevhenii.to_do_list.exception.ListAlreadyExistException;
import com.yevhenii.to_do_list.exception.NotContentException;
import com.yevhenii.to_do_list.model.List;
import com.yevhenii.to_do_list.model.Task;
import com.yevhenii.to_do_list.repository.ListRepository;
import com.yevhenii.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ListRepository listRepository;


    public ToDoService() {

    }

    public java.util.List<com.yevhenii.to_do_list.model.List> getLists() {
        return listRepository.findAll();
    }

    public List addList(List list) throws ListAlreadyExistException {
        if (listRepository.findById(list.getId()) == null) {
            return listRepository.save(list);
        }
        throw new ListAlreadyExistException();
    }

    public List changeList(List list) {
        return listRepository.save(list);
    }

    public void deleteList(String id) {
        listRepository.delete(listRepository.findById(id));
    }

    public java.util.List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task changeTask(Task task) {
        return taskRepository.save(task);

    }

    public void deleteTask(int id) throws NotContentException {
        try {
            taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotContentException();
        }

    }
}
