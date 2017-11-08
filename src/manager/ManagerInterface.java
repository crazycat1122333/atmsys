package manager;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import login.LoginInterface;

public class ManagerInterface extends JPanel{
	String account;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	JFrame f = new JFrame();
	 JButton exit = new JButton("退出");
	 
	
	 //定义组件  
    //北部区域  
  JLabel jl1  ;
  //中部区域  
  JTabbedPane jtp = new JTabbedPane(JTabbedPane.LEFT);    ;// 选项卡窗格  
  //JLabel
  JLabel weclome = new JLabel("欢迎进进入ATM管理系统管理员界面! ");

  JPanel jp1  = new JPanel();
  JPanel jp2 = new JPanel();
  JPanel jp3 = new JPanel();
  JPanel jp4 = new JPanel();  
  JPanel jp5 = new JPanel();
  JPanel jp6 = new JPanel();
  JPanel jp7 = new JPanel();
  JPanel jp8 = new JPanel();
  JPanel jp9 = new JPanel();
  JPanel jp10 = new JPanel();
  public void SetJframe()
  {
	  //CreateCommonUser返回jp2
	  CreateCommonUser a1 = new CreateCommonUser();
	  jp2.setVisible(false);
	  jp2 = a1.create();
	  //DeleteCommonUser返回jp3
	  DeleteCommonUser a2 = new DeleteCommonUser();
	  jp3.setVisible(false);
	  jp3 = a2.delete();
	  //Loss返回jp4
	  Loss a3 = new Loss();
	  jp4.setVisible(false);
	  jp4 = a3.loss();
	  //HangingSolution返回jp5
	  HangingSolution a4 = new HangingSolution();
	  jp5.setVisible(false);
	  jp5 = a4.hangingSolution();
	  //Freezeing返回jp6
	  Freezeing a5 = new Freezeing ();
	  jp6.setVisible(false);
	  jp6 = a5.freezeing();
	  //Thawing返回jp7
	  Thawing a6 = new Thawing();
	  jp7.setVisible(false);
	  jp7 = a6.thawing();
	  //Search返回jp8
	  Search a7 = new Search();
	  jp8.setVisible(false);
	  jp8 = a7.search();
	  ChangeUser a9=new ChangeUser();
	  jp10.setVisible(false);
	  jp10=a9.ChangeUser();
	  //ChangePassword返回jp9
	  ChangePassword a8 = new ChangePassword();
	  a8.setAccount(account);
	  jp9.setVisible(false);
	  jp9 = a8.changePassword();
	  
	 //往选项卡窗格里添加JPanel
	jtp.add("主界面", jp1);  
    jtp.add("开户", jp2);  
    jtp.add("销户", jp3);  
    jtp.add("挂失", jp4); 
    jtp.add("解挂", jp5); 
    jtp.add("冻结", jp6); 
    jtp.add("解冻", jp7); 
    jtp.add("查询", jp8); 
    jtp.add("管理用户信息", jp10);
    jtp.add("修改密码", jp9); 
    
    //主界面的退出按钮
    
    exit.setBounds(650,500,130,45);
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
    
    jl1 = new JLabel(new ImageIcon("src//mface.png")); 
    //设置JLabel
    weclome.setBounds(80,150,750,100);
    weclome.setFont(new java.awt.Font("Dialog",1,40));
    weclome.setForeground(Color.red);
    
    //设置主界面
    jp1.setLayout(null);
    //往主界面里添加组件
    jp1.add(exit);
    jp1.add(weclome);
    
    f.add(jl1, BorderLayout.NORTH);  // 图片标签位于北部  
     //按钮位于南部  
    f.add(jtp, BorderLayout.CENTER); //选项卡窗格位于中部  
    
    //设置JFrame。
    f.setSize(900, 700);  
    f.setResizable(false);   //禁止改变窗体大小  
    f.setTitle("中国建设银行管理系统");  
    f.setVisible(true);  
	f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    Font font = new Font("微软雅黑",Font.BOLD,22);
    
       
    
    
  }
  
}
 
