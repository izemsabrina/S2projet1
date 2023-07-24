package fr.doranco.s2projet1.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import fr.doranco.s2projet1.entities.Student;


@Database(entities = {Student.class},version = 1)
public abstract class DaoFactory extends RoomDatabase {

    private static String NOM_BD = "BD_STUDENT";

    private static DaoFactory daoFactory;

    public static DaoFactory getInstance(Context context) {
        if (daoFactory == null)
            daoFactory = Room
                    .databaseBuilder(context, DaoFactory.class, NOM_BD)
                    .allowMainThreadQueries()
                    .build();
      return  daoFactory;
    }
   public abstract StudentDao getStudentDao();

}
