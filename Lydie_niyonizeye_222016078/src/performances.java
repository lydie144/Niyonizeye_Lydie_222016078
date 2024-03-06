zpackage Form;

public class performances {
	
private int id;
private String PerformanceDate;
private String startTime;
private String duration;

public performances () {}
public performances (int id, String PerformanceDate, String startTime, String duration ) {
	this.id = id;
	this.PerformanceDate = PerformanceDate;
	this.startTime = startTime;
	this.duration = duration;
	
}
public String getduration() {
	return duration;
}
public void setduration(String duration) {
	this.duration = duration;
}
public String getstartTime() {
	return startTime;
}
public void setstartTime(String startTime) {
	this.startTime = startTime;
}
public String PerformanceDate() {
	return startTime;
}
public void setPerformanceDate1(String PerformanceDate) {
	this.PerformanceDate = PerformanceDate;
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public String getPerformanceDate() {
	return PerformanceDate;
}
public void setPerformanceDate(String performanceDate) {
	PerformanceDate = performanceDate;
}


}

