package pkg_main;

import java.util.Scanner;

import pkg_book.Book;
import pkg_book.BookManager;
import pkg_exception.BookNotFoundException;
import pkg_exception.StudentNotFoundException;
import pkg_person.Student;
import pkg_person.StudentManager;
import pkg_transaction.BooktransactionManager;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static String prompt(String message) {
        System.out.print(message); // Using print keeps the cursor on the same line
        return sc.nextLine();
    }

    public static void main(String[] args) {
        int choice;

        Scanner sc = new Scanner(System.in);
        BookManager bm = new BookManager();
        StudentManager sm = new StudentManager();
        BooktransactionManager btm = new BooktransactionManager();

        do {
            System.out.println("Enter 1 if Student\nEnter 2 if Librarian\nEnter 3 if Exit");
            choice = sc.nextInt();
            if (choice == 1) // user is student
            {
                System.out.println("Enter Your RollNo:- ");
                int rollno = sc.nextInt();
                try {
                    Student s = sm.get(rollno);
                    if (s == null) {
                        throw new StudentNotFoundException();

                    }
                    int stud_choice;
                    do {
                        System.out.println("\r\n" + //
                                "Enter 1 to View All Books \r\n" + //
                                "Enter 2 to Search Book by ISBN\r\n" + //
                                "Enter 3 to Search Books by Subject\r\n" + //
                                "Enter 4 to Issue a book\r\n" + //
                                "Enter 5 to Return a book\r\n" + //
                                "Enter 99 to Exit \r\n" + //
                                "");
                        stud_choice = sc.nextInt();

                        switch (stud_choice) {
                            case 1:
                                System.out.println("====== All Records ======");
                                bm.viewAllBooks();
                                break;
                            case 2: // serach book by isbn
                                System.out.println("To Serach Book by Isbn");
                                int search_isbn = Integer.parseInt(prompt("Enter isbn to search : "));
                                Book serach_book = bm.searchBookByIsbn(search_isbn);
                                if (serach_book == null)
                                    System.out.println("Book Not Found");
                                else
                                    System.out.println(serach_book);
                                break;
                            case 3:// search book by subject
                                System.out.println("search books by subject");
                                String search_subject = prompt("Enter subject to search : ");
                                bm.listBooksBySubject(search_subject);
                                
                                break;
                            case 4: // issue a book
                                System.out.println("Issues a book");
                                 int issue_isbn = Integer.parseInt(prompt("Enter isbn to Issue : "));
                                  Book book = bm.searchBookByIsbn(issue_isbn);  
                                  try{
                                    if(book==null){
                                        throw new BookNotFoundException();
                                    }
                                    if(book.getAvailable_quantity()>0){
                                        if(btm.issueBook(rollno, issue_isbn)){
                                            book.setAvailable_quantity(book.getAvailable_quantity()-1);
                                            System.out.println("book has Been issued");
                                        }
                                    } 
                                    else{
                                        System.out.println(
                                            "book not availble to issue ...");
                                        
                                    }
                                   
                                  }
                                  catch(BookNotFoundException bnfe){
                                    System.out.println(bnfe);
                                  }                                
                                 break;
                            case 5:
                                System.out.println("To return a book");
                                 int return_isbn = Integer.parseInt(prompt("Enter isbn to Return : "));
                                 book=bm.searchBookByIsbn(return_isbn);
                                 if (book!=null){
                                 if(btm.returnBook(rollno,return_isbn)){
                                        book.setAvailable_quantity(book.getAvailable_quantity()+1);
                                        System.out.println("thank For returning the book");
                                    }
                                    else{
                                        System.out.println("Could not Return a book");
                                    }
                                }
                                else{
                                    System.out.println("book does not exits");
                                }
                                 break;
                            case 99:
                                System.out.println("Thanks for using Library");
                                break;
                            default:
                                System.out.println("Invalid Input");
                                break;
                        }

                    } while (stud_choice != 99);
                } catch (StudentNotFoundException e) {
                    System.out.println(e);
                }
            }

            else if (choice == 2) // user is libraian
            {
                int lib_choice;
                do {
                    System.out.println("\r\n" + //
                            "Enter 11 to View All Students\r\n" + //
                            "Enter 12 to print Student by Rollno\r\n" + //
                            "Enter 13 to Register a student\r\n" + //
                            "Enter 14 to Update a student\r\n" + //
                            "Enter 15 to delete a student\r\n" + //
                            "Enter 21 to view All Books\r\n" + //
                            "Enter 22 to to print a Book by Isbn\r\n" + //
                            "Enter 23 to Register a new Book\r\n" + //
                            "Enter 24 to Update A book\r\n" + //
                            "Enter 25 to Delete A book\r\n" + //
                            "Enter 31 to View All Transaction\r\n" + //
                            "Enter 99 to Exit \r\n" + //
                            "");
                    lib_choice = sc.nextInt();

                    switch (lib_choice) {
                        case 11: // to show all student
                            System.out.println("====== All Student Records ======");
                            sm.viewAllStudent();
                            break;
                        case 12: // search student by roll number
                            System.out.println("Enter RollNo To Fetch Record:-");
                            int get_rollno = sc.nextInt();
                            Student student = sm.get(get_rollno);
                            if (student == null)
                                System.out.println("Student Not Found");
                            else
                                System.out.println(student);
                            break;
                        case 13: // Register A Studnet
                            System.out.println("Enter Students Details to Add");
                            sc.nextLine();
                            String name = prompt("Name: ");
                            String emailId = prompt("Email: ");
                            String phonenumber = prompt("Phono: ");
                            String address = prompt("Address: ");
                            String dob = prompt("DOB: ");
                            int rollNo = Integer.parseInt(prompt("Rollno: "));
                            int std = Integer.parseInt(prompt("Std: "));
                            String divsion = prompt("Div: ");
                            student = new Student(name, emailId, phonenumber, address, dob, rollNo, std, divsion);
                            sm.addAStudent(student);
                            System.out.println("Student Added !");
                            break;
                        case 14: // update student
                            try {
                                int modify_rollno = Integer.parseInt(prompt("Enter A Rollno:"));
                                student = sm.get(modify_rollno);
                                if (student == null) {
                                    throw new StudentNotFoundException();
                                    // System.out.println("Student not Found");
                                }
                                name = prompt("Name: ");
                                emailId = prompt("Email: ");
                                phonenumber = prompt("Phono: ");
                                address = prompt("Address: ");
                                dob = prompt("DOB: ");
                                std = Integer.parseInt(prompt("Std: "));
                                divsion = prompt("Div: ");
                                sm.updateStudent(modify_rollno, name, emailId, phonenumber, address, dob, std, divsion);
                                System.out.println("Student Record updated");
                            } catch (StudentNotFoundException es) {
                                System.out.println(es);
                            }
                            break;

                        case 15:// delete a student
                            int delete_rollno = Integer.parseInt(prompt("Enter A Rollno:"));
                            if (sm.deleteStudent(delete_rollno)) {
                                System.out.println("Student is Record Removed!");
                            } else {
                                System.out.println("Roll no Does not Exits to delete");
                            }
                            break;
                        case 21:// view all books
                            System.out.println("====== All Records ======");
                            bm.viewAllBooks();
                            break;
                        case 22:// search by book by isbn
                            int search_isbn = Integer.parseInt(prompt("Enter isbn to search : "));
                            Book serach_book = bm.searchBookByIsbn(search_isbn);
                            if (serach_book == null)
                                System.out.println("Book Not Found");
                            else
                                System.out.println(serach_book);
                            break;
                        case 23: // add a book to libray
                            int isbn = Integer.parseInt(prompt("Enter ISBN : "));
                            String title = prompt("Enter Title : ");
                            String author = prompt("Enter Author : ");
                            String publisher = prompt("Enter Publisher : ");
                            int edition = Integer.parseInt(prompt("Enter Edition : "));
                            String subject = prompt("Enter a Subject : ");
                            int available_quantity = Integer.parseInt(prompt("Enter Available Quanitity : "));
                            Book add_book = new Book(isbn, title, author, publisher, edition, subject,
                                    available_quantity);
                            bm.addBook(add_book);
                            System.out.println("book added !");
                            break;
                        case 24:// update a record
                            int update_isbn = Integer.parseInt(prompt("Enter ISBN to update : "));
                            title = prompt("Enter Title : ");
                            author = prompt("Enter Author : ");
                            publisher = prompt("Enter Publisher : ");
                            edition = Integer.parseInt(prompt("Enter Edition : "));
                            subject = prompt("Enter a Subject : ");
                            available_quantity = Integer.parseInt(prompt("Enter Available Quanitity : "));
                            bm.updateBook(update_isbn, title, author, publisher, edition, subject, available_quantity);
                            System.out.println("Record Updated !");
                            break;
                        case 25: // delete a record
                            int delete_isbn = Integer.parseInt(prompt("Enter ISBN to Delete : "));
                            if (bm.deleteBook(delete_isbn)) {
                                System.out.println("Record a Deleted");
                            } else {
                                System.out.println("Record not found to delete");
                            }
                            break;
                        case 31:// show all transcation
                            System.out.println("===== All Records =====");
                            btm.showAll();
                            break;    
                        case 99:
                            System.out.println("thanks for using program");
                            break;

                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
                } while (lib_choice != 99);
            }

        } while (choice != 3);
        sm.writeToFile();
        bm.writeToFile();
        btm.writeToFile();
        sc.close();

    }
}
