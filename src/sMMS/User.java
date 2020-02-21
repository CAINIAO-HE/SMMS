package sMMS;
import java.sql.*;
public class User {
private int id;
private String username;
private String keyword;
private String name;
private String email;
private Date birthday;
public User() {
	super();
}
public User(int id,String username,String keyword,String name,String Email,Date Birthday) {
	super();
	this.id=id;
	this.username=username;
	this.keyword=keyword;
	this.name=name;
	this.email=Email;
	this.birthday=Birthday;
}
public int getId() {
	return id;
}
public String getusername() {
	return username;
}
public String getKeyword() {
	return keyword;
}
public String getName() {
	return name;
}
public String getEmail() {
	return email;
}
public Date getBirthday() {
	return birthday;
}
public void setid(int id) {
	this.id=id;
}
public void setusername(String username) {
	this.username=username;
}
public void setkeyword(String keyword) {
	this.keyword=keyword;
}
public void setemail(String email) {
	this.email=email;
}
public void setbirthday(Date birthday) {
	this.birthday=birthday;
}

}
