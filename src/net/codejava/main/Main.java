package net.codejava.main;
import java.util.Scanner;

import net.codejava.operations.AddStudent;
import net.codejava.operations.Query;
import net.codejava.operations.RemoveStudent;
import net.codejava.operations.UpdateStudent;
import net.codejava.utils.Clear;

public class Main {
    public static void main(String[] args) {
    	Clear cl = new Clear();
    	Query qr = new Query();
    	Scanner cn = new Scanner(System.in);
    	boolean isExit = false;
        do {
        	System.out.println("---CRUD with Database---");
        	System.out.println("[0] Exit");
        	System.out.println("[1] Add Student");
        	System.out.println("[2] View Student");
        	System.out.println("[3] Remove Student");
        	System.out.println("[4] Update Student");
        	System.out.print("Option -> ");
        	String op = cn.nextLine();
        	
        	switch(op) {
        		case "0":
        			cl.clear();
        			isExit = true;
        			break;
        		case "1":
        			cl.clear();
        			System.out.println("---Add Student Info---");
        			System.out.print("Name: ");
        			String name = cn.nextLine();
        			System.out.print("GWA: ");
        			Double gwa = cn.nextDouble();
        			cn.nextLine(); // Fix here
        			AddStudent addStudent = new AddStudent(name, gwa);
        			addStudent.addStudent();
        			qr.viewStudent();
        			break;
        		case "2":
        			cl.clear();
        			qr.viewStudent();
        			break;
        		case "3":
        			cl.clear();
        			System.out.println("---Delete Student Info---");
        			qr.viewStudent();
        			System.out.print("Select id: ");
        			int id = cn.nextInt();
        			cn.nextLine(); // Fix here
        			RemoveStudent std = new RemoveStudent(id);
        			std.removeStd();
        			qr.viewStudent();
        			break;
        		case "4":
        			cl.clear();
        			System.out.println("---Update Student Info---");
        			qr.viewStudent();
        			
        			System.out.print("Select id: ");
        			int update_id = cn.nextInt();
        			cn.nextLine();
        			
        			System.out.print("Name: ");
        			String update_name = cn.nextLine();
        			
        			System.out.print("GWA: ");
        			Double update_gwa = cn.nextDouble();
        			cn.nextLine();
        			UpdateStudent up = new UpdateStudent(update_id, update_name, update_gwa);
        			up.updateStudent();
        			qr.viewStudent();
        			break;
        		default:
        			System.out.println("Invalid Option");
        			break;
        	}
        }while(isExit == false);
        cn.close();
    }
}

