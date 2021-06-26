package com.connection_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class patientInputForm extends JFrame implements ActionListener {
	private Container c;
	private JTextField pname, phone, pid;
	private JComboBox bg, day, month, year;
	private JLabel title, name, ph, blood_group, doc, id, recovered;
	private JButton ok,insert, updateDetail, updateSymptom, updateRecovery, delete, display; //ctor resp : (int), (String int), (String, String), (int, int)
	private JRadioButton detail, symptom, recovery, yes, no;
	private ButtonGroup buttons;
	
	public String nameData,phData, bgData, dayData ,monthData, yearData, date;
	public int pidData;
	
	private String days[]
	        = { "1", "2", "3", "4", "5",
	            "6", "7", "8", "9", "10",
	            "11", "12", "13", "14", "15",
	            "16", "17", "18", "19", "20",
	            "21", "22", "23", "24", "25",
	            "26", "27", "28", "29", "30",
	            "31" };
	    private String months[]
	        = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	    private String years[]
	        = { "1995", "1996", "1997", "1998",
	            "1999", "2000", "2001", "2002",
	            "2003", "2004", "2005", "2006",
	            "2007", "2008", "2009", "2010",
	            "2011", "2012", "2013", "2014",
	            "2015", "2016", "2017", "2018",
	            "2019" };

	    private String bgs[]
	    		= {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
	    

	    //Form to get Patient details for INSERTION in database
	    public patientInputForm(int n) {
	    	setTitle("Enter your Details");
	    	setBounds(100, 90, 500, 400);
	    	setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	
	    	c=getContentPane();
	    	c.setLayout(null);
	    	
	    	title = new JLabel("Registration Form");
	    	title.setLocation(300, 30);
	    	c.add(title);
	    	
	    	name = new JLabel("Name");
	    	name.setSize(100,20);
	    	name.setLocation(100,100);
	    	c.add(name);
	    	
	    	pname = new JTextField();
	    	pname.setSize(270, 20);
	    	pname.setLocation(150,100);
	    	c.add(pname);
	    	
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
	    	
	    	doc = new JLabel("Date Of Contraction");
	    	doc.setSize(150, 20);
	    	doc.setLocation(100, 250);
	    	c.add(doc);
	    	
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
 
	    	insert = new JButton("Submit");
	    	insert.setSize(100, 20);
	    	insert.setLocation(220, 300);
	    	insert.addActionListener(this);
	    	c.add(insert);
   	
	    	setVisible(true);
	    }
	    
	    
	    //Form to get Patient details to UPDATE BASIC DETAILS in database
	    public patientInputForm(String s, int n) {
	    	setTitle("Update Form");
	    	setBounds(100, 90, 500, 400);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	    	c=getContentPane();
	    	c.setLayout(null);
	    	
	    	title = new JLabel("Enter Your New Details");
	    	title.setLocation(300, 20);
	    	c.add(title);
	    	
	    	id = new JLabel("Patient ID");
	    	id.setSize(100,20);
	    	id.setLocation(100, 50);
	    	c.add(id);
	    	
	    	pid = new JTextField();
	    	pid.setSize(100,20);
	    	pid.setLocation(220, 50);
	    	c.add(pid);
	    	
	    	name = new JLabel("Name");
	    	name.setSize(100,20);
	    	name.setLocation(100,100);
	    	c.add(name);
	    	
	    	pname = new JTextField();
	    	pname.setSize(270, 20);
	    	pname.setLocation(150,100);
	    	c.add(pname);
	    	
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
	    	
	    	doc = new JLabel("Date Of Contraction");
	    	doc.setSize(150, 20);
	    	doc.setLocation(100, 250);
	    	c.add(doc);
	    	
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
 
	        updateDetail = new JButton("Submit");
	    	updateDetail.setSize(100, 20);
	    	updateDetail.setLocation(220, 300);
	    	updateDetail.addActionListener(this);
	    	c.add(updateDetail);
   	
	    	setVisible(true);
	    }
	    
	    //Form to get Patient details to UPDATE SYMPTOMS in database
	    public patientInputForm(String s1, String s2) {
	    	setTitle("Update Form");
	    	setBounds(100, 90, 500, 400);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	    	c=getContentPane();
	    	c.setLayout(null);
	    	
	    	title = new JLabel("Kindly enter the following...");
	    	title.setLocation(300, 20);
	    	c.add(title);
	    	
	    	id = new JLabel("Patient ID");
	    	id.setSize(100,20);
	    	id.setLocation(100, 50);
	    	c.add(id);
	    	
	    	pid = new JTextField();
	    	pid.setSize(100,20);
	    	pid.setLocation(200, 50);
	    	c.add(pid);
	    	
	        updateSymptom = new JButton("Submit");
	    	updateSymptom.setSize(100, 20);
	    	updateSymptom.setLocation(220, 100);
	    	updateSymptom.addActionListener(this);
	    	c.add(updateSymptom);
	    	
	    	setVisible(true);
	    	
	    }
	    //Form to get Patient details to UPDATE RECOVERY in database
	    public patientInputForm(int n, int m) {
	    	setTitle("Update Form");
	    	setBounds(100, 90, 500, 400);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	    	c=getContentPane();
	    	c.setLayout(null);
	    	
	    	title = new JLabel("Kindly enter the following...");
	    	title.setLocation(300, 20);
	    	c.add(title);
	    	
	    	id = new JLabel("Patient ID");
	    	id.setSize(100,20);
	    	id.setLocation(100, 50);
	    	c.add(id);
	    	
	    	pid = new JTextField();
	    	pid.setSize(100,20);
	    	pid.setLocation(200, 50);
	    	c.add(pid);
	    	
	    	recovered = new JLabel("Have you Recovered?");
	    	recovered.setSize(200,20);
	    	recovered.setLocation(100, 100);
	    	c.add(recovered);
	    	
	    	yes = new JRadioButton("Yes");
	    	yes.setSize(100, 20);;
	    	yes.setLocation(120, 130);
	    	c.add(yes);
	    	
	    	no = new JRadioButton("No");
	    	no.setSize(100,20);
	    	no.setLocation(120, 160);
	    	c.add(no);
	    	
	        updateRecovery = new JButton("Submit");
	    	updateRecovery.setSize(100, 20);
	    	updateRecovery.setLocation(220, 300);
	    	updateRecovery.addActionListener(this);
	    	c.add(updateRecovery);
	    	
	    	setVisible(true);
	    	
	    }
	    
	    //default ctor to invoke ctors for insertion and update forms
	    public patientInputForm(String s) {
	    	if(s=="insert") {
	    		new patientInputForm(10);
	    	}
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
		    	
		    	
		    	detail = new JRadioButton("Update your Basic Details - Name, Blood Group, Phone, etc");
		    	detail.setSize(500, 20);
		    	detail.setLocation(30, 60);
		    	//detail.addActionListener(this);
		    	//detail.setMnemonic(KeyEvent.VK_Y);
		    	c.add(detail);
		    	
		    	symptom = new JRadioButton("Update your Symptoms");
		    	symptom.setSize(200, 20);
		    	symptom.setLocation(30, 100);
		    	//symptom.addActionListener(this);
		    	//symptom.setMnemonic(KeyEvent.VK_Y);
		    	c.add(symptom);
		    	
		    	recovery = new JRadioButton("Update your Recovery");
		    	recovery.setSize(200, 20);
		    	recovery.setLocation(30, 140);
		    	//recovery.addActionListener(this);
		    	//recovery.setMnemonic(KeyEvent.VK_Y);
		    	c.add(recovery);
		    	
		    	buttons = new ButtonGroup();
		    	buttons.add(detail); buttons.add(symptom); buttons.add(recovery);
		    	
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
		    	
		    	id = new JLabel("Patient ID");
		    	id.setSize(100,20);
		    	id.setLocation(50, 50);
		    	c.add(id);
		    	
		    	pid = new JTextField();
		    	pid.setSize(100,20);
		    	pid.setLocation(120, 50);
		    	c.add(pid);
		    	
		        delete = new JButton("Submit");
		    	delete.setSize(100, 20);
		    	delete.setLocation(150, 100);
		    	delete.addActionListener(this);
		    	c.add(delete);
	   	
		    	setVisible(true);
		    	
	    	}
	    	
	    	//DISPLAY DETAILS
	    	else if(s=="display") {
		    	setTitle("Display Details");
		    	setBounds(500, 300, 400, 200);
		    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	
		    	c=getContentPane();
		    	c.setLayout(null);
		    	
		    	title = new JLabel("Kindly enter the following...");
		    	title.setSize(250,20);
		    	title.setLocation(100, 20);
		    	c.add(title);
		    	
		    	id = new JLabel("Patient ID");
		    	id.setSize(100,20);
		    	id.setLocation(50, 50);
		    	c.add(id);
		    	
		    	pid = new JTextField();
		    	pid.setSize(100,20);
		    	pid.setLocation(120, 50);
		    	c.add(pid);
		    	
		        display = new JButton("Submit");
		    	display.setSize(100, 20);
		    	display.setLocation(150, 100);
		    	display.addActionListener(this);
		    	c.add(display);
	   	
		    	setVisible(true);
		    	
	    	}
	    }
	    
	    
	    public void actionPerformed(ActionEvent e) {
	    	if(e.getSource() == insert) {
	    		nameData = pname.getText();
	    		phData = phone.getText();
	    		bgData = (String)bg.getSelectedItem();
	    		dayData = (String)day.getSelectedItem();
	    		monthData = (String)month.getSelectedItem();
	    		yearData = (String)year.getSelectedItem();
	    		date = yearData+"-"+monthData+"-"+dayData;
	    		//System.out.println(date+nameData+bgData+phData);
	    		setVisible(false);
				//System.out.println(f1.nameData+f1.phData+f1.bgData+f1.date);

	            Patient p1 = new Patient(nameData, bgData,phData, date);
	            boolean result = Patient_operation.insertPatient(p1);
	            if(!result) {
	            	System.out.println("error-insertion");
	            }	
	    	}
	    	if(e.getSource() == updateDetail) {
	    		pidData = Integer.parseInt(pid.getText());
	    		nameData = pname.getText();
	    		phData = phone.getText();
	    		bgData = (String)bg.getSelectedItem();
	    		dayData = (String)day.getSelectedItem();
	    		monthData = (String)month.getSelectedItem();
	    		yearData = (String)year.getSelectedItem();
	    		date = yearData+"-"+monthData+"-"+dayData;
	    		//System.out.println(date+nameData+bgData+phData);
	    		setVisible(false);
				//System.out.println(f1.nameData+f1.phData+f1.bgData+f1.date);

	            Patient p1 = new Patient(pidData, nameData, bgData,phData, date);
	            boolean result=false;
				try {
					result = Patient_operation.updatePatient(p1, 1, pidData);
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

	    	if(e.getSource() == updateSymptom) {
	    		pidData = Integer.parseInt(pid.getText());
	    		setVisible(false);

	            Patient p1 = new Patient(pidData);
	            boolean result=false;
				try {
					result = Patient_operation.updatePatient(p1, 2, pidData);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	            if(!result) {
	            	System.out.println("error-update-symptom");
	            }	
	    	}
	    	
	    	if(e.getSource() == updateRecovery) {
	    		pidData = Integer.parseInt(pid.getText());
	    		setVisible(false);

	            Patient p1 = new Patient(pidData);
	            boolean result=false;
	            if(yes.isSelected()) {
					try {
						result = Patient_operation.updatePatient(p1, 3, pidData);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		            if(!result) {
		            	System.out.println("error-update-recovery");
		            }		
	            }
	    	}
	    	
	    	
	    	if(e.getSource() == ok) {
	    		
		    	if(detail.isSelected()) {
		    		new patientInputForm("detail", 1);
		    		detail.setEnabled(false);
		    		symptom.setEnabled(false);
		    		recovery.setEnabled(false);
		    		setVisible(false);
		    	}
		    	else if(symptom.isSelected()) {
		    		new patientInputForm("update", "symptom");
		    		detail.setEnabled(false);
		    		symptom.setEnabled(false);
		    		recovery.setEnabled(false);
		    		setVisible(false);
		    	}
		    	else if(recovery.isSelected()) {
		    		new patientInputForm(10,10);
		    		setVisible(false);
		    	}
	    	} 
	    	
	    	if(e.getSource() == delete) {
	    		pidData = Integer.parseInt(pid.getText());
	    		setVisible(false);
	
	            //Patient p1 = new Patient(pidData);
	            boolean result=false;
				try {
					result = Patient_operation.deletePatient(pidData);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	            if(!result) {
	            	System.out.println("error-insertion");
	            }	
	    	}
	    	
	    	if(e.getSource() == display) {
	    		pidData = Integer.parseInt(pid.getText());
	    		setVisible(false);
	
	            Patient p1 = new Patient(pidData);
				Patient_operation.displayPatient(p1);
	    	}
	    	
	    }
}
