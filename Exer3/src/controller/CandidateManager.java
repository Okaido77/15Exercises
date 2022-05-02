package controller;

import model.Candidate;

import java.util.Optional;
import java.util.Set;

public class CandidateManager {
    Set<Candidate> candidateList;

    public CandidateManager(Set<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    public boolean AddNewCandidate(Candidate candidate) {
        if (candidateList.add(candidate))
            System.out.println("this Candidate Added Successfully!");
        else
            System.out.println("this Candidate already exists");
        return false;
    }

    public void listAll() {
        if (candidateList.size() == 0)
            System.out.println("No Data");
        candidateList.forEach(
                c -> System.out.println(c)
        );

    }

    public Candidate findByID(String id) {
        Optional<Candidate> record = candidateList.stream().filter(c -> c.getId().equals(id)).findFirst();
        if (record.isPresent()){
            return record.get();
        }
        return null;
    }

}
