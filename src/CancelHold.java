/**
 * Imara Dharmakirthi
 * first Login
 * it will show Book buttons. select the Book and click cancel order
 * Date: 05/10/2015
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class CancelHold extends AppFrame implements ActionListener{
	
	ArrayList<User> list;
	ArrayList<Book> CancelList;
	int User_Num;
	JPanel PANEL = new JPanel();
	JPanel textPanel=new JPanel();
	JPanel ButtonPanel=new JPanel();
	JPanel BookRack=new JPanel();
	
	JButton[] BookButton;
	JButton[] button = new JButton[3];
	String[] buttonName={"YES","Cancel Order","Exit"};
	
	JTextArea Display = new JTextArea(12,30);
	JScrollPane scr = new JScrollPane(Display);
	
	Dimension displayDimension = new Dimension(400,700);
	
	public CancelHold(int UserNum, ArrayList<User> NList) {
		super();
		list=NList;
		User_Num=UserNum;
		CancelList=new  ArrayList<Book>();
		PANEL.setLayout(new GridLayout(3,1));
		
		BookButton=new JButton[list.get(User_Num).BookList.size()];
		GridLayout experimentLayout = new GridLayout(list.get(User_Num).BookList.size()/3,3);
		Display.setPreferredSize(displayDimension);	
		Display.setEditable(false);
		Display.setFont(new Font("Times new Roman", Font.BOLD, 16));
		//scr.setBackground(Color.WHITE);

		//JScrollPane scr = new JScrollPane(Display); 
		Display.setBounds(20, 30, 450, 100);
		scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		PANEL.add(scr);
		
		
 		textPanel.setLayout(experimentLayout);
 		
 		SetBookButton();
 		
 		for(int i=0; i<3;i++){
 			button[i]= new JButton();
 			button[i].setText(buttonName[i]);
 			button[i].setFont(new Font("Times new Roman", Font.BOLD, 14));
 			button[i].addActionListener(this);
 			button[i].setPreferredSize(new Dimension(90,30));
 			ButtonPanel.add(button[i]);
 		}
 		button[1].setPreferredSize(new Dimension(150,30));
 		BookRack.setBackground(new Color(0,0,0,0));
 		ButtonPanel.setBackground(new Color(0,0,0,0));
 		
 		PANEL.add(textPanel);
 		PANEL.add(ButtonPanel);
 		
 		
 		PANEL.setBackground(new Color(0,0,0,0));
 		//add(Display, BorderLayout.NORTH);
 		//textPanel.setVisible(true);
 		add(PANEL, BorderLayout.NORTH);
 		
		//System.out.print(BookButton.length);
 		button[0].setVisible(false);
 		//button[1].setVisible(false);
 		
 		//setSize(500,800);
 		set_Screen();
		setVisible(true);
	}
	
	public void SetBookButton(){
		
		for(int i=0;i<list.get(User_Num).BookList.size();i++){
 			BookRack = new JPanel(new GridLayout(2,0));
 			
 			BookButton[i]=new JButton(new ImageIcon(((new ImageIcon(
 					list.get(User_Num).BookList.get(i).getFrontCover()).getImage()
 		            .getScaledInstance(80,115,
 		                    java.awt.Image.SCALE_SMOOTH)))));
 			
 			BookButton[i].setPreferredSize(new Dimension(80,110));
 			JTextArea Book_Display = new JTextArea();
 			Book_Display.append(list.get(User_Num).BookList.get(i).toString());
 			//System.out.print(list.get(User_Num).BookList.get(i).toString());
 			Book_Display.setFont(new Font("Times new Roman", Font.BOLD, 14));
 			Book_Display.setEditable(false);
 			Book_Display.setBackground(new Color(0,0,0,0));
 			BookButton[i].addActionListener(this);
 			if(list.get(User_Num).BookList.get(i).valied_Book)	BookRack.add( BookButton[i] );
 			BookRack.add( Book_Display );
 			BookRack.setBackground(new Color(0,0,0,0));
 			textPanel.add(BookRack);
 			textPanel.setBackground(new Color(0,0,0,0));
 			
 		}
		//ButtonPanel.setVisible(true);
	}
	
	public void set_Screen(){
		
		
		Display.setText("");
		
		if(list.get(User_Num).BookList.size()==0){
			Display.append("YOU HAVE NOT ORDER ANY BOOK!");
		}
		//String s=String.format("%s%30s%30s%30s%30s\n","Title","Author","Pick On","Return","Price");
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String BookData="";
		double total=0.0;
		for(int i=0;i<list.get(User_Num).BookList.size();i++){
			BookData=BookData+ list.get(User_Num).BookList.get(i).GetBookData()+"\n";
			total=total+list.get(User_Num).BookList.get(i).getAmmount();
		}
		for(int i=0;i<CancelList.size();i++){
			total=total-CancelList.get(i).getAmmount();
		}
		BookData=BookData+"\nTotal: "+ formatter.format(total);
		Display.append(BookData);
		
		//Display.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		
		for(int i=0; i<list.get(User_Num).BookList.size();i++){
			if(e.getSource()==BookButton[i]){
				CancelList.add(list.get(User_Num).BookList.get(i)); 
				//System.out.print(list.get(User_Num).BookList.get(i).title);
				}
		}
		
		if(e.getSource() == button[1]){
			if(!CancelList.isEmpty()){
				ButtonPanel.setVisible(false);
				button[0].setVisible(true);
		 		button[1].setVisible(true);
		 		ButtonPanel.setVisible(true);
		 		String Booklist="";
		 		for(int i=0; i<CancelList.size();i++){Booklist=Booklist+", "+CancelList.get(i).title; }
		 		String text="You Want to Delete These Items From your List: "+Booklist+". \n If it is right, select (YES), AND If it is wrong select (EXIT).";
		 		JOptionPane.showMessageDialog(this,text);
			}else JOptionPane.showMessageDialog(this,"You Have Not Select Any Item!");
		}
		
		
		if(e.getSource() == button[2]){
			setVisible(false);
		}
		
		
		
		
		
		if(e.getSource() == button[0]){
			for(int i=0;i<list.get(User_Num).BookList.size();i++){
				for(int j=0;j<CancelList.size();j++){
					if(list.get(User_Num).BookList.get(i).equals(CancelList.get(j)) && list.get(User_Num).BookList.get(i).valied_Book){list.get(User_Num).BookList.get(i).setValiedStatus(false);;}
				}
			}
			
			
			button[0].setVisible(false);
	 		button[1].setVisible(false);
	 		textPanel.setVisible(false);
	 		Display.setVisible(false);
	 		ButtonPanel.setVisible(false);
			set_Screen();
			
			
			Display.setVisible(true);
			PANEL.setBackground(Color.white);
			button[2].setVisible(true);
			ButtonPanel.setVisible(true);
		}
		
		
		
		
	}




}
