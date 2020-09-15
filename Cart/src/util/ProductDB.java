package util;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

import model.Product;
import java.util.List;
import java.util.ArrayList;

public class ProductDB {
	static Connection con;
	public static List<Product> getAll(){
		List<Product> listProd = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Cart", "sa", "12345");
			String sql = "SELECT * FROM Products";
			Statement stt = con.createStatement();
			ResultSet rs = stt.executeQuery(sql);
			while(rs.next()) {
				listProd.add(new Product(rs.getString("code"), rs.getString("name"), rs.getFloat("price")));
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return listProd;
	}
	
	public static void main(String arg[]) {
		List<Product> list = ProductDB.getAll();
		for(Product x : list) {
			System.out.println(x);
		}
		System.out.println("e");
	}
}
