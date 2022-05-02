package Service;

import model.*;

import java.util.*;
import java.util.stream.Collectors;

public class UniversityManager {
    University uni;

    public UniversityManager(University uni) {
        this.uni = uni;
    }

    //
    //3
    public boolean addStudent(StudentStandardModel student) throws Exception {
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
                            f.getSubjectList().add(student);
                    }
            );
            return true;
        }
        return false;
    }


    public void listAll() {
        uni.getStudents().forEach(
                s -> s.ShowInfo()
        );
    }

    ;
    //
    //4

    boolean checkTypeOfStudent(String type, StudentStandardModel student) {
        return student.getClass().getSimpleName().equals(type);
    }

    boolean checkTypeOfStudent(String type, String id) {
        return searchAStudentByID(id).getClass().getSimpleName().equals(type);
    }

    private StudentStandardModel searchAStudentByID(String id) {
        Optional<StudentStandardModel> record = uni.getStudents().stream().filter(s -> s.getId().equals(id)).findFirst();
        if (record.isPresent())
            return record.get();
        return null;

    }

    private List<StudentStandardModel> searchStudentByName(String name, boolean type) {
        return uni.getStudents().stream().filter(s -> s.getName().contains(name)).collect(Collectors.toList());
    }

    //6
    public double semesterGradeOfAStudent(String id, int semesterIndex) throws Exception {
        StudentStandardModel s = searchAStudentByID(id);
        s.getSemesters().get(semesterIndex).calculateAverageScore();
        return s.getSemesters().get(semesterIndex).getAverageScore();
    }

    //
    //7
    public long countStudentByType(String type, String faculty) {
        long count = uni.getStudents().stream().filter(s -> checkTypeOfStudent(type, s)).count();
        return count;

    }


    //

    private Faculty findFaculty(String name){
        Optional<Faculty> of = uni.getFaculties().stream().filter(f -> f.getFacultyName().equals(name)).findFirst();
        if(of.isPresent()) return of.get();
        return null;
    }
    //8
    public List<StudentStandardModel> HighestEntryPointStudent(String fa) {
        Faculty f = findFaculty(fa);
        if(f==null) return null;
        List<StudentStandardModel> sl = uni.getStudents();
        double maxGrade = -1;
        for (StudentStandardModel s : sl) {
            if (s.getEntryPoint() > maxGrade)
                maxGrade = s.getEntryPoint();
        }
        final double maxGradeFinal = maxGrade;
        sl = sl.stream().filter(s -> s.getEntryPoint() == maxGradeFinal).collect(Collectors.toList());
        return sl;
    }

    //


    public List<StudentStandardModel> getStudentByType(String type) {
        return uni.getStudents().stream().filter(s -> checkTypeOfStudent(type, s)).collect(Collectors.toList());
    }

    //9
    public List<In_serviceStudent> getIn_serviceStudentAt(Faculty fa, String trainingCoopPlace) {
        List<In_serviceStudent> l = new LinkedList<>();
        for (StudentStandardModel s : uni.getStudents()) {
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
    public List<StudentStandardModel> getHighestAvgGradeStudent(Faculty fa, int semesterIndex) {
        TreeMap<Double, StudentStandardModel> sl = new TreeMap();

        StudentStandardModel student;
        for (StudentStandardModel s : fa.getSubjectList()) {
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
        double highestGrade = sl.lastKey().doubleValue();
        List<StudentStandardModel> hl = new LinkedList<>();
        for (Map.Entry<Double, StudentStandardModel> st : sl.entrySet()) {
            if (st.getKey() == highestGrade) hl.add(st.getValue());
        }

        return hl;
    }

    ;
    //

    //10
    public List<StudentStandardModel> findStudentsHigherThan(Faculty fa, int semesterIndex, double gradeBase) {
        Map<Double, StudentStandardModel> sl = new HashMap<>();

        StudentStandardModel student;
        for (StudentStandardModel s : fa.getSubjectList()) {
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
        List<StudentStandardModel> hl = new LinkedList<>();
        for (Map.Entry<Double, StudentStandardModel> st : sl.entrySet()) {
            if (st.getKey() >= gradeBase) hl.add(st.getValue());
        }

        return hl;
    }

    ;
    //

    //12
    // asc = true; desc = false;
    // type asc ; start year desc
    public List<StudentStandardModel> sortByAvgPoint(Faculty fa, boolean order) {
        List<StudentStandardModel> sl = fa.getSubjectList();
        Collections.sort(sl, new Comparator<StudentStandardModel>() {
            @Override
            public int compare(StudentStandardModel s1, StudentStandardModel s2) {
                if (s1.getClass().getSimpleName().equals(s2.getClass().getSimpleName())) {
                    return s2.getStartYear().compareTo(s1.getStartYear());
                }
                return s1.getClass().getSimpleName().equals("RegularStudent") ? 1 : -1;
            }
        });
        return sl;
    }
    //

    //13
    public Map<Date, List<StudentStandardModel>> countStudentByYear(Faculty fa) {
        TreeMap<Date, List<StudentStandardModel>> slc = new TreeMap<>();
        List<StudentStandardModel> sl;
        for (StudentStandardModel s : fa.getSubjectList()) {
            List<StudentStandardModel> studentList = slc.get(s.getStartYear());
            if (studentList == null)
                slc.put(s.getStartYear(), new LinkedList<>());
            else studentList.add(s);
        }
        return slc;
    }
    //

}
