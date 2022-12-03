package com.example.ejednevnik.room;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.ejednevnik.room.ActiveDatabase;

import io.reactivex.Flowable;

@Dao
public interface ActiveDatabaseDAO {

    @Query("SELECT * FROM activedatabase")
    List<ActiveDatabase> getAll();

    @Delete
    void delete(ActiveDatabase t);

    @Insert
    void insert(ActiveDatabase t);

    @Update
    void update(ActiveDatabase t);
}
