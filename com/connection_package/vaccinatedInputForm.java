package com.connection_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class vaccinatedInputForm extends JFrame implements ActionListener{
	private Container c;
	private JTextField vname, phone, vid, vaccine;
	private JComboBox bg, day, month, year;
	private JLabel title, name, ph, blood_group, dov, id, vaccine_name;
	private JButton ok,insert, updateDetail, updateSideEffect, delete, display; //ctor for insert and update resp : (int), (String int), (String, String)
	private JRadioButton detail, sideEffect, yes, no;
	private ButtonGroup buttons;
	
	public String nameData,phData, bgData, dayData ,monthData, yearData, date, vaccineData;
	public int vidData;
	
	
	private String days[]
	        = { "01", "02", "03", "04", "05",
	            "06", "07", "08", "09", "10",
	            "11", "12", "13", "14", "15",
	            "16", "17", "18", "19", "20",
	            "21", "22", "23", "24", "25",
	            "26", "27", "28", "29", "30",
	            "31" };
	    private String months[]
	        = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	    private String years[]
	        = { "2020", "2021" };

	    private String bgs[]
	    		= {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
	    
	    
	    //Form to get Patient details for INSERTION in database
	    public vaccinatedInputForm(int n) {
	    	setTitle("Enter your Details");
	    	setBounds(100, 90, 500, 450);
	    	setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	
	    	c=getContentPane();
	    	c.setLayout(null);
	    	
	    	title = new JLabel("Registration Form");
	    	title.setLocation(300, 30);
	    	c.add(title);
	    	
	    	name = new JLabel("Name");
	    	name.setSize(100,20);
	    	name.setLocation(100,50);
	    	c.add(name);
	    	
	    	vname = new JTextField();
	    	vname.setSize(270, 20);
	    	vname.setLocation(150,50);
	    	c.add(vname);
	    	
	    	id = new JLabel("COWIN 4-Digit ID");
	    	id.setSize(100,20);
	    	id.setLocation(100,100);
	    	c.add(id);
	    	
	    	vid = new JTextField();
	    	vid.setSize(100,20);
	    	vid.setLocation(200,100);
	    	c.add(vid);
	    	
	    	ph = new JLabel("Phone Number");
	    	ph.setSize(100,20);;
	    	ph.setLocation(100,150);
	    	c.add(ph);
	    	
	    	phone = new JTextField();
	    	phone.setSize(220, 20);
	    	phone.setLocation(200, 150);
	    	c.add(phone);
	    	
	    	
	    	blood_group = new JLabel("Blood Group");
	    	blood_group.setSize(100, 20);;
	    	blood_group.setLocation(100, 200);
	    	c.add(blood_group);
	    	
	    	bg = new JComboBox(bgs);
	    	bg.setSelectedIndex(1);
	    	bg.setSize(50, 20);
	    	bg.setLocation(200, 200);
	    	c.add(bg);
	    	
	    	dov = new JLabel("Date Of Vaccination");
	    	dov.setSize(150, 20);
	    	dov.setLocation(100, 250);
	    	c.add(dov);
	    	
	    	day = new JComboBox(days);
	    	day.setSize(50, 20);
	    	day.setLocation(220, 250);
	    	c.add(day);
	    	
	        month = new JComboBox(months);
	        month.setSize(50, 20);
	        month.setLocation(290, 250);
	        c.add(month);
	  
	        year = new JComboBox(years);
	        year.setSize(60, 20);
	        year.setLocation(360, 250);
	        c.add(year);
 
	        vaccine_name = new JLabel("Vaccine Name");
	        vaccine_name.setSize(100,20);
	        vaccine_name.setLocation(100, 300);
	        c.add(vaccine_name);
	        
	        vaccine = new JTextField();
	        vaccine.setSize(100,20);
	        vaccine.setLocation(200, 300);
	        c.add(vaccine);
	        
	    	insert = new JButton("Submit");
	    	insert.setSize(100, 20);
	    	insert.setLocation(220, 350);
	    	insert.addActionListener(this);
	    	c.add(insert);
   	
	    	setVisible(true);
	    }
	    
	    
	    //Form to get vaccinated person's details to UPDATE BASIC DETAILS in database
	    public vaccinatedInputForm(String s, int n) {
	    	setTitle("Update Form");
	    	setBounds(100, 90, 500, 400);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	    	c=getContentPane();
	    	c.setLayout(null);
	    	
	    	title = new JLabel("Enter Your New Details");
	    	title.setLocation(300, 20);
	    	c.add(title);
	    	
	    	id = new JLabel("COWIN ID (same as old ID as it cannot be modified)");
	    	id.setSize(300,20);
	    	id.setLocation(100, 50);
	    	c.add(id);
	    	
	    	vid = new JTextField();
	    	vid.setSize(100,20);
	    	vid.setLocation(190, 70);
	    	c.add(vid);
	    	
	    	name = new JLabel("New Name");
	    	name.setSize(100,20);
	    	name.setLocation(100,100);
	    	c.add(name);
	    	
	    	vname = new JTextField();
	    	vname.setSize(270, 20);
	    	vname.setLocation(190,100);
	    	c.add(vname);
	    	
	    	ph = new JLabel("Phone Number");
	    	ph.setSize(100,20);;
	    	ph.setLocation(100,150);
	    	c.add(ph);
	    	
	    	phone = new JTextField();
	    	phone.setSize(220, 20);
	    	phone.setLocation(190, 150);
	    	c.add(phone);

	        updateDetail = new JButton("Submit");
	    	updateDetail.setSize(100, 20);
	    	updateDetail.setLocation(200, 200);
	    	updateDetail.addActionListener(this);
	    	c.add(updateDetail);
   	
	    	setVisible(true);
	    }
	    
	    //Form to get person's details to UPDATE SIDE EFFECTS in database
	    public vaccinatedInputForm(String s1, String s2) {
	    	setTitle("Update Form");
	    	setBounds(100, 90, 500, 400);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	    	c=getContentPane();
	    	c.setLayout(null);
	    	
	    	title = new JLabel("Kindly enter the following...");
	    	title.setLocation(300, 20);
	    	c.add(title);
	    	
	    	id = new JLabel("COWIN 4-Digit ID");
	    	id.setSize(100,20);
	    	id.setLocation(100, 50);
	    	c.add(id);
	    	
	    	vid = new JTextField();
	    	vid.setSize(100,20);
	    	vid.setLocation(200, 50);
	    	c.add(vid);
	    	
	        updateSideEffect = new JButton("Submit");
	    	updateSideEffect.setSize(100, 20);
	    	updateSideEffect.setLocation(220, 100);
	    	updateSideEffect.addActionListener(this);
	    	c.add(updateSideEffect);
	    	
	    	setVisible(true);
	    	
	    }
	    
	    public vaccinatedInputForm(String s) {
	    	if(s=="insert") {
	    		new vaccinatedInputForm(10);
	    	}
	    	
	    	//update details and side effects
	    	else if(s=="update") {
	    		setTitle("Update Your Details");
		    	setBounds(100, 90, 500, 400);
		    	setDefaultCloseOperation(EXIT_ON_CLOSE);
		    	
		    	c=getContentPane();
		    	c.setLayout(null);
		    	
		    	title = new JLabel("Update Options");
		    	title.setSize(200,30);
		    	title.setLocation(200, 20);
		    	c.add(title);
		    	
		    	
		    	detail = new JRadioButton("Update your Basic Details - Name and Phone");
		    	detail.setSize(500, 20);
		    	detail.setLocation(100, 60);
		    	//detail.addActionListener(this);
		    	//detail.setMnemonic(KeyEvent.VK_Y);
		    	c.add(detail);
		    	
		    	sideEffect = new JRadioButton("Update your Side Effects");
		    	sideEffect.setSize(200, 20);
		    	sideEffect.setLocation(100, 100);
		    	//symptom.addActionListener(this);
		    	//symptom.setMnemonic(KeyEvent.VK_Y);
		    	c.add(sideEffect);
		    	
		   
		    	buttons = new ButtonGroup();
		    	buttons.add(detail); buttons.add(sideEffect);
		    	
		    	ok = new JButton("OK");
		    	ok.setSize(100, 20);
		    	ok.setLocation(200, 180);
		    	ok.addActionListener(this);
		    	c.add(ok);
		    	
		    	setVisible(true);
	    	}
	    	
	    	//DELETION
	    	else if(s=="delete") {
		    	setTitle("Delete Details");
		    	setBounds(500, 300, 400, 200);
		    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	
		    	c=getContentPane();
		    	c.setLayout(null);
		    	
		    	title = new JLabel("Kindly enter the following...");
		    	title.setSize(250,20);
		    	title.setLocation(100, 20);
		    	c.add(title);
		    	
		    	id = new JLabel("COWIN 4-Digit ID");
		    	id.setSize(100,20);
		    	id.setLocation(100, 50);
		    	c.add(id);
		    	
		    	vid = new JTextField();
		    	vid.setSize(100,20);
		    	vid.setLocation(200, 50);
		    	c.add(vid);
		    	
		        delete = new JButton("Submit");
		    	delete.setSize(100, 20);
		    	delete.setLocation(150, 100);
		    	delete.addActionListener(this);
		    	c.add(delete);
	   	
		    	setVisible(true);
		    	
	    	}
	    	
	    }
	    
	    public void actionPerformed(ActionEvent e) {
	    	if(e.getSource() == insert) {
                vidData = Integer.parseInt(vid.getText());
	    		nameData = vname.getText();
	    		phData = phone.getText();
	    		bgData = (String)bg.getSelectedItem();
	    		dayData = (String)day.getSelectedItem();
	    		monthData = (String)month.getSelectedItem();
	    		yearData = (String)year.getSelectedItem();
	    		date = yearData+"-"+monthData+"-"+dayData;
	    		vaccineData = vaccine.getText();
	    		
	    		//System.out.println(date+nameData+bgData+phData);
	    		setVisible(false);
				//System.out.println(f1.nameData+f1.phData+f1.bgData+f1.date);

	    		vaccinated v1 = new vaccinated(vidData, date, nameData, bgData, phData, vaccineData);
	            boolean result = vaccinated_operation.insertVaccinated(v1);
	            if(!result) {
	            	System.out.println("error-insertion");
	            }	
	    	}
	    	
	    	if(e.getSource() == updateDetail) {
	    		vidData = Integer.parseInt(vid.getText());
	    		nameData = vname.getText();
	    		phData = phone.getText();
	    		
	    		setVisible(false);
	    		vaccinated v1= new vaccinated(vidData, nameData, phData);
	            boolean result=false;
				try {
					result = vaccinated_operation.updateVaccinated(v1, 1);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            if(!result) {
	            	System.out.println("error-update-details");
	            }	
	    	}
	    	
	    	if(e.getSource() == updateSideEffect) {
	    		vidData = Integer.parseInt(vid.getText());
	    		setVisible(false);

	            vaccinated v1 = new vaccinated(vidData);
	            boolean result=false;
				try {
					result = vaccinated_operation.updateVaccinated(v1, 2);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	            if(!result) {
	            	System.out.println("error-update-symptom");
	            }	
	    	}
	    	
	    	
            if(e.getSource() == ok) {
		    	if(detail.isSelected()) {
		    		new vaccinatedInputForm("detail", 1);
		    		detail.setEnabled(false);
		    		sideEffect.setEnabled(false);
		    		setVisible(false);
		    	}
		    	else if(sideEffect.isSelected()) {
		    		new vaccinatedInputForm("update", "symptom");
		    		detail.setEnabled(false);
		    		sideEffect.setEnabled(false);
		    		setVisible(false);
		    	}
	    	}
            
	    	if(e.getSource() == delete) {
	    		vidData = Integer.parseInt(vid.getText());
	    		setVisible(false);

	            boolean result=false;
				try {
					result = vaccinated_operation.deleteVaccinated(vidData);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	            if(!result) {
	            	System.out.println("error-deletion");
	            }	
	    	}
	    	
	    }
}
