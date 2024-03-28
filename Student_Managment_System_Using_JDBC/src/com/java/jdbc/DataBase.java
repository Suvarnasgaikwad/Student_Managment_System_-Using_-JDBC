package com.java.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Mysqlroot3306");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public List<Student> readdata() throws ClassNotFoundException, SQLException {
		List<Student> list = new ArrayList<>();
		Connection con=DataBase.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select*from Student");

		while (rs.next()) {
			Student stud = new Student();
			stud.setId(rs.getInt("StudID"));
			stud.setName(rs.getString("StudName"));
			list.add(stud);
			
		}
		  con.close();
		return list;
   
	}

	public int savedata(Student stud) throws ClassNotFoundException, SQLException
	{
		
		Connection con=DataBase.getConnection();
		Statement st = con.createStatement();
		 String sql = "INSERT INTO Student (StudId,StudName)"+" VALUES ('" + stud.getId()+ "','" +stud.getName() + "');";
		int num=st.executeUpdate(sql);
		con.close();
	
		return num;
		
	}
	public int deleterecords(int id) throws ClassNotFoundException, SQLException
	{
		
		Connection con=DataBase.getConnection();
		Statement st = con.createStatement();
		String sql="delete from Student where StudId='"+id+"'";
		int num=st.executeUpdate(sql);
		return num;
		
	}
	public int updaterecords(Student stud) throws ClassNotFoundException, SQLException
	{
	
		Connection con=DataBase.getConnection();
		Statement st = con.createStatement();
		String sql="Update Student Set StudName='"+stud.getName()+"'where StudId='"+stud.getId()+"'";
		int num=st.executeUpdate(sql);
		return num;
		
	}
}
