package com.connection_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;

public class Patient_operation {
	public static boolean insertPatient(Patient p1){

		boolean flag = false;
		try{
		Connection con = connection.create_connection();

		String pname = p1.getpname();
		String bg = p1.getblood_group();
		String phone = p1.getphone();
		String date = p1.getdate();
		
		
		String q = "insert into patient(pname, blood_group, phone, positive_date) values(?,?,?,?)";
		//preparedstatement
		PreparedStatement pstmt = con.prepareStatement(q);

		//set the values of parameter
		pstmt.setString(1, pname);
		pstmt.setString(2, bg);
		pstmt.setString(3, phone);
		pstmt.setString(4, date);

		//execute
		pstmt.executeUpdate();

		Connection con2 = connection.create_connection();
		PreparedStatement pstmt2 = con2.prepareStatement("SELECT pid, recovered FROM patient WHERE pname=? and blood_group=? and phone=?");
		pstmt2.setString(1, p1.getpname());
		pstmt2.setString(2, p1.getblood_group());
		pstmt2.setString(3, p1.getphone());
		ResultSet set = pstmt2.executeQuery();
		int pid=0; String recovered=null;
        while(set.next()) {
        	pid =set.getInt(1);
    		recovered = set.getString(2);
        }
		
		String str =  "\nName : " + p1.getpname() +"\nPhone : " + p1.getphone() + "\nBlood Group : " + p1.getblood_group() + "\nDate of Contraction : " + p1.getdate() + "\nRecovered : " + recovered + "\n";
		
		/**while(set.next()) {
			p1.setpid(set.getInt(1)); //OR int pid = set.getInt("pid");
		    displayPatient(p1);
		}*/
				
		JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED YOUR DETAILS."+ str +"\nYOUR GENERATED PATIENT ID : "+ pid +"\nPatient ID will be used to access/modify your details in future.\nKindly note it.","Confirmation", JOptionPane.INFORMATION_MESSAGE);
		flag=true;
		
		}catch(Exception e){
		e.printStackTrace();
		}

		return flag;
		}
	
