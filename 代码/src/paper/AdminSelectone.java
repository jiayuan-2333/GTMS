package 教务管理系统;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

public class AdminSelectone extends JFrame{
	private static final long serialVersionUID = 1L;

	public AdminSelectone () {
		 setTitle("查找某个学生信息");
		 setLayout(null);
	     setBounds(300, 200, 350, 200);
	     Container cp = getContentPane();
	     
	     JLabel jl = new JLabel("查找学生的学号：");
	     jl.setBounds(30, 20, 140, 30);
	     cp.add(jl);
	     
	     JTextField jt = new JTextField();
	     jt.setBounds(150,20,140,25);
	     cp.add(jt);
	     
	     
	     JButton jb = new JButton("确认查找");
	     jb.setBounds(50, 80, 120, 30);
	     cp.add(jb);

	     
	     jb.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	Connection con = jdbc.getConnection("root","520");	
					try {
						String id = jt.getText();
						if(jdbc.checkid(id) == false) {
							 JOptionPane.showMessageDialog(null, "查无此人");
						}else {
		            		setVisible(false);
		            		new AdminShowone(id);
						}
					}catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				jdbc.releaseConnectin(con);
	            }
	        });
	     
		JButton jb2=new JButton("返回菜单");
		jb2.setBounds(170, 80, 120, 30);
		cp.add(jb2);
		
		
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new AdminJFrame();
			}
		});
		
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	     setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}

}