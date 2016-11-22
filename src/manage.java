/**
 * Imara Dharmakirthi
 * First Login 
 * Display show all users and transactions 
 * Date:05/10/2015 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class manage extends AppFrame implements ActionListener {
	ArrayList<User> list=new ArrayList<User>();
	ArrayList<Book> Booklist=new ArrayList<Book>();
	JTextArea Display = new JTextArea(10,30);
	JScrollPane scr = new JScrollPane(Display);
	
	JTextArea Dis_Title = new JTextArea(1,10);	
	JTextArea Dis_author = new JTextArea(1,10);
	JTextArea Dis_ISBN = new JTextArea(1,10);
	JTextArea Dis_Price = new JTextArea(1,10);
	
	JButton[] button = new JButton[3];
	String[] buttonName ={"OK","ADD A NEW BOOK", "Cancel"};
	JPanel PANEL=new JPanel();
	JPanel Book_PANEL=new JPanel();
	
	manage(ArrayList<User> Nlist, ArrayList<Book> NBooklist ){
		super();
		list=Nlist;
		Booklist=NBooklist;
		Display.setEditable(false);
		Display.setFont(new Font("Times new Roman", Font.BOLD, 14));
		Display.setPreferredSize(new Dimension(460,900));
		Display.setBounds(20, 30, 450, 100);
		scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		String text="";
		for(int i=1; i<list.size();i++){
		text=text+list.get(i).toString()+"\n";
		for(int j=0;j<list.get(i).BookList.size();j++){
			if(list.get(i).BookList.get(j).valied_Book)	{text=text+"Recerved\n";
			}else text=text+"Canceled\n";
			text=text+list.get(i).BookList.get(j).toString();
		}	
		}
		//System.out.print(text);
		Display.append(text);
		
		PANEL.setLayout(new GridLayout(2,1));
		Book_PANEL.setLayout(new GridLayout(4,1));
		PANEL.add(scr);
		
		JPanel ButtnPanel=new JPanel();
		JPanel ButtnANDBOOK=new JPanel(new GridLayout(2,1));
		//ButtnANDBOOK.setLayout();
		for(int i=0; i<3;i++){
 			button[i]= new JButton();
 			button[i].setText(buttonName[i]);
 			button[i].setFont(new Font("Times new Roman", Font.BOLD, 17));
 			button[i].addActionListener(this);
 			if(i==1){button[i].setPreferredSize(new Dimension(200,30));}else button[i].setPreferredSize(new Dimension(90,30));
 			ButtnPanel.add(button[i]);
 		}
		ButtnPanel.setBackground(new Color(0,0,0,0));
		JLabel Title=new JLabel("Title:    ");
		JLabel author=new JLabel("Author:  ");
		JLabel ISBN=new JLabel("ISBN:      ");
		JLabel Price=new JLabel("Price:    ");
		
		Dis_Title.setPreferredSize(new Dimension(100,30));
		Dis_author.setPreferredSize(new Dimension(100,30));
		Dis_ISBN.setPreferredSize(new Dimension(100,30));
		Dis_Price.setPreferredSize(new Dimension(100,30));
		
		JPanel tit=new JPanel();
		tit.add(Title); 	tit.add(Dis_Title);
		tit.setBackground(new Color(0,0,0,0));
		Book_PANEL.add(tit);
		JPanel aut=new JPanel();
		aut.add(author);	aut.add(Dis_author);
		aut.setBackground(new Color(0,0,0,0));
		Book_PANEL.add(aut);
		JPanel isbn=new JPanel();
		isbn.add(ISBN);	isbn.add(Dis_ISBN);
		isbn.setBackground(new Color(0,0,0,0));
		Book_PANEL.add(isbn);
		JPanel pric=new JPanel();
		pric.add(Price);	pric.add(Dis_Price);
		pric.setBackground(new Color(0,0,0,0));
		Book_PANEL.add(pric);
		Book_PANEL.setBackground(new Color(0,0,0,0));
		Book_PANEL.setVisible(false);
		ButtnANDBOOK.add(ButtnPanel);
		ButtnANDBOOK.add(Book_PANEL);
		ButtnANDBOOK.setBackground(new Color(0,0,0,0));
		PANEL.add(ButtnANDBOOK);
		PANEL.setBackground(new Color(0,0,0,0));
		add(PANEL, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button[0]){
			setSize(500,700);
			Book_PANEL.setVisible(true);
		}
		if(e.getSource() == button[1]){
			String title=Dis_Title.getText();
			String autho=Dis_author.getText();
			String isbn=Dis_ISBN.getText();
			String price=Dis_Price.getText();
			if(title.length()>0 && autho.length()>0 && isbn.length()>0 && price.length()>0){
				double value=0.0;
				try{
				value= Double.parseDouble(price);
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(this,"Enter The Price!");
					Dis_Price.setText("");
				}
				Book tem=new Book(title, autho, isbn,value);
				Booklist.add(tem);
				setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this,"Enter All Infomation!");
				Dis_Title.setText("");	Dis_author.setText(""); 	Dis_ISBN.setText(""); 	Dis_Price.setText("");
			}
		}
		if(e.getSource() == button[2]){
			setVisible(false);
		}
	}
	
	
	
}
