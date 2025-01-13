package com.hcl.implementation;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.hcl.interfacee.IstoreInformation;

import com.hcl.pojo.product;
import com.hcl.pojo.user;

public class storeInformation {
	
	
	Scanner sc = new Scanner(System.in);
	double sum3=0;
	
	static String username ="root";
	static String password="root";
	static String url = "jdbc:mysql://localhost:3306/onlineStore?useSSL=false"; 

	public user register() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO usertable VALUES (?,?,?,?)");
		
			System.out.println("Enter your EmailID here:");
			ps.setString(2,sc.next());
			
			System.out.println("Create Username:");
			ps.setString(1,sc.next());
			
			System.out.println("Set your Password :");
			System.out.println("(Your password must have atleast one Capital letter,one small letter,one Special character, one number.And");
		    System.out.println("it should be 8 characters!)");
		    ps.setString(3,sc.next());
		    
		    ps.setInt(4,100);
		    
		    int i =  ps.executeUpdate();
		    if(i > 0) {
		    	System.out.println("You registered successfully...!");		      	     
		    }
		    else
		    	System.out.println("Regist Failed........!");
		    ps.close();
		    conn.close();
		}
		catch (ClassNotFoundException | SQLException ex) {
	        ex.printStackTrace();
	    }
		return null;
	}
	
	public void usermenu(String uuname) 
	{
		System.out.println();
		System.out.println("********************************************************************");
		System.out.println("************************PRINCY SUPERMARKET**************************");
		System.out.println("********************************************************************");
		System.out.println("____________________________________________________________________"); 
		System.out.println("                                                                    "); 
		System.out.println("#       #  # # # #  #        # # # #  # # # #  #       #  # # # #   ");
		System.out.println("#       #  #        #        #        #     #  # #   # #  #         ");
        System.out.println("#   #   #  # # #    #        #        #     #  #   #   #  # # #     ");
        System.out.println("# #   # #  #        #        #        #     #  #       #  #         ");     
        System.out.println("#       #  # # # #  # # # #  # # # #  # # # #  #       #  # # # #   ");
        System.out.println("      PRINCY supermarket                   PRINCY supermarket       "); 
        System.out.println("___________________________HAPPY CUSTOMER___________________________"); 
        System.out.println(); 
        System.out.println("*****************************(DASHBOARD)****************************");
        System.out.println();
        
        int af=0;
		do
		{
			System.out.println();
			System.out.println();
			System.out.println("--------------USER MENU---------------");
			System.out.println("Exit from the Application------------0");
			System.out.println("List of the products-----------------1");
			System.out.println("Search your product using productID--2");
			System.out.println("Changing password--------------------3");
			System.out.println("----------------FILTER----------------");
			System.out.println("Price Low to high--------------------4");
			System.out.println("Select Catogery to view products-----5");
			System.out.println("Search your product using name-------6");
			
			
			
			System.out.println();
			System.out.println("Choose the option:");
			int ad = sc.nextInt();
			try {
			switch(ad)
			{
			case 0:
				af=1;
				choosing(uuname); 
				System.out.println("              ThankYou.....Visit Again");
				break;
			case 1:
				System.out.println("List of the products");
				getAllProd();
				break;
			case 2:
				System.out.println("Search your product using productID");
			    searchById();
				break;
			case 3:
				System.out.println("Changing password");
				changepassword();
				break;
			case 4:
				System.out.println("Price Low to high");
				priceToLow();
				break;
			case 5:
				System.out.println("Enter Catogery to view products");
				String str4=sc.next();
				getProdIncatWise(str4);
				break;
			case 6:
				System.out.println("Search your product using product name");
				System.out.println("Type your product name here :");
				String str1 =sc.next();
				searchByName(str1);
				break;
			
				
			default:
				throw new Exception();
				
			}
			}
			catch(Exception e) {
				System.out.println("PLEASE CHOOSE THE NUMBER BETWEEN 0-6");
			}
			
			
		}while(af==0);
		
	}
        
	public void adminMenu() 
	{
		
		int o=1;
		
		do
		{
			System.out.println();
			System.out.println();
		    System.out.println("************************MENU OPTIONS*************************");
			System.out.println("Exit from this menu-----------------------------------------0");
			System.out.println("List of the products in the store---------------------------1");
			System.out.println("search the products using productid-------------------------2");
			System.out.println("List of products in category wise---------------------------3");
			System.out.println("Enter productname to view details of the product------------4");
			System.out.println("To check the total amount spend on all products-------------5");
			System.out.println("Profit amount on catogory wise------------------------------6");
			System.out.println("To change password------------------------------------------7");
			System.out.println("Log out from app--------------------------------------------8");
			System.out.println();
			try 
			{
				System.out.println("Enter your choice:");
				int choice = sc.nextInt();// need to choose for the options
				
				switch(choice)
				{
					case 0:
						System.out.println("Exited");
						o=0;
						break;
					case 1:
						System.out.println("List of the products");
						getAllProd();
						break;
					case 2:
						System.out.println("Search your product using productID");
					    searchById();
						break;
					case 3:
						System.out.println("products in catogery wise");
						String str2 =sc.next();
						getProdIncatWise(str2);
						break;
					case 4:
						System.out.println("Search your product using name");
						String stry =sc.next();
						searchByName(stry);
						break;
					case 5:
						System.out.println("The total amount spend on all products");
						totalSpentAmnt();
						break;
					case 6:
						System.out.println("Profit in catogerywise");
						System.out.println();
						profitAmnt();
						break;
					case 7:
						System.out.println("Changing password");
						changepassword();
						break;
					case 8:
						o=0;
						System.out.println("You are logged out!");
						break;
					default:
						throw new Exception();
						
				}
			}
			catch(Exception e) 
			{//user didn't choose correct option exception handle by this block
				System.out.println("PLEASE CHOOSE THE NUMBER BETWEEN 0-9");
			}
		}while(o==1);
	}

	public product searchById() {
		
		try
		{
			System.out.println("Type your productID:");
			int pID = sc.nextInt();
			String query = "select * from product where pID="+pID;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			try {
			if(rs.next()) {
			        pID = rs.getInt(1);
					String pname = rs.getString(2);
					int price = rs.getInt(3);
					int availbalequan=rs.getInt(4);
					String category = rs.getString(5);
						
					System.out.println("                 ");
					System.out.println("Product ID        : "+pID);
					System.out.println("Product Name      : "+pname);
					System.out.println("Price             : "+price);
					System.out.println("Available Quantity: "+ availbalequan);
					System.out.println("Category          : "+category);
			}else
				throw new Exception();
			}catch(Exception e) {
				System.out.println("There is no product matching this productID");
			}
			rs.close();
			st.close();
			conn.close();
		}
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

    public product searchByName(String str1) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement("select * from product where pname=?");
			ps.setString(1, str1);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{	
				int ppID = rs.getInt(1);
				String ppname = rs.getString(2);
				int pprice = rs.getInt(3);
				int aavailbalequan=rs.getInt(4);
				String ccategory = rs.getString(5);
				int buyprice =rs.getInt(6);
						
				System.out.println("                 ");
				System.out.println("Product Name      : "+ppname);
				System.out.println("Product ID        : "+ppID);
				System.out.println("Price             : "+pprice);
				System.out.println("Available Quantity: "+aavailbalequan);
				System.out.println("Category          : "+ccategory);
			}
			rs.close();
			ps.close();
			conn.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

    public product getAllProd() {
		try
		{
			String query = "select * from product";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{	
				int pID = rs.getInt(1);
				String pname = rs.getString(2);
				int price = rs.getInt(3);
				int availbalequan=rs.getInt(4);
				String category = rs.getString(5);
						
				System.out.println("                 ");
				System.out.println("Product Name      : "+pname);
				System.out.println("Product ID        : "+pID);
				System.out.println("Price             : "+price);
				System.out.println("Available Quantity: "+availbalequan);
				System.out.println("Category          : "+category);
			}
			rs.close();
			st.close();
			conn.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
		
    public product getProdIncatWise(String tt) {
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			//Statement st = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement("select * from product where pcategory=?");
			ps.setString(1, tt);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{	
				int pID = rs.getInt(1);
				String pname = rs.getString(2);
				int price = rs.getInt(3);
				int availbalequan=rs.getInt(4);
				String category = rs.getString(5);
				int buyprice = rs.getInt(6);
						
				System.out.println("                 ");
				System.out.println("Product Name      : "+pname);
				System.out.println("Product ID        : "+pID);
				System.out.println("Price             : "+price);
				System.out.println("Available Quantity: "+availbalequan);
				System.out.println("Category          : "+category);
			}
			rs.close();
			ps.close();
			conn.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
    
    public void totalSpentAmnt() {
    	try
		{
			String query = "select * from product";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			double sum1=0;
			while(rs.next())
			{	
				String pname = rs.getString(2);
				int price = rs.getInt(6);
				int availbalequan=rs.getInt(4);
				double spent =price*availbalequan;
				sum1 +=spent;
				
				System.out.println("                 ");
				System.out.println("The total amount spent on "+pname +"is "+spent);
			}
			System.out.println();
			System.out.println("THE TOTAL AMOUNT SPENT ALL PRODUCTS IS "+sum1);
			rs.close();
			st.close();
			conn.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
    }
			
    public void profitAmnt() {
    	try
		{
			String aaaa=sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement("select * from product where pcategory=?");
			ps.setString(1, aaaa);
			ResultSet rs = ps.executeQuery();
			
			double sum1=0;
			while(rs.next())
			{	
				String pname = rs.getString(2);
				int profit = rs.getInt(6);
				int availbalequan=rs.getInt(4);
				String cattt=rs.getString(5);
				double spent =profit*availbalequan;
				sum1 +=spent;
				
				System.out.println("The total amount spent on "+pname +" is "+spent);
				System.out.println();
			}
			System.out.println("THE TOTAL PROFIT IN "+ aaaa +" IS "+sum1);
			rs.close();
			ps.close();
			conn.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
    }
    
    public product priceToLow() {
		try
		{
			String query = "select * from product order by psellingprice asc";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{	
				int pID = rs.getInt(1);
				String pname = rs.getString(2);
				int price = rs.getInt(3);
				int availbalequan=rs.getInt(4);
				String category = rs.getString(5);
						
				System.out.println("                 ");
				System.out.println("Product Name      : "+pname);
				System.out.println("Product ID        : "+pID);
				System.out.println("Price             : "+price);
				System.out.println("Available Quantity: "+availbalequan);
				System.out.println("Category          : "+category);
			}
			rs.close();
			st.close();
			conn.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

    public void choosing(String name) {
    	
    	
    		
    		  
    		//List<String> al = new ArrayList<String>();
    		Map<Integer, Integer> ordersList = new LinkedHashMap<>();
    		
    		while(true) {
    		System.out.println();
    		System.out.println("select the productId ");
    		int tttt=sc.nextInt();
    		System.out.println("Quantity ");
    		int quantity=sc.nextInt();
    		System.out.println("Enter 1 to contiue! \nEnter 0 to exit!");
			int a6= sc.nextInt();
			ordersList.put(tttt,quantity);
			if(a6==0)
				
			
				break;
    		}
    		System.out.println("If you want to use your Supercoins CLICK.....1  if no CLICK....0 ");
		    int a7=sc.nextInt();
			System.out.println("Enter your address");
		    String tt= sc.next();
		    String ttt= sc.next();
		    
		    System.out.println("Enter your phone number");
		    long uu= sc.nextLong();
		    
			System.out.println();
			System.out.println();
			System.out.println("             *************PRINCY SUPERMARKET*************               ");
			System.out.println();
			System.out.println(" Name          : "+name);
			System.out.println();
			System.out.println(" Address       :"+tt);
			System.out.println("                "+ttt);
			System.out.println();
			System.out.println(" Phone number  :"+uu);
			System.out.println();

    		billtable();
    		
    		try
    		{
	    		for(Integer key : ordersList.keySet())
	    		{
	    			int value = ordersList.get(key);
	    			
	    			
	    			Class.forName("com.mysql.cj.jdbc.Driver");
	    			Connection conn = DriverManager.getConnection(url, username, password);
	    			PreparedStatement ps = conn.prepareStatement("select * from product where pID=?");
	    			
	    			ps.setInt(1,key);
	    			ResultSet rs = ps.executeQuery();
	    			
	    			while(rs.next())
	    			{	
	    				int ppID = rs.getInt(1);
	    				String ppname = rs.getString(2);
	    				int pprice = rs.getInt(3);
	    				
	    				String ccategory = rs.getString(5);
	    				int buyprice =rs.getInt(6);
	    				double totalamnt =pprice*value;
	    				
	    				System.out.println(ppID+"         "+ppname+"         "+value+"       "+pprice+"        "+totalamnt);
	    				sum3+=totalamnt;
	    				
	    			}
	    			
	    			rs.close();
	    			ps.close();
	    			conn.close();
	        		
	    		}
	    		System.out.format("---------------------------------------------------------");  
	    		System.out.println("                                   Total Amount in (RS) :"+sum3+"rs");
	    		double eeee=sum3*0.18;
	    		double eeeee=sum3/10;
	    		
	    		System.out.println("                                         GST(18%):"+eeee+"rs");
	    		
	    		System.out.println();
	    		System.out.println("                           Special Discount(10%) : "+eeeee+"rs");
	    		double billmoney = sum3+eeee-eeeee;
	    		
	    		System.out.println();
	    		if(a7==1) {
	    			try
	    			{
	    				Class.forName("com.mysql.cj.jdbc.Driver");
	    				Connection conn = DriverManager.getConnection(url, username, password);
	    				PreparedStatement ps = conn.prepareStatement("select * from usertable where uname=?");
	    				ps.setString(1, name);
	    				ResultSet rs = ps.executeQuery();
	    				if(rs.next())
	    				{	
	    					String qq =rs.getString(1);
	    					int qqq = rs.getInt(4);
	    					int qqqq = qqq/20;
	    					System.out.println("                      Supercoin redeem reduction : "+qqqq+"rs");
	    					System.out.println();
	    					billmoney = billmoney -qqqq;
	    					
	    				}
	    				rs.close();
	    				ps.close();
	    				conn.close();
	    				
	    			}
	    			catch(ClassNotFoundException | SQLException e) {
	    				
	    				e.printStackTrace();
	    			}
	    			
	    		
	    		}
	    		System.out.println();
	    		System.out.println("                          THE ACTUAL BILL AMOUNT :"+billmoney+"rs"); 
	    		System.out.println();
	    		System.out.println();
	    		System.out.println();
    		}
    		catch(ClassNotFoundException | SQLException e) {
    			
    				e.printStackTrace();
    		}
    		
      
    	
    }
    		
	public void billtable()   
    {  
        System.out.format("---------------------------------------------------------");  
        System.out.print("\nProduct ID  Name       Quantity  Rate      Total Price\n");  
        System.out.format("---------------------------------------------------------\n");  
    }

	public void changepassword() {//for changing password user and admin
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your new password : ");
		String p= sc.next();
		System.out.println("Confirm your new password : ");
		String d= sc.next();
		if(p.equals(d)) {
			System.out.println("Password changed succesfully!");
		System.out.println();}
	    else {
			System.out.println("New Password and confirm Password mismatch!");
		    System.out.println();
	    }
	}
    
   

	
	
	

	
	
	
	

}
