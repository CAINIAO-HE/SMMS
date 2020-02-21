/*同一个包下不需要连接各个类*/
package sMMS;
import java.awt.Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
//界面相关元素定义（按钮，文本框）
public class Window implements MouseListener{
	public JFrame frame = new JFrame("欢迎使用学生信息管理系统");
	private JLabel label1=new JLabel("用户名:");
	private JTextField txt1=new JTextField();
	private JLabel label2=new JLabel("密   码:");
	private JTextField txt2=new JTextField();
	private JButton btn1=new JButton("登陆");
	private JButton btn2=new JButton("注册");
	private JButton btn3=new JButton("退出");
	private JButton btn4=new JButton("修改");
	private String text1;
	private String text2;
	private int distinguish;
	//数据库连接配置
	String DBDriver="com.mysql.cj.jdbc.Driver";
	String DBURL="jdbc:mysql://localhost:3306/KCSJ?useSSL=false&serverTimezone=UTC";
	String DBUser="root";
	String DBPass="250413";
	MyDBConnection myDB=new MyDBConnection(DBDriver,DBURL,DBUser,DBPass);
	public DBOperation myOpr=new DBOperation(myDB);
	public Window(){
	
	}
	//设置字体，颜色，框体大小
	public void show(){
		frame.setLayout(null);
		frame.setSize(470,300);
		frame.setLocation(400, 200);
		
		Font font=new Font("华文行楷",Font.BOLD,20);
		label1.setFont(font);
		label1.setForeground(Color.BLACK);
		label2.setFont(font);
		
		label2.setForeground(Color.BLACK);
		txt1.setOpaque(false);
		txt2.setOpaque(false);
		
		btn1.setContentAreaFilled(false);
		btn1.setFont(font);
	    btn1.setForeground(Color.BLACK);
	    btn1.setBorder(BorderFactory.createRaisedBevelBorder());
	    btn2.setContentAreaFilled(false);
		btn2.setFont(font);
		btn2.setBorder(BorderFactory.createRaisedBevelBorder());
	    btn2.setForeground(Color.BLACK);
	    btn3.setContentAreaFilled(false);
		btn3.setFont(font);
		btn3.setBorder(BorderFactory.createRaisedBevelBorder());
		btn3.setForeground(Color.BLACK);
		
	  //导入背景图片
		JPanel bj = new JPanel() {
			protected void paintComponent(Graphics g) {
				Image bg;
				try {
					bg = ImageIO.read(new File("src/sMMS/登录背景图片.PNG"));//可以直接将图片复制到类存在的路径下然后将调用路径补全
					g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
	//框体大小设置
	    label1.setBounds(100,50,100,100);
		txt1.setBounds(180,90, 150, 20);
		label2.setBounds(100,80,100,100);
		txt2.setBounds(180,120, 150, 20);
		btn1.setBounds(100,200,80,20);
		btn2.setBounds(190,200,80,20);
		btn3.setBounds(280,200,80,20);
		
		
		frame.setContentPane(bj);
		frame.setLayout(null);
		frame.add(label1);
		frame.add(txt1);
		frame.add(label2);
		frame.add(txt2);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		
		btn1.addMouseListener(this);
		btn2.addMouseListener(this);
		btn3.addMouseListener(this);
	
		frame.setVisible(true);	
	}
	//接收鼠标信息，来响应相关事件
	public void mouseClicked(MouseEvent arg0) {
	   text1=txt1.getText();
	   text2=txt2.getText();
	   if(distinguish==1){//登录
	   if(myOpr.selectName(text1)){//name能查询到
		   if(myOpr.selectPassword(text2)){//密码也能查到则执行
			   JOptionPane.showMessageDialog(null, "登陆成功","提示",2);
				txt1.setText("");
				txt2.setText("");
				//distinguish=4;
				frame.setVisible(false);
		   }else{
				JOptionPane.showMessageDialog(null, "密码错误","提示",2);
				txt2.setText("");
				myOpr.setNumber1();
				myOpr.setNumber2();
		   }
	   }else{
		   JOptionPane.showMessageDialog(null, "此用户不存在，请注册","提示",2);
			txt1.setText("");//清空错误信息
			txt2.setText("");//清空错误信息
	   }
	   }
	   if(distinguish==2){//注册
		   
		   String logi=(String) JOptionPane.showInputDialog(null,"请输入你的用户名ID：\n","注册",JOptionPane.PLAIN_MESSAGE,null,null,"在此输入"); 
		   String pas=(String) JOptionPane.showInputDialog(null,"请输入你的密码：\n","注册",JOptionPane.PLAIN_MESSAGE,null,null,"在此输入");
		   String bir=(String) JOptionPane.showInputDialog(null,"请输入你的生日：\n","注册",JOptionPane.PLAIN_MESSAGE,null,null,"在此输入");
		   String sex=(String) JOptionPane.showInputDialog(null,"请输入你的性别：\n","注册",JOptionPane.PLAIN_MESSAGE,null,null,"在此输入");
			myOpr.insertData(logi,pas,0,bir,sex);
			JOptionPane.showMessageDialog(null, "注册成功","提示",2);
	   }
	   if(distinguish==3){//退出
		   int n = JOptionPane.showConfirmDialog(null, "是否退出?", "感谢使用",JOptionPane.YES_NO_OPTION);
		   myDB.closeMyConnection();
			if(n==JOptionPane.YES_OPTION){
			System.exit(1);
			}
			 
			
	   }
	   
	}
//当鼠标进入组件时调用
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btn1) {
			distinguish=1;
			btn1.setForeground(Color.red);
			btn1.setBorder(BorderFactory.createLoweredBevelBorder());
			btn2.setForeground(Color.BLACK);
			btn2.setBorder(BorderFactory.createRaisedBevelBorder());
			btn3.setForeground(Color.BLACK);
			btn3.setBorder(BorderFactory.createRaisedBevelBorder());
			
		}
		if (arg0.getSource() == btn2) {
			distinguish=2;
			btn1.setForeground(Color.BLACK);
			btn1.setBorder(BorderFactory.createRaisedBevelBorder());
			btn2.setForeground(Color.red);
			btn2.setBorder(BorderFactory.createLoweredBevelBorder());
			btn3.setForeground(Color.BLACK);
			btn3.setBorder(BorderFactory.createRaisedBevelBorder());
			
		}
		if (arg0.getSource() == btn3) {
			distinguish=3;
			btn1.setForeground(Color.BLACK);
			btn1.setBorder(BorderFactory.createRaisedBevelBorder());
			btn2.setForeground(Color.BLACK);
			btn2.setBorder(BorderFactory.createRaisedBevelBorder());
			btn3.setForeground(Color.red);
			btn3.setBorder(BorderFactory.createLoweredBevelBorder());
			
			}
	

	}
	//当鼠标退出组件时调用
	public void mouseExited(MouseEvent arg0) {
		distinguish=0;
		label1.setForeground(Color.BLACK);
		label2.setForeground(Color.BLACK);
		txt1.setOpaque(false);
		txt2.setOpaque(false);
		btn1.setContentAreaFilled(false);
	    btn1.setForeground(Color.BLACK);
	    btn1.setBorder(BorderFactory.createRaisedBevelBorder());
	    btn2.setContentAreaFilled(false);
		btn2.setBorder(BorderFactory.createRaisedBevelBorder());
	    btn2.setForeground(Color.BLACK);
	    btn3.setContentAreaFilled(false);
		btn3.setBorder(BorderFactory.createRaisedBevelBorder());
	    btn3.setForeground(Color.BLACK);
	   
	}
	
	public void mousePressed(MouseEvent arg0) {
			
	}
	public void mouseReleased(MouseEvent arg0) {
		
		
	}
	public String getText1(){
		return text1;
	}
	public String getText2(){
		return text2;
	}
	public int getDistinguish(){
		return distinguish;
	}
public static void main(String args[]){
	Window window=new Window();
	window.show();
}
	
}


