package Service;

import model.GoodStudent;
import model.NormalStudent;
import model.Student;
import relatedException.CandidateManagerException.InvalidNumberOfCandidateException;

import java.util.*;
import java.util.stream.Collectors;

public class CandidateManager {
    List<Student> studentList;

    public CandidateManager(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> filterCandidate(int number) throws InvalidNumberOfCandidateException {
        if (number < 11 || number > 15)
            throw new InvalidNumberOfCandidateException(number + "- This number of candidates is not allowed");
        List<Student> candidateList = getTypeOfStudentList("GoodStudent");


        if (candidateList.size() >= 15) {
            Collections.sort(candidateList, new Comparator<Student>() {
                //  good student > 15 sort by gpa desc + name asc
                @Override
                public int compare(Student s1, Student s2) {
                    if (((GoodStudent) s1).getGpa() != ((GoodStudent) s2).getGpa())
                        return (int) (((GoodStudent) s2).getGpa() - ((GoodStudent) s1).getGpa());
                    return s1.getFullName().compareTo(s2.getFullName());
                }
            });
            return candidateList.stream().limit(15).collect(Collectors.toList());
        } else {
            // good student < 15 add more normal student sort by englishscore desc + name asc
            List<Student> normalStudentList = getTypeOfStudentList("NormalStudent");
            Collections.sort(normalStudentList, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    if (((NormalStudent) s1).getEnglishScore() != ((NormalStudent) s2).getEnglishScore())
                        return (int) (((NormalStudent) s2).getEnglishScore() - ((NormalStudent) s1).getEnglishScore());
                    return s1.getFullName().compareTo(s2.getFullName());
                }
            });
            normalStudentList = normalStudentList.stream().limit(15 - candidateList.size()).collect(Collectors.toList());
            candidateList.addAll(normalStudentList);
            return candidateList;
        }

    }

    private List<Student> getTypeOfStudentList(String type) {
        return studentList.stream().filter(s -> s.getClass().getSimpleName().equals(type)).collect(Collectors.toList());
    }

    public boolean addAStudent(Student student) {
        // handling duplicated student
        boolean isDuplicated = studentList.stream().filter(s -> s.equals(s)).findFirst().isPresent();
        if (isDuplicated)
            return false;
        studentList.add(student);
        return true;
    }


    public void listAllStudent() {
        Collections.sort(studentList, new Comparator<Student>() {
            // order by fullname desc, phonenumber asc
            @Override
            public int compare(Student s1, Student s2) {
                if (!s2.getFullName().equals(s1.getFullName()))
                    return s2.getFullName().compareTo(s1.getFullName());
                return s1.getPhoneNumber().compareTo(s2.getPhoneNumber());
            }
        });
        studentList.forEach(
                s -> s.ShowMyInfor()
        );
    }


}
