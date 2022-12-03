package com.example.ejednevnik.room;

import androidx.room.Database;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;
import com.example.ejednevnik.room.ActiveDatabase;
import com.example.ejednevnik.room.ActiveDatabaseDAO;

@Database(entities = {ActiveDatabase.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract ActiveDatabaseDAO activeDatabaseDAO();

}