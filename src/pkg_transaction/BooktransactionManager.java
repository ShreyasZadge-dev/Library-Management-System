package pkg_transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class BooktransactionManager {
    ObjectOutputStream oos_booktransaction = null;
    ObjectInputStream ois_booktransaction =null;
    File book_file=null;
    ArrayList <Booktransaction> book_list=null;

    @SuppressWarnings("unchecked")
    public BooktransactionManager(){
        book_file= new File("Booktransaction.dat");
        book_list= new ArrayList<Booktransaction>();

        if(book_file.exists()){
            try{
            ois_booktransaction=new ObjectInputStream(new FileInputStream(book_file));
            book_list =(ArrayList<Booktransaction>)ois_booktransaction.readObject();
            }
            catch(IOException | ClassNotFoundException  e){
                e.printStackTrace();
            }

        }
    }

    public boolean issueBook(int rollno,int isbn){
        int total_books_issued=0;

        for (Booktransaction book_i : book_list) {
            if ((book_i.getRollno()==rollno)&&(book_i.getReturnDate()==null)) {
                total_books_issued+=1;
                if(total_books_issued>=3){
                    return false;
                }
            }
        }
        String issueDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        Booktransaction book_transcationnew=new Booktransaction(isbn,rollno,issueDate,null);
        book_list.add(book_transcationnew);

        return true;
    }


    public boolean returnBook(int rollno,int isbn){
        for (Booktransaction book_i : book_list){
            if ((book_i.getRollno()==rollno)&&(book_i.getIsbn()==isbn)&&(book_i.getReturnDate()==null)){
                  String returnDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());  
                  book_i.setReturnDate(returnDate);
                  return true; 
            }
        }
        return false;
    }


    public void showAll(){
        for (Booktransaction book_i : book_list) System.out.println(book_i);
    }

}
