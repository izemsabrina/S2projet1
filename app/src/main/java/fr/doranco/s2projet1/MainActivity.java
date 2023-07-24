package fr.doranco.s2projet1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import fr.doranco.s2projet1.dao.DaoFactory;
import fr.doranco.s2projet1.dao.StudentDao;
import fr.doranco.s2projet1.entities.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Student student1=new Student("sabrina","ZERTTT");
        Student student2=new Student("malika","ZERzr");
        Student student3=new Student("naima","ZEeferT");
        Student student4=new Student("samira","ZEerferT");
        StudentDao studentDao = DaoFactory.getInstance(this).getStudentDao();

       // studentDao.create(student1);
       // studentDao.create(student2);
       // studentDao.create(student3);
        //studentDao.create(student4);
         //list des students
        Log.i("student_db",studentDao.findAll().toString());

        //update student
       Student student5 =studentDao.findBymatricule("ZERTTT");
       student5.setName("tata");

       studentDao.update(student5);
       Log.i("student_db",studentDao.findAll().toString());

       studentDao.delete(student5);
        Log.i("student_db",studentDao.findAll().toString());

      deletesAllStudents(studentDao);
        Log.i("test", studentDao.findAll().toString());


    }
    private void deletesAllStudents (StudentDao studentDao){
       List <Student> allstudent= studentDao.findAll();
       allstudent.stream().map(
               student -> {studentDao.delete(student); return null;}

       );


    }
}
