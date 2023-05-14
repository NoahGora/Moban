package com.example.moban;

import java.util.ArrayList;

public class TaskManager {

    ArrayList<Task> taskList;

    public void addTask(Task task){
        taskList.add(task);
    }

    public void removeTask(Task task){
        taskList.remove(task);
    }

    public ArrayList<Task> taskList(){
        return taskList;
    }

    public int getTaskCount(){
        return taskList.size();
    }
}
