package com.me.bui.todolist.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

/**
 * Created by mao.bui on 5/10/2018.
 */

@Database(entities = {TaskEntry.class}, version = 1, exportSchema = false)
public abstract class AppData extends RoomDatabase {

    private static final String TAG = AppData.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "todolist";
    private static AppData sInstance;

    public static AppData getInstance (Context context){
        if (sInstance == null){
            synchronized (LOCK) {
                Log.d(TAG, "Create new database instance.");
                sInstance = Room.databaseBuilder(context.getApplicationContext(), AppData.class, AppData.DATABASE_NAME).build();
            }
        }
        Log.d(TAG, "Getting the database instance.");
        return sInstance;
    }

    public abstract TaskDao taskDao();
}
