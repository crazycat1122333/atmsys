package login;
import java.awt.*; 

import javax.swing.*;
//���崰�ڵĳ����ࡣ
public class Interface extends JPanel {
	
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	int x = 0, y = 0;
    	ImageIcon icon = new ImageIcon("src/face1.png");
    	g.drawImage(icon.getImage(), x, y, getSize().width,
    	getSize().height, this);
    }
    
	}
   
   
    
    
	

