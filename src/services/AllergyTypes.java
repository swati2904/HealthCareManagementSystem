package services;

import java.util.ArrayList;

public class AllergyTypes {
	private ArrayList<String> allergyType;

	public AllergyTypes(ArrayList<String> allergyType) {
		this.allergyType = allergyType;
	}

	public String getAllergyTypes() {
		if (allergyType.get(0).contentEquals("dizziness"))
			return "Food Allergic";
		else if (allergyType.get(0).contentEquals("wheezing"))
			return "Tobacco Allergic";
		else if (allergyType.get(0).contentEquals("edema"))
			return "Insect Allergic";
		else
			return "Normal Allergy";
	}

}
