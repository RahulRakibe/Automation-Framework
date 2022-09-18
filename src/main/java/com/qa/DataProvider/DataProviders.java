package com.qa.DataProvider;



import java.io.FileInputStream;

import java.util.Properties;

public class DataProviders 
{
	Properties properties;

	String path = "C:\\Users\\User\\eclipse-workspace\\AutomationFramework\\Configuration\\Config.properties";

	//constructor
	public DataProviders() {
		try {
			properties = new Properties();

			FileInputStream  fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	//User Name
 public String getusername()
 {
	String username= properties.getProperty("username");
	 if (username!=null)
		 return username;
	 else 
		throw new RuntimeException ("username not found");  	 
 }
   //Password
 public String getPassword()
 {
	String password= properties.getProperty("password");
	 if (password!=null)
		 return password;
	 else 
		throw new RuntimeException ("password not found");  	 
 }
 
   //URl
 public String getUrl()
 {
	String url= properties.getProperty("url");
	 if (url!=null)
		 return url;
	 else 
		throw new RuntimeException ("URL not found");  	 
 }

   //Account Holder Name
 public String getAccount_Holder_Name()
 {
	String Account_Holder_Name= properties.getProperty("Account_Holder_Name");
	 if (Account_Holder_Name!=null)
		 return Account_Holder_Name;
	 else 
		throw new RuntimeException ("Account holder name not found");  	 
 }
 
   //Product Name
 public String product_Name_For_Search()
 {
	String Product_For_Search= properties.getProperty("Product_For_Search");
	 if (Product_For_Search!=null)
		 return Product_For_Search;
	 else 
		throw new RuntimeException ("product name not found");  	 
 }
}
	
