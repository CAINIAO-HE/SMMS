/*���ݿ����ز���
 * �����ݿ����������ظ����ճ���
 *  
 *  */
package sMMS;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class DBOperation {
	private MyDBConnection myDB=null;
	private Connection conn=null;
	private Statement stmt=null;
	private int id;
	private int number1;
	private int number2;
	private String name;
	private String password;
	private String birthday;
	private String sex;
	public DBOperation(MyDBConnection myDB){
		conn=myDB.getMyConnection();
		stmt=myDB.getMyStatement();
		number1=0;
		number2=0;
	}
	public void insertData(String name,String password,int id,String birthday,String sex){
		try{
			String newType1=new String(name.getBytes(),"GBK");//�ֽ�ת��
			String newType2=new String(password.getBytes(),"GBK");
			String newType3=new String(birthday.getBytes(),"GBK");
			String newType4=new String(sex.getBytes());
			String sql="INSERT INTO tb_dl(id,name,password,birthday,sex)VALUES("+id+",'"+newType1+"','"+newType2+"','"+newType3+"','"+newType4+"')";
			stmt.executeUpdate(sql);//�������
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void deleteData(int id){
		String sql="DELETE FROM tb_dl WHERE id="+id+"";
		System.out.print(sql);
		try{
			stmt.executeUpdate(sql);
			//System.out.println("һ����¼��ɾ��");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void updateData(int mscores,int id,String name,String password,String birthday,String sex){//�޸�
		String sql="UPDATE tb_dl SET id="+id+",name='"+name+"',password='"+password+"',birthday='"+birthday+"',sex='"+sex+"'where id="+mscores+"&&name='"+name+"'&&password='"+password+"'&&bithday='"+birthday+"'&&sex='"+sex+"'";
		try{
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public boolean  selectPassword(String mpassword){
		String sql="SELECT id,name,password FROM tb_dl";
		try{
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			while(rs.next()){//ָ������ƶ�
				password=rs.getString("password");
				number2++;
				//System.out.print(rs.getString("password")+"  ");
				if(password.equals(mpassword)&&(number2==number1)){
					//System.out.print("number2:"+number2);
					return true;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean selectName(String mname){
		String sql="SELECT id,name,password FROM tb_dl";
		try{
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			while(rs.next()){//ָ������ƶ�
				name=rs.getString("name");
				number1++;
				if(name.equals(mname)){
					//System.out.print("number1:"+number1);
					return true;
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public int selectid(String name,String password){
		String sql="SELECT id,name,password FROM tb_dl where name='"+name+"'&&password='"+password+"'";
		try{
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			while(rs.next()){//ָ������ƶ�
				id=rs.getShort("id");
				return id;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	return 0;
	}
	public void selectAll(){
		int i=0;
		String sql="SELECT id,name,password FROM tb_dl";
		try{
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			while(rs.next()){//ָ������ƶ�
				name=rs.getString("name");
				password=rs.getString("password");
		id=rs.getShort("id");
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	public int getid(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	
	public void setNumber1(){
		number1=0;
	}
	public void setNumber2(){
		number2=0;
	}

}
