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

	public Patient(int patientId, int patientAge, String patientName, String diseaseCategory) {
		super();
		this.id = patientId;
		this.age = patientAge;
		this.name = patientName;
		this.diseaseCategory = diseaseCategory;
	}

	// getter method for patient
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