package sMMS;
import java.util.Scanner;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
public class DL {
	private  int XuanZhe;
	private static String username;
	private static String keyword;
	Scanner scan=new Scanner(System.in);
	//public static void DLcx(Connection conn);
	public static void createtable(Connection conn) {
		try
		{
			Statement stat = conn.createStatement();
			String sql="create table usermanage( username int(100), keyword int(100))";
			stat.executeUpdate(sql);
			stat.cancel();
		}catch(SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void insertdata(Connection conn)  //插入数据函数
	{ 
		
		try
		{	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Statement stat=conn.createStatement();
		    String psql;
		    psql=br.readLine();
		    stat.executeUpdate(psql);
			/*PreparedStatement psql = conn.prepareStatement("insert into usermanage(username)"+"values(?,?)");  //注意中英文状态的符号，用preparedStatement预处理来执行sql语句
			
			System.out.println("输入URL:");
			String str=br.readLine();
			URL getURL=new URL(str);
			    System.out.println("协议："+getURL.getProtocol());
		        System.out.println("主机："+getURL.getHost());
		        System.out.println("端口："+getURL.getPort());
		        System.out.println("文件路径："+getURL.getPath());
		        System.out.println("文件名："+getURL.getFile());
		        System.out.println("URL名"+str);
		        filepath=getURL.getPath();
		        Filename=getURL.getFile() ;
		        URLname=str;
		       psql.setString(1,Filename);
		        psql.setString(2,filepath);
			   psql.setString(3,URLname);
			psql.executeUpdate();*/
		}catch(SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		 }
	public static void DLcx(Connection conn) {
		try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Statement stat=conn.createStatement();
		System.out.println("用户名:");
		username=br.readLine();
		System.out.println("密码:");
		keyword=br.readLine();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		System.out.println("*********<欢迎使用学生信息管理系统>******************            ");
		System.out.println("1.登录  2.注册");
		
		while(true) {
		XuanZhe=scan.nextInt();
		//switch(XuanZhe) {
		//case 1: DLcx();
		        break;
		//case 2:
		}
		}
	
	public void main(String args[]) {
		 Connection conn;    //与特定数据库的连接（会话）的变量
			String driver = "com.mysql.cj.jdbc.Driver";  //驱动程序名？？？
			String url  = "jdbc:mysql://localhost:3306/SMMS?useSSL=false&serverTimezone=UTC"; //指向要访问的数据库！注意后面跟的是数据库名称
			String user = "root";   //navicat for sql配置的用户名
			String password = "250413";  //navicat for sql配置的密码
			try{
				Class.forName(driver);  //用class加载动态链接库——驱动程序？？？
				conn = DriverManager.getConnection(url,user,password);  //利用信息链接数据库
				if(!conn.isClosed())
					System.out.println("Succeeded connecting to the Database!");	
				//insertdata(conn);  //插入数据
				//fetchdata(conn);   //读取数据
				//updatedata(conn);  //修改数据
				//deletedata(conn);  //删除数据			
				conn.close();
			}catch(ClassNotFoundException e){  //catch不同的错误信息，并报错
				System.out.println("Sorry,can`t find the Driver!");
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		
	}

}
