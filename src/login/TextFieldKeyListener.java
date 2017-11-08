package login;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;


	public class TextFieldKeyListener implements KeyListener{
	
		private int a;
		
		public TextFieldKeyListener(int a)
		{
		this.a = a;
		
		}
	      public void keyPressed(KeyEvent e){

	      }
	      public void keyReleased(KeyEvent e){

	      }

	      public void keyTyped(KeyEvent e )
	      {
	     
	        
	   if(a==1){
		   Object o = e.getSource();
	        if (o instanceof JTextField )
	        {	
              
	          char keyCh = e.getKeyChar();
	           
	          if ((keyCh < '0') || (keyCh > '9'))
	          {
	            if (keyCh != '') //回车字符
	              e.setKeyChar('\0');
	          }
	        }
	   }
	        if(a==2)
	        {
	        	 Object o = e.getSource();
	        	if (o instanceof JTextField )
		        {	
	              
		          char keyCh = e.getKeyChar();
		         // (keyCh < '.') ||(keyCh > '.'&& keyCh < '0') || (keyCh > '9')
		          if ( (keyCh < '.') ||(keyCh > '.'&& keyCh < '0') || (keyCh > '9'))
		          {
		        	  if (keyCh != '') //回车字符
			              e.setKeyChar('\0');
		          }		           
		            
		          }
	        }
	     }
	     
	        
	       
	    
	      }
		
	    