	//public static boolean updatePatient(int pid) throws NumberFormatException, IOException{
	public static boolean updatePatient(Patient p1, int n, int pid) throws NumberFormatException, IOException{

		boolean flag = false;
		/**System.out.println("1. UPDATE NAME/BLOOD GROUP/PHONE/DATE OF CONTRACTION\n2. UPDATE SYMPTOMS\n3. UPDATE RECOVERY\nPRESS 0 TO RETURN");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());*/
		switch(n)
		{
		case 1:
			try{
				/**Scanner sc = new Scanner(System.in);
				System.out.print("ENTER NAME : ");
				String name = sc.nextLine();
				System.out.print("ENTER BLOOD GROUP (O+/O-/A+/A-/B+/B-/AB+/AB-) : ");
				String bg = sc.nextLine();
				System.out.print("ENTER PHONE NUMBER : ");
				String phone = sc.nextLine();
				System.out.print("ENTER DATE OF CONTRACTION (YYYY-MM-DD) : ");
				String date = sc.nextLine();
				
				Patient p1= new Patient(pid, name, bg, phone, date);
				*/
				
				Connection con = connection.create_connection();
				

				String q = "update patient set pname=? , blood_group=? , phone=?, positive_date=? where pid=?";
				//preparedstatement
				PreparedStatement pstmt = con.prepareStatement(q);

				//set the values of parameter
				/*pstmt.setString(1, name);
				pstmt.setString(2, bg);
				pstmt.setString(3, phone);
				pstmt.setString(4, date);
				pstmt.setInt(5, pid);*/

				
				
				
				//set the values of parameter
				pstmt.setString(1, p1.getpname());
				pstmt.setString(2, p1.getblood_group());
				pstmt.setString(3, p1.getphone());
				pstmt.setString(4, p1.getdate());
				pstmt.setInt(5, p1.getpid());
				//execute
				pstmt.executeUpdate();
				flag=true;
                displayPatient(p1);

				}catch(Exception e){
				e.printStackTrace();
				}
				break;
		case 2:
			//update symptom table using days table
			try{
				String date=null;
				Connection con = connection.create_connection();
				Patient p2= new Patient(pid);
				PreparedStatement pstmt = con.prepareStatement("SELECT pid, pname, blood_group, phone, positive_date, recovered FROM patient WHERE pid=?");
				pstmt.setInt(1, p2.getpid());
				ResultSet set = pstmt.executeQuery();
				while(set.next()) {
				    date = set.getString(5);
				}
				
				String s = "Update Symptoms for the following number of days after contraction.\nYOUR DATE OF CONTRACTION : " + date + "\nPRESS 5 FOR 5 DAYS\nPRESS10 FOR 10 DAYS\nPRESS 15 FOR 15 DAYS\n";
				int daysNum = Integer.parseInt(JOptionPane.showInputDialog(null, s, "Update Symptoms", JOptionPane.OK_CANCEL_OPTION));
				int i = 1;
				String[] symptomsInput = new String[15];
				String[] updateDays = new String[15];
				while(i<=daysNum) {
					updateDays[i-1] = "day"+i;
					symptomsInput[i-1] = getDayWiseSymptom(pid, updateDays[i-1],i);
					
					//database updation 
					/**try {
						Connection con2 = connection.create_connection();

						String q = "insert into days(pid, "+updateDays+") values(?,?)";
						//preparedstatement
						PreparedStatement pstmt2 = con2.prepareStatement(q);

						//set the values of parameter
						//pstmt2.setString(1, updateDays);
						pstmt2.setInt(1, pid);
						pstmt2.setString(2, symptomsInput);
						

						//execute
						pstmt2.executeUpdate();
					}catch(Exception e) {
						e.printStackTrace();
					}*/
					
					i++;
				}
				if(daysNum == 5) {
					String q = "insert into days (pid,"+updateDays[0] +","+updateDays[1]+","+updateDays[2] +","+updateDays[3] +","+updateDays[4]+") values(?,?,?,?,?,?)";
					PreparedStatement pstmt2 = con.prepareStatement(q);

					pstmt2.setInt(1, pid);
					pstmt2.setString(2, symptomsInput[0]);
					pstmt2.setString(3, symptomsInput[1]);
					pstmt2.setString(4, symptomsInput[2]);
					pstmt2.setString(5, symptomsInput[3]);
					pstmt2.setString(6, symptomsInput[4]);
					
					pstmt2.executeUpdate();
				}
				else if(daysNum == 10) {
					String q = "insert into days (pid,"+updateDays[0] +","+updateDays[1]+","+updateDays[2] +","+updateDays[3] +","+updateDays[4]+","+updateDays[5] +","+updateDays[6] +","+updateDays[7] +","+updateDays[8] +","+updateDays[9] +") values(?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pstmt2 = con.prepareStatement(q);

					pstmt2.setInt(1, pid);
					pstmt2.setString(2, symptomsInput[0]);
					pstmt2.setString(3, symptomsInput[1]);
					pstmt2.setString(4, symptomsInput[2]);
					pstmt2.setString(5, symptomsInput[3]);
					pstmt2.setString(6, symptomsInput[4]);
					pstmt2.setString(7, symptomsInput[5]);
					pstmt2.setString(8, symptomsInput[6]);
					pstmt2.setString(9, symptomsInput[7]);
					pstmt2.setString(10, symptomsInput[8]);
					pstmt2.setString(11, symptomsInput[9]);
					
					pstmt2.executeUpdate();
				}
				else if(daysNum == 15) {
					String q = "insert into days (pid,"+updateDays[0] +","+updateDays[1]+","+updateDays[2] +","+updateDays[3] +","+updateDays[4]+","+updateDays[5] +","+updateDays[6] +","+updateDays[7] +","+updateDays[8] +","+updateDays[9] +","+updateDays[10] +","+updateDays[11] +","+updateDays[12] +","+updateDays[13] +","+updateDays[14] +") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pstmt2 = con.prepareStatement(q);

					pstmt2.setInt(1, pid);
					pstmt2.setString(2, symptomsInput[0]);
					pstmt2.setString(3, symptomsInput[1]);
					pstmt2.setString(4, symptomsInput[2]);
					pstmt2.setString(5, symptomsInput[3]);
					pstmt2.setString(6, symptomsInput[4]);
					pstmt2.setString(7, symptomsInput[5]);
					pstmt2.setString(8, symptomsInput[6]);
					pstmt2.setString(9, symptomsInput[7]);
					pstmt2.setString(10, symptomsInput[8]);
					pstmt2.setString(11, symptomsInput[9]);
					pstmt2.setString(12, symptomsInput[10]);
					pstmt2.setString(13, symptomsInput[11]);
					pstmt2.setString(14, symptomsInput[12]);
					pstmt2.setString(15, symptomsInput[13]);
					pstmt2.setString(16, symptomsInput[14]);
					
					pstmt2.executeUpdate();
				}
				JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED ALL SYMPTOMS!","Confirmation", JOptionPane.PLAIN_MESSAGE);
				flag=true;
				}catch(Exception e){
				e.printStackTrace();
				}
				break;

		case 3:
			//update recovery column;
			try{
				Connection con = connection.create_connection();
				Patient p3= new Patient(pid);

				String q = "update patient set recovered=? where pid=?";
				//preparedstatement
				PreparedStatement pstmt = con.prepareStatement(q);

				//set the values of parameter
				pstmt.setString(1, "YES");
				pstmt.setInt(2, p3.getpid());
				//execute
				pstmt.executeUpdate();
				flag=true;
                displayPatient(p3);
                System.out.println("YAY YOU'VE RECOVERED!!! :D");

				}catch(Exception e){
				e.printStackTrace();
				}
				break;
		}
		return flag;

		}
	
	
	//Utility function for updation of symptoms in the "days" table in database
	public static String getDayWiseSymptom(int pid, String updateDays, int iter)
	{
		String n=null;
		try{
			Connection con = connection.create_connection();
			PreparedStatement pstmt = con.prepareStatement("SELECT sid, sname FROM symptom");
			ResultSet set = pstmt.executeQuery();
			String[] symptoms= new String[20]; int i=0;
			while(set.next()) {
			    symptoms[i++] = set.getString(2);
			}
			
			n = JOptionPane.showInputDialog(null, "DAY "+(iter), "Update Symtoms", JOptionPane.QUESTION_MESSAGE,null, symptoms, symptoms[0]).toString();
			//System.out.println(n);
		}catch(Exception e){
			e.printStackTrace();
		}
		return n;
	}
	
	
	public static boolean deletePatient(int pid) throws NumberFormatException, IOException{

		boolean flag = false;
		//System.out.println("ENTER PATIENT ID : ");
		//Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
		
		/**BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pid = Integer.parseInt(br.readLine());*/
		
		Patient p1 = new Patient(pid);
		//System.out.println("YOUR DETAILS WILL BE DELETED FROM THE DATABASE");
		try{
			Connection con = connection.create_connection();
			
			PreparedStatement pstmt = con.prepareStatement("SELECT pid, pname, blood_group, phone, positive_date, recovered FROM patient WHERE pid=?");
			pstmt.setInt(1, p1.getpid());
			String pname, blood_group, phone, date, recovered, s="null";
		
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				pid= set.getInt(1); //OR int pid = set.getInt("pid");
				pname = set.getString(2);
				blood_group = set.getString(3);
				phone = set.getString(4);
				date = set.getString(5);
				recovered = set.getString(6);
			
				s = "Name : " + pname +"\nPatient ID : " + pid + "\nPhone : " + phone + "\nBlood Group : " + blood_group + "\nDate of Contraction : " + date + "\nRecovered : " + recovered;
			}
			
		
			//JOptionPane.showMessageDialog(null, s, "Your Details", JOptionPane.PLAIN_MESSAGE);
            int result = JOptionPane.showConfirmDialog(null,s + "\nAre you sure you want to delete?", "Delete Details",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                 if(result == JOptionPane.YES_OPTION){
                	 delete(p1);
                	 flag=true;
                    JOptionPane.showMessageDialog(null, "SUCCESSFULLY DELETED YOUR DETAILS.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                 }
		    
			set.close();
			pstmt.close();
			
		
		}catch(Exception e){
		e.printStackTrace();
		}
		return flag;

		}
	
	//Utility function to delete patient record from database
	public static void delete(Patient p1)
	{
		try{
			Connection con = connection.create_connection();
			
			Statement smt1 = con.createStatement();
			Statement smt2 = con.createStatement();
			
			//set foreign key check to 0 so that rows with foreign keys can be deleted in parent table
			smt1.executeUpdate("set FOREIGN_KEY_CHECKS=0");
			
			//execute delete operation
			PreparedStatement pstmt = con.prepareStatement("DELETE from patient WHERE pid=?");
			pstmt.setInt(1, p1.getpid());
			pstmt.executeUpdate();
			
			//reset foreign key check to 1 after deleting
			smt2.executeUpdate("set FOREIGN_KEY_CHECKS=1");
		}catch(Exception e){
			e.printStackTrace();
			}
	}
	public static void displayPatient(Patient p1){

		try{
		Connection con = connection.create_connection();
		//String q = "select pid, pname, blood_group, phone, positive_date from patient where pid=?;";
		//Statement stmt = con.createStatement();
	    //PreparedStatement pstmt = con.prepareStatement(q);
		PreparedStatement pstmt = con.prepareStatement("SELECT pid, pname, blood_group, phone, positive_date, recovered FROM patient WHERE pid=?");
		pstmt.setInt(1, p1.getpid());
		
		//ResultSet set = stmt.executeQuery(q);
		
		int pid;
		String pname, blood_group, phone, date, recovered, s="null";
	
		ResultSet set = pstmt.executeQuery();
		
		while(set.next()) {
			/**int pid= set.getInt(1); //OR int pid = set.getInt("pid");
			String pname = set.getString(2);
			String blood_group = set.getString(3);
			String phone = set.getString(4);
			String date = set.getString(5);
			String recovered = set.getString(6);*/
			
			/**System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println("Patient ID : " + pid);
			System.out.println("Patient Name  : "+pname);
			System.out.println("Blood Group : " + blood_group);
			System.out.println("Phone : " + phone);
			System.out.println("Date of Contraction : "+ date);
			System.out.println("Recovery Status : "+ recovered);*/
			
			
			pid= set.getInt(1); //OR int pid = set.getInt("pid");
			pname = set.getString(2);
			blood_group = set.getString(3);
			phone = set.getString(4);
			date = set.getString(5);
			recovered = set.getString(6);
		
			s = "Name : " + pname +"\nPatient ID : " + pid + "\nPhone : " + phone + "\nBlood Group : " + blood_group + "\nDate of Contraction : " + date + "\nRecovered : " + recovered;
		}
		
		//creating dialog box to display patient details
		//JOptionPane.showMessageDialog(f, s);
		JOptionPane.showMessageDialog(null, s, "Your Details", JOptionPane.PLAIN_MESSAGE);
		
	    
		set.close();
		pstmt.close();
			
		}catch(Exception e){
		e.printStackTrace();
		}
		}
	
	public static void displayAll(){

		try{
		Connection con = connection.create_connection();
		String q = "SELECT * FROM patient";
		Statement stmt = con.createStatement();
		
		ResultSet set = stmt.executeQuery(q);
		//ResultSet set = pstmt.executeQuery();
		JFrame f=new JFrame(); 
		
	    int i=0;
	    String[][] rows = new String[100][100];
		while(set.next()) {
			int pid= set.getInt(1); 
			String pname = set.getString(2);
			String blood_group = set.getString(3);
			String phone = set.getString(4);
			String date = set.getString(5);
			String recovered = set.getString(6);
		    //rows[][j++]={String.valueOf(sid), sname, effect, medication};
		    rows[i][0]=String.valueOf(pid);
		    rows[i][1]=pname;
		    rows[i][2]=blood_group;
		    rows[i][3]=phone;
		    rows[i][4]=date;
		    rows[i][5]=recovered;
		    i++;
			/**System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Symptom ID : " + sid);
			System.out.println("Symptom name : "+sname);
			System.out.println("Effect : " + effect);
			System.out.println("Medication : " + medication);*/
		
		}
		String data[][]=rows;
	    String column[]= {"PATIENT ID","NAME","BLOOD GROUP", "PHONE", "DATE OF CONTRACTION", "RECOVERED"}; 
	    JTable jt=new JTable(data,column);    
	    jt.setBounds(30,40,200,300);          
	    JScrollPane sp=new JScrollPane(jt);    
	    f.add(sp);          
	    f.setSize(1000,500);    
	    f.setVisible(true); 
	    
		set.close();
		stmt.close();
		
		}catch(Exception e){
		e.printStackTrace();
		}
		}
	
	public static void patientGetInfo(int pid)
	{
		try{
			Connection con = connection.create_connection();
			PreparedStatement pstmt = con.prepareStatement("select * from days where pid=?");
		    pstmt.setInt(1, pid);
			ResultSet set = pstmt.executeQuery();
			String[] days= new String[16]; int i=0;
			while(set.next()) {
				days[1]=set.getString(17);
				days[2]=set.getString(3);
				days[3]=set.getString(4);
				days[4]=set.getString(5);
				days[5]=set.getString(6);
				days[6]=set.getString(7);
				days[7]=set.getString(8);
				days[8]=set.getString(9);
				days[9]=set.getString(10);
				days[10]=set.getString(11);
				days[11]=set.getString(12);
				days[12]=set.getString(13);
				days[13]=set.getString(14);
				days[14]=set.getString(15);
				days[15]=set.getString(16);
			}
			
			//n = JOptionPane.showInputDialog(null, "DAY "+(iter), "Update Symtoms", JOptionPane.QUESTION_MESSAGE,null, symptoms, symptoms[0]).toString();
			//System.out.println(n);
			
			String str = "select max(day5), max(day10), max(day15) from days where ";
			for(int j=1;j<15;j++) {
				str += " day"+j+ " = " + "'" + days[j] + "'" + " or ";
 			}
			str += "day15 = " + "'" + days[15] + "'" + " and pid is not null";
			System.out.println(str);
			PreparedStatement pstmt2 = con.prepareStatement(str);
			ResultSet set2 = pstmt2.executeQuery();
			String output="";
			while(set2.next()) {
				String sympAfter5days = set2.getString(1);
				String sympAfter10days = set2.getString(2);
				String sympAfter15days = set2.getString(3);
				output = "EXPECTED SYMPTOMS (from date of contraction) \nAFTER" + "\n05 Days : " + sympAfter5days +"\n10 Days : " + sympAfter10days +"\n15 Days : " + sympAfter15days;
			}
			JOptionPane.showMessageDialog(null, output, "Information", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
