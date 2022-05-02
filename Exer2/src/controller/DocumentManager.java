package controller;

import model.Document;

import java.util.*;
import java.util.stream.Collectors;

public class DocumentManager {

    Set<Document> documentList;

    public boolean AddNewDocument(Document document) {
        if (documentList.add(document))
            return true;

        return false;
    }

    public boolean deleteById(int code) {
        Optional<Document> targetBook = documentList.stream().filter(
                d -> d.getCode().equals(code)
        ).findFirst();
        if (targetBook.isPresent()) {
            documentList.remove(targetBook.get());
            return true;
        }
        return false;
    }

    public Set<Document> searchByType(String type) {
        Set<Document> targetDocs = documentList.stream().filter(
                d -> d.getClass().getSimpleName().equals(type)
        ).collect(Collectors.toSet());
        return targetDocs;
    }

    public Document searchByCode(String code) {
        Optional<Document> RecordFound = documentList.stream().filter(
                d -> d.getCode().equals(code)
        ).findFirst();
        if (RecordFound.isPresent()) return RecordFound.get();
        return null;
    }

    public void listAll() {
        if (documentList.size() == 0) System.out.println("No data");
        else
            documentList.forEach(
                    s -> System.out.println(s)
            );
    }

    public DocumentManager(HashSet<Document> documentList) {
        this.documentList = documentList;
    }

}
