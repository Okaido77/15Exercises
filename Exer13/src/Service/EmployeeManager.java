package Service;

import model.Employee;
import model.Experience;
import model.Fresher;
import model.Intern;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeManager {
    List<Employee> employeeList ;

    public EmployeeManager(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public boolean addAEmployee(Employee e){
        Optional<Employee> record = employeeList.stream().filter( em -> em.equals(e)).findFirst();
        if(record.isPresent()) return false;
        employeeList.add(e);
        return true;
    }
    public boolean updateAEmployee(String id,Employee e){
        Optional<Employee> record = employeeList.stream().filter( em -> em.getID().equals(id)).findFirst();
        if(record.isPresent()){
            Employee em = record.get();
            em.setID(e.getID());
            em.setEmployee_type(em.getEmployee_type());
            em.setEmail(em.getEmail());
            em.setBirthDay(new Date(e.getBirthDay().getTime()));
            em.setFullName(e.getFullName());
            em.setPhone(e.getPhone());

            if(em instanceof Experience){
                Experience ex  = (Experience) em;
                Experience ex2  = (Experience) e;
                ex.setExpInYear(ex2.getExpInYear());
                ex.setProSkill(ex2.getProSkill());
            }

            if(em instanceof Fresher){
                Fresher fr  = (Fresher) em;
                Fresher fr2  = (Fresher) e;
                fr.setEducation(fr2.getEducation());
                fr.setGraduation_date(new Date(fr2.getGraduation_date().getTime()));
                fr.setGraduation_rank(fr2.getGraduation_rank());
            }

            if(em instanceof Intern){
                Intern in  = (Intern) em;
                Intern in2  = (Intern) e;
                in.setMajors(in2.getMajors());
                in.setSemester(in2.getSemester());
                in.setUniversity_name(in2.getUniversity_name());


            }
        }

        return false;
    }
    public boolean deleteAEmployee(String id){
        Optional<Employee> record = employeeList.stream().filter( em -> em.getID().equals(id)).findFirst();
        if(record.isPresent())
            return employeeList.remove(record.get());
        return false;
    }
    //9 , 10 , 11
    public List<Employee> getEmployeeListByType(String type){
        List<Employee> l = employeeList.stream().filter(e -> e.getEmployee_type().equals(type)).collect(Collectors.toList());
        return l;
    }
}
