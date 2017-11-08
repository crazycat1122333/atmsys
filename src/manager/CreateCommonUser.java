package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import login.TextFieldKeyListener;
import Bean.accountBean;
import Bean.userBean;
import Dao.accountDao;
import Dao.managerDao;
import commonuser.FinalChangePassword;

public class CreateCommonUser extends AllInterface {
	JPanel jp1;
	
	String c_type;
	double setOver;
	userBean ub=new userBean();
	//JLabel
	JLabel a1 = new JLabel(" ����д���Ŀ�����Ϣ��   ");
	JLabel a2 = new JLabel("����д�������� ��");
	JLabel a3 = new JLabel("��ѡ�������Ա� ��");
	JLabel a4 = new JLabel("����д���ĳ������� ��");
	JLabel a5 = new JLabel("����д�������֤���� ��");
	JLabel a6 = new JLabel("����д���ļ�ͥסַ ��");
	JLabel a7 = new JLabel("����д�����ֻ����� ��");
	JLabel a11 = new JLabel("����д���Ĺ�����λ��ַ ��");
	JLabel a13 = new JLabel("��ѡ�������������� ��");
	//�ı���
	JTextField b1 = new JTextField();
	JTextField b2 = new JTextField();
	JTextField b3 = new JTextField();
	JTextField b4 = new JTextField();
	JTextField b5 = new JTextField();
	JTextField b6 = new JTextField();
	JTextField b7 = new JTextField();
	JTextField b8 = new JTextField();
	//�Ա�ѡ���
	JRadioButton male = new JRadioButton("��",true);
	JRadioButton female = new JRadioButton("Ů");
	ButtonGroup sex = new ButtonGroup();
	//������òѡ���
	JComboBox shenfen ;
	//��������ѡ���
	JComboBox birthYear;
	JComboBox birthMonth;
	JComboBox birthTime;
	
