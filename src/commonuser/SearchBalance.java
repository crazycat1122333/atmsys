package commonuser;

import java.awt.Color;

import javax.swing.JLabel;

import login.AllInterface;

public class SearchBalance extends AllInterface{
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel jl4;
	private JLabel jl5;

	public void setJframe() {
		// TODO 自动生成的方法存根
		super.setJframe();
   
    	super.removedetermentButton();
    	jl1 =new JLabel("   查询结果      ");
    	jl2 =new JLabel(" 您的账户余额为 ：");
    	jl4 = new JLabel(" 您的可用余额为 ：");
    	
    	
    	jl1.setBounds(320,160,300,100);
    	jl1.setFont(new java.awt.Font("微软雅黑",1,35));
    	
    	jl2.setBounds(200,280,280,50);
    	jl2.setFont(new java.awt.Font("Dialog",1,28));
    	
    	getJl3().setBounds(480,287,250,40);
    	getJl3().setFont(new java.awt.Font("Dialog",1,24));
    	
    	jl4.setBounds(200,400,280,50);
    	jl4.setFont(new java.awt.Font("Dialog1",1,28));
    	getJl5().setBounds(480,407,250,40);
    	getJl5().setFont(new java.awt.Font("Dialog",1,24));
    	p.add(jl1);
    	p.add(jl2);
    	p.add(getJl3());
    	p.add(jl4);
    	p.add(jl5);
    	
		
	}

	public JLabel getJl3() {
		return jl3;
	}

	public void setJl3(JLabel jl3) {
		this.jl3 = jl3;
	}
	public JLabel getJl5() {
		return jl5;
	}

	public void setJl5(JLabel jl5) {
		this.jl5 = jl5;
	}

}
