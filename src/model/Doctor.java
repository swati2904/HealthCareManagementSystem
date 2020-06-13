package model;

import java.util.*;


public class Doctor {
	
	public int id;
	public String name;
	public ArrayList<String>  majorSpecialization= new ArrayList<>();// [A, B, C]
	public HashMap<String, ArrayList<String>> subSpecialization = new HashMap<String, ArrayList<String>>();
	public int startTime;
	public int endTime;
	// constructor
	public Doctor() {
	}

}

	


