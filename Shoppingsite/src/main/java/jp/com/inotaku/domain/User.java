package jp.com.inotaku.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import jp.com.inotaku.validation.Login;
import jp.com.inotaku.validation.LoginForm;



@Entity
@Table(name = "user")
@Login(groups = LoginForm.class)
public class User implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(){}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	
}
