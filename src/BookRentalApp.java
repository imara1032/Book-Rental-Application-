/**
 * Imara Dharmakirth
 * Title: CSUMB Library APP
 * Has four main Functions: Create Account, Place Hold, Cancel Hold, and Manage the System.
 * Date:05/10/2015
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class BookRentalApp extends AppFrame implements ActionListener{
	
	JButton[] button = new JButton[4];
	String[] buttonName ={"create.jpg","hold.jpg","cancel.jpg","menageSys.jpg"};
	Dimension ButtonDimension = new Dimension(300,70);
	JPanel PANEL = new JPanel();
	JPanel Label_PANEL = new JPanel();
	
	Font font = new Font("Times new Roman", Font.BOLD, 20);
	
	CreateAccount NewAaccount;
	PlaceHold Place_Hold;
	Account MyAccount;
	
	ArrayList<User> Userlist = new ArrayList<User>();
	ArrayList<Book> list = new ArrayList<Book>();
	
	public BookRentalApp() {
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String s=sdf.format(cal.getTime());
		
		Userlist.add(new User("!admin2","!admin2",s));
		Userlist.add(new User("a@lice5","@csit100",s));
		Userlist.add(new User("$brian7","123abc##",s));
		Userlist.add(new User("!chris12!","CHIS12!!",s));
		
		list.add(new Book("Hot Java","S. Narayanan","123-ABC-101",0.05));		list.get(0).setFrontCover("HotJava.jpg");
		list.add(new Book("Fun Java","Y. Byun","ABCDEF-09",1.00));				list.get(1).setFrontCover("funjava.jpg");
		list.add(new Book("Algorithm for Java","K. Alice","CDE-777-123",0.25));	list.get(2).setFrontCover("algorithm.jpg");
		
	    
	    JLabel labe = new JLabel(new ImageIcon(((new ImageIcon(
 					"libarary.jpg").getImage()
 		            .getScaledInstance(505, 150,
 		                    java.awt.Image.SCALE_SMOOTH)))));
	    
	    Label_PANEL.add(labe);	Label_PANEL.setBackground(new Color(0,0,0,0));
	    add(Label_PANEL,BorderLayout.NORTH);
	    
		for(int i=0; i<4;i++){
 			button[i]= new JButton();
 			//button[i].setDebugGraphicsOptions(HEIGHT);
 			button[i]=new JButton(new ImageIcon(((new ImageIcon(
 					buttonName[i]).getImage()
 		            .getScaledInstance(300, 70,
 		                    java.awt.Image.SCALE_SMOOTH)))));
 			
 			button[i].setFont(font);
 			button[i].addActionListener(this);
 			button[i].setPreferredSize(ButtonDimension);
 			button[i].setBackground(new Color(0,0,0,125));
 		}
		
		
		add(button[0], BorderLayout.CENTER);
		
		add(button[1], BorderLayout.CENTER);
		add(button[2], BorderLayout.CENTER);
		add(button[3], BorderLayout.SOUTH);
		setVisible(true);
		}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button[0]){
			NewAaccount=new CreateAccount(Userlist);
			}
		
		if(e.getSource() == button[1]){
			Place_Hold= new PlaceHold(Userlist,list);
		}
		
		if(e.getSource() == button[2]){
			MyAccount=new Account(Userlist, list,2);
		}
		
		if(e.getSource() == button[3]){
		MyAccount=new Account(Userlist,list,3);
		}
	}
	
	public static void main(String[] arguments) {
		BookRentalApp app=new BookRentalApp();
	}
}
