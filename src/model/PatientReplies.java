package model;

import java.util.ArrayList;

public class PatientReplies {
	private ArrayList<String> descriptionAnswer = new ArrayList<String>();
	private ArrayList<String> allergyTypeReply = new ArrayList<String>();
	private ArrayList<String> anyPastRecordReply = new ArrayList<String>();
	private ArrayList<String> whenStartReply = new ArrayList<String>();
	private ArrayList<String> lifeStyleReply = new ArrayList<String>();

	public ArrayList<String> getDescriptionAnswer() {
		return descriptionAnswer;
	}

	public void setDescriptionAnswer(String answer) {
		this.descriptionAnswer.add(answer);
	}

	public ArrayList<String> getAllergicTypeReply() {
		return allergyTypeReply;
	}

	public void setAllergicTypeReply(String answer) {
		this.allergyTypeReply.add(answer);
	}

	public ArrayList<String> getAnyPastRecordReply() {
		return anyPastRecordReply;
	}

	public void setAnyPastRecordReply(String answer) {
		this.anyPastRecordReply.add(answer);
	}

	public ArrayList<String> getWhenStartReply() {
		return whenStartReply;
	}

	public void setWhenStartReply(String answer) {
		this.whenStartReply.add(answer);
	}

	public ArrayList<String> getLifeStyleReply() {
		return lifeStyleReply;
	}

	public void setLifeStyleReply(String answer) {
		this.lifeStyleReply.add(answer);
	}

}
