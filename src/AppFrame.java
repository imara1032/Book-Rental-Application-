import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppFrame extends JFrame {

	public AppFrame() {
		super("CSUMB Libarary");
		setSize(500,600);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
 	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
 	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
 	    setLocation(x, y);
 		setResizable(false);
 		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//JLabel background=new JLabel(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg"));
		setLayout(new BorderLayout());
	    setContentPane(new JLabel(new ImageIcon(((new ImageIcon(
		            "csumb_000.jpg").getImage()
		            .getScaledInstance(500, 600,
		                    java.awt.Image.SCALE_SMOOTH))))));//new ImageIcon("csumb_000.jpg")));
	    setLayout(new FlowLayout());
	}

}
