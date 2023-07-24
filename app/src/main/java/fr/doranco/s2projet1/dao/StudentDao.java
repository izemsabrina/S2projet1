package fr.doranco.s2projet1.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.doranco.s2projet1.entities.Student;

@Dao
public interface StudentDao {


    @Insert
    void create(Student student);


    @Query("SELECT * FROM students")
    List<Student> findAll();

    @Update
    void update (Student student);

    @Delete
    void  delete (Student student);

    @Query("SELECT * FROM students WHERE matricule= :identifiant")
            Student findBymatricule (String identifiant);


}
