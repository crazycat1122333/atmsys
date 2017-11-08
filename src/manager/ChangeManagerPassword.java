package manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Dao.accountDao;

public class ChangeManagerPassword extends AllInterface{
	public void  setFrame()
	{   JPanel p=new JPanel();
		JLabel jl1=new JLabel("请输入密码：");
		JLabel jl2=new JLabel("再次确认密码：");
		JPasswordField jf1=new JPasswordField(6);
		JPasswordField jf2=new JPasswordField(6);
		JButton jb=new JButton("确定");
		jl2.setBounds(100,200,100,100);
		jf2.setBounds(100,300,100,100);
		jb.setBounds(100, 400, 100, 100);
		p.add(jl1);
		p.add(jf1);
		p.add(jl2);
		p.add(jf2);
		p.add(jb);
		this.add(p);
		this.setSize(300,300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);	
		this.setResizable(false);
	//当出现多个窗口，只关闭当前窗口的代码
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	Font font = new Font("微软雅黑",Font.BOLD,22);
	jb.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{   if(jf1.getText().equals(jf2.getText())){
    		accountDao ad= new accountDao();
    		ad.updatePassword(jf2.getText());}
    	else{
    		jf1.setText("");
    		jf2.setText("");
    		JOptionPane.showMessageDialog(null, "请输入正确的账号和密码！", "ERROR", JOptionPane.ERROR_MESSAGE);
    		
    	}
    	}
    	
    });
	
	
	}
}
