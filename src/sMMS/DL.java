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
	public static void insertdata(Connection conn)  //�������ݺ���
	{ 
		
		try
		{	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Statement stat=conn.createStatement();
		    String psql;
		    psql=br.readLine();
		    stat.executeUpdate(psql);
			/*PreparedStatement psql = conn.prepareStatement("insert into usermanage(username)"+"values(?,?)");  //ע����Ӣ��״̬�ķ��ţ���preparedStatementԤ������ִ��sql���
			
			System.out.println("����URL:");
			String str=br.readLine();
			URL getURL=new URL(str);
			    System.out.println("Э�飺"+getURL.getProtocol());
		        System.out.println("������"+getURL.getHost());
		        System.out.println("�˿ڣ�"+getURL.getPort());
		        System.out.println("�ļ�·����"+getURL.getPath());
		        System.out.println("�ļ�����"+getURL.getFile());
		        System.out.println("URL��"+str);
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
		System.out.println("�û���:");
		username=br.readLine();
		System.out.println("����:");
		keyword=br.readLine();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		System.out.println("*********<��ӭʹ��ѧ����Ϣ����ϵͳ>******************            ");
		System.out.println("1.��¼  2.ע��");
		
		while(true) {
		XuanZhe=scan.nextInt();
		//switch(XuanZhe) {
		//case 1: DLcx();
		        break;
		//case 2:
		}
		}
	
	public void main(String args[]) {
		 Connection conn;    //���ض����ݿ�����ӣ��Ự���ı���
			String driver = "com.mysql.cj.jdbc.Driver";  //����������������
			String url  = "jdbc:mysql://localhost:3306/SMMS?useSSL=false&serverTimezone=UTC"; //ָ��Ҫ���ʵ����ݿ⣡ע�������������ݿ�����
			String user = "root";   //navicat for sql���õ��û���
			String password = "250413";  //navicat for sql���õ�����
			try{
				Class.forName(driver);  //��class���ض�̬���ӿ⡪���������򣿣���
				conn = DriverManager.getConnection(url,user,password);  //������Ϣ�������ݿ�
				if(!conn.isClosed())
					System.out.println("Succeeded connecting to the Database!");	
				//insertdata(conn);  //��������
				//fetchdata(conn);   //��ȡ����
				//updatedata(conn);  //�޸�����
				//deletedata(conn);  //ɾ������			
				conn.close();
			}catch(ClassNotFoundException e){  //catch��ͬ�Ĵ�����Ϣ��������
				System.out.println("Sorry,can`t find the Driver!");
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		
	}

}
