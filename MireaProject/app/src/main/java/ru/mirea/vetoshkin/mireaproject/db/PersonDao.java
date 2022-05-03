package ru.mirea.vetoshkin.mireaproject.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM Person")
    List<Person> getAllUsers();

    @Insert
    void insertUser(Person... people);

    @Delete
    void delete(Person person);
}
