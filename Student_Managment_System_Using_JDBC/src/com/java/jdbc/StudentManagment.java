package com.java.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentManagment {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		String str = "--------------------Welcome Student----------------------";
		String str1 = "\n #Select one option" + " \n 1) Save Student Information" + " \n 2) Show Student Information"
				+ " \n 3) Delete Student Records" + " \n 4)Update Student Information " + " \n 5) exit";

		while (true) {
			System.out.println(str);
			System.out.println(str1);

			int option = sc.nextInt();
			switch (option) {
			case 1:
				inserdata();
				break;

			case 2:
				showrecords();
				break;

			case 3:
				  deleteRecords();
				break;

			case 4:
				 updaterecords();
				break;

			case 5:
				System.out.println("Exit");
				break;
			}
		}

	}

	private static void updaterecords() throws ClassNotFoundException, SQLException {
		DataBase db = new DataBase();
		Student stud = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id=");
		int id = sc.nextInt();
		System.out.println("Enter Student Name for Update=");
		String name = sc.next();
		stud.setName(name);
		stud.setId(id);
		int num=db.updaterecords(stud);
		if (num > 0) {
			System.out.println("Student update Successfully");
		} else {
			System.out.println("Student failed to update");
		}
		
		
	}

	private static void deleteRecords() throws ClassNotFoundException, SQLException {
		DataBase db = new DataBase();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id for delete records=");
		int id=sc.nextInt();
		int num=db.deleterecords(id);
		if (num > 0) {
			System.out.println("Delete records Successfully");
		} else {
			System.out.println(" failed to delete records");
		}
		
		
	}

	private static void showrecords() throws ClassNotFoundException, SQLException {
		DataBase db = new DataBase();
		List<Student> list = db.readdata();
		for (Student s : list) {
			System.out.println(s);
		}

	}

	private static void inserdata() throws ClassNotFoundException, SQLException {
		DataBase db = new DataBase();
		Student stud = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id=");
		int id = sc.nextInt();
		System.out.println("Enter Student Name=");
		String name = sc.next();
		stud.setId(id);
		stud.setName(name);
		int num = db.savedata(stud);
		if (num > 0) {
			System.out.println("Student Save Successfully");
		} else {
			System.out.println("Student failed to save");
		}
		
	}

}
