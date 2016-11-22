import java.text.NumberFormat;




public class Book {
String title, author,ISBN,PlaceHold,ReturnDay, BookFront_page,reservationNum;;
private double price=0.0;
double amount;
boolean valied_Book;
	public Book() {
		title="";
		author="";
		ISBN="";
		//price=0.0;
		amount=0.0;
		PlaceHold="";
		ReturnDay="";
		reservationNum="";
		valied_Book=true;
	}
	public Book(String Ntitle,String Nauthor,String NISBN, double Nprice) {
		title=Ntitle;
		author=Nauthor;
		ISBN=NISBN;
		price=Nprice;
		amount=0.0;
		PlaceHold="";
		ReturnDay="";
		reservationNum="";
		valied_Book=true;
	}
	public boolean isvaliedBook(){
		return valied_Book;
	}
	public void setValiedStatus(boolean onoff){
		valied_Book=onoff;
	}
	public void SetPlaceHold(String NplaceHold){
		PlaceHold=NplaceHold;
	}
	public String getFrontCover(){
		return BookFront_page;
	}
	public void SetReservation(String Rese){
		reservationNum=Rese;
	}
	public void setFrontCover(String newcover){
		BookFront_page=newcover;
	}
	public String GeTPlaceHold(){
		return PlaceHold;
	}
	public void SetReturnDay(String day){
		ReturnDay=day;
	}
	public String GetReturnDay(){
		return ReturnDay;
	}
	public void SetAmount(double a){
		amount=a;
	}
	public double getAmmount(){
		return amount;
	}
	public double getPrice(){
		return price;
	}
	public String GetBookData(){
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString="";
		if(valied_Book)		 moneyString = formatter.format(amount);
		if(!valied_Book)	 moneyString = formatter.format(0.00);
		String status="";
		if(valied_Book) status="Recerved";
		if(!valied_Book) status="Canceld";
		String s=title+"     "+status+"\n"+author+"\nHold Day "+PlaceHold+"\nReturn Day"+ReturnDay+"\nPrice: "+moneyString;
		//System.out.print(s);
		return s;//title+ "|"+author+"|"+PlaceHold+"|"+ ReturnDay+"|"+moneyString;
	}
	public String toString(){
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(price);
		return (title +"\n"+author+"\n"+ISBN+"\n"+moneyString+"\n");//+price+" "+PlaceHold+" "+ReturnDay);
	}
	public boolean equals(Object otherObject)
	{
	Book otherBook = (Book)otherObject;
	return (title.equals(otherBook.title)
	&& author.equals(otherBook.author) && ISBN.equals(otherBook.ISBN));
	}
}
