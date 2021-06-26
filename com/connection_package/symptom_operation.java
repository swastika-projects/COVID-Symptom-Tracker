package com.connection_package;


import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;    
   

public class symptom_operation {
	
	public static boolean insertSymptom(symptom s1){

		boolean flag = false;
		try{
		Connection con = connection.create_connection();

		String q = "insert into symptom(sname, effect) values (?,?);";
		PreparedStatement pstmt = con.prepareStatement(q);

		//set the values of parameter
		pstmt.setString(1, s1.getSname());
		pstmt.setString(2, s1.getEffect());

		//execute
		pstmt.executeUpdate();
			
		PreparedStatement pstmt2 = con.prepareStatement("SELECT sid FROM symptom WHERE sname=? and effect=?");
		pstmt2.setString(1, s1.getSname());
		pstmt2.setString(2, s1.getEffect());
		ResultSet set = pstmt2.executeQuery();
		while(set.next()) {
			s1.setSid(set.getInt(1)); 
		    //displaySymptom(s1);
		}
        String str =  "\nSymptom Name : " + s1.getSname() +"\nEffect : " + s1.getEffect() + "\nMedication : " + s1.getMedication() +"\n";
			
		JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED SYMPTOM.\n"+ str +"\nGENERATED SYMPTOM ID : "+ s1.getSid() ,"Confirmation", JOptionPane.INFORMATION_MESSAGE);
		flag=true;
		
		}catch(Exception e){
		e.printStackTrace();
		}

		return flag;
	}
	
	public static boolean updateSymptom(symptom s1) throws NumberFormatException, IOException{

		boolean flag = false;
		//System.out.println("1. UPDATE \nPRESS 0 TO RETURN");
	
			try{
				/**Scanner sc = new Scanner(System.in);
				System.out.print("ENTER NAME TO UPDATE : ");
				String sname = sc.nextLine();
				System.out.print("ENTER EFFECT : ");
				String effect = sc.nextLine();
				System.out.print("ENTER MEDICATION (NULL IF UNAVAILABLE) : ");
				String medication = sc.nextLine();*/
	
				Connection con = connection.create_connection();
				
				
				//symptom s1= new symptom(sid, sname, effect, medication);

				String q = "update symptom set sname=? , effect=?, medication=? where sid = ?;";
				//preparedstatement
				PreparedStatement pstmt = con.prepareStatement(q);

				//set the values of parameter
				pstmt.setString(1, s1.getSname());
				pstmt.setString(2, s1.getEffect());
				pstmt.setString(3, s1.getMedication());
				pstmt.setInt(4, s1.getSid());
				
				//execute
				pstmt.executeUpdate();
				flag=true;
                displaySymptom(s1);

				}catch(Exception e){
				e.printStackTrace();
				}
		return flag;

	}
	
	public static void displaySymptom(symptom s1){

		try{
		Connection con = connection.create_connection();
		PreparedStatement pstmt = con.prepareStatement("SELECT sid, sname, effect, medication FROM symptom WHERE sid=?");
		pstmt.setInt(1, s1.getSid());
		
		//ResultSet set = stmt.executeQuery(q);
		ResultSet set = pstmt.executeQuery();
		String s=null;
		while(set.next()) {
			int sid= set.getInt(1); 
			String sname = set.getString(2);
			String effect = set.getString(3);
			String medication = set.getString(4);
			
			/*System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Symptom ID : " + sid);
			System.out.println("Symptom name : "+sname);
			System.out.println("Effect : " + effect);
			System.out.println("Medication : " + medication);*/
			
			s = "\nSymptom Name : " + sname + "\nSymptom ID : " + sid + "\nEffect : " + effect + "\nMedication : " + medication +"\n";
		}
		JOptionPane.showMessageDialog(null, s, "Symptom Details", JOptionPane.PLAIN_MESSAGE);
		
		set.close();
		pstmt.close();
		
		}catch(Exception e){
		e.printStackTrace();
		}
		}
	
	public static void updateMedication(int sid, String medication) {
		try{
			/*Scanner in = new Scanner(System.in);
			System.out.print("ENTER MEDICATION : ");
			String medication = in.nextLine();*/
			
			
			
			Connection con = connection.create_connection();
			
			String q = "update symptom set medication=? where sid = ?;";
			//preparedstatement
			PreparedStatement pstmt = con.prepareStatement(q);

			//set the values of parameter
			pstmt.setString(1, medication);
			pstmt.setInt(2, sid);
			
			//execute
			pstmt.executeUpdate();
            //displaySymptom(s1);
			//System.out.println("SUCCESSFULLY UPDATED!");
			JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED!!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}catch(Exception e){
			e.printStackTrace();
			}
	}
	
	public static void displayAll(){

		try{
		Connection con = connection.create_connection();
		String q = "SELECT * FROM symptom";
		Statement stmt = con.createStatement();
		
		ResultSet set = stmt.executeQuery(q);
		//ResultSet set = pstmt.executeQuery();
		JFrame f=new JFrame(); 

	    int i=0;
	    String[][] rows = new String[100][100];
		while(set.next()) {
			int sid= set.getInt(1); 
			String sname = set.getString(2);
			String effect = set.getString(3);
			String medication = set.getString(4);
		    //rows[][j++]={String.valueOf(sid), sname, effect, medication};
		    rows[i][0]=String.valueOf(sid);
		    rows[i][1]=sname;
		    rows[i][2]=effect;
		    rows[i][3]=medication;
		    i++;
			/**System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Symptom ID : " + sid);
			System.out.println("Symptom name : "+sname);
			System.out.println("Effect : " + effect);
			System.out.println("Medication : " + medication);*/
		
		}
		String data[][]=rows;
	    String column[]= {"SYMPTOM ID","SYMPTOM NAME","EFFECT", "MEDICATION"}; 
	    JTable jt=new JTable(data,column);    
	    jt.setBounds(30,40,600,500);          
	    JScrollPane sp=new JScrollPane(jt);    
	    f.add(sp);          
	    f.setSize(300,400);    
	    f.setVisible(true); 
	    
		set.close();
		stmt.close();
		
		}catch(Exception e){
		e.printStackTrace();
		}
		}
}
