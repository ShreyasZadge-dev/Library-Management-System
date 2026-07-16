package pkg_main;

import java.util.Scanner;

import pkg_book.BookManager;
import pkg_exception.StudentNotFoundException;
import pkg_person.Student;
import pkg_person.StudentManager;
import pkg_transaction.BooktransactionManager;

public class Main {
    public static void main(String[] args) {
        int choice;

        Scanner sc = new Scanner(System.in);
        BookManager bm = new BookManager();
        StudentManager sm = new StudentManager();
        BooktransactionManager btm = new BooktransactionManager();

        do {
            System.out.println("Enter 1 if Student\nEnter 2 if Librarian\nEnter 3 if Exit");
            choice = sc.nextInt();
            if (choice == 1) {
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
                        stud_choice=sc.nextInt();
                        
                        switch(stud_choice){
                            case 1:
                               System.out.println("View All Books");
                               break;
                            case 2:
                                System.out.println("To Serach Book by Isbn");
                                break;    
                            case 3:
                                System.out.println("search books by subject");
                                break;
                            case 4:
                                System.out.println("Issues a book");  
                                break;
                            case 5:
                                System.out.println("To return a book");
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
        } while (choice != 3);
    }
}
