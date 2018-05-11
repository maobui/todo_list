package com.me.bui.todolist.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.me.bui.todolist.AddTaskActivity;
import com.me.bui.todolist.data.AppData;

/**
 * Created by mao.bui on 5/12/2018.
 */
public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final AppData mDb;
    private final int mTaskId;

    public AddTaskViewModelFactory(AppData db, int taskId) {
        mDb = db;
        mTaskId = taskId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AddTaskViewModel(mDb, mTaskId);
    }
}
