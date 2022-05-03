package Service;

import model.Faculty;
import model.Teacher;

import java.util.Optional;

public class TeacherManager {
    Faculty fa;

    public TeacherManager(Faculty fa) {
        this.fa = fa;
    }

    public boolean addTeacher(Teacher teacher) {
        Optional<Teacher> r = fa.getTeacherList().stream().filter(t -> t.equals(teacher)).findFirst();
        if (r.isPresent()) return false;
        fa.getTeacherList().add(teacher);
        return true;
    }

    public boolean deleteTeacher(String id) {
        Optional<Teacher> r = fa.getTeacherList().stream().filter(t -> t.getId().equals(id)).findFirst();
        if (r.isPresent()){
            return fa.getTeacherList().remove(r.get());
        }
        return false;

    }

    public long calculateSalary(Teacher teacher) {
        return teacher.getBasicSalary() + teacher.getBonusSalary() - teacher.getPenaltySalary();
    }
}
