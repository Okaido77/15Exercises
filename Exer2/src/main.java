import controller.DocumentManager;
import controller.GeneralFeatureContainer;
import model.Book;
import model.Document;
import model.Journal;
import model.Newspaper;
import relatedException.InvalidChoiceException;
import relatedException.bookException.InvalidAuthorNameException;
import relatedException.bookException.InvalidNumberOfPageException;
import relatedException.journalException.InvalidReleaseDateException;
import relatedException.newspaperException.InvalidReleaseMonthException;
import relatedException.newspaperException.InvalidReleaseNumberException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DocumentManager bm = new DocumentManager(new HashSet());
        while (true) {
            GeneralFeatureContainer.viewByLine("Document Management System",
                    "1.Add A New Document",
                    "2.Search by type",
                    "3.List All Document",
                    "4.Find Doucment by Code",
                    "5.Exit"
            );
            String choice = sc.nextLine().trim();
            try {
                switch (choice) {
                    case "1":
                        GeneralFeatureContainer.viewByLine("Enter type of document:",
                                "1.Book",
                                "2.Journal",
                                "3.Newspaper"
                        );
                        System.out.println("Enter Type Of Document: ");
                        Document newDoc;
                        String option = sc.nextLine();
                        try {
                            switch (option) {
                                case "1":
                                    newDoc = GeneralFeatureContainer.getDocumentInfo();
                                    if (newDoc == null) break;
                                    String authorName;
                                    int numberOfPage = 0;

                                    System.out.println("enter author's name: ");
                                    authorName = sc.nextLine().trim();
                                    if (authorName.isEmpty())
                                        throw new InvalidAuthorNameException("Author Name is Empty!");
                                    System.out.println("Enter number of page: ");
                                    numberOfPage = Integer.parseInt(sc.nextLine());
                                    if (numberOfPage == 0)
                                        throw new InvalidNumberOfPageException("Number of page is invalid");
                                    newDoc = new Book(newDoc.getCode(), newDoc.getPublisher()
                                            , newDoc.getNumberOfRelease(), authorName, numberOfPage
                                    );
                                    break;
                                case "2":
                                    newDoc = GeneralFeatureContainer.getDocumentInfo();
                                    if (newDoc == null) break;
                                    LocalDate releaseDate;
                                    System.out.println("Enter release date(yyyy-MM-dd): ");
                                    try {
                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                        releaseDate = LocalDate.parse(sc.nextLine().trim(), formatter);
                                    }catch (RuntimeException ex){
                                        throw new InvalidReleaseDateException("Incorrect release date format");
                                    }
                                    newDoc = new Journal(newDoc.getCode(), newDoc.getPublisher(), newDoc.getNumberOfRelease(), releaseDate);
                                    break;
                                case "3":
                                    newDoc = GeneralFeatureContainer.getDocumentInfo();
                                    if (newDoc == null) break;
                                    int releaseNumber;
                                    int releaseMonth;

                                    System.out.println("Enter Release Number:");
                                    try {
                                        releaseNumber = Integer.parseInt(sc.nextLine());
                                    }catch (NumberFormatException ex){
                                        throw new InvalidReleaseNumberException("Incorrect Release Number Format");
                                    }
                                    System.out.println("Enter Release Month: ");
                                    releaseMonth = Integer.parseInt(sc.nextLine());
                                    if (releaseMonth < 1 || releaseMonth > 12)
                                        throw new InvalidReleaseMonthException("Release Month is invalid");
                                    newDoc = new Newspaper(newDoc.getCode(), newDoc.getPublisher(), newDoc.getNumberOfRelease(), releaseNumber, releaseMonth);
                                    break;
                                default:
                                    throw new InvalidChoiceException("No Type Found");
                            }
                            boolean n = bm.AddNewDocument(newDoc);
                            if (n == true) System.out.println("this document is added successfully");
                            else System.out.println("this document already exists");
                        } catch (Exception ex) {
                            System.out.println("Error:" + ex.getMessage());
                        }

                        break;
                    case "2":
                        System.out.println("Enter type of document");
                        String type = sc.nextLine().trim();
                        Set<Document> docList = bm.searchByType(type);
                        if (docList.size() != 0)
                            docList.forEach(
                                    d -> System.out.println(d)
                            );
                        else
                            System.out.println("No Documents Found");
                        break;
                    case "3":
                        System.out.println("document list :");
                        bm.listAll();
                        break;
                    case "4":
                        System.out.println("Enter a code: ");
                        String code = sc.nextLine().trim();
                        Document d = bm.searchByCode(code);
                        if (d != null)
                            System.out.println(d);
                        else System.out.println("No Data Found");
                        break;
                    case "5":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        throw new InvalidChoiceException("Invalid choice");
                }
            } catch (Exception ex) {
                System.out.println("Error:");
                System.out.println(ex.getMessage());
            }

        }
    }
}
