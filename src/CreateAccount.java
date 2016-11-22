/**
 * Imara Dharmakirthi
 * Creating new account
 * 05/10/2015
 */
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class CreateAccount extends AppFrame implements ActionListener{

	JButton[] button = new JButton[2];
	String[] buttonName ={"Register","Cancel"};
	
	JPanel lablPanel=new JPanel(); 
	JPanel PANEL=new JPanel();
	JPanel PANEL1=new JPanel();
	JPanel PANEL2=new JPanel();
	JPanel PANEL3=new JPanel();
	JPanel BUTTON_PANEL=new JPanel();
	
	Dimension displayDimension = new Dimension(80,35);
	Dimension buttonDemention = new Dimension(90,40);
	
	JTextArea DisplayUser = new JTextArea(1,12);
	JTextArea DisplayPas = new JTextArea(1,12);
	JTextArea DisplayCon = new JTextArea(1,12);
	Font font = new Font("Times new Roman", Font.BOLD, 14);
	
	//Account My_Account;
	ArrayList<User> Userlist;//=new ArrayList<User>();
	
	User UnewUser; boolean UserHasBult=false;
	
	CreateAccount(ArrayList<User> NewUserlist){
		super();
		Userlist = NewUserlist;
		FlowLayout frame1 = new FlowLayout(FlowLayout.LEFT);
 		UnewUser=null;
 		
 		for(int i=0; i<2;i++){
 			button[i]= new JButton();
 			button[i].setText(buttonName[i]);
 			button[i].setFont(font);
 			button[i].addActionListener(this);
 		}
 		
 		DisplayUser.setFont(font);
 		DisplayUser.setEditable(true);
 		DisplayUser.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 		DisplayUser.setPreferredSize(displayDimension);
 		DisplayPas.setFont(font);
 		DisplayPas.setEditable(true);
 		DisplayPas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 		DisplayPas.setPreferredSize(displayDimension);
 		DisplayCon.setFont(font);
 		DisplayCon.setEditable(true);
 		DisplayCon.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 		DisplayCon.setPreferredSize(displayDimension);
 		for(int i=0; i<2;i++){button[i].setPreferredSize(buttonDemention);}
 		
 		JLabel labe1 = new JLabel("username and password should at least one special symbol (!, @, #, or $)," );//labe1.setLayout(frame1);
 		JLabel labe2 = new JLabel(" one number, and three alphabet letters.");//labe2.setLayout(frame1);
 		labe1.setLayout(frame1);	labe2.setLayout(frame1);
 		
 
 		add(labe1, BorderLayout.NORTH);
 		add(labe2, BorderLayout.NORTH);
 		
 		JLabel labelUser = new JLabel("User Name                  ");labelUser.setFont(new Font("Times new Roman", Font.BOLD, 18));
 		PANEL1.add(labelUser);	PANEL1.add(DisplayUser);
 		PANEL1.setBackground(new Color(0,0,0,125));		add(PANEL1, BorderLayout.CENTER);
 		JLabel labelPass = new JLabel("Password                    ");labelPass.setFont(new Font("Times new Roman", Font.BOLD, 18));
 		
 		PANEL2.add(labelPass);	PANEL2.add(DisplayPas);
 		PANEL2.setBackground(new Color(0,0,0,125));		add(PANEL2, BorderLayout.CENTER);
 		
 		JLabel labelCon = new JLabel ("Conformed Password ");labelCon.setFont(new Font("Times new Roman", Font.BOLD, 18));
 		PANEL3.add(labelCon);PANEL3.add(DisplayCon);
 		PANEL3.setBackground(new Color(0,0,0,125));		add(PANEL3, BorderLayout.CENTER);
 		
 		
 		BUTTON_PANEL.add(button[0]);	BUTTON_PANEL.add(button[1]);
 		add(BUTTON_PANEL, BorderLayout.SOUTH);
 		
 		setVisible(true);
	}

	public User GetUser(){
		
		return UnewUser;
	}
	public boolean UserHasBuilt(){
		if(UserHasBult) return true;
		else return false;
	}
	public ArrayList<User> get_User_List(){
		return Userlist;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button[0]){
			
			String userName=DisplayUser.getText();
			String password=DisplayPas.getText();
			String conf=DisplayCon.getText();
			
			
			if((password.length() > 0) && (userName.length()>0) && (conf.length()>0) ){
				if(password.equals(conf)){
					
					
					boolean foundinUser = false; boolean foundinPass = false;
					
					
					
					if(password.contains("!") || password.contains("@")|| password.contains("#")|| password.contains("$")||
							password.contains("^") ||password.contains("&")||password.contains("*") || password.contains("(")
							||password.contains(")")||password.contains("_")){foundinPass = true;}
					
					if(userName.contains("!") || userName.contains("@")|| userName.contains("#")|| userName.contains("$")||
							userName.contains("^") ||userName.contains("&")||userName.contains("*") || userName.contains("(")
							||userName.contains(")")||userName.contains("_")){foundinUser = true;}
					
					
					
					
					
					int countIntPass = 0;
					for (int i = 0; i <password.length(); i++) {
					    if (Character.isDigit(password.charAt(i))) {
					        countIntPass++;
					    }
					}
					int countIntUse = 0;
					for (int i = 0; i <userName.length(); i++) {
					    if (Character.isDigit(userName.charAt(i))) {
					        countIntUse++;
					    }
					}
					int countLatUse=0;
					for (int i = 0; i < userName.length(); i++) {
						 
			            if (Character.isLetter(userName.charAt(i)))
			            	countLatUse++;
			        }
					int countLatPas=0;
					for (int i = 0; i < password.length(); i++) {
						 
			            if (Character.isLetter(password.charAt(i)))
			            	countLatPas++;
			        }
						
						
					if (foundinUser && foundinPass && countIntPass>0 && countIntUse>0 && countLatUse>2 && countLatPas>2) {
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();
						String s=sdf.format(cal.getTime());
						UnewUser=new User(DisplayUser.getText().replaceAll(" ", ""),DisplayPas.getText().replaceAll(" ", ""),s);
						boolean hasused=false;
						
						
						for(int i=0; i<Userlist.size();i++){
							//System.out.println(Userlist.get(0).UserName+" "+ Userlist.get(0).PassWord);
							if(UnewUser.equals(Userlist.get(i))){ 
								hasused=true;}
						}
						if( !hasused){
						Userlist.add(UnewUser);
						JOptionPane.showMessageDialog(this,"You Successfuly Created An Account");
						setVisible(false);
						}
						if(hasused){JOptionPane.showMessageDialog(this,"Choose Different User Name And Password");
						DisplayUser.setText("");	DisplayPas.setText("");	DisplayCon.setText("");
						setVisible(false);
						}
						
					}else {
						JOptionPane.showMessageDialog(this,"username and password should at least one special symbol (!, @, #, or $), one number, and three alphabet letters.");
						DisplayUser.setText("");	DisplayPas.setText("");	DisplayCon.setText("");
						setVisible(false);
					} 	
					
				}else {
					JOptionPane.showMessageDialog(this,"username and password should at least one special symbol (!, @, #, or $), one number, and three alphabet letters.");
					DisplayUser.setText("");	DisplayPas.setText("");	DisplayCon.setText("");
					setVisible(false);
				} 	
				
			}else {
					JOptionPane.showMessageDialog(this,"Please Enter User Name and Password in order to create an Account.");
					DisplayUser.setText("");	DisplayPas.setText("");	DisplayCon.setText("");
					setVisible(false);
				} 	
			}
		if(e.getSource() == button[1]){
			setVisible(false);
		}
		}
		
	}
	

