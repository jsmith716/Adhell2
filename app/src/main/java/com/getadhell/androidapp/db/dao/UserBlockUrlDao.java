package com.getadhell.androidapp.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.getadhell.androidapp.db.DateConverter;
import com.getadhell.androidapp.db.entity.UserBlockUrl;

import java.util.List;

@Dao
@TypeConverters(DateConverter.class)
public interface UserBlockUrlDao {
    @Query("SELECT * FROM UserBlockUrl")
    LiveData<List<UserBlockUrl>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(UserBlockUrl userBlockUrl);

    @Delete
    void delete(UserBlockUrl userBlockUrl);

    @Query("DELETE FROM UserBlockUrl WHERE url = :url")
    void deleteByUrl(String url);
}