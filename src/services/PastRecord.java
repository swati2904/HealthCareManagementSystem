package services;

import java.util.ArrayList;

public class PastRecord {
	private ArrayList<String> pastRecord;

	public PastRecord(ArrayList<String> pastRecord) {
		this.pastRecord = pastRecord;
	}

	public String getmedicalhistory() {
		if (pastRecord.get(0).contentEquals("yes")) {
			return "yes";
		} else
			return "no";
	}

	public String getHappenBefore() {
		if (pastRecord.get(1).contentEquals("yes")) {
			return "yes";
		} else
			return "no";
	}
}
