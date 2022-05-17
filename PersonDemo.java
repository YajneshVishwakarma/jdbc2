package DAO;

import java.sql.*;
import java.util.Scanner;

import DTO.Person;

public class PersonDemo {
	public static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person2","root","root");
		return con;
	}
	
	public static void insertPerson(Person p) throws Exception {	
		
		Connection con = getConnection();
		PreparedStatement pstmt =  con.prepareStatement("insert into person_details values(?,?,?)");

		pstmt.setInt(1, p.getId());
		pstmt.setString(2,p.getName());
		pstmt.setInt(3, p.getAge());
		
		System.out.println("Inside insertPerson --->\nID :"+p.getId()+"\nname :"+p.getName()+"\nage :"+p.getAge());
		pstmt.execute();

		con.close();
	}
	
	public static void selectPerson(Person p) throws Exception
	{
		Connection con = getConnection();
		PreparedStatement pstmt =  con.prepareStatement("select * from person_details where id = ?");
		pstmt.setInt(1, p.getId());
		ResultSet res = pstmt.executeQuery();
		
		ResultSetMetaData resmeta = res.getMetaData();
		
		int count = resmeta.getColumnCount();
		
		System.out.println("-----------------------------------------");
		
		for(int i = 1; i<=count;i++)
		{
			System.out.print(resmeta.getColumnName(i)+" ");
		}
		System.out.println();
		
		while(res.next())
		{
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3));
		}
		
		System.out.println("-----------------------------------------");

		pstmt.execute();
		
		con.close();
	}
	
	public static void updatePerson(Person p) throws Exception
	{
		Connection con = getConnection();
		PreparedStatement pstmt =  con.prepareStatement("update person_details set name = ?, age = ? where id=?");
		pstmt.setInt(3, p.getId());
		pstmt.setString(1,p.getName());
		pstmt.setInt(2,p.getAge());

		System.out.println("Inside upadatePerson --->\nID :"+p.getId()+"\nname :"+p.getName()+"\nage :"+p.getAge());
		pstmt.execute();
		System.out.println("Inside upadatePerson after exec --->\nID :"+p.getId()+"\nname :"+p.getName()+"\nage :"+p.getAge());
		
		con.close();
	}
	
	public static void deletePerson(int id) throws Exception
	{
		Connection con = getConnection();
		PreparedStatement pstmt =  con.prepareStatement("delete from person_details where id=?");
		pstmt.setInt(1, id);

		System.out.println("Inside deletePerson --->\nID :"+id);
		pstmt.execute();

		con.close();
	}
}


