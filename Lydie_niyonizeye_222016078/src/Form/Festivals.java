package Form;

public class Festivals {

private int id;
private String name;
private String location; 
private String startDate;
private String endDate;
private String organizer;
private String ticketPrice;

public Festivals () {}
public Festivals (int id, String name, String location, String startDate, String endDate, String organizer,String ticketPrice ) {
	this.id = id;
	this.name = name;
	this.location = location;
	this.startDate = startDate;
	this.endDate = endDate;
	this.organizer = organizer;
	this.ticketPrice = ticketPrice;
	
}
public String getticketPrice() {
	return ticketPrice;
}
public void setticketPrice(String ticketPrice) {
	this.ticketPrice = ticketPrice;
}
public String getorganizer() {
	return organizer;
}
public void setorganizer(String organizer) {
	this.organizer = organizer;
}

public String getendDate() {
	return endDate;
}
public void setendDate(String endDate) {
	this.endDate = endDate;
}
public String getstartDate() {
	return startDate;
}
public void setstartDate(String startDate) {
	this.startDate = startDate;
}
public String getlocation() {
	return location;
}
public void setlocation(String location) {
	this.location = location;
}	
public String getname() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


}

