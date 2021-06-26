package com.connection_package;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class vaccinated_operation {
	
	public static boolean insertVaccinated(vaccinated v1){

		boolean flag = false;
		try{
		/**Scanner sc = new Scanner(System.in);
		System.out.print("ENTER NAME : ");
		String vname = sc.nextLine();
		System.out.print("ENTER 4 DIGIT ID(SAME AS ON COWIN WEBSITE) : ");
		int vid = sc.nextInt();
		System.out.print("ENTER DATE OF VACCINATION(YYYY-MM-DD) : ");
		String date = sc.next();
		System.out.print("ENTER BLOOD GROUP : ");
		String blood_group = sc.next();
		System.out.print("ENTER PHONE NUMBER : ");
		String phone = sc.next();
        System.out.print("ENTER VACCINE NAME : ");
        //String vaccine_name = sc.nextLine();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      	String vaccine_name = br.readLine();
        
		vaccinated v1 = new vaccinated(vid, date, vname, blood_group, phone, vaccine_name);*/
		Connection con = connection.create_connection();

		String q = "insert into vaccinated values(?,?,?,?,?,?);";
		//preparedstatement
		PreparedStatement pstmt = con.prepareStatement(q);

		//set the values of parameter
		pstmt.setInt(1, v1.getVid());
		pstmt.setString(2, v1.getDate() );
		pstmt.setString(3, v1.getVname());
		pstmt.setString(4, v1.getBlood_group());
		pstmt.setString(5, v1.getPhone());
		pstmt.setString(6,  v1.getVaccine_name());

		//execute
		pstmt.executeUpdate();
		
		
		String str =  "\nName : " + v1.getVname() +  "\nCOWIN ID : " + v1.getVid() +"\nPhone : " + v1.getPhone() + "\nBlood Group : " + v1.getBlood_group() + "\nDate of Vaccination : " + v1.getDate() + "\nVaccine : " + v1.getVaccine_name() + "\n";
		JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED YOUR DETAILS."+ str +"\nYour COWIN ID will be used to access/modify your details in future.\nKindly save it.","Confirmation", JOptionPane.INFORMATION_MESSAGE);
		
		//System.out.println("SUCCESSFULLY ADDED YOUR DETAILS!!");
		flag=true;
		
		}catch(Exception e){
		e.printStackTrace();
		}

		return flag;
		}
	
	public static boolean updateVaccinated(vaccinated v1 ,int n) throws NumberFormatException, IOException{

		boolean flag = false;
		//System.out.println("1. UPDATE NAME/PHONE NUMBER\n2. UPDATE SIDE EFFECTS\nPRESS 0 TO RETURN");
		//Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());*/
		switch(n)
		{
		case 1:
			try{
				/**Scanner sc = new Scanner(System.in);
				System.out.print("ENTER NAME : ");
				String vname = sc.nextLine();
				System.out.print("ENTER PHONE NUMBER : ");
				String phone = sc.nextLine();
				
				
				
				vaccinated v1= new vaccinated(vid, vname, phone);*/

				Connection con = connection.create_connection();
				String q = "update vaccinated set vname=?, phone=? where vid=?;";
				//prepared statement
				PreparedStatement pstmt = con.prepareStatement(q);
	
				//set the values of parameter
				pstmt.setString(1, v1.getVname());
				pstmt.setString(2, v1.getPhone());
				pstmt.setInt(3, v1.getVid());
				//execute
				pstmt.executeUpdate();
				flag=true;
				
				displayVaccinated(v1);
				//System.out.println("SUCCESSFULLY UPDATED YOUR DETAILS!!");
                //displayPatient(p1);

				}catch(Exception e){
				e.printStackTrace();
				}
				break;
		case 2:
			//update symptom table using date table
			try{
				String date=null;
				Connection con = connection.create_connection();
				PreparedStatement pstmt = con.prepareStatement("select * from vaccinated where vid=?");
				pstmt.setInt(1, v1.getVid());
				ResultSet set = pstmt.executeQuery();
				while(set.next()) {
				    date = set.getString(2);
				}
				
				String s = "Update Side-effects for the following number of days after Vaccination.\nYOUR DATE OF VACCINATION : " + date + "\nPRESS 5 FOR 5 DAYS\nPRESS10 FOR 10 DAYS\nPRESS 15 FOR 15 DAYS\n";
				int daysNum = Integer.parseInt(JOptionPane.showInputDialog(null, s, "Update Side Effects", JOptionPane.OK_CANCEL_OPTION));
				int i = 1;
				String[] symptomsInput = new String[15];
				String[] updateDays = new String[15];
				while(i<=daysNum) {
					updateDays[i-1] = "day"+i;
					symptomsInput[i-1] = getDayWiseSymptom(v1.getVid(), updateDays[i-1],i);			
					i++;
				}
				if(daysNum == 5) {
					String q = "insert into days (vid,"+updateDays[0] +","+updateDays[1]+","+updateDays[2] +","+updateDays[3] +","+updateDays[4]+") values(?,?,?,?,?,?)";
					PreparedStatement pstmt2 = con.prepareStatement(q);

					pstmt2.setInt(1, v1.getVid());
					pstmt2.setString(2, symptomsInput[0]);
					pstmt2.setString(3, symptomsInput[1]);
					pstmt2.setString(4, symptomsInput[2]);
					pstmt2.setString(5, symptomsInput[3]);
					pstmt2.setString(6, symptomsInput[4]);
					
					pstmt2.executeUpdate();
				}
				else if(daysNum == 10) {
					String q = "insert into days (vid,"+updateDays[0] +","+updateDays[1]+","+updateDays[2] +","+updateDays[3] +","+updateDays[4]+","+updateDays[5] +","+updateDays[6] +","+updateDays[7] +","+updateDays[8] +","+updateDays[9] +") values(?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pstmt2 = con.prepareStatement(q);

					pstmt2.setInt(1, v1.getVid());
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
					String q = "insert into days (vid,"+updateDays[0] +","+updateDays[1]+","+updateDays[2] +","+updateDays[3] +","+updateDays[4]+","+updateDays[5] +","+updateDays[6] +","+updateDays[7] +","+updateDays[8] +","+updateDays[9] +","+updateDays[10] +","+updateDays[11] +","+updateDays[12] +","+updateDays[13] +","+updateDays[14] +") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pstmt2 = con.prepareStatement(q);

					pstmt2.setInt(1, v1.getVid());
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
				JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED ALL SIDE EFFECTS!","Confirmation", JOptionPane.PLAIN_MESSAGE);
				flag=true;
				}catch(Exception e){
				e.printStackTrace();
				}
				break;

		}
		return flag;
	}
	
	public static boolean deleteVaccinated(int vid) throws NumberFormatException, IOException{

		boolean flag = false;

		vaccinated v1 = new vaccinated(vid);
		
		try{
			Connection con = connection.create_connection();
			
			PreparedStatement pstmt = con.prepareStatement("SELECT vid, vname, blood_group, phone, vaccination_date, vaccine_name FROM vaccinated WHERE vid=?");
			pstmt.setInt(1, v1.getVid());
			String vname, blood_group, phone, date, vaccine_name, s="null";
		
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()) {
				vid= set.getInt(1); //OR int pid = set.getInt("pid");
				vname = set.getString(2);
				blood_group = set.getString(3);
				phone = set.getString(4);
				date = set.getString(5);
				vaccine_name = set.getString(6);
			
				s = "Name : " + vname +"\nCOWIN ID : " + vid + "\nPhone : " + phone + "\nBlood Group : " + blood_group + "\nDate of Vaccination : " + date + "\nVaccine : " + vaccine_name;
			}
			
		
			//JOptionPane.showMessageDialog(null, s, "Your Details", JOptionPane.PLAIN_MESSAGE);
            int result = JOptionPane.showConfirmDialog(null,s + "\nAre you sure you want to delete?", "Delete Details",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                 if(result == JOptionPane.YES_OPTION){
                	 delete(v1);
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
	public static void delete(vaccinated v1)
	{
		try{
			Connection con = connection.create_connection();
			
			PreparedStatement pstmt = con.prepareStatement("DELETE from vaccinated WHERE vid=?");
			pstmt.setInt(1, v1.getVid());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			}
	}
	
	public static void displayVaccinated(vaccinated v1){

		try{
		Connection con = connection.create_connection();
		//String q = "select pid, pname, blood_group, phone, positive_date from patient where pid=?;";
		//Statement stmt = con.createStatement();
	    //PreparedStatement pstmt = con.prepareStatement(q);
		PreparedStatement pstmt = con.prepareStatement("select * from vaccinated where vid=?;");
		pstmt.setInt(1, v1.getVid());
		
		//ResultSet set = stmt.executeQuery(q);
		ResultSet set = pstmt.executeQuery();
		while(set.next()) {
			int vid= set.getInt(1); //OR int pid = set.getInt("pid");
			String date = set.getString(2);
			String vname = set.getString(3);
			String blood_group = set.getString(4);
			String phone = set.getString(5);
			String vaccine_name = set.getString(6);
			
			/**System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Patient ID : " + vid);
			System.out.println("Patient Name  : "+vname);
			System.out.println("Blood Group : " + blood_group);
			System.out.println("Phone : " + phone);
			System.out.println("Vaccine Name : " + vaccine_name);
			System.out.println("Date of Contraction : "+ date);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");*/
			
			String str =  "\nName : " + vname +  "\nCOWIN ID : " + vid +"\nPhone : " + phone + "\nBlood Group : " + blood_group + "\nDate of Vaccination : " + date + "\nVaccine : " + vaccine_name + "\n";
			JOptionPane.showMessageDialog(null,str +"\nYour COWIN ID will be used to access/modify your details in future.\nKindly save it.","Your Details", JOptionPane.INFORMATION_MESSAGE);
		}
		set.close();
		pstmt.close();
		
		}catch(Exception e){
		e.printStackTrace();
		}
		}
	
	public static void displayAll(){

		try{
		Connection con = connection.create_connection();
		String q = "SELECT * FROM vaccinated";
		Statement stmt = con.createStatement();
		
		ResultSet set = stmt.executeQuery(q);
		//ResultSet set = pstmt.executeQuery();
		JFrame f=new JFrame(); 

	    int i=0;
	    String[][] rows = new String[100][100];
		while(set.next()) {
			int vid= set.getInt(1); 
			String date = set.getString(2);
			String vname = set.getString(3);
			String blood_group = set.getString(4);
			String phone = set.getString(5);
			String vaccine_name = set.getString(6);
			
		    //rows[][j++]={String.valueOf(sid), sname, effect, medication};
		    rows[i][0]=String.valueOf(vid);
		    rows[i][1]=vname;
		    rows[i][2]=blood_group;
		    rows[i][3]=phone;
		    rows[i][4]=date;
		    rows[i][5]=vaccine_name;
		    i++;
		
		}
		String data[][]=rows;
	    String column[]= {"COWIN ID","NAME","BLOOD GROUP", "PHONE", "DATE OF VACCINATION", "VACCINE NAME"}; 
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

	//Utility function for updation of symptoms in the "days" table in database
	public static String getDayWiseSymptom(int vid, String updateDays, int iter)
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
	
}
