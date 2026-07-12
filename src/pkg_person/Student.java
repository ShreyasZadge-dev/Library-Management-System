package pkg_person;

public class Student extends Person {
    private int rollNo;
    private int std;
    private String divsion;
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public int getStd() {
        return std;
    }
    public void setStd(int std) {
        this.std = std;
    }
    public String getDivsion() {
        return divsion;
    }
    public void setDivsion(String divsion) {
        this.divsion = divsion;
    }
    public Student(String name, String emailId, String phonenumber, String address, String dob, int rollNo, int std,
            String divsion) {
        super(name, emailId, phonenumber, address, dob);
        this.rollNo = rollNo;
        this.std = std;
        this.divsion = divsion;
    }
    public Student() {
       super();
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + ", std=" + std + ", emailId=" + emailId + ", divsion="
                + divsion + ", phonenumber=" + phonenumber + ", address=" + address + ", dob=" + dob + ", getRollNo()="
                + getRollNo() + ", getName()=" + getName() + ", getStd()=" + getStd() + ", getEmailId()=" + getEmailId()
                + ", getDivsion()=" + getDivsion() + ", getPhonenumber()=" + getPhonenumber() + ", getAddress()="
                + getAddress() + ", getDob()=" + getDob() + "]";
    }
    
    
    
}
