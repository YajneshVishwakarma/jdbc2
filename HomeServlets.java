package Controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import DAO.PersonDemo;
import DTO.Person;

public class HomeServlets extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		System.out.println("Inside HomeServlet --->\nID :"+id+"\nname :"+name+"\nage :"+age);
		
		Person p = new Person(id,name,age);
		try {
			PersonDemo.insertPerson(p);
			PersonDemo.selectPerson(p);
//			PersonDemo.updatePerson(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
