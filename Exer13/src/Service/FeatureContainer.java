package Service;

import model.Employee;
import model.Experience;
import model.Fresher;
import model.Intern;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FeatureContainer {
    Scanner sc = new Scanner(System.in);
    void viewAllLines(String... lines){
        for(String line : lines)
            System.out.println(line);
    }
    EmployeeManager em ;
    public FeatureContainer(List<Employee> el) {
        em = new EmployeeManager(el);
    }

    public void addANewEmployee(){
        String input;
        viewAllLines("Enter type of employee",
                "1.Experience",
                "2.Fresher",
                "3.Intern"
                );
        String choice = sc.nextLine().trim();

        switch (choice){

        }
    }
    private Employee takeEmployeeInfo(){
        return null;
    }
    private Experience takeExperienceInfo(){
        return null;
    }

    private Fresher takeFresherInfo(){
        return null;
    }
    private Intern takeInternInfo(){
        return null;
    }

    public void updateANewEmployee(){

    }
    public void findEmployeeByType(){

    }

}
