import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Account extends AppFrame implements ActionListener{
	ArrayList<User> list;
	ArrayList<Book> orderList;
	int LegitimateUser;
	boolean NotvaliedUser;
	PlaceHold Pace_A_Book;
	CancelHold Cancel_A_Hold;
	manage ManageSys;
	
	boolean option1=false;
	boolean option2=false;
	boolean option3=false;
	
	
	//JPanel[] row = new JPanel[2];
	
	
	
	JButton[] button = new JButton[3];
	String[] ButtonName={ "Correct Info","Log In", "Cancel"};
	
	Dimension displayDimension = new Dimension(50,20);
	Dimension buttonDemention = new Dimension(150,50);
	JPanel PANEL=new JPanel();
	JPanel PANEL_USE = new JPanel();
	JPanel PANEL_PAS= new JPanel();
	JPanel PANEL_LABLE = new JPanel();
	JPanel PANEL_BTTON = new JPanel();
	
	
	JTextArea DisplayUser = new JTextArea(1,10);
	JTextArea DisplayPas = new JTextArea(1,10);
	JTextArea Display = new JTextArea(10,30);
	JScrollPane scr = new JScrollPane(Display);
	Font font = new Font("Times new Roman", Font.BOLD, 16);

	Account(ArrayList<User> Nlist, ArrayList<Book> NBookList, int option ){
		super();
		list=Nlist;
		orderList=NBookList;
		NotvaliedUser=true;
		LegitimateUser=-1;
		//System.out.println(BookList.size());
		if(option==1)	option1=true;
		if(option==2)	option2=true;
		if(option==3)	option3=true;
		Display.setPreferredSize(new Dimension(400,700));
		Display.setFont(new Font("Times new Roman", Font.BOLD, 18));
		Display.setEditable(false);
		//JScrollPane scr = new JScrollPane(Display); 
		Display.setBounds(20, 30, 450, 100);
		scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//GridLayout grid = new GridLayout(4,1);
		//setLayout(grid);
		//FlowLayout frame1 = new FlowLayout(FlowLayout.LEFT);
 		//FlowLayout frame2 = new FlowLayout(FlowLayout.LEFT,1,1);
 		//for(int i = 0; i < 4; i++){row[i] = new JPanel();}
 		//row[0].setLayout(frame1);
 		//for(int i = 1; i < 4; i++)row[i].setLayout(frame2);
		PANEL_BTTON.setLayout(new GridLayout(1,1));
		//System.out.print(ButtonName.length);
 		for(int i=0;i<button.length;i++){
 			button[i]=new JButton();
 			button[i].setFont(font);
 			button[i].setText(ButtonName[i]);
 			button[i].addActionListener(this);
 			button[i].setPreferredSize(buttonDemention);
 			PANEL_BTTON.add(button[i]);
 		}
 		PANEL_BTTON.setBackground(new Color(0,0,0,0));
 		
 		DisplayUser.setFont(font);
 		DisplayUser.setEditable(true);
 		DisplayUser.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 		DisplayUser.setPreferredSize(displayDimension);
 		DisplayUser.setBackground(Color.LIGHT_GRAY);
 		DisplayPas.setFont(font);
 		DisplayPas.setEditable(true);
 		DisplayPas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 		DisplayPas.setPreferredSize(displayDimension);
 		DisplayPas.setBackground(Color.LIGHT_GRAY);
 		
 		
 		JLabel labe1 = new JLabel(new ImageIcon(((new ImageIcon("edward.jpg").getImage().getScaledInstance(490, 350,java.awt.Image.SCALE_SMOOTH)))));
 		
 		
 		PANEL.setLayout(new GridLayout(4,1));
 		PANEL_LABLE.add(labe1);//PANEL_LABLE.add(labe2);PANEL_LABLE.add(labe3);PANEL_LABLE.add(labe4);PANEL_LABLE.add(labe5);
 		PANEL_LABLE.setPreferredSize(new Dimension(500,200));
 		add(PANEL_LABLE, BorderLayout.NORTH);
 	//	PANEL_LABLE.setLayout(frame1); //PANEL_LABLE.setFont(new Font("Times new Roman", Font.BOLD, 18));
 		
 		
 		//add(PANEL_LABLE, BorderLayout.NORTH);	
 		//add(PANEL_LABLE, BorderLayout.NORTH);
 		//PANEL_PAS.setBackground(Color.white);
 		JLabel labelUser = new JLabel("User Name  ");	
 		labelUser.setFont(new Font("Times new Roman", Font.BOLD, 25));	DisplayUser.setBackground(Color.lightGray);
 		//DisplayUser.setBorder(arg0);;
 		PANEL_USE.setLayout( new GridLayout(1,1));
 		PANEL_USE.add(labelUser);	PANEL_USE.add(DisplayUser);
 		PANEL_USE.setBackground(new Color(0,0,0,0));
 		
 		
 		//row[1].add();	row[1].setBackground(Color.WHITE);	row[1].add();	PANEL_USE.add(row[1]);	PANEL_USE.setBackground(Color.WHITE);
 		
 		
 		//PANEL_PAS.add(PANEL_USE);	PANEL_PAS.setBackground(new Color(0,0,0,0));
 		
 		//
 		
 		JLabel labelPass = new JLabel("Password    ");	
 		labelPass.setFont(new Font("Times new Roman", Font.BOLD, 25));	
 		PANEL_PAS.setLayout( new GridLayout(1,1));
 		PANEL_PAS.add(labelPass);	PANEL_PAS.add(DisplayPas);	DisplayPas.setBackground(Color.lightGray);
 		PANEL_PAS.setBackground(new Color(0,0,0,0));
 		
 		//PANEL.add(PANEL_LABLE);
 		PANEL.add(PANEL_USE);
 		PANEL.add(PANEL_PAS);
 		PANEL.add(PANEL_BTTON);
 		PANEL.setBackground(new Color(0,0,0,0));
 		add(PANEL, BorderLayout.CENTER);
 		add(scr, BorderLayout.SOUTH);
 		scr.setVisible(false);
 		//row[2].;	row[2].setBackground(Color.WHITE);	row[2].	; PANEL_PAS.add(row[2]);	PANEL_PAS.add(button);
 		//add(, BorderLayout.SOUTH);
 		//add(button, BorderLayout.CENTER);
 		if(option2)button[0].setVisible(false);
 		button[0].setVisible(false);
 		setVisible(true);
	}

	
	
	public void actionPerformed(ActionEvent e) {
	
	if(e.getSource() == button[1]){
		String uName=DisplayUser.getText();	DisplayUser.setText("");
		String pass=DisplayPas.getText();	DisplayPas.setText("");
		User tempU= new User(uName,pass,"");
		if(option3){
			if(tempU.equals(list.get(0)))	ManageSys=new manage(list, orderList);
			setVisible(false);
		}
		for(int i=0; i<list.size();i++) {
			if(tempU.equals(list.get(i))){
				NotvaliedUser=false;
				LegitimateUser=i;
				if(option1)	 First_option();
				if(option2){	
					JOptionPane.showMessageDialog(this,"Your Successfully Logedin.\nThank you.");
					setVisible(false);	Cancel_A_Hold=new CancelHold(i, list);}
				//System.out.print(list.get(i).BookList.size());
				
			//setVisible(false);
			//JOptionPane.showMessageDialog(this,"Your Successfully Logedin.\nThank you.");
			}
			//
			
			}
		if(NotvaliedUser) JOptionPane.showMessageDialog(this,"You may have enter wrong User name or Password!");
	}
	
	
	
	
	
	
	if(e.getSource() == button[0]){
		if(LegitimateUser!=-1){
			for(int j=0; j<orderList.size();j++){
			list.get(LegitimateUser).AddBook(orderList.get(j));
			}
			setVisible(false);
		}else JOptionPane.showMessageDialog(this,"First, Log In.");
	}
	if(e.getSource() == button[2]){
		setVisible(false);
		//orderList.clear();
	}

	}
	
	//public ArrayList<User> getUser_List(){
	//	return 
	//}

	public void  First_option(){
		JOptionPane.showMessageDialog(this,"Your Successfully Logedin.\nThank you.");
		NotvaliedUser=false;
		button[0].setVisible(true);
		button[1].setVisible(false);
		PANEL_LABLE.setVisible(false);
		PANEL_USE.setVisible(false);
		PANEL_PAS.setVisible(false);
		PANEL_BTTON.setVisible(true);
		scr.setVisible(true);
		//System.out.print("yes"+orderList.size());
		double total=0.0;
		String display=list.get(LegitimateUser).UserName+": \n";
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
	for(int j=0; j<orderList.size();j++){
		//
		total=total+orderList.get(j).getAmmount();
		String moneyString = formatter.format(orderList.get(j).getAmmount());
		//System.out.print("yes "+orderList.get(j).title+" "+orderList.get(j).price );
		display=display+"Pickup Date:"+orderList.get(j).PlaceHold+"\nReturn Date"+ orderList.get(j).ReturnDay
				+"\nBook Title:"+orderList.get(j).title+"\nReservation #:"+orderList.get(j).reservationNum
				+"\nAmount:"+moneyString+"\n";
		//list.get(i).AddBook(orderList.get(j));
	}
	display=display+"\nTotalAmmount: "+formatter.format(total);
	Display.append(display);
	}
	/**	
	public User GetLegitimateUser(){
		return LegitimateUser;
	}
	public void addUser(User newOne){
		if(newOne!=null)list.add(newOne);
	}**/
/**public static void main(String[] arguments) {
		ArrayList<User> a=new ArrayList<User>();
		a.add(new User("imara", "imara",""));
		ArrayList<Book> b=new ArrayList<Book>();
		Account cal = new Account(a,b,1);
		}**/
}
