package com.cloudware.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    //Data access object(Dao) is where we put in what we want to use

    @Insert
    public void addUser(User user);

    @Query("select * from users")   //we use query to read data from our db. users is the table name from User class
    List<User> getUser();
}
