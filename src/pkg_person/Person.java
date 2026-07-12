package pkg_person;

abstract public class Person {
    protected String name;
    protected String emailId;
    protected String phonenumber;
    protected String address;
    protected String dob;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public Person(String name, String emailId, String phonenumber, String address, String dob) {
        this.name = name;
        this.emailId = emailId;
        this.phonenumber = phonenumber;
        this.address = address;
        this.dob = dob;
    }
    public Person() {
    }

    
}
