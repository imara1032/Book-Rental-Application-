import java.util.ArrayList;
public class User {
	String UserName;
	String PassWord;
	String StartDay;
	ArrayList<Book> BookList;
	User(){
		UserName="";
		PassWord="";
		StartDay="";
		BookList=new ArrayList<Book>();
		}
	User(String name, String pass, String date){
		UserName=name;
		PassWord=pass;
		StartDay=date;
		BookList=new ArrayList<Book>();
	}
	public void AddBook(Book a){
		BookList.add(a);
	}
	
	public String toString(){
		String data="";
		data=data+"UserName:" +UserName+"\nPassword:"+PassWord+"\nMembership Date:"+ StartDay+"\n";
		return data;
	}
	public boolean equals(Object otherObject)
	{
	User otherEmployee = (User)otherObject;
	return (UserName.equals(otherEmployee.UserName)
	&& PassWord.equals(otherEmployee.PassWord));
	}

}
