package controller;

import model.Document;
import relatedException.documentException.InvalidCodeException;
import relatedException.documentException.InvalidNumberOfReleaseException;
import relatedException.documentException.InvalidPublisherException;

import java.util.Arrays;
import java.util.Scanner;

public class GeneralFeatureContainer {
    public static void viewByLine(String... params) {
        Arrays.stream(params).forEach(
                s -> System.out.println(s)
        );
    }

    public static Document getDocumentInfo() throws Exception{
        Document b = null;
        Scanner sc = new Scanner(System.in);
        String Code;
        String publisher;
        int numberOfRelease;
        System.out.println("Enter code:");
        Code = sc.nextLine().trim();
        if (Code.isEmpty()) throw new InvalidCodeException("Code is empty");
        System.out.println("Enter publisher");
        publisher = sc.nextLine().trim();
        if (publisher.isEmpty()) throw new InvalidPublisherException("publisher is invalid");
        System.out.println("Enter number of release: ");
        try {
            numberOfRelease = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ex) {
            throw new InvalidNumberOfReleaseException("Invalid Format Of Number Of Release");
        }
        return new Document(Code, publisher, numberOfRelease);
    }
}
