package model;

public class PatientQueries {
	private String[] descriptionQuery = { "What is your name","How old you are?" };
	// Allergies (food, tobacco, insect)
	private String[] allergyType = {"Which problem you are facing(dizziness/wheezing/edema)" };
	private String[] anyPastRecordQuery = { "Is there any past medical history?(yes/no)", "is this happen before?(yes/no)" };
	private String[] whenStartQuery = { "when it was started?(week/month)", "Did you take any precautions?(yes/no)" }; 
	private String[] lifeStyleQuery = { "Do you take your proper meal?", "Do You Smoke Cigarettes?","Do You Drink Alcohol? " };

	public String[] getDescriptionQuery() {
		return this.descriptionQuery;
	}

	public String[] getAllergyType() {
		return this.allergyType;
	}

	public String[] getPastRecordQuery() {
		return this.anyPastRecordQuery;
	}

	public String[] getWhenStartQuery() {
		return this.whenStartQuery;
	}

	public String[] getLifeStyleQuery() {
		return this.lifeStyleQuery;
	}
}
