package com.cloudware.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//This is the database that hold the dbclass
@Database(entities = {User.class}, version = 1)   //entity is the CLASS that has a table
public abstract class MyAppDataBase extends RoomDatabase {
    public abstract MyDao myDao();


}
