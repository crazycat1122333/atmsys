package superuser;

import javax.swing.*;

import manager.CreateCommonUser;

public class CreateManager {
	JPanel panel2;
	
	//JLabel;�������Ա𣬳������ڣ���ְ���ڣ�סַ���ֻ����룬���䣬���֤�ţ�ѧ����������ò
	JLabel a1 = new JLabel("����д�¹���Ա��");
	JLabel a2 = new JLabel("     ���� ��");
	JLabel a3 = new JLabel("     �Ա�  ��");
	JLabel a4 = new JLabel("�������� ��");
	JLabel a5 = new JLabel("��ְ���� ��");
	JLabel a6 = new JLabel("     סַ ��");
	JLabel a7 = new JLabel("�ֻ����� ��");
	JLabel a8 = new JLabel("     ���� ��");
	JLabel a9 = new JLabel("���֤�� ��");
	JLabel a10 = new JLabel("     ѧ�� ��");
	JLabel a11 = new JLabel("������ò ��");
	JLabel a12 = new JLabel("����Ա��� ��");
	
	//JTextField 5
	JTextField b1 = new JTextField();
	JTextField b2 = new JTextField();
	JTextField b3 = new JTextField();
	JTextField b4 = new JTextField();
	JTextField b5 = new JTextField();
	
	//��ť
	JButton c1 = new JButton("ȷ��");
	
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
	//��ְ����
	JComboBox entryYear;
	JComboBox entryMonth;
	JComboBox entryTime;
	//ѧ��ѡ���
	JComboBox education;
	
	
	public JPanel createManager()
	{
		panel2 = new JPanel();
		panel2.setLayout(null);
		//����CreateCommonUser��
		CreateCommonUser reusing = new CreateCommonUser();
		
		//����JLabel
		a1.setBounds(320, 0, 300, 50);
		a1.setFont(new java.awt.Font("Dialog",1,25));
		a2.setBounds(200,60,100,40);
		a2.setFont(new java.awt.Font("Dialog",1,15));
		a3.setBounds(200,100,100,40);
		a3.setFont(new java.awt.Font("Dialog",1,15));
		a4.setBounds(200,140,100,40);
		a4.setFont(new java.awt.Font("Dialog",1,15));
		a5.setBounds(200,180,100,40);
		a5.setFont(new java.awt.Font("Dialog",1,15));
		a6.setBounds(200,220,100,40);
		a6.setFont(new java.awt.Font("Dialog",1,15));
		a7.setBounds(200,260,100,40);
		a7.setFont(new java.awt.Font("Dialog",1,15));
		a8.setBounds(200,300,100,40);
		a8.setFont(new java.awt.Font("Dialog",1,15));
		a9.setBounds(200,340,100,40);
		a9.setFont(new java.awt.Font("Dialog",1,15));
		a10.setBounds(200,380,100,40);
		a10.setFont(new java.awt.Font("Dialog",1,15));
		a11.setBounds(200,420,100,40);
		a11.setFont(new java.awt.Font("Dialog",1,15));
		a12.setBounds(200,460,100,40);
		a12.setFont(new java.awt.Font("Dialog",1,15));
		
		//����JTextField
		b1.setBounds(280,67,100,25);
		b1.setFont(new java.awt.Font("Dialog",1,15));
		b2.setBounds(280,227,300,25);
		b2.setFont(new java.awt.Font("Dialog",1,15));
		b3.setBounds(280,267,150,25);
		b3.setFont(new java.awt.Font("Dialog",1,15));
		b4.setBounds(280,307,150,25);
		b4.setFont(new java.awt.Font("Dialog",1,15));
		b5.setBounds(280,347,180,25);
		b5.setFont(new java.awt.Font("Dialog",1,15));
		
		//���ð�ť
		c1.setBounds(670,470,130,50);
		c1.setFont(new java.awt.Font("Dialog",1,22));
		
		//���Ա�ѡ���������ӵ�ѡ��ť
		sex.add(male);
		sex.add(female);
		
		//����JRadioButton
		male.setBounds(280,100,50,40);
		male.setFont(new java.awt.Font("Dialog",1,15));		
		female.setBounds(330,100,50,40);
		female.setFont(new java.awt.Font("Dialog",1,15));
		
		//���ó�������,����CreateCommonUser�ķ���
		birthYear =  reusing.Year();
		birthMonth = reusing.Month();
		birthTime = reusing.Times();
		birthYear.setBounds(285,145,75,25);
		birthMonth.setBounds(360,145,60,25);
		birthTime.setBounds(420,145,60,25);
		
		//������ְ����
		entryYear = new JComboBox();
	    entryYear.addItem("2017��");
		entryMonth = reusing.Month();
	    entryTime = reusing.Times();
		entryYear.setBounds(285,185,75,25);
		entryMonth.setBounds(360,185,60,25);
		entryTime.setBounds(420,185,60,25);
		
		//����������ò�����б�
		shenfen = new JComboBox();
		shenfen.addItem("Ⱥ��");
	    shenfen.addItem("������Ա");
		shenfen.addItem("��Ա");
		shenfen.setBounds(285,425,95,25);
				
		//����ѧ�������б�
		education = new JComboBox();
		education.addItem("Сѧ");
		education.addItem("����");
		education.addItem("����");
		education.addItem("��ѧר��");
		education.addItem("��ѧ����");
		education.addItem("�о���");		
		education.setBounds(285,385,95,25);
		
		//��panel2��������
		//���JLabel
		panel2.add(a1);
		panel2.add(a2);
		panel2.add(a3);
		panel2.add(a4);
		panel2.add(a5);
		panel2.add(a6);
		panel2.add(a7);
		panel2.add(a8);
		panel2.add(a9);
		panel2.add(a10);
		panel2.add(a11);
		panel2.add(a12);
		//���JTextField
		panel2.add(b1);
		panel2.add(b2);
		panel2.add(b3);
		panel2.add(b4);
		panel2.add(b5);
		//��Ӱ�ť
		panel2.add(c1);
		//��ӵ�ѡ��ť
		panel2.add(male);
		panel2.add(female);
		//��ӳ�������
		panel2.add(birthYear);
		panel2.add(birthMonth);
		panel2.add(birthTime);
		//�����ְ����
		panel2.add(entryYear);
		panel2.add(entryMonth);
		panel2.add(entryTime);
		//���ѧ��
		panel2.add(education);
		//���������ò
		panel2.add(shenfen);
		return panel2;
	}

}
