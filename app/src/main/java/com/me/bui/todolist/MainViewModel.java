package com.me.bui.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.me.bui.todolist.data.AppData;
import com.me.bui.todolist.data.TaskEntry;

import java.util.List;

/**
 * Created by mao.bui on 5/12/2018.
 */
public class MainViewModel extends AndroidViewModel{

    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        Log.d(TAG, "Actively retrieving the task from Database.");
        tasks = AppData.getInstance(this.getApplication()).taskDao().loadAllTask();
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
