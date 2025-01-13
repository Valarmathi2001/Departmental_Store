package com.hcl.pojo;

public class user {
	
	String username="";
	String email="";
	String password="";
	int supercoins;
	@Override
	public String toString() {
		return "user [username=" + username + ", email=" + email + ", password=" + password + ", supercoins="
				+ supercoins + "]";
	}
	public int getSupercoins() {
		return supercoins;
	}
	public void setSupercoins(int supercoins) {
		this.supercoins = supercoins;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    public user(String username,String email ,String password,int supercoins){
    	super();
    	this.username=username;
    	this.email=email;
    	this.password=password;
    	this.supercoins=supercoins;
    }
	public user() {
		// TODO Auto-generated constructor stub
	}
	

}
