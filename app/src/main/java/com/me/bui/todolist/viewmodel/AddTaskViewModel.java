package com.me.bui.todolist.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.me.bui.todolist.data.AppData;
import com.me.bui.todolist.data.TaskEntry;

/**
 * Created by mao.bui on 5/12/2018.
 */
public class AddTaskViewModel extends ViewModel{

    private LiveData<TaskEntry> task;

    public AddTaskViewModel(AppData db, int taskId) {
        task = db.taskDao().loadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask() {
        return task;
    }
}
