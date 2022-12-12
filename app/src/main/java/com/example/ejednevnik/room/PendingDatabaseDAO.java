package com.example.ejednevnik.room;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.ejednevnik.room.PendingDatabase;

import io.reactivex.Flowable;

@Dao
public interface PendingDatabaseDAO {

    @Query("SELECT * FROM pendingdatabase")
    List<PendingDatabase> getAll();

    @Query("SELECT * FROM pendingdatabase where id = :id")
    PendingDatabase getdelo(int id);

    @Delete
    void delete(PendingDatabase t);

    @Insert
    void insert(PendingDatabase t);

    @Update
    void update(PendingDatabase t);
}