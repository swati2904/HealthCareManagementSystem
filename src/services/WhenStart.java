package services;

import java.util.ArrayList;

public class WhenStart {
	private ArrayList<String> whenStart = new ArrayList<String>();

	public WhenStart(ArrayList<String> whenStart) {
		this.whenStart = whenStart;
	}

	public String getWhenStart() {
		if (whenStart.get(0).equals("week"))
			return "You are in normal zone.";
		else if (whenStart.get(0).equals("month"))
			return "You are step up from the normal condition.";
		else
			return "You are in a serious condition.";
	}

	public String getPrecaution() {
		if (whenStart.get(1).contentEquals("yes")) {
			return "yes";
		} else
			return "no";
	}
}
