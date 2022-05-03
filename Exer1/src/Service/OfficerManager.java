package Service;

import model.Officer;

import java.util.*;
import java.util.stream.Collectors;

public class OfficerManager {
    Set<Officer> officerList;

    public OfficerManager(HashSet<Officer> officerList) {
        this.officerList = officerList;
    }

    public boolean addNewOfficer(Officer officer) {
        if (officerList.add(officer)){
            return true;
        }
        else {
            return false;
        }
    }

    public Set<Officer> searchByName(String name) {
        Set<Officer> list = officerList.stream().filter(o -> o.getName().contains(name)).collect(Collectors.toSet());
        return list;
    }

    public void ListAll() {
        System.out.println("List Of Officers: ");
        if (officerList.isEmpty()) {
            System.out.println("Empty!");
            return;
        }
        officerList.stream().forEach(
               o ->  System.out.println(o+"\n")
        );

    }




}
