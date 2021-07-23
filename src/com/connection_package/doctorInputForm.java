package com.connection_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class doctorInputForm extends JFrame implements ActionListener {
	private Container c;
	private JTextField sname, effect, medication, sid;
	private JLabel title, name, eff, med, id;
	private JButton ok,insert,updateSymptom, displayAll, updateMedication, covidRecord, vaccinatedRecord; //ctor resp : (int), (String int), (String, String), (int, int)
	private JRadioButton detail, symptom, recovery, yes, no, mild, serious, other;
	private ButtonGroup buttons;
	
	public String nameData,effectData, medData;
	public int sidData;
	
    //Form to get Patient details for INSERTION in database
    public doctorInputForm(int n) {
    	setTitle("Enter Symptom Details");
    	setBounds(400, 300, 500, 400);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	c=getContentPane();
    	c.setLayout(null);
    	
    	title = new JLabel("Add New Symptom");
    	title.setSize(200,20);
    	title.setLocation(150, 20);
    	c.add(title);
    	
    	name = new JLabel("Name");
    	name.setSize(100,20);
    	name.setLocation(100,50);
    	c.add(name);
    	
    	sname = new JTextField();
    	sname.setSize(270, 20);
    	sname.setLocation(150,50);
    	c.add(sname);
    	
    	eff = new JLabel("Effect");
    	eff.setSize(100,20);;
    	eff.setLocation(100,100);
    	c.add(eff);
    	
    	mild = new JRadioButton("Mild");
    	mild.setSize(100,20);
    	mild.setLocation(120, 120);
    	c.add(mild);
    	
    	serious = new JRadioButton("Serious");
    	serious.setSize(100,20);
    	serious.setLocation(120, 140);
    	c.add(serious);
    	
    	other = new JRadioButton("Other");
    	other.setSize(100,20);
    	other.setLocation(120, 160);
    	c.add(other);
    	
    	med = new JLabel("Medication (NULL if unavailable");
    	med.setSize(450,20);
    	med.setLocation(100,200);
    	c.add(med);
    	
    	medication = new JTextField();
    	medication.setSize(270, 20);
    	medication.setLocation(100,220);
    	c.add(medication);
    	
    	insert = new JButton("Submit");
    	insert.setSize(100, 20);
    	insert.setLocation(220, 320);
    	insert.addActionListener(this);
    	c.add(insert);
	
    	setVisible(true);
    }
    
	
	
	//DEFAULT ctor to invoke ctors for insertion, update, delete, display,....etc
    public doctorInputForm(String s) {
    	if(s=="insert") {
    		new doctorInputForm(10);
    	}
 
    	//update symptom
    	else if(s=="update") {
    		setTitle("Update Symptom Details");
	    	setBounds(100, 90, 500, 400);
	    	setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	
	    	c=getContentPane();
	    	c.setLayout(null);
	    	
	    	title = new JLabel("Kindly note the Symptom ID from generated list of existing symptoms.");
	    	title.setSize(400,20);
	    	title.setLocation(50, 20);
	    	c.add(title);
	    	
	    	//display all symptoms
	    	symptom_operation.displayAll();
	    	
	    	
	    	id = new JLabel("Symptom ID");
	    	id.setSize(100,20);
	    	id.setLocation(100, 50);
	    	c.add(id);
	    	
	    	sid = new JTextField();
	    	sid.setSize(100,20);
	    	sid.setLocation(200, 50);
	    	c.add(sid);
	    	
	    	name = new JLabel("New Name");
	    	name.setSize(100,20);
	    	name.setLocation(100,70);
	    	c.add(name);
	    	
	    	sname = new JTextField();
	    	sname.setSize(270, 20);
	    	sname.setLocation(200,70);
	    	c.add(sname);
	    	
	    	eff = new JLabel("Effect");
	    	eff.setSize(100,20);;
	    	eff.setLocation(100,100);
	    	c.add(eff);
	    	
	    	mild = new JRadioButton("Mild");
	    	mild.setSize(100,20);
	    	mild.setLocation(120, 120);
	    	c.add(mild);
	    	
	    	serious = new JRadioButton("Serious");
	    	serious.setSize(100,20);
	    	serious.setLocation(120, 140);
	    	c.add(serious);
	    	
	    	other = new JRadioButton("Other");
	    	other.setSize(100,20);
	    	other.setLocation(120, 160);
	    	c.add(other);
	    	
	    	med = new JLabel("Medication (NULL if unavailable)");
	    	med.setSize(400,20);
	    	med.setLocation(100,200);
	    	c.add(med);
	    	
	    	medication = new JTextField();
	    	medication.setSize(270, 20);
	    	medication.setLocation(100,220);
	    	c.add(medication);
	    	
	    	updateSymptom = new JButton("Submit");
	    	updateSymptom.setSize(100, 20);
	    	updateSymptom.setLocation(200, 250);
	    	updateSymptom.addActionListener(this);
	    	c.add(updateSymptom);
	    	
	    	setVisible(true);
    	}
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == insert) {
    		nameData = sname.getText();
    		medData = medication.getText();
    		if(mild.isSelected()) {
    			effectData= "MILD";
    		}
    		else if(serious.isSelected()) {
    			effectData= "SERIOUS";
    		}
    		else if(other.isSelected()) {
    			effectData= "Other";
    		}
    	
    		setVisible(false);
    		symptom s1 = new symptom(nameData, effectData, medData);
            boolean result = symptom_operation.insertSymptom(s1);
            if(!result) {
            	System.out.println("error-insertion");
            }	
    	}
    	if(e.getSource() == updateSymptom) {
    		sidData = Integer.parseInt(sid.getText());
    		nameData = sname.getText();
    		medData = medication.getText();
    		if(mild.isSelected()) {
    			effectData= "MILD";
    		}
    		else if(serious.isSelected()) {
    			effectData= "SERIOUS";
    		}
    		else if(other.isSelected()) {
    			effectData= "Other";
    		}
    	
    		setVisible(false);
    		symptom s1 = new symptom(sidData, nameData, effectData, medData);
    		try {
    			boolean result2 = symptom_operation.updateSymptom(s1);
    			if(!result2){
    			System.out.println("error-update");
    			}
    		}catch(Exception e1){
				e1.printStackTrace();
			}
    	}
    }
}
