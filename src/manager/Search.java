package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import commonuser.SearchTransactionDetails;

public class Search {
	JPanel panel3;
	//JLabel
	JLabel a1 = new JLabel("��������Ҫ��ѯ���˺� ��");
	JLabel a3 = new JLabel("�������˺ŵ�����  ��");
	//JTextField
	JTextField b1 = new JTextField();
	
	JTextField b3= new JTextField();
	//ȷ����ť
	JButton c1 = new JButton("��ѯ");
	
	
	public JPanel search()
	{
		panel3 = new JPanel();
		panel3.setLayout(null);
		//����JLabel
		a1.setBounds(100,150,250,50);
		a1.setFont(new java.awt.Font("Dialog",1,20));		
		a3.setBounds(100,250,250,50);
		a3.setFont(new java.awt.Font("Dialog",1,20));
		//����JTextField
		b1.setBounds(350,155,200,35);
		b1.setFont(new java.awt.Font("Dialog",1,20));		
		b3.setBounds(350,255,200,35);
		b3.setFont(new java.awt.Font("Dialog",1,20));
		//����ȷ����ť
		c1.setBounds(550,375,130,50);
		c1.setFont(new java.awt.Font("Dialog",1,20));
		c1.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		SearchAccount c1=new SearchAccount();
	    		c1.setAccount(b1.getText());
	    		c1.setJframe();
	    	}
	    	
	    });
		//��panel3��������
		panel3.add(a1);
		
		panel3.add(a3);
		panel3.add(b1);
	
		panel3.add(b3);
		panel3.add(c1);
		
		
		return panel3;
	}

}
