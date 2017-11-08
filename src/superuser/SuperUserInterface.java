package superuser;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import login.LoginInterface;



import login.LoginInterface;


public class SuperUserInterface {
	
	JFrame f = new JFrame();
	 JButton exit;
	   
	
	 //定义组件  
   //北部区域  
 JLabel jl1  ;
 //中部区域  
 JTabbedPane jtp = new JTabbedPane();    ;// 选项卡窗格  
 JPanel jp1 = new JPanel();
 JPanel jp2 = new JPanel();
 JPanel jp3 = new JPanel();
 
//JLabel
 JLabel weclome = new JLabel("欢迎进进入ATM管理系统超级用户界面 ! ");

 public void SetJframe()
 {
	 
	 //CreateManager返回jp2
	 CreateManager a1 = new CreateManager();
	 jp2.setVisible(false);
	 jp2 = a1.createManager();
	 
	 
	 jtp.add("主界面", jp1);  
   jtp.add("创建管理员", jp2);  
   jtp.add("管理员信息", jp3);  
   
   
   exit = new JButton("退出");
   exit.setBounds(700,470,130,45);
   exit.setFont(new java.awt.Font("Dialog",1,20));
  
 //exit的监听事件
   exit.addActionListener(new ActionListener()
   {
   	public void actionPerformed(ActionEvent e)
   	{
   		LoginInterface c3 = new LoginInterface();
   		c3.SetJframe();
   		f.setVisible(false);
   	}
   	
   });
   //设置JLabel
   weclome.setBounds(80,150,750,100);
   weclome.setFont(new java.awt.Font("Dialog",1,40));
   weclome.setForeground(Color.red);
   jl1 = new JLabel(new ImageIcon("src//a123.jpg")); 
   jp1.setLayout(null);
   jp1.add(exit);
   jp1.add(weclome);
   
   f.add(jl1, BorderLayout.NORTH);  // 图片标签位于北部  
    //按钮位于南部  
   f.add(jtp, BorderLayout.CENTER); //选项卡窗格位于中部  
     
   f.setSize(950, 700);  
   f.setResizable(false);   //禁止改变窗体大小  
   f.setTitle("中国建设银行管理系统");  
   f.setVisible(true);  
	f.setLocationRelativeTo(null);
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
   Font font = new Font("微软雅黑",Font.BOLD,22);
   
   
 }
	
    


}
