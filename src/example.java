import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import org.omg.CORBA.Bounds;


public class example  extends AppFrame implements ActionListener{
	ArrayList<Book> list= new ArrayList<Book>();
	JPanel PANEL=new JPanel();
	JPanel BookRack;
	JScrollPane scr = new JScrollPane(BookRack);
	JButton[] BookButton;
	example(ArrayList<Book> Nlist){
	super();
	list=Nlist;
		
		BookButton=new JButton[list.size()];
		GridLayout experimentLayout = new GridLayout(4,3);
		PANEL.setPreferredSize(new Dimension(450,1000));
		PANEL.setLayout(experimentLayout);
		scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		for(int i=0;i<list.size();i++){
 		 BookRack = new JPanel(new GridLayout(2,0));
 			BookButton[i]=new JButton(new ImageIcon(((new ImageIcon(
 					list.get(i).getFrontCover()).getImage()
 		            .getScaledInstance(130,160,
 		                    java.awt.Image.SCALE_SMOOTH)))));
 			
 			BookButton[i].setPreferredSize(new Dimension(130,160));
 			JTextArea Book_Display = new JTextArea();
 			Book_Display.append(list.get(i).toString());
 			Book_Display.setFont(new Font("Times new Roman", Font.BOLD, 14));
 			Book_Display.setEditable(false);
 			Book_Display.setBackground(new Color(0,0,0,0));
 			BookButton[i].addActionListener(this);
 			BookRack.add( BookButton[i] );
 			BookRack.add( Book_Display );
 			BookRack.setPreferredSize(new Dimension(130,220));
 			BookRack.setBackground(new Color(0,0,0,0));
 			//PANEL.add(BookRack);
 			//PANEL.setBackground(new Color(0,0,0,0));
 			//PANEL.revalidate();
 		}
	
	add(scr, BorderLayout.CENTER);
	setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] arguments) {
		ArrayList<User> NList= new ArrayList<User>();  
		NList.add(new User("!admin2","!admin2",""));
		ArrayList<Book> list= new ArrayList<Book>();
		int i=0;
		while(i<10){
		list.add(new Book("Hot Java","S. Narayanan","123-ABC-101",0.05));		list.get(i).setFrontCover("HotJava.jpg");
		//list.add(new Book("Fun Java","Y. Byun","ABCDEF-09",1.00));				list.get(i+1).setFrontCover("funjava.jpg");
		//list.add(new Book("Algorithm for Java","K. Alice","CDE-777-123",0.25));	list.get(i+2).setFrontCover("algorithm.jpg");
		i++;}
		example a= new example(list);
	}
	
}
