package Form;
import java.sql.Date;

public class Ticket {
private int Ticketid ; 
private Date   PurchaseDate ;
private int price ;
public Ticket() {}
public Ticket(int id, Date PurchaseDate) {
	this.Ticketid = Ticketid;
	this.price = price;
	this.PurchaseDate = PurchaseDate;
}

public int getId() {
	return Ticketid;
}
public int price() {
	return price;
}
public void setId(int id) {
	this.Ticketid = id;
}
public void setprice(int price) {
	this.price = price;
}
public  Date getpurchasedate() {
	return PurchaseDate;
}
public void setpurchasedate(Date purchasedate) {
	this.PurchaseDate = purchasedate;
}


}



