package com.fiveWork;

public class PIMContact extends PIMEntity{
    private String firstName;
    private String lastName;
    private String emailAddress;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    @Override
    public void fromString(String s) {
	// TODO Auto-generated method stub
	System.out.println(s);
    }
    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "CONTACT "+getPriority()+" "+getFirstName()+" "+
		getLastName()+" "+getEmailAddress();
    }
}