	//��������ѡ���
	JRadioButton saveCard = new JRadioButton("���",true);
	JRadioButton creditCard = new JRadioButton("���ÿ�");
	ButtonGroup cardType = new ButtonGroup();
	//ȷ����ť
	JButton determent = new JButton("ȷ��");

	
	
	
	public JPanel create()	
	{
		jp1 = new JPanel();
		jp1.setLayout(null);
		//����JLabel
		 a1.setBounds(250, 0, 280, 50);
		 a1.setFont(new java.awt.Font("Dialog",1,22));
		
		 a2.setBounds(80, 50, 150, 40);
		 a2.setFont(new java.awt.Font("Dialog",1,15));
		 a3.setBounds(80, 90, 150, 40);
		 a3.setFont(new java.awt.Font("Dialog",1,15));
		 a4.setBounds(80, 130, 180, 40);
		 a4.setFont(new java.awt.Font("Dialog",1,15));
		 a5.setBounds(80, 170, 180, 40);
		 a5.setFont(new java.awt.Font("Dialog",1,15));
		 b5.addKeyListener(new TextFieldKeyListener(1));
		 b5.addKeyListener(
		    		new KeyAdapter()
		    		{ 
		    		public void keyTyped(KeyEvent e) 
		    		{ 	    		
		    		int length=b5.getText().length();	 
		    		
		    		if((length>17))
		    		{ 
		    		e.consume(); 
		    		}
		    		
		    		} 
		    		});
		
		 a6.setBounds(80, 210, 180, 40);
		 a6.setFont(new java.awt.Font("Dialog",1,15));
		 a7.setBounds(80, 250, 180, 40);
		 a7.setFont(new java.awt.Font("Dialog",1,15));
		 a11.setBounds(80, 290, 200, 40);
		 a11.setFont(new java.awt.Font("Dialog",1,15));
		 a13.setBounds(80,330,180,40);
		 a13.setFont(new java.awt.Font("Dialog",1,15));
		 
		 //����JTextField
		 b1.setBounds(230,57,100,25);
		 b1.setFont(new java.awt.Font("Dialog",1,15));
		 b2.setBounds(260,177,160,25);
		 b2.setFont(new java.awt.Font("Dialog",1,15));
		 b3.setBounds(250,217,350,25);
		 b3.setFont(new java.awt.Font("Dialog",1,15));
		 b4.setBounds(250,257,110,25);
		 b4.setFont(new java.awt.Font("Dialog",1,15));
		 b8.setBounds(275,297,350,25);
		 b8.setFont(new java.awt.Font("Dialog",1,15));
	
		//���Ա�ѡ���������ӵ�ѡ��ť
		sex.add(male);
		sex.add(female);
		//����JRadioButton
		male.setBounds(230,90,50,40);
		male.setFont(new java.awt.Font("Dialog",1,15));		
		female.setBounds(280,90,50,40);
		female.setFont(new java.awt.Font("Dialog",1,15));
		//���ó�������
		birthYear =  Year();
		birthMonth = Month();
		birthTime = Times();
		birthYear.setBounds(260,140,75,25);
		birthMonth.setBounds(335,140,60,25);
		birthTime.setBounds(395,140,60,25);			
		//��������������ӵ�ѡ��ť
		cardType.add(saveCard);
		cardType.add(creditCard);
		//���ÿ�������
		saveCard.setBounds(260,330,80,40);
		saveCard.setFont(new java.awt.Font("Dialog",1,15));		
		creditCard.setBounds(340,330,80,40);
		creditCard.setFont(new java.awt.Font("Dialog",1,15));		
		//����ȷ����ť
		determent.setBounds(580,460,130,40);
		determent.setFont(new java.awt.Font("Dialog",1,20));
		
		//��JPanel jp1��������
		//��JPanel����� JLabel��
		jp1.add(a1);
		jp1.add(a2);
		jp1.add(a3);
		jp1.add(a4);
		jp1.add(a5);
		jp1.add(a6);
		jp1.add(a7);
		jp1.add(a11);
	
		jp1.add(a13);
		//��JPanel jp1�����JTexeField
		jp1.add(b1);
		jp1.add(b2);
		jp1.add(b3);
		jp1.add(b4);
		jp1.add(b8);
		
		//���������ò
		//����Ա�
		jp1.add(male);
		jp1.add(female);
		//��ӳ�������
		jp1.add(birthYear);
		jp1.add(birthMonth);
		jp1.add(birthTime);		
		//��ӿ�������
		jp1.add(saveCard);
		jp1.add(creditCard);
		
		//���ȷ����ť
		jp1.add(determent);
		birthYear.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent evt)
            {
            	//if (ItemEvent.SELECTED == evt.getStateChange()) { 
            	ub.setUage((birthYear.getSelectedItem().toString()));
            	
            	//}
            }
        });
		determent.addActionListener(new ActionListener()
	      {
	      	public void actionPerformed(ActionEvent e)
	      	
	      	{   
	      		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
	      		String a=birthYear.getSelectedItem().toString();
	      	System.out.println(a);
	      	String date=df.format(new Date());
	      	   int i = 2017-Integer.parseInt(a);
	      	   String Uage=i+"";
	      		boolean Usex =false;
	      		managerDao md=new managerDao();
	      	if(male.isSelected()){
	      		Usex=true; 
	      	}
	      	if(female.isSelected()){
	      		Usex=false; 
	      	}
	      	if(saveCard.isSelected()){
	      		c_type="���";
	      		setOver=0.00;
	      		}
	      	if(creditCard.isSelected()){
	      		c_type="���ÿ�";
	      		setOver=3000.00;
	      		}
	        	md.setAccount(getAccount());
	       md.createCommonUser(b1.getText(), Uage, b2.getText(), Usex, b4.getText(), b3.getText(), "��������", b7.getText());
	      	 
	      	md.createCommonAccount( b1.getText(), "123456", date, "��������", "����", "0",c_type, setOver, false,"20000",50000.00,"�й���������");
	      	ChangeManagerPassword a1=new ChangeManagerPassword();
	      	a1.setFrame();
	      	
	      	}
	      	
	      });	
		return jp1;
		
	}

	public JComboBox Year()
	{
		String[] arry = new String[117];
		for (int i = 2017; i > 1900; i--)
		{
			arry[2017-i] = i +"";			
		}
		JComboBox combox = new JComboBox(arry);
		return combox;
	}
	public JComboBox Month()
	{
		String[] arry = new String[12];
		for (int i = 1; i <13; i++)
		{
			arry[i-1] = i +"";			
		}
		JComboBox combox = new JComboBox(arry);
		return combox;
	}
	public JComboBox Times()
	{
		String[] arry = new String[30];
		for (int i = 1; i <31; i++)
		{
			arry[i-1] = i+"" ;			
		}
		JComboBox combox = new JComboBox(arry);
		return combox;
	}
	
	
}
