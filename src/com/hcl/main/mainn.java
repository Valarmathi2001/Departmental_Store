package com.hcl.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.hcl.implementation.storeInformation;

public class mainn {
	static String username ="root";
	static String password="root";
	static String url = "jdbc:mysql://localhost:3306/onlineStore?useSSL=false"; 


	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		int a2=0,a3=0,c=0;
		
		storeInformation obj =new storeInformation();
		
		System.out.println();
		
		System.out.println("**************************************************************");
		System.out.println("*********************PRINCY SUPER MARKET**********************");
		System.out.println("**************************************************************");
		
		
		try {
		do {
		System.out.println();
		System.out.println("For Register......press.....0");
		System.out.println("For Admin login...press ....1");
		System.out.println("For User login....press.....2");
		System.out.println("For logout........press.....3");
        int a1= sc.nextInt();
                switch(a1) {
        		case 0:
        			
        		    obj.register();
        			
        			break;
        		case 1:
        			do {
		        			try 
		        			{
			        			Class.forName("com.mysql.cj.jdbc.Driver");
			    				System.out.println();
			    				System.out.println("********ADMIN LOGIN PAGE********");
			    				System.out.println("Enter your Username here:");
			    				String aname =sc.next();
			    				
			    				System.out.println("Enter the Password :");
			    				String apassword =sc.next();
			    				
			    				String query = "select * from admintable where aname ='"+ aname +"'and apassword ='"+apassword+"' ";
			    				Connection conn = DriverManager.getConnection(url, username, password);
			    		        Statement st = conn.createStatement();
			    		        ResultSet rs = st.executeQuery(query);
			    				
			    				if(rs.next()) {
			    					System.out.println();
			    			    	System.out.println("You loggedin successfully...!");
			    			    	obj.adminMenu();
			    			    	
			    			    	a3=5;
			    			    }
			    			    else {
			    			    	a3++;
			    			    	System.out.println();
			    			    	System.out.println("Sorry! your Username or Password is incorrect...!");
			    			    }
			    			    st.close();
			    			    rs.close();
			    			    conn.close();
		        			}
		        			catch (ClassNotFoundException | SQLException ex) {
		        			ex.printStackTrace();
		    			}
        			}while(a3<4);
        			break;
        			
        		case 2:
        			do {
	        			try 
	        			{
	        				Class.forName("com.mysql.cj.jdbc.Driver");
	        				System.out.println();
	        				System.out.println("********LOGIN PAGE********");
	        				System.out.println("Enter your Username here:");
	        				String uuname =sc.next();
	        				
	        				System.out.println("Enter the Password :");
	        				String uupassword =sc.next();
	        				
	        				String query = "select * from usertable where uname ='"+ uuname +"'and upassword ='"+uupassword+"' ";
	        				Connection conn = DriverManager.getConnection(url, username, password);
	        		        //PreparedStatement ps = conn.prepareStatement("select uname,upassword from usertable");
	        				Statement st = conn.createStatement();
	        		        ResultSet rs = st.executeQuery(query);
	        				
	        				if(rs.next()) {
	        					a2=5;
	        					System.out.println();
	        			    	System.out.println("You loggedin successfully...!");
	        			    	obj.usermenu(uuname);
	        			    	
	        			    }
	        			    else {
	        			    	a2++;
	        			    	System.out.println();
	        			    	System.out.println("Sorry! your Username or Password is incorrect...!");
	        			    }
	        			    st.close();
	        			    rs.close();
	        			    conn.close();
	        			}
	        			catch (ClassNotFoundException | SQLException ex) {
        		        ex.printStackTrace();
	        			}
        			}while(a2<4);
        			
        			break;
        		
        		case 3:
        			c=1;
        			System.out.println("you are logged out");
        			break;
        		default:
        			throw new Exception("You need to choose a number from 0 to 3.....");
        		
        		}
        		
        		}while(c==0);
		}
        catch(Exception e) {
	    	System.out.println(e.getMessage());
        }
	}
}
