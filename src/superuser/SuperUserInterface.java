package superuser;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import login.LoginInterface;



import login.LoginInterface;


public class SuperUserInterface {
	
	JFrame f = new JFrame();
	 JButton exit;
	   
	
	 //�������  
   //��������  
 JLabel jl1  ;
 //�в�����  
 JTabbedPane jtp = new JTabbedPane();    ;// ѡ�����  
 JPanel jp1 = new JPanel();
 JPanel jp2 = new JPanel();
 JPanel jp3 = new JPanel();
 
//JLabel
 JLabel weclome = new JLabel("��ӭ������ATM����ϵͳ�����û����� ! ");

 public void SetJframe()
 {
	 
	 //CreateManager����jp2
	 CreateManager a1 = new CreateManager();
	 jp2.setVisible(false);
	 jp2 = a1.createManager();
	 
	 
	 jtp.add("������", jp1);  
   jtp.add("��������Ա", jp2);  
   jtp.add("����Ա��Ϣ", jp3);  
   
   
   exit = new JButton("�˳�");
   exit.setBounds(700,470,130,45);
   exit.setFont(new java.awt.Font("Dialog",1,20));
  
 //exit�ļ����¼�
   exit.addActionListener(new ActionListener()
   {
   	public void actionPerformed(ActionEvent e)
   	{
   		LoginInterface c3 = new LoginInterface();
   		c3.SetJframe();
   		f.setVisible(false);
   	}
   	
   });
   //����JLabel
   weclome.setBounds(80,150,750,100);
   weclome.setFont(new java.awt.Font("Dialog",1,40));
   weclome.setForeground(Color.red);
   jl1 = new JLabel(new ImageIcon("src//a123.jpg")); 
   jp1.setLayout(null);
   jp1.add(exit);
   jp1.add(weclome);
   
   f.add(jl1, BorderLayout.NORTH);  // ͼƬ��ǩλ�ڱ���  
    //��ťλ���ϲ�  
   f.add(jtp, BorderLayout.CENTER); //ѡ�����λ���в�  
     
   f.setSize(950, 700);  
   f.setResizable(false);   //��ֹ�ı䴰���С  
   f.setTitle("�й��������й���ϵͳ");  
   f.setVisible(true);  
	f.setLocationRelativeTo(null);
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
   Font font = new Font("΢���ź�",Font.BOLD,22);
   
   
 }
	
    


}
