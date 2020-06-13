package businessLogic;

import java.util.ArrayList;
import model.PatientReplies;
import services.AllergyTypes;
import services.PastRecord;
import services.WhenStart;
import services.LifeStyle;

public class AnalysisResult {
	int age, allergy_start;
	String medical_history, meal, cigarette, alcohol, precaution, having_before, allergy_type;
	private ArrayList<String> analysisResult = new ArrayList<String>();

	public AnalysisResult(PatientReplies reply) {
		// Creating object and initializing the variable by calling it's method.
		// asking for age.

		// Type of the disease.
		AllergyTypes at = new AllergyTypes(reply.getAllergicTypeReply());
		this.allergy_type = at.getAllergyTypes();

		// this method is for if patient is having any past record or not?
		PastRecord pr = new PastRecord(reply.getAnyPastRecordReply());
		this.having_before = pr.getmedicalhistory();
		this.medical_history = pr.getHappenBefore();
		
		
		this.age = Integer.parseInt(reply.getDescriptionAnswer().get(1));


		WhenStart ws = new WhenStart(reply.getWhenStartReply());
		this.allergy_start = Integer.parseInt(ws.getWhenStart());
		this.precaution = ws.getPrecaution();

		LifeStyle ls = new LifeStyle(reply.getLifeStyleReply());
		this.meal = ls.getMeal();
		this.cigarette = ls.getCigarette();
		this.alcohol = ls.getAlcohol();
	}

	public ArrayList<String> getAnalysisResult() {
		analysisResult.add("Analysis Result");

		// display the type of the allergy.
		analysisResult.add("Patient Age: "+ age);
		analysisResult.add("Type of the Disease: " + allergy_type);
		

		return analysisResult;

	}

}
