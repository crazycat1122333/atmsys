package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import commonuser.CommonUserInterface;
import commonuser.Transfer;

public class AllInterface extends JFrame{
	String account;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public JFrame t = new JFrame("�й���������ATMϵͳ");
	//�������
    public Interface p = new Interface();
    public ATMButton determent;
   
    public  ATMButton back ;
    ATMButton exit;
  //��ȡ������ť��ͼƬ
  //  Icon icon1 = new ImageIcon("src//button2-8.jpg");
  //  Icon icon2 = new ImageIcon("src//button10.jpg");
  //  Icon icon3 = new ImageIcon("src//button2-7.jpg"); 
  // icon4 = new ImageIcon("src//button1.jpg");
   
    
    public void setJframe()
    {
    //��ͼƬ��ӵ�������ť	
   
    back = new ATMButton("����");
    back.setFont(new java.awt.Font("Dialog",1,20));
    exit = new ATMButton("�˿�");
    exit.setFont(new java.awt.Font("Dialog",1,20));
    determent = new ATMButton("ȷ��");
    determent.setFont(new java.awt.Font("Dialog",1,20));
    //���ð�ť��λ��
   
    back.setBounds(0,480,120,45);
    exit.setBounds(770,520,120,45);
    determent.setBounds(770,240,120,50);
    //continue1�ļ����¼�
   
    //back�ļ����¼�
    back.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		CommonUserInterface c2 = new CommonUserInterface();
    		
    		c2.setAccount(account);
    		
    		c2.setJframe();
    		t.setVisible(false);
    	}
    	}
    	
    );
    //exit�ļ����¼�
    exit.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		LoginInterface c3 = new LoginInterface();
    	
    		c3.SetJframe();
    		t.setVisible(false);
    	}
    	
    });
    //determent�ļ����¼�
    determent.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		
    	}
    	
    });
    
  //����ť��ӵ������
    
    p.add(back);
    p.add(exit);
    p.add(determent);
    p.setLayout(null);
	t.add(p);
	t.setSize(900,600);
	t.setVisible(true);
	t.setLocationRelativeTo(null);	
	t.setResizable(false);
	t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
    }
    
    public void removebackButton()
    {
    	p.remove(back);
    }
    public void removeexitButton()
    {
    	p.remove(exit);
    }
    public void removedetermentButton()
    {
    	p.remove(determent);
    }

}
