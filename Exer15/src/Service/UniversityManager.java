package Service;

import model.*;

import java.util.*;
import java.util.stream.Collectors;

public class UniversityManager {
    private University uni;

    public UniversityManager(University uni) {
        this.uni = uni;
    }

    public University getUni() {
        return uni;
    }

    public void setUni(University uni) {
        this.uni = uni;
    }

    //
    //3
    public boolean addStudent(Student student) throws Exception {
        boolean isDuplicated = uni.getStudents().stream().filter(o -> o.equals(student)).findAny().isPresent();

        if (isDuplicated == false) {
            uni.getStudents().add(student);
            String faculty;
            try {
                faculty = student.getFaculty();
            } catch (NullPointerException e) {
                //
                throw new Exception("this student doenst have falcuty", e);
            }
            uni.getFaculties().forEach(
                    f -> {
                        if (faculty.equals(f.getFacultyName()))
                            f.getStudentList().add(student);
                    }
            );
            return true;
        }
        return false;
    }


    public void listAll() {
        List<Student> sl = uni.getStudents();
        if(sl==null||sl.size()==0) System.out.println("No Data");
        sl.forEach(
                s -> s.ShowInfo()
        );
    }

    ;
    //
    //4

    boolean checkTypeOfStudent(String type, Student student) {
        return student.getClass().getSimpleName().equals(type);
    }

    boolean checkTypeOfStudent(String type, String id) {
        return searchAStudentByID(id).getClass().getSimpleName().equals(type);
    }

    private Student searchAStudentByID(String id) {
        List<Student> sl = uni.getStudents();
        if(sl==null) return null;
        Optional<Student> record = sl.stream().filter(s -> s.getId().equals(id)).findFirst();
        if (record.isPresent())
            return record.get();
        return null;

    }

    private List<Student> searchStudentByName(String name, boolean type) {
        List<Student> sl = uni.getStudents();
        if(sl==null) return null;
        return sl.stream().filter(s -> s.getName().contains(name)).collect(Collectors.toList());
    }

    //6
    public double semesterGradeOfAStudent(String id, int semesterIndex) throws Exception {
        Student s = searchAStudentByID(id);
        List<Semester> sl = s.getSemesters();
        if(sl == null) return 0;
        sl.get(semesterIndex).calculateAverageScore();
        return s.getSemesters().get(semesterIndex).getAverageScore();
    }

    //
    //7
    public long countStudentByType(String type, String faculty) {
        List<Student> sl = uni.getStudents();
        if (sl == null) return 0;
        long count = uni.getStudents().stream().filter(s -> checkTypeOfStudent(type, s)).count();
        return count;

    }


    //

    private Faculty findFaculty(String name) {
        List<Faculty> fl = uni.getFaculties();
        if(fl==null) return null;
        Optional<Faculty> of = fl.stream().filter(f -> f.getFacultyName().equals(name)).findFirst();
        if (of.isPresent()) return of.get();
        return null;
    }

    //8
    public List<Student> HighestEntryPointStudent(String fa) {
        Faculty f = findFaculty(fa);
        if (f == null) return null;
        List<Student> sl = uni.getStudents();
        if(sl==null) return null;
        double maxGrade = -1;
        for (Student s : sl) {
            if (s.getEntryPoint() > maxGrade)
                maxGrade = s.getEntryPoint();
        }
        final double maxGradeFinal = maxGrade;
        sl = sl.stream().filter(s -> s.getEntryPoint() == maxGradeFinal).collect(Collectors.toList());
        return sl;
    }

    //


    public List<Student> getStudentByType(String type) {
        return uni.getStudents().stream().filter(s -> checkTypeOfStudent(type, s)).collect(Collectors.toList());
    }

    //9
    public List<In_serviceStudent> getIn_serviceStudentAt(Faculty fa, String trainingCoopPlace) {
        List<In_serviceStudent> l = new LinkedList<>();
        for (Student s : uni.getStudents()) {
            if (s.getClass().getSimpleName().equals("In_serviceStudent")) {
                In_serviceStudent is = (In_serviceStudent) s;
                if (((In_serviceStudent) s).getTrainingCoopPlace().equals(trainingCoopPlace))
                    l.add(is);
            }
        }
        return l;
    }

    //
    //11
    public List<Student> getHighestAvgGradeStudent(Faculty fa, int semesterIndex) {
        TreeMap<Double, Student> sl = new TreeMap();

        Student student;
        for (Student s : fa.getStudentList()) {
            student = s;
            double grade;
            try {
                //calculate to ensure this grade presents
                List<Semester> sel = s.getSemesters();
                sel.get(semesterIndex).calculateAverageScore();
                grade = s.getSemesters().get(semesterIndex).getAverageScore();
            } catch (Exception e) {
                // error detail: missing grade of some courses
                grade = 0;
            }
        }
        double highestGrade;
        try {
            highestGrade = sl.lastKey();
        } catch (Exception e) {
            highestGrade = 0;
        }
        List<Student> hl = new LinkedList<>();
        for (Map.Entry<Double, Student> st : sl.entrySet()) {
            if (st.getKey() == highestGrade) hl.add(st.getValue());
        }

        return hl;
    }

    ;
    //

    //10
    public List<Student> findStudentsHigherThan(Faculty fa, int semesterIndex, double gradeBase) {
        Map<Double, Student> sl = new HashMap<>();

        Student student;
        for (Student s : fa.getStudentList()) {
            student = s;
            double grade;
            try {
                //calculate to ensure this grade presents
                s.getSemesters().get(semesterIndex).calculateAverageScore();
                grade = s.getSemesters().get(semesterIndex).getAverageScore();
            } catch (Exception e) {
                // error detail: missing grade of some courses
                grade = 0;
            }
        }
        List<Student> hl = new LinkedList<>();
        for (Map.Entry<Double, Student> st : sl.entrySet()) {
            if (st.getKey() >= gradeBase) hl.add(st.getValue());
        }

        return hl;
    }

    ;
    //

    //12
    // asc = true; desc = false;
    // type asc ; start year desc
    public List<Student> sortByTypeAndYear(Faculty fa) {
        List<Student> sl = fa.getStudentList();
        Collections.sort(sl, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getClass().getSimpleName().equals(s2.getClass().getSimpleName())) {
                    return s2.getStartYear() - s1.getStartYear();
                }
                return s1.getClass().getSimpleName().equals("RegularStudent") ? 1 : -1;
            }
        });
        return sl;
    }
    //

    //13
    //trả về danh sách học sinh của từng khoa phân chia theo năm(key) và danh sách học sinh của năm đó( value)
    public Map<Integer, List<Student>> countStudentByYear(Faculty fa) {
        TreeMap<Integer, List<Student>> slc = new TreeMap<>();
        List<Student> sl;
        for (Student s : fa.getStudentList()) {
            List<Student> studentList = slc.get(s.getStartYear());
            if (studentList == null){
                studentList = new LinkedList<>();// khởi tạo list nếu năm này chưa có dữ liệu
                studentList.add(s);
                slc.put(s.getStartYear(), studentList);
            }
            else studentList.add(s);//add học sinh theo năm vào từng khoa
        }
        return slc;
    }
    //

}
