package services;

import java.util.ArrayList;

public class LifeStyle {
	private ArrayList<String> lifeStyle;

	public LifeStyle(ArrayList<String> lifeStyle) {
		this.lifeStyle = lifeStyle;
	}

	public String getMeal() {
		if (lifeStyle.get(0).contentEquals("yes")) {
			return "yes";
		} else
			return "no";

	}

	public String getCigarette() {
		if (lifeStyle.get(1).contentEquals("yes")) {
			return "yes";
		} else
			return "no";
	}

	public String getAlcohol() {
		if (lifeStyle.get(2).contentEquals("yes")) {
			return "yes";
		} else
			return "no";
	}
}
