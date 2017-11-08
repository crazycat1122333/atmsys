package superuser;

import javax.swing.*;

import manager.CreateCommonUser;

public class CreateManager {
	JPanel panel2;
	
	//JLabel;姓名，性别，出生日期，入职日期，住址，手机号码，邮箱，身份证号，学历，政治面貌
	JLabel a1 = new JLabel("请填写新管理员表");
	JLabel a2 = new JLabel("     姓名 ：");
	JLabel a3 = new JLabel("     性别  ：");
	JLabel a4 = new JLabel("出生日期 ：");
	JLabel a5 = new JLabel("入职日期 ：");
	JLabel a6 = new JLabel("     住址 ：");
	JLabel a7 = new JLabel("手机号码 ：");
	JLabel a8 = new JLabel("     邮箱 ：");
	JLabel a9 = new JLabel("身份证号 ：");
	JLabel a10 = new JLabel("     学历 ：");
	JLabel a11 = new JLabel("政治面貌 ：");
	JLabel a12 = new JLabel("管理员编号 ：");
	
	//JTextField 5
	JTextField b1 = new JTextField();
	JTextField b2 = new JTextField();
	JTextField b3 = new JTextField();
	JTextField b4 = new JTextField();
	JTextField b5 = new JTextField();
	
	//按钮
	JButton c1 = new JButton("确定");
	
	//性别选择框
	JRadioButton male = new JRadioButton("男",true);
	JRadioButton female = new JRadioButton("女");
	ButtonGroup sex = new ButtonGroup();
	//政治面貌选择框
	JComboBox shenfen ;
	//出生日期选择框
	JComboBox birthYear;
	JComboBox birthMonth;
	JComboBox birthTime;
	//入职日期
	JComboBox entryYear;
	JComboBox entryMonth;
	JComboBox entryTime;
	//学历选择框
	JComboBox education;
	
	
	public JPanel createManager()
	{
		panel2 = new JPanel();
		panel2.setLayout(null);
		//创建CreateCommonUser类
		CreateCommonUser reusing = new CreateCommonUser();
		
		//设置JLabel
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
		
		//设置JTextField
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
		
		//设置按钮
		c1.setBounds(670,470,130,50);
		c1.setFont(new java.awt.Font("Dialog",1,22));
		
		//往性别选择框组里添加单选按钮
		sex.add(male);
		sex.add(female);
		
		//设置JRadioButton
		male.setBounds(280,100,50,40);
		male.setFont(new java.awt.Font("Dialog",1,15));		
		female.setBounds(330,100,50,40);
		female.setFont(new java.awt.Font("Dialog",1,15));
		
		//设置出生日期,重用CreateCommonUser的方法
		birthYear =  reusing.Year();
		birthMonth = reusing.Month();
		birthTime = reusing.Times();
		birthYear.setBounds(285,145,75,25);
		birthMonth.setBounds(360,145,60,25);
		birthTime.setBounds(420,145,60,25);
		
		//设置入职日期
		entryYear = new JComboBox();
	    entryYear.addItem("2017年");
		entryMonth = reusing.Month();
	    entryTime = reusing.Times();
		entryYear.setBounds(285,185,75,25);
		entryMonth.setBounds(360,185,60,25);
		entryTime.setBounds(420,185,60,25);
		
		//设置政治面貌下拉列表
		shenfen = new JComboBox();
		shenfen.addItem("群众");
	    shenfen.addItem("共青团员");
		shenfen.addItem("党员");
		shenfen.setBounds(285,425,95,25);
				
		//设置学历下拉列表
		education = new JComboBox();
		education.addItem("小学");
		education.addItem("初中");
		education.addItem("高中");
		education.addItem("大学专科");
		education.addItem("大学本科");
		education.addItem("研究生");		
		education.setBounds(285,385,95,25);
		
		//往panel2里添加组件
		//添加JLabel
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
		//添加JTextField
		panel2.add(b1);
		panel2.add(b2);
		panel2.add(b3);
		panel2.add(b4);
		panel2.add(b5);
		//添加按钮
		panel2.add(c1);
		//添加单选按钮
		panel2.add(male);
		panel2.add(female);
		//添加出生日期
		panel2.add(birthYear);
		panel2.add(birthMonth);
		panel2.add(birthTime);
		//添加入职日期
		panel2.add(entryYear);
		panel2.add(entryMonth);
		panel2.add(entryTime);
		//添加学历
		panel2.add(education);
		//添加政治面貌
		panel2.add(shenfen);
		return panel2;
	}

}
