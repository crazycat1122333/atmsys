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
	 JButton exit = new JButton("�˳�");
	 
	
	 //�������  
    //��������  
  JLabel jl1  ;
  //�в�����  
  JTabbedPane jtp = new JTabbedPane(JTabbedPane.LEFT);    ;// ѡ�����  
  //JLabel
  JLabel weclome = new JLabel("��ӭ������ATM����ϵͳ����Ա����! ");

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
	  //CreateCommonUser����jp2
	  CreateCommonUser a1 = new CreateCommonUser();
	  jp2.setVisible(false);
	  jp2 = a1.create();
	  //DeleteCommonUser����jp3
	  DeleteCommonUser a2 = new DeleteCommonUser();
	  jp3.setVisible(false);
	  jp3 = a2.delete();
	  //Loss����jp4
	  Loss a3 = new Loss();
	  jp4.setVisible(false);
	  jp4 = a3.loss();
	  //HangingSolution����jp5
	  HangingSolution a4 = new HangingSolution();
	  jp5.setVisible(false);
	  jp5 = a4.hangingSolution();
	  //Freezeing����jp6
	  Freezeing a5 = new Freezeing ();
	  jp6.setVisible(false);
	  jp6 = a5.freezeing();
	  //Thawing����jp7
	  Thawing a6 = new Thawing();
	  jp7.setVisible(false);
	  jp7 = a6.thawing();
	  //Search����jp8
	  Search a7 = new Search();
	  jp8.setVisible(false);
	  jp8 = a7.search();
	  ChangeUser a9=new ChangeUser();
	  jp10.setVisible(false);
	  jp10=a9.ChangeUser();
	  //ChangePassword����jp9
	  ChangePassword a8 = new ChangePassword();
	  a8.setAccount(account);
	  jp9.setVisible(false);
	  jp9 = a8.changePassword();
	  
	 //��ѡ����������JPanel
	jtp.add("������", jp1);  
    jtp.add("����", jp2);  
    jtp.add("����", jp3);  
    jtp.add("��ʧ", jp4); 
    jtp.add("���", jp5); 
    jtp.add("����", jp6); 
    jtp.add("�ⶳ", jp7); 
    jtp.add("��ѯ", jp8); 
    jtp.add("�����û���Ϣ", jp10);
    jtp.add("�޸�����", jp9); 
    
    //��������˳���ť
    
    exit.setBounds(650,500,130,45);
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
    
    jl1 = new JLabel(new ImageIcon("src//mface.png")); 
    //����JLabel
    weclome.setBounds(80,150,750,100);
    weclome.setFont(new java.awt.Font("Dialog",1,40));
    weclome.setForeground(Color.red);
    
    //����������
    jp1.setLayout(null);
    //����������������
    jp1.add(exit);
    jp1.add(weclome);
    
    f.add(jl1, BorderLayout.NORTH);  // ͼƬ��ǩλ�ڱ���  
     //��ťλ���ϲ�  
    f.add(jtp, BorderLayout.CENTER); //ѡ�����λ���в�  
    
    //����JFrame��
    f.setSize(900, 700);  
    f.setResizable(false);   //��ֹ�ı䴰���С  
    f.setTitle("�й��������й���ϵͳ");  
    f.setVisible(true);  
	f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    Font font = new Font("΢���ź�",Font.BOLD,22);
    
       
    
    
  }
  
}
 
