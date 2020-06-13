package services;

import java.util.ArrayList;

public class AllergyTypes {
	private ArrayList<String> allergyType;

	public AllergyTypes(ArrayList<String> allergyType) {
		this.allergyType = allergyType;
	}

	public String getAllergyTypes() {
		if (allergyType.get(0).equals("throat,face and lips swelled"))
			return "You are Food Allergic.";
		else if (allergyType.get(1).equals("congestion, itchiness, watery eyes"))
			return "You are Tobacco Allergic.";
		else if (allergyType.get(2).equals("swelling area, hoarse voice, chest pain"))
			return "You are insect allergic";
		else
			return "You have normal allergy.";
	}

}
