/**
 * Imara Dharmakirthi
 * Select pickup date and return date, click "Available Books"
 * select the book by clicking the icon, and select "Rent" button.
 * display will show deatails if details were correct select "Conform button" 
 * Date:05/10/2015
 */
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.Writer;
import java.util.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class PlaceHold extends AppFrame implements ActionListener{
	ArrayList<Book> list = new ArrayList<Book>();
	ArrayList<Book> OrderList = new ArrayList<Book>();
	ArrayList<User> Userlist;
	boolean ReadyToRent;
	//User TheUser;
	int hours;
	//Account MyAccount;
	
	JPanel PANEL = new JPanel();
	JPanel panel = new JPanel();
	JPanel Rpanel = new JPanel();
	JPanel ButtonPanel = new JPanel();
	JPanel textPanel = new JPanel();
	JButton[] button = new JButton[3];
	String[] buttonName ={"Rent","EXIT", "Avilable Books"};
	JButton[] BookButton;
	
	JMenuItem fif,six, sev,eig, mo1,mo2,mo3,mo4,mo5,mo6,mo7,mo8,mo9,mo10,mo11,mo12,am,pm;
	
	JMenuItem Rfif,Rsix, Rsev,Reig, Rmo1,Rmo2,Rmo3,Rmo4,Rmo5,Rmo6,Rmo7,Rmo8,Rmo9,Rmo10,Rmo11,Rmo12,Ram,Rpm;
	
	
	String SAMPM,RAMPM,Stime,Rtime;
	int Syear,Ryear,Smonth,Rmonth,Sday,Rday;
	
	Dimension displayDimension = new Dimension(500,400);
	Dimension timeDispaly = new Dimension(20,20);
	JTextArea DisplayDay = new JTextArea(1,5);
	JTextArea DisplayTime = new JTextArea(1,5);
	JTextArea RDisplayDay = new JTextArea(1,5);
	JTextArea RDisplayTime = new JTextArea(1,5);
	JTextArea Display = new JTextArea(10,30);

	Font font = new Font("Times new Roman", Font.BOLD, 14);
	Font DisplayFont=new Font("Times new Roman", Font.BOLD, 17);
	JMenu date;
	JMenu Rdate;
	
	PlaceHold( ArrayList<User> NewUserlist,  ArrayList<Book> NList){
		super();
		Userlist=NewUserlist;
		list=NList;
		//TheUser=Userlist.get(userNum);
		//user=userNum;
		ReadyToRent=false;
		hours=0;
 		JMenu year = new JMenu("Year");
 		JMenu month = new JMenu("Month");
 		date = new JMenu("Data");
 		JMenu time = new JMenu("AM/PM");
 		
 		PANEL.setLayout( new GridLayout(3,1));
 		
 		 fif= new JMenuItem("2015");	fif.addActionListener(this);	year.add(fif);
 		 six= new JMenuItem("2016");	six.addActionListener(this);	year.add(six);
 		 sev= new JMenuItem("2017");	sev.addActionListener(this);	year.add(sev);
 		 eig= new JMenuItem("2018");	eig.addActionListener(this);	year.add(eig);
 		
 		 mo1= new JMenuItem("January");		mo1.addActionListener(this);	month.add(mo1);
 		 mo2= new JMenuItem("February");	mo2.addActionListener(this);	month.add(mo2);
 		 mo3= new JMenuItem("March");		mo3.addActionListener(this);	month.add(mo3);
 		 mo4= new JMenuItem("April");		mo4.addActionListener(this);	month.add(mo4);
 		 mo5= new JMenuItem("May");			mo5.addActionListener(this);	month.add(mo5);
 		 mo6= new JMenuItem("June");		mo6.addActionListener(this);	month.add(mo6);
 		 mo7= new JMenuItem("July");		mo7.addActionListener(this);	month.add(mo7);
 		 mo8= new JMenuItem("August");		mo8.addActionListener(this);	month.add(mo8);
 		 mo9= new JMenuItem("September");	mo9.addActionListener(this);	month.add(mo9);
 		 mo10= new JMenuItem("October");	mo10.addActionListener(this);	month.add(mo10);
 		 mo11= new JMenuItem("November");	mo11.addActionListener(this);	month.add(mo11);
 		 mo12= new JMenuItem("December");	mo12.addActionListener(this);	month.add(mo12);
 		
 		DisplayDay.setFont(font);
 		DisplayDay.setEditable(true);
 		DisplayDay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 		DisplayDay.setPreferredSize(timeDispaly);
 		DisplayDay.setBackground(Color.LIGHT_GRAY);
 		JLabel Daylabe = new JLabel("Date");
 		
 		 am= new JMenuItem("AM");	am.addActionListener(this);	time.add(am);
 		 pm= new JMenuItem("PM");	pm.addActionListener(this);	time.add(pm);
 		
 		DisplayTime.setFont(font);
 		DisplayTime.setEditable(true);
 		DisplayTime.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 		DisplayTime.setPreferredSize(timeDispaly);
 		DisplayTime.setBackground(Color.LIGHT_GRAY);
 		
 		JMenuBar yearBar = new JMenuBar();
 		yearBar.add(year);
 		JMenuBar Monthbar = new JMenuBar();
 		Monthbar.add(month);
 		//JMenuBar dateBar = new JMenuBar();
 		//Monthbar.add(date);
 		JMenuBar timebar = new JMenuBar();
 		timebar.add(time);
 		JLabel labe = new JLabel("Pickup Date");
 		panel.add(labe);panel.add(yearBar);panel.add(Monthbar);panel.add(Daylabe);panel.add(DisplayDay);panel.add(timebar);panel.add(DisplayTime);
 		panel.setBackground(new Color(0,0,0,100));
 		//add(panel, BorderLayout.NORTH);
 		PANEL.add(panel);
 		
 		JMenu Ryear = new JMenu("Year");
 		JMenu Rmonth = new JMenu("Month");
 		Rdate = new JMenu("Data");
 		JMenu RTime = new JMenu("AM/PM");
 		
 		 Rfif= new JMenuItem("2015");	Rfif.addActionListener(this);	Ryear.add(Rfif);
 		 Rsix= new JMenuItem("2016");	Rsix.addActionListener(this);	Ryear.add(Rsix);
 		 Rsev= new JMenuItem("2017");	Rsev.addActionListener(this);	Ryear.add(Rsev);
 		 Reig= new JMenuItem("2018");	Reig.addActionListener(this);	Ryear.add(Reig);
 		
 		 Rmo1= new JMenuItem("January");	Rmo1.addActionListener(this);	Rmonth.add(Rmo1);
 		 Rmo2= new JMenuItem("February");	Rmo2.addActionListener(this);	Rmonth.add(Rmo2);
 		 Rmo3= new JMenuItem("March");		Rmo3.addActionListener(this);	Rmonth.add(Rmo3);
 		 Rmo4= new JMenuItem("April");		Rmo4.addActionListener(this);	Rmonth.add(Rmo4);
 		 Rmo5= new JMenuItem("May");		Rmo5.addActionListener(this);	Rmonth.add(Rmo5);
 		 Rmo6= new JMenuItem("June");		Rmo6.addActionListener(this);	Rmonth.add(Rmo6);
 		 Rmo7= new JMenuItem("July");		Rmo7.addActionListener(this);	Rmonth.add(Rmo7);
 		 Rmo8= new JMenuItem("August");		Rmo8.addActionListener(this);	Rmonth.add(Rmo8);
 		 Rmo9= new JMenuItem("September");	Rmo9.addActionListener(this);	Rmonth.add(Rmo9);
 		 Rmo10= new JMenuItem("October");	Rmo10.addActionListener(this);	Rmonth.add(Rmo10);
 		 Rmo11= new JMenuItem("November");	Rmo11.addActionListener(this);	Rmonth.add(Rmo11);
 		 Rmo12= new JMenuItem("December");	Rmo12.addActionListener(this);	Rmonth.add(Rmo12);
 		
 		 Ram= new JMenuItem("AM");	Ram.addActionListener(this);	RTime.add(Ram);
 		 Rpm= new JMenuItem("PM");	Rpm.addActionListener(this);	RTime.add(Rpm);
 		
 		RDisplayDay.setFont(font);
 		RDisplayDay.setEditable(true);
 		RDisplayDay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 		RDisplayDay.setPreferredSize(timeDispaly);
 		 
 		RDisplayTime.setFont(font);
 		RDisplayTime.setEditable(true);
 		RDisplayTime.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 		RDisplayTime.setPreferredSize(timeDispaly);
 		
 		JMenuBar RyearBar = new JMenuBar();
 		RyearBar.add(Ryear);
 		JMenuBar RMonthbar = new JMenuBar();
 		RMonthbar.add(Rmonth);
 		JMenuBar Rtimebar = new JMenuBar();
 		Rtimebar.add(RTime);
 		JLabel Rlabe = new JLabel("Return Date");
 		JLabel RDaylabe = new JLabel("Date");
 		Rpanel.add(Rlabe);Rpanel.add(RyearBar);Rpanel.add(RMonthbar);Rpanel.add(RDaylabe);Rpanel.add(RDisplayDay);Rpanel.add(Rtimebar);Rpanel.add(RDisplayTime);
 		Rpanel.setBackground(new Color(0,0,0,100));
 		//add(Rpanel, BorderLayout.NORTH);
 		PANEL.add(Rpanel);
 		
 		button[2]= new JButton();
		button[2].setText(buttonName[2]);
		button[2].setFont(font);
		button[2].addActionListener(this);
		button[2].setPreferredSize(new Dimension(130,30));
		ButtonPanel.add(button[2]);
		for(int i=0; i<2;i++){
 			button[i]= new JButton();
 			button[i].setText(buttonName[i]);
 			button[i].setFont(font);
 			button[i].addActionListener(this);
 			button[i].setPreferredSize(new Dimension(90,30));
 			ButtonPanel.add(button[i]);
 		}
		ButtonPanel.setBackground(new Color(0,0,0,0));
		PANEL.add(ButtonPanel);
		PANEL.setBackground(new Color(0,0,0,100));
		add(PANEL, BorderLayout.NORTH);
	
		
		BookButton=new JButton[list.size()];
 		GridLayout experimentLayout = new GridLayout(list.size()/3,3);
 		textPanel.setPreferredSize(new Dimension(100*3,300*(list.size()/3)));
 		textPanel.setLayout(experimentLayout);
 		
 		
 		for(int i=0;i<list.size();i++){
 			JPanel BookRack = new JPanel(new GridLayout(2,0));
 			BookButton[i]=new JButton(new ImageIcon(((new ImageIcon(
 					list.get(i).getFrontCover()).getImage()
 		            .getScaledInstance(80,115,
 		                    java.awt.Image.SCALE_SMOOTH)))));
 			
 			BookButton[i].setPreferredSize(new Dimension(80,110));
 			JTextArea Book_Display = new JTextArea();
 			Book_Display.append(list.get(i).toString());
 			Book_Display.setFont(new Font("Times new Roman", Font.BOLD, 14));
 			Book_Display.setEditable(false);
 			Book_Display.setBackground(new Color(0,0,0,0));
 			BookButton[i].addActionListener(this);
 			BookRack.add( BookButton[i] );
 			BookRack.add( Book_Display );
 			BookRack.setBackground(new Color(0,0,0,0));
 			textPanel.add(BookRack);
 			textPanel.setBackground(new Color(0,0,0,0));
 			textPanel.revalidate();
 		}
 		
 		
 		textPanel.setVisible(false);
 		add(textPanel, BorderLayout.CENTER);
 		
 			
 		setVisible(true);
	}

	public void setDisplay(){
		String tem=String.format("%s%30s%30s","Tile","Author","Price");
		Display.append(tem+"\n");
		for(int i=0;i<list.size();i++){
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(list.get(i).getPrice());
 		String s=String.format("%s%40s%30s",list.get(i).title, list.get(i).author,  moneyString);
 		//System.out.println(s);
 		Display.setEditable(false);
 		Display.setFont(DisplayFont);
 		Display.append(s+"\n");
 		}
	}

	public void actionPerformed(ActionEvent e) {
		//
		
		if(e.getSource() == button[0]){
			//System.out.println(Syear+":"+Smonth+":"+ Sday+":"+SAMPM+":"+ Stime);
		//	System.out.println(Ryear+":"+Rmonth+":"+ Rday+":"+RAMPM+":"+ Rtime);
			if(Syear==2015 && Smonth==5 && Sday==19 && Ryear==2015 && Rmonth==5 && Rday==25 ){ 
			//	System.out.print("yes");
				ReadyToRent=false;}
			if(ReadyToRent){
			for(int i=0; i<OrderList.size();i++){
				OrderList.get(i).SetPlaceHold(Syear+":"+Smonth+":"+ Sday+":"+SAMPM+":"+ Stime);
				OrderList.get(i).SetReturnDay(Ryear+":"+Rmonth+":"+ Rday+":"+RAMPM+":"+ Rtime);
				OrderList.get(i).setValiedStatus(true);
				//Userlist.get(user).AddBook(OrderList.get(i));;
				//int randomNum = 100000 + (int)(Math.random()*999999);
				
				OrderList.get(i).SetReservation(Integer.toString(100000 + (int)(Math.random()*999999)));
			}
			//
			Account MyAccount=new Account(Userlist,OrderList,1);
			}else {
				JOptionPane.showMessageDialog(this,"Please Choose Pickup Day and Return Day.");
				DisplayTime.setText("");	DisplayDay.setText("");  RDisplayDay.setText("");	RDisplayTime.setText("");	Stime="";	Rtime="";
			}
			//OrderList.clear();
			setVisible(false);
			//System.out.print(OrderList.size());
			
		}
	
		if(e.getSource() == button[1]){
			setVisible(false);
		}
		
		
		
		if(e.getSource()==fif){Syear=2015;}		if(e.getSource()==six){Syear=2016;}		if(e.getSource()==sev){Syear=2017;}		if(e.getSource()==eig){Syear=2018;}
		if(e.getSource()==Rfif){Ryear=2015;}	if(e.getSource()==Rsix){Ryear=2016;}	if(e.getSource()==Rsev){Ryear=2017;}	if(e.getSource()==Reig){Ryear=2018;}
		
		if(e.getSource()==mo1){Smonth=1;}		if(e.getSource()==mo2){Smonth=2;}		if(e.getSource()==mo3){Smonth=3;}		if(e.getSource()==mo4){Smonth=4;}
		if(e.getSource()==mo5){Smonth=5;}		if(e.getSource()==mo6){Smonth=6;}		if(e.getSource()==mo7){Smonth=7;}		if(e.getSource()==mo8){Smonth=8;}
		if(e.getSource()==mo9){Smonth=9;}		if(e.getSource()==mo10){Smonth=10;}		if(e.getSource()==mo11){Smonth=11;}		if(e.getSource()==mo12){Smonth=12;}
		
		if(e.getSource()==Rmo1){Rmonth=1;}		if(e.getSource()==Rmo2){Rmonth=2;}		if(e.getSource()==Rmo3){Rmonth=3;}		if(e.getSource()==Rmo4){Rmonth=4;}
		if(e.getSource()==Rmo5){Rmonth=5;}		if(e.getSource()==Rmo6){Rmonth=6;}		if(e.getSource()==Rmo7){Rmonth=7;}		if(e.getSource()==Rmo8){Rmonth=8;}
		if(e.getSource()==Rmo9){Rmonth=9;}		if(e.getSource()==Rmo10){Rmonth=10;}	if(e.getSource()==Rmo11){Rmonth=11;}	if(e.getSource()==Rmo12){Rmonth=12;}
		
		if(e.getSource()==am){SAMPM="AM";}	if(e.getSource()==pm){SAMPM="PM";}
		if(e.getSource()==Ram){RAMPM="AM";}	if(e.getSource()==Rpm){RAMPM="PM";}
		
		for(int i=0; i<list.size();i++){
			Book temp=new Book();
			temp=list.get(i);
			temp.SetAmount(list.get(i).getPrice()*hours);
			if(e.getSource()==BookButton[i]){OrderList.add(temp); }
		}
		
		if(e.getSource() == button[2]){
			
			
			if(DisplayTime.getText().length()>2 && RDisplayTime.getText().length()>2 &&  DisplayTime.getText().length()<5 && RDisplayTime.getText().length()<5  && DisplayDay.getText().length()>0 && DisplayDay.getText().length()<3 && RDisplayDay.getText().length()>0 && RDisplayDay.getText().length()<3){
			/**
			Stime= DisplayTime.getText();	String bagBegin = Stime.substring(0,2);		String bagEnd = Stime.substring(2);		Stime=bagBegin+":"+bagEnd;
			Rtime= RDisplayTime.getText();	String RbagBegin = Rtime.substring(0,2);	String RbagEnd = Rtime.substring(2);	Rtime=RbagBegin+":"+RbagEnd;
			int Shour = Integer.parseInt(bagBegin);		int Sminu = Integer.parseInt(bagEnd);
			int Rhour = Integer.parseInt(RbagBegin);	int Rminu = Integer.parseInt(RbagEnd);
			**/
		int StimeInt=0;	int RtimeInt =0;
		try{
			StimeInt=Integer.parseInt(DisplayTime.getText());	
			RtimeInt=Integer.parseInt(RDisplayTime.getText());	
			}catch(Exception e1){JOptionPane.showMessageDialog(this,"Wrong Time format.");}
			
		
		
			int  Sminu=StimeInt%100;	 int Shour =  StimeInt/100;
			int Rminu=RtimeInt%100;	 int Rhour =  RtimeInt/100;
			Stime=Shour+":"+Sminu;
			Rtime=Rhour+":"+Rminu;
			
			Sday=Integer.parseInt(DisplayDay.getText());	Rday=Integer.parseInt(RDisplayDay.getText());
			
			//System.out.print(Sday+"   "+Rday);
			boolean Sday_Correct=false;
			boolean Rday_Correct=false;
			if(Smonth==1 || Smonth==3 || Smonth==5 || Smonth==8 || Smonth==10 || Smonth==12 ){
				if(Sday>0 && Sday<32){Sday_Correct=true;}
			}
			if(Smonth==2){if(Sday>0 && Sday<29){Sday_Correct=true;}}
			else{if(Sday>0 && Sday<31){Sday_Correct=true;}}
			
			if(Rmonth==1 || Rmonth==3 || Rmonth==5 || Rmonth==8 || Rmonth==10 || Rmonth==12 ){
				if(Rday>0 && Rday<32){Rday_Correct=true;}
			}
			if(Rmonth==2){if(Rday>0 && Rday<29){Rday_Correct=true;}}
			else{if(Rday>0 && Rday<31){Rday_Correct=true;}}
			
			
				if( ((Shour>0 && Shour<13) && (Sminu>=0 && Sminu<=60)) && ((Rhour>0 && Rhour<13) && (Rminu>=0 && Rminu<=60))){
					if(Rday_Correct && Sday_Correct){
						
					if(Syear!=0 && Ryear!=0 && Smonth!=0 && Rmonth!=0 && Sday!=0 && Rday!=0 && SAMPM!=null && RAMPM!=null){
						
						long Smin;
						long Rmin;
						boolean notvalidDat=false;
						if(Syear==2015 && Smonth==5 && Sday==19 && Ryear==2015 && Rmonth==5 && Rday==25)	notvalidDat=true;	
						if(!notvalidDat){
						
						
						
							if(SAMPM.equals("PM")){
								Smin = Sminu+ (Shour+12)*60 + Sday*24*60 + Smonth*30*24*60 +Syear*12*30*24*60;
							}else Smin = Sminu+ Shour*60 + Sday*24*60 + Smonth*30*24*60 + Syear*12*30*24*60;
							
							if(RAMPM.equals("PM")){
								Rmin = Rminu+ (Rhour+12)*60 + Rday*24*60 + Rmonth*30*24*60 +Syear*12*30*24*60;
							}else Rmin = Rminu+ Rhour*60 + Rday*24*60 + Rmonth*30*24*60 +Syear*12*30*24*60;
							if((Rmin-Smin)<=10080 && (Rmin-Smin)>=0  ){
								textPanel.setVisible(true);
								ReadyToRent=true;
								hours=(int)(Rmin-Smin)/60;
								}else {
									if((Rmin-Smin)<0){JOptionPane.showMessageDialog(this,"You have picked a wrong Returnday.");}	
									else JOptionPane.showMessageDialog(this,"You can’t rent a book more than 7 days.");
									DisplayTime.setText("");	DisplayDay.setText("");  RDisplayDay.setText("");	RDisplayTime.setText("");	Stime="";	Rtime="";
								}
						
					}else {
						JOptionPane.showMessageDialog(this,"No Book available for this day.");
						DisplayTime.setText("");	DisplayDay.setText("");  RDisplayDay.setText("");	RDisplayTime.setText("");	Stime="";	Rtime="";
					}
						
						}else {
							JOptionPane.showMessageDialog(this,"Select YYYY:MM:DD.");
							DisplayTime.setText("");	DisplayDay.setText("");  RDisplayDay.setText("");	RDisplayTime.setText("");	Stime="";	Rtime="";
						}
				}else{JOptionPane.showMessageDialog(this,"Wrong Day (HHMM).");
					DisplayDay.setText("");  RDisplayDay.setText("");
				}
					
				}else {
					JOptionPane.showMessageDialog(this,"Wrong Time (HHMM).");
					DisplayTime.setText("");	DisplayDay.setText("");  RDisplayDay.setText("");	RDisplayTime.setText("");	Stime="";	Rtime="";
				}
			
			}else {
				JOptionPane.showMessageDialog(this,"Wrong Time format (HHMM).");
				DisplayTime.setText("");	DisplayDay.setText("");  RDisplayDay.setText("");	RDisplayTime.setText("");	Stime="";	Rtime="";
			}
			}
		
		
		}
	

	
}

