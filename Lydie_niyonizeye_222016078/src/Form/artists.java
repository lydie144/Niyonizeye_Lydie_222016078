package Form;

public class artists {

private String name ;
private String genre;
private String website;
private String contactEmail;
private int id;

public artists() {}
public artists(int id, String name, String genre ,String website,String contactEmail ) {
	this.id = id;
	this.name = name;
	this.genre = genre;
	this.website = website;
	this.contactEmail = contactEmail;
}
public String getcontactEmail() {
	return contactEmail;
}
public void setContactEmail(String contactEmail) {
	this.contactEmail = contactEmail;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


}

