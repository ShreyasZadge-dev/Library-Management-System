package pkg_person;

public class Librarian extends Person {
   private int id;
   private String doj;
   public int getId() {
    return id;
   }
   public void setId(int id) {
    this.id = id;
   }
   public String getDoj() {
    return doj;
   }
   public void setDoj(String doj) {
    this.doj = doj;
   }
   public Librarian(String name, String emailId, String phonenumber, String address, String dob, int id, String doj) {
    super(name, emailId, phonenumber, address, dob);
    this.id = id;
    this.doj = doj;
   }
   public Librarian() {
    super();
   }
   @Override
   public String toString() {
    return "Librarian [name=" + name + ", id=" + id + ", doj=" + doj + ", emailId=" + emailId + ", phonenumber="
            + phonenumber + ", address=" + address + ", dob=" + dob + ", getId()=" + getId() + ", getName()="
            + getName() + ", getDoj()=" + getDoj() + ", getEmailId()=" + getEmailId() + ", getPhonenumber()="
            + getPhonenumber() + ", getAddress()=" + getAddress() + ", getDob()=" + getDob() + "]";
   }

   
   
   
   
    
}