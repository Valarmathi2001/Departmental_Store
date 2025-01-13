package com.hcl.interfacee;

import com.hcl.pojo.product;
import com.hcl.pojo.user;

public interface IstoreInformation {
	
	public user register();
	public void usermenu(String uuname) ;
	public void adminMenu() ;
	public product searchById();
	public product getAllProd();
	public product searchByName(String str1); 
	public product getProdIncatWise(String tt);
	public void totalSpentAmnt();
	public void profitAmnt();
	public product priceToLow();
	public void choosing(String name); 
	public void billtable();
	//public void finalBill(Integer key,Integer value);

}
