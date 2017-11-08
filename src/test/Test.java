package test;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Test extends JFrame {
	private JList textList = null;
	private JLabel message = null;
	private JButton delButton = null;

	public Test() {
		super("¼àÌýÉ¾³ý¾ÙÀý");
		JPanel pane = new JPanel();
		delButton = new JButton("É¾³ýËùÓÐ¼àÌý");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delListener();
			}
		});
		String [] model = {"aaa", "bbb", "ccc"};
		textList = new JList(model);
		message = new JLabel();
		message.setPreferredSize(new Dimension(280, 20));
		textList.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				message.setText("Ê§È¥");
			}
			public void focusGained(FocusEvent e) {
				message.setText("»ñµÃ");
			}
		});
		textList.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				message.setText(String.valueOf(e.getKeyChar()));
			}
		});
		getContentPane().add(pane);
		pane.add(message);
		pane.add(textList);
		pane.add(delButton);
		pane.add(new JTextField(10));
		setSize(300, 200);
		setVisible(true);
	}

	private void delListener(){
		KeyListener [] keys = textList.getKeyListeners();
		for (KeyListener k : keys) {
			textList.removeKeyListener(k);
		}
		FocusListener [] focus = textList.getFocusListeners();
		for (FocusListener f : focus) {
			textList.removeFocusListener(f);
		}
	}
	
	public static void main(String[] args) {
		new Test();
	}

}