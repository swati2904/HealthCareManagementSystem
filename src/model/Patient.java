package model;
public class Patient {

	public int id;
	public int age;
	public String name;
	public String diseaseCategory;// A
	public String diseaseSubCategory;
	public int startTime;
	public int endTime;
	public Patient(){}

	public Patient(int id, int age, String name, String diseaseCategory) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.diseaseCategory = diseaseCategory;
	}

	// getter methods for patient class
	public int getPatientId() {
		return id;
	}

	public int getPatientAge() {
		return age;
	}

	public String getPatientName() {
		return name;
	}
	public String getPatientDiseaseCategory() {
		return diseaseCategory;
	}
}