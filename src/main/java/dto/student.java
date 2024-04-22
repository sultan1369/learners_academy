package dto;

public class student {

	private String firstName, middleName, lastName, dob, gender, email, institute, course;
	private int studentId;
	
	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName = firstName;
		
	}
	public String getmiddleName() {
		return middleName;
	}

	public void setmiddleName(String middleName) {
		// TODO Auto-generated method stub
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

	public void setdob(String Dob) {
		this.dob = Dob;
		
	}
	public String getgender() {
		return gender;
	}

	public void setgender(String Gender) {
		this.gender = Gender;
		
	}
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
		
	}
	

	    public String getInstitute() {
	        return institute;
	    }

	    public void setInstitute(String institute) {
	        this.institute = institute;
	    }
	
	public String getcourse() {
		return course;
	}

	public void setcourse(String course) {
		this.course = course;
		
	}
	
	public int getstudentId() {
		return studentId;
	}

	public void setstudentId(int studentId) {
		// TODO Auto-generated method stub
		this.studentId = studentId;
	}

	
	
	

	

}
