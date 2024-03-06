package Form;

public class stages {

private int id;
private String name;
private String capacity;

public stages () {}
public stages (int id, String name, String capacity  ) {
	this.id = id;
	this.name = name;
	this.capacity = capacity;
	
}
public String getcapacity() {
	return capacity;
}
public void setcapacity(String capacity) {
	this.capacity = capacity;
}
public String getName() {
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

