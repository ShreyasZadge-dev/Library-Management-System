package pkg_person;

import java.io.Serializable;
import java.util.regex.Pattern;

abstract public class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String name;
    protected String emailId;
    protected String phonenumber;
    protected String address;
    protected String dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        boolean isValidName = Pattern.matches("^[a-zA-Z\\s]+$", name);
        this.name = name;
        if (isValidName) {
            this.name = name;
        } else {
            this.name = "Default Name";
        }

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
        // boolean isValidDob = Pattern.matches("\\d{2}-\\d{2}-\\d{4}", dob);
        // if (isValidDob) {
            this.dob = dob;
        // }
        // this.dob = "01-06-2005";
    }

    public Person(String name, String emailId, String phonenumber, String address, String dob) {
        this.setName(name);
        this.emailId = emailId;
        this.phonenumber = phonenumber;
        this.address = address;
        this.setDob(dob);
    }

    public Person() {
    }

}
