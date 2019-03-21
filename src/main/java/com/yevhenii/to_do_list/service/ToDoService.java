package com.yevhenii.to_do_list.service;

import com.yevhenii.to_do_list.exception.ListAlreadyExistException;
import com.yevhenii.to_do_list.exception.NotContentException;
import com.yevhenii.to_do_list.model.List;
import com.yevhenii.to_do_list.model.OutputTask;
import com.yevhenii.to_do_list.model.Task;
import com.yevhenii.to_do_list.repository.ListRepository;
import com.yevhenii.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    public ArrayList<OutputTask> getTasks() {
        java.util.List<Task> t = taskRepository.findAll();

        ArrayList<OutputTask> outputTasks = new ArrayList<OutputTask>();

        for (Task task : t) {
            outputTasks.add(new OutputTask(task.getId(), task.getList().getId(), task.getText(), task.isComplete()));
        }

        return outputTasks;
    }

    public OutputTask addTask(Task task) {
        Task t = taskRepository.save(task);

        OutputTask outputTask = new OutputTask(t.getId(), t.getList().getId(), t.getText(), t.isComplete());

        return outputTask;
    }

    public OutputTask changeTask(Task task) {
        Task t = taskRepository.save(task);

        OutputTask outputTask = new OutputTask(t.getId(), t.getList().getId(), t.getText(), t.isComplete());

        return outputTask;

    }

    public void deleteTask(int id) throws NotContentException {
        if (taskRepository.findById(id).isPresent()) {
            taskRepository.deleteById(id);
        } else {
            throw new NotContentException();
        }
    }

    //////////////////////REALIZE IT !!!!!!!!!!!!!!!!!!!!!!!!/////////////////////////////////////////////////////////

    public java.util.List<List> getListsAndNotSolvedTasks() {
        return listRepository.getListsAndNotSolvedTasks();
    }
}
