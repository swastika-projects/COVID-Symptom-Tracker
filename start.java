import com.connection_package.Patient;
import com.connection_package.Patient_operation;
import com.connection_package.doctorInputForm;
import com.connection_package.symptom;
import com.connection_package.symptom_operation;
import com.connection_package.vaccinated;
import com.connection_package.vaccinatedInputForm;
import com.connection_package.vaccinated_operation;
import com.connection_package.patientInputForm;

import java.io.*;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class start {

	public static void patient() throws NumberFormatException, IOException
	{
		/**System.out.println("1. ADD YOUR DETAILS\n2. UPDATE YOUR DETAILS\n3. DELETE YOUR DETAILS\n4. GET INFORMATION\n5. DISPLAY YOUR DETAILS\nPRESS 0 TO RETURN\n");
		Scanner input = new Scanner(System.in);
		int n=input.nextInt();*/
		//sc.close();
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int n = Integer.parseInt(br.readLine());
		
		String str="1. ADD YOUR DETAILS\n\n2. UPDATE YOUR DETAILS\n\n3. DELETE YOUR DETAILS\n\n4. GET INFORMATION\n\n5. DISPLAY YOUR DETAILS\n\nPRESS 0 TO EXIT\n"; 
		int n =1;
		//while(n!=0) {
		 n= Integer.parseInt(
						JOptionPane.showInputDialog(null, str, "Patient Options", JOptionPane.QUESTION_MESSAGE)
						);
		switch(n)
		{
		case 1:
			/**Scanner in = new Scanner(System.in);
			System.out.print("ENTER NAME : ");
			String name = in.nextLine();
			System.out.print("ENTER BLOOD GROUP (O+/O-/A+/A-/B+/B-/AB+/AB-) : ");
			String bg = in.nextLine();
			System.out.print("ENTER PHONE NUMBER : ");
			String phone = in.nextLine();
			System.out.print("ENTER DATE OF CONTRACTION (YYYY-MM-DD) : ");
			String date = in.nextLine();
			*/
			/*JTextField name = new JTextField(30);
			JTextField bg = new JTextField(5);
			JTextField phone = new JTextField(12);
			JTextField date = new JTextField(10);
			
			JPanel panel = new JPanel();
			panel.add(new JLabel("ENTER NAME : "));
			panel.add(name);
			panel.add(new JLabel("ENTER BLOOD GROUP : "));
			panel.add(bg);
			panel.add(new JLabel("ENTER PHONE NUMBER : "));
			panel.add(phone);
			panel.add(new JLabel("ENTER DATE OF CONTRACTION : "));
			panel.add(date);
			
			int result = JOptionPane.showConfirmDialog(null, panel, 
		               "Add Your Details", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION) {
			       Patient p1= new Patient(name.getText(), bg.getText(), phone.getText(), date.getText());
			       boolean result2 = Patient_operation.insertPatient(p1);
			       if(!result2){
				   System.out.println("error-additon");
					//System.out.println("SUCCESSFULLY ADDED YOUR DETAILS! :)");
					//System.out.println(p1);
					//Patient_operation.displayPatient(p1);
					//System.out.println("KINDLY NOTE YOUR PATIENT ID. IT WILL BE USED TO ACCESS/MODIFY YOUR DETAILS IN FUTURE.");
					}
		      }*/
			
			patientInputForm f1 = new patientInputForm("insert");		
			break;
		case 2:
			/**Scanner sc = new Scanner(System.in);
			System.out.println("ENTER YOUR PATIENT ID : ");
			int pid = sc.nextInt();
			boolean result2 = Patient_operation.updatePatient(pid);
			if(result2){
			//System.out.println("SUCCESSFULLY UPDATED YOUR DETAILS! :)");
			//1System.out.println(p1);
			//System.out.println("KINDLY NOTE YOUR PATIENT ID. IT WILL BE USED TO ACCESS/MODIFY YOUR DETAILS IN FUTURE.");
			}else{
			System.out.println("error-updation");
			}*/
			patientInputForm f2 = new patientInputForm("update");
			break;
			
		case 3:
			//delete details
			/**boolean result3 = Patient_operation.deletePatient();
			if(!result3){
				System.out.println("error- deletion ");
			}*/
			patientInputForm f3 = new patientInputForm("delete");
			break;
		case 4:
			//give information from already available data
			break;
		case 5:
			/**System.out.println("ENTER PATIENT ID : ");
			Scanner sc2 = new Scanner(System.in);
			int p_id = sc2.nextInt();
			Patient p = new Patient(p_id);
			Patient_operation.displayPatient(p);*/
			patientInputForm f5 = new patientInputForm("display");
			break;	
		case 0:
			break;
		}
		//}
	}
	
	public static void doctor() throws NumberFormatException, IOException
	{
		/**System.out.println("1. ADD NEW SYMPTOM\n2. UPDATE SYMPTOM\n3. DISPLAY ALL SYMPTOMS\n4. UPDATE MEDICATION\n5. COVID PATIENT RECORD\n6. VACCINATED PERSON RECORD\nPRRSS 0 TO EXIT\n");
		Scanner input = new Scanner(System.in);
		int n=input.nextInt();*/
		
		
		String str="1. ADD NEW SYMPTOM\n\n2. UPDATE SYMPTOM\n\n3. DISPLAY ALL SYMPTOMS\n\n4. UPDATE MEDICATION\n\n5. COVID PATIENT RECORD\n\n6. VACCINATED PERSON RECORD\n\nPRESS 0 TO RETURN\n"; 
		int n2=1;
		while(n2!=0) {
			
		 n2= Integer.parseInt(
						JOptionPane.showInputDialog(null, str, "Doctor Options", JOptionPane.QUESTION_MESSAGE)
						);
		switch(n2)
		{
		case 1:
			/**Scanner in = new Scanner(System.in);
			System.out.println("ENTER SYMPTOM NAME : ");
			String sname = in.nextLine();
			System.out.println("ENTER EFFECT (Mild/Serious/Other) : ");
			String effect = in.nextLine();
			System.out.println("ENTER MEDICATION (NULL IF UNAVAILABLE) : ");
			String medication = in.nextLine();
			
			symptom s1 = new symptom(sname, effect, medication);
			boolean result = symptom_operation.insertSymptom(s1);
			if(result){
			System.out.println("SUCCESSFULLY ADDED SYMPTOM.");
			}else{
			System.out.println("error");
			}*/
			
			doctorInputForm d1 = new doctorInputForm("insert");
			break;
		case 2:
			/**Scanner a = new Scanner(System.in);
			System.out.println("Already existing Symptoms");
			symptom_operation.displayAll();
			System.out.println("ENTER SYMPTOM ID (sid) TO UPDATE : ");
			int sid = a.nextInt();
			boolean result2 = symptom_operation.updateSymptom(sid);
			if(result2){
			System.out.println("SUCCESSFULLY UPDATED!!");
			}else{
			System.out.println("error");
			}*/
			
			doctorInputForm d2 = new doctorInputForm("update");
			break;
		case 3:
			symptom_operation.displayAll();
			break;
		case 4:
			//Scanner in2 = new Scanner(System.in);
			//System.out.print("ENTER SYMPTOM ID (sid) TO UPDATE IT'S MEDICATION : ");
			//int sid2 = in2.nextInt();
			int sid2 = Integer.parseInt(
					JOptionPane.showInputDialog(null,"Enter Symptom ID to update medication", "Medication Update", JOptionPane.QUESTION_MESSAGE)
					);
			String med = JOptionPane.showInputDialog(null,"Enter Medication", "Medication Update", JOptionPane.QUESTION_MESSAGE);
 
			symptom_operation.updateMedication(sid2, med);
			break;
		case 5:
			Patient_operation.displayAll();
			break;
		case 6:
			vaccinated_operation.displayAll();
			break;
		}
		}
	}
	
	
	public static void vaccinated() throws NumberFormatException, IOException
	{
		/**System.out.println("1. ADD DETAILS\n2. UPDATE DETAILS\n3. DISPLAY YOUR DETAILS\n4. DELETE YOUR DETAILS\n5. GET INFORMATION\nPRESS 0 TO EXIT\n");
		Scanner input = new Scanner(System.in);
		int n=input.nextInt();*/
		
		
		String str="1. ADD DETAILS\n\n2. UPDATE DETAILS\n\n3. DISPLAY YOUR DETAILS\n\n4. DELETE YOUR DETAILS\n\n5. GET INFORMATION\n\nPRESS 0 TO RETURN\n"; 
		int n3=1;
		while(n3!=0) {
			
		 n3= Integer.parseInt(
						JOptionPane.showInputDialog(null, str, "Doctor Options", JOptionPane.QUESTION_MESSAGE)
						);
		switch(n3) {
		case 1:
			//vaccinated_operation.insertVaccinated();
			vaccinatedInputForm vac1 = new vaccinatedInputForm("insert");
			break;
		case 2:
			/**Scanner sc = new Scanner(System.in);
			System.out.print("ENTER COWIN 4-DIGIT ID : ");
			int vid = sc.nextInt();
			vaccinated_operation.updateVaccinated(vid);*/
			
			vaccinatedInputForm vac2 = new vaccinatedInputForm("update");
			break;
		case 3:
			/**Scanner sc2 = new Scanner(System.in);
			System.out.print("ENTER COWIN 4-DIGIT ID : ");
			int id = sc2.nextInt();*/
			
			int id = Integer.parseInt(
					JOptionPane.showInputDialog(null,"Enter COWIN ID", "Your Details", JOptionPane.QUESTION_MESSAGE)
					);
			vaccinated v1 = new vaccinated(id);
			vaccinated_operation.displayVaccinated(v1);
			break;
		case 4:
			//delete details
			vaccinatedInputForm vac4 = new vaccinatedInputForm("delete");
			break;
		case 5:
			//get info
			break;
		}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int n;
		while(true)
		{
			/**System.out.println("1. COVID PATIENT\n2. VACCINATED PERSON\n3. DOCTOR\nPRRSS 0 TO EXIT\n");
			Scanner sc = new Scanner(System.in);
			n=sc.nextInt();*/
			
			String str = "1. COVID PATIENT\n\n2. VACCINATED PERSON\n\n3. DOCTOR\n\nPRESS 0 TO EXIT\n";
			n = Integer.parseInt(
					JOptionPane.showInputDialog(null, str, "Start Menu", JOptionPane.QUESTION_MESSAGE)
					);
					
			switch(n)
			{
			case 1:
				patient();
				break;
			case 2:
				vaccinated();
				break;
			case 3:
				doctor();
				break;
			case 0:
				System.exit(0);
			}	
		}
	}
}
