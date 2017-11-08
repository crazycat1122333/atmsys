package login;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel;
import org.jvnet.substance.title.ArcHeaderPainter;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;

import superuser.SuperUserInterface;
import manager.ManagerInterface;
import commonuser.CommonUserInterface;
import Bean.accountBean;
import Dao.accountDao;
import Dao.managerDao;
public class LoginInterface extends JFrame{
	
	JFrame t = new JFrame("�й���������ATMϵͳ");
	//�������
    Interface p = new Interface();
    ATMButton ab ;
    int a;
    JLabel a1 = new JLabel("�����������˺� : "); 
    JLabel a2 = new JLabel("�������������� : "); 
    JLabel a3 = new JLabel("��ѡ��������� : ");
    String account=null;
    //�ı���
    private JTextField textfield1 = new JTextField();
    JPasswordField textfield2 = new JPasswordField();
    //��ѡ��
    JRadioButton commonUser = new JRadioButton("��ͨ�û�", true);
    JRadioButton manager = new JRadioButton("����Ա");
   // JRadioButton superUser = new JRadioButton("�����û�");
    ButtonGroup userType = new ButtonGroup();
    int n=3;
    
public void SetJframe(){
	
	   
	    a1.setBounds(220, 220, 180, 80);
	    a1.setFont(new java.awt.Font("Dialog",1,20));
	    
	    a2.setBounds(220, 320, 180, 80);
	    a2.setFont(new java.awt.Font("Dialog",1,20));
	    
	    a3.setBounds(220,420,180,80);
	    a3.setFont(new java.awt.Font("Dialog",1,20));
	    //�����ı���
	    getTextfield1().setFont(new java.awt.Font("Dialog",1,20));
	    getTextfield1().setBounds(410,240,200,37);
	    textfield2.setFont(new java.awt.Font("Dialog",1,20));
	    textfield2.setBounds(410,340,200,37);
	    
	    //����go��ť
	   
	    ab = new ATMButton("ȷ��");
	    ab.setBounds(700,280,160,58);
	    //������������
	    textfield1.addKeyListener(new TextFieldKeyListener(1));
	    textfield2.addKeyListener(new TextFieldKeyListener(1));

	    textfield1.addKeyListener(
	    		new KeyAdapter()
	    		{ 
	    		public void keyTyped(KeyEvent e) 
	    		{ 	    		
	    		int length=textfield1.getText().length();	 
	    		
	    		if((length>15))
	    		{ 
	    		e.consume(); 
	    		}
	    		
	    		} 
	    		});
	    textfield2.addKeyListener(
	    		new KeyAdapter()
	    		{ 
	    		public void keyTyped(KeyEvent e) 
	    		{ 
	    		int length=textfield2.getText().length();
	    		if((length>5))
	    		{ 
	    		e.consume(); 
	    		}
	    		} 
	    		});
	    	
//	    public void removeActionListener(textfield2.getKeyListeners());
	   
	    //����ȷ����ť�ļ����¼�
	    ab.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    	  accountDao ad=new accountDao();
	    	  managerDao md=new managerDao();
    		  String jf1=getTextfield1().getText();
    	      String jf2=textfield2.getText();
    	    
	    		if(commonUser.isSelected())
	    			
	    		{  
	    			
	    	    
	    		     try {
	    		    	 
	    		    	 if(ad.accountCheck(jf1))
	    		    	 {
	    		    		
	    		    		 if(ad.checkUsalesstatus(jf1))
		    		    	 {
		    		    		 JOptionPane.showMessageDialog(null, "�Ƿ����������û��ѱ�ע��", "ERROR", JOptionPane.ERROR_MESSAGE);
		    		    		 
		    		    	 }
	    		    		 if(!ad.checkUsalesstatus(jf1))
	    		    		 {
	    		    	 if(ad.login(jf1, jf2))
	    		     {	
	    		    		
								CommonUserInterface a1 = new CommonUserInterface();
								a1.setAccount(jf1);							
								a1.setJframe();
								t.setVisible(false);
								
								
	    		     }
	    		    	 
						else
						{
							n--;
							if(n==0)
							{
								md.freezeing(jf1);
								JOptionPane.showMessageDialog(null, "���˺��ѱ����ᣡ", "ERROR", JOptionPane.ERROR_MESSAGE);
								textfield1.setText("");
								textfield2.setText("");
							}
							if(!(n==0))
							{
							JOptionPane.showMessageDialog(null, "��������ȷ������!\n�㻹��"+n+"�λ��ᣡ", "ERROR", JOptionPane.ERROR_MESSAGE);
							textfield1.setText("");
							textfield2.setText("");
							}
						}
	    		    	 }
	    		    	 
	    		     }
	    		    	 if(!ad.accountCheck(jf1))
	    		    	 {
	    		    		 JOptionPane.showMessageDialog(null, "���˺Ų����ڣ�\n��������ȷ���˺ţ�", "ERROR", JOptionPane.ERROR_MESSAGE);
	    		    		 textfield1.setText("");
							textfield2.setText("");
	    		    	 }
	    		     
	    		     
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.toString();																
					}							
					}
					 
					
	    		else if(manager.isSelected())
	    		{  try {
					if(md.login(jf1, jf2))
					{
						ManagerInterface a2 = new ManagerInterface();
						a2.setAccount(jf1);;
						a2.SetJframe();
						t.setVisible(false);}
					else
					{
						JOptionPane.showMessageDialog(null, "��������ȷ���˺ź�����", "ERROR", JOptionPane.ERROR_MESSAGE);
						
					}
				} catch (SQLException e1) 
	    		{
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
	    		}
//	    		}else if(superUser.isSelected())
//	    		{
//	    			SuperUserInterface a3 = new SuperUserInterface();
//	    			a3.SetJframe();
//	    			t.setVisible(false);
//	    		}
	    	}
	    });
	    //����ѡ��ť�ӽ���ѡ��ť��
	    userType.add(commonUser);
	    userType.add(manager);
	   // userType.add(superUser);
	    //���õ�ѡ��ť��λ��
	    commonUser.setBounds(420,440,80,50);
	    manager.setBounds(500,440,80,50);
	  //  superUser.setBounds(580,440,80,50);
	   //�������������Ӹ��������
	    p.add(a1);
	    p.add(a2);
	    p.add(a3);
	    p.add(getTextfield1());
	    p.add(textfield2);
	  //  p.add(go);
	    p.add(commonUser);
	    p.add(manager);
	 //   p.add(superUser);
	    p.add(ab);
	   
	    p.setLayout(null);
		t.add(p);
		t.setSize(900,600);
		t.setVisible(true);
		t.setLocationRelativeTo(null);	
		t.setResizable(false);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("΢���ź�",Font.BOLD,22);
		
		
	    
	}
public static void main(String args[])
{
 //�����߿�
    
    try { 
        UIManager.setLookAndFeel(new SubstanceBusinessBlueSteelLookAndFeel());  
          JFrame.setDefaultLookAndFeelDecorated(true);  
          JDialog.setDefaultLookAndFeelDecorated(true);  
     //    SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());  
   //        SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());  
       SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());  
       SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());  
    //   SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());  
//         SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());  
         SubstanceLookAndFeel.setCurrentTitlePainter(new ArcHeaderPainter());  
     
      } catch (Exception e) {  
          System.err.println("Something went wrong!");  
      }  
    
	LoginInterface inface = new LoginInterface();
	inface.SetJframe();
	
}
public JTextField getTextfield1() 
{
	return textfield1;
}
public void setTextfield1(JTextField textfield1)
{
	this.textfield1 = textfield1;
}

		
		



}
