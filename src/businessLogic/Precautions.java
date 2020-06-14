package businessLogic;

import java.util.ArrayList;
import model.PatientReplies;

public class Precautions extends AnalysisResult {
	private ArrayList<String> precautionList = new ArrayList<String>();

	public Precautions(PatientReplies reply) {
		super(reply);
	}

	// methods
	public ArrayList<String> providePrecautions() {
		System.out.println("---------------------------------------------------------------------------------------");
		precautionList.add("*****READ IT CAREFULLY.*****\n\n Here The Precautions For Your Problems : \n");

		if (allergy_type == "Food Allergic" ) {
			precautionList.add(
					"Food Allergy: \n1. 90 percent of cases of all reaction is this kind of foods -peanuts, tree nuts, wheat, soy, fish, shellfish, eggs and milk.\n 2. Be extra careful when eating in restaurants or if possible then avoid the outdoor foods. \n");
		}

		if (allergy_type == "Tobacco Allergic") {
			precautionList.add(
					"Tobacco Allergy: \n1. The Only solution of this allergy to managed by the same fashion: 'MEDICATION' and 'AVOIDANCE OF NARCOTICS'. \n 2. Remedies for tobacco allergies include throat lozenges and decongestants. Nonetheless, avoidance is better than any medicine. \n 3.Try to take the 'hypnotherapy' and 'cognitive-behavioral therapy'\n");
		}

		if (allergy_type == "Insect Allergic") {
			precautionList.add(
					"Insect Allergy: \n1. Try to avoid walking on barefoot in the grass.\n 2. Garbage cans stored outside should be covered with tight fitting lids. \n 3. Avoid sweet-smelling perfumes, hair sparys. \n 4. When eating outdoors, try to keep food covered at all times. \n");
		}
		if(allergy_type == "Normal Allergy") {
			precautionList.add("Normal Allergy: \n1. You need to take a proper rest.\n 2.Clear your area and wash always your vegitables and fruits before taking it.");
		}
		if (precaution.equals("yes")) {
			precautionList.add(
					"**Doctor Advice: \nBefore taking any medicine, first consult to the doctor.\n 2. It may the highly effect of your health. \n");
		}
		if (meal.equals("no")) {
			precautionList.add(
					"** Health Concious: \nTake Your Proper meal, and try to avoid outdoor foods.\n");
		}
		if (this.cigarette.equals("yes")) {
			precautionList.add(
					"** Don't Smoke: \nCigarette smoke contains Nicotine which is the main addictive chemical in tobacco, It causes a rush of adrenaline when absorbed in the bloodstream or inhaled via cigarette smoke.");
		}
		if (this.alcohol.equals("yes")) {
			precautionList.add(
					"** Try To Avoid: \nAlcohol increases the inflammation and changes the hormonal milieu in the body, your immune system treats alcohol as a threat. It responds to alcohol by producing antibodies known as immunoglobulin E (IgE). These antibodies trigger an allergic reaction in your body.");
		}
		return precautionList;

	}
}
