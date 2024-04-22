package dto;

public class User {

	private String firstName, middleName, lastName, dob, gender, email;
	
	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getmiddleName() {
		return middleName;
	}

	public void setmiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getlastName() {
		return lastName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getdob() {
		return dob;
	}
	
	public void dob(String Dob) {
		this.dob = Dob;
	}
	
	public String getgender() {
		return lastName;
	}
	
	public void setgender1(String Gender) {
		this.gender = Gender;
	}


	public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email = email;
	}

}