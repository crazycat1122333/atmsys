package login;
import java.awt.*; 

import javax.swing.*;
//总体窗口的抽象父类。
public class Interface extends JPanel {
	
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	int x = 0, y = 0;
    	ImageIcon icon = new ImageIcon("src/face1.png");
    	g.drawImage(icon.getImage(), x, y, getSize().width,
    	getSize().height, this);
    }
    
	}
   
   
    
    
	

