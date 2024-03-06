package Form;

public class attendees {
	private int id ;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Phone;
	
public attendees() {}
public attendees(int attendeeid, String FirstName, String LastName ,String Email,String Phone ) {
	this.id = id;
	this.FirstName = FirstName;
	this.LastName = LastName;
	this.Email = Email;
	this.Phone = Phone;
}
public String getEmail() {
	return Email;
}
public void setEmail(String Email) {
	this.Email = Email;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstname) {
	this.FirstName = firstname;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastname) {
	this.LastName = lastname;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	this.Phone = phone;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


}

