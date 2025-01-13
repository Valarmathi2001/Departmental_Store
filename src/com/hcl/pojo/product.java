package com.hcl.pojo;

public class product {
	
	public int productid;
	String productName;
	int sellingPrice;
	int availableQuantity;
	//String catogery;
	double total;
	
    
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	

	/*public product(int productid,String productname,int sellingPrice,int availableQuantity,double tot) {
		super();
		this.productid=productid;
		this.productName=productname;
		this.sellingPrice=sellingPrice;
		this.availableQuantity=availableQuantity;
		//this.catogery=catogery;
		this.total=tot;
		*/
	
	@Override
	public String toString() {
		return "product [productid=" + productid + ", productName=" + productName + ", sellingPrice=" + sellingPrice
				+ ", availableQuantity=" + availableQuantity + ", total=" + total + "]";
	}
	public product(int ppID, String ppname, int pprice, int quantity, double totalamnt) {
	    super();
	    this.productid=ppID;
	    this.productName=ppname;
	    this.sellingPrice=pprice;
	    this.availableQuantity=quantity;
	    this.total=totalamnt;
	}

	 

	
	

}
