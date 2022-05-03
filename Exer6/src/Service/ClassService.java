package Service;

import model.MyClass;
import model.Student;

import java.util.Optional;

public class ClassService {
    private MyClass c;

    public ClassService(MyClass c) {
        this.c = c;
    }

    public boolean addStudent(Student student){
        Optional<Student> s = c.getStudents().stream().filter(st -> st.equals(student)).findFirst();
        if(s.isPresent())
            return false;
        return c.getStudents().add(student);
    }
}
