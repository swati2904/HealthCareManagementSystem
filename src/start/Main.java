package start;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import businessLogic.AnalysisResult;
import businessLogic.Precautions;
import controller.Signup;
import model.Doctor;
import model.Patient;
import model.PatientQueries;
import model.PatientReplies;
import services.Analysis;

public class Main {
//-------------------------	for E-test report-----------------------------------
	public static void pdfReport(AnalysisResult result,Precautions precautions,String name) {
			Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(name+".pdf"));
	         document.open();
	         System.out.print("File is prepared with your name!!");
	         document.add(new Paragraph("HEALTH CARE MANAGEMENT ANALYSIS REPORT : "+name));
	         for (String str : result.getAnalysisResult()) {
	        	 document.add(new Paragraph("\n"+str));
	         }
	         document.add(new Paragraph("__________________________________________________________________________\n"));
	   
	         for (String str : precautions.providePrecautions()) {
	        	 document.add(new Paragraph("\n"+str));
	         }
	         document.add(new Paragraph("Thanks for visiting here"));
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	}
	static Doctor[] doctors = new Doctor[2];
	
	static String[] majorSpecialization = { "Allergists", "Cardiologists", "Colon surgeons",
			"Gastroenterlogists", "Neurologists", "Gynecologists", "Ophthalmologists", "Plastic surgeons" };

	static void handleDisease(Patient p) {
		for (int i = 1; i <= majorSpecialization.length; i++) {
			System.out.println(String.valueOf(i) + majorSpecialization[i-1]);
		}
		System.out.println("Enter option num");

		Scanner sc = new Scanner(System.in);
		int optionNumber = sc.nextInt();
		String mainCategory =majorSpecialization[optionNumber-1];
		p.diseaseCategory = mainCategory;	
		HashMap<Integer, ArrayList<String>> hmap = new HashMap<Integer, ArrayList<String>>();
		hmap.put(1, new ArrayList<String>(Arrays.asList("food allergies", "insect sting")));
		hmap.put(2, new ArrayList<String>(Arrays.asList("heart and blood vessels", "heart attack")));
		hmap.put(3, new ArrayList<String>(Arrays.asList("small intestine", "colon cancer", "inflammatory bowel")));
		hmap.put(4, new ArrayList<String>(Arrays.asList("stomach pain", "liver problem", "jaundice")));
		hmap.put(5, new ArrayList<String>(Arrays.asList("brain tumors", "strokes")));
		hmap.put(6, new ArrayList<String>(Arrays.asList("preganacy", "pap smears")));
		hmap.put(7, new ArrayList<String>(Arrays.asList("eyes", "glaueoma ")));
		hmap.put(8, new ArrayList<String>(Arrays.asList("breast", "skin")));
		ArrayList<String> subCategoryOptions = new ArrayList<>(); 
		subCategoryOptions = hmap.get(optionNumber);
		System.out.println("Enter Sub option num");
		for(int i=1;i<=subCategoryOptions.size();i++) {
			System.out.println(String.valueOf(i) +subCategoryOptions.get(i-1));
		}
		int subOptionNum = sc.nextInt();
		String mainSubCategory = subCategoryOptions.get(subOptionNum-1);
		p.diseaseSubCategory = mainSubCategory;
	}
	static int[] startTime = { 1, 2, 3, 4, 5, 6, 7, 8 };
	static int[] endTime = { 3, 5, 7, 9, 1, 12, 2, 4 };
	
	public static void doctorAvailability(Patient p, int n) {
		boolean isMajorCatFound = false;
		boolean isMajorSubCatFound = false;
		boolean isTimeFound = false;
		boolean isDoctorFound =false;
		//
		
		System.out.println(p.diseaseCategory+" "+p.diseaseSubCategory);
		//
		
		for(int i=0;i<n;i++) {
			isMajorCatFound = false;
			isMajorSubCatFound = false;
			isTimeFound = false;
			
			// finding Category
			ArrayList<String> ms= doctors[i].majorSpecialization;
			for(int j=0;j<ms.size();j++) {
				if(ms.get(i)==p.diseaseCategory) {
					isMajorCatFound = true;
				}
			}
			
			//finding Sub Category
			if(isMajorCatFound) {
				HashMap<String, ArrayList<String>> sc = doctors[i].subSpecialization;
				ArrayList<String> scList= sc.get(p.diseaseCategory);
				for(int j=0;j<scList.size();j++) {
					if(scList.get(j)== p.diseaseSubCategory) {
						isMajorSubCatFound = true;
					}
				}
			}
			
			// Finding Timings;
			if(isMajorCatFound && isMajorSubCatFound ){
				if(doctors[i].startTime <= p.startTime && p.endTime <= doctors[i].endTime) {
					isTimeFound = true;
				}
			}
			 
			if( isMajorCatFound && isMajorSubCatFound && isTimeFound) {
				//doctors[i].name;
				//p.start
				System.out.println("Doctor Found!!!!");
				isDoctorFound = true;
				break;
			}
			
		}
		if(!isDoctorFound) {
			System.out.println("No Doctor Available!!!!");
		}
	}
	
	public static void handleTime(Patient p) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the start time between 1 to 12");
		int startTime = sc.nextInt();
		System.out.println("Enter the end time between " + startTime + " to 12");
		int endTime = sc.nextInt();
		
		p.startTime = startTime;
		p.endTime = endTime;
	}

	public static void main(String[] args) throws IOException {
		// ------------------------Doctors Details-------------------------------
		// DOCTOR 1
		Doctor d1 = new Doctor();
		d1.id=1; d1.name="doctor1"; 
		d1.majorSpecialization.add("Allergists");
		d1.majorSpecialization.add("Cardiologists");
		d1.subSpecialization.put("Allergists",new ArrayList<String>(Arrays.asList("food allergies", "insect sting")));
		d1.subSpecialization.put("Cardiologists",new ArrayList<String>(Arrays.asList("heart and blood vessels", "heart attack")));
		d1.startTime=1;
		d1.endTime=5;
		
		doctors[0]=d1;
		
		// DOCTOR 2
		Doctor d2 = new Doctor();
		d2.id=2; d2.name="doctor2"; 
		d2.majorSpecialization.add("Allergists");
		d2.majorSpecialization.add("Cardiologists");
		d2.majorSpecialization.add("Plastic surgeons");
		d2.subSpecialization.put("Allergists",new ArrayList<String>(Arrays.asList("food allergies", "insect sting")));
		d2.subSpecialization.put("Cardiologists",new ArrayList<String>(Arrays.asList("heart and blood vessels", "heart attack")));
		d2.subSpecialization.put("Plastic surgeons",new ArrayList<String>(Arrays.asList("skin","Hair","Leg")));
		d2.startTime=2;
		d2.endTime=6;
		
		doctors[1]=d2;
		
		// Patient Created
				
		Patient p = new Patient();
		
		//----------------------------------------PATEINT SIGN UP AND LOGIN OPTION--------------------------------------------
//		Signup.userDetails();
//		System.out.println(" ");
		
		//--------------------------------------------PATIENT GENERAL INFORMATION---------------------------------------------
		Scanner patientDetails = new Scanner(System.in);
		
//		System.out.println("Enter your Name");
//		String patientName = patientDetails.nextLine();
//		
//		System.out.println("Enter your age");
//		int patientAge = patientDetails.nextInt();
//		
		//-----------------------------------PATEINT WANT TO TAKE APPOINTEMENT OR E_TEST---------------------------------------
		Scanner pReply = new Scanner(System.in);
		String patientAns = "";
		System.out.println("Want to to meet the Doctor?(Then press Yes) Or Want the E- Check(Then press No");
		patientAns = pReply.next();
		pReply.nextLine();
		if (patientAns.equals("yes")||patientAns.equals("y")||patientAns.equals("Y")) {
			handleDisease(p);
			handleTime(p);
			doctorAvailability(p,2);
		}
		
		else {
		
		

		PatientQueries query = new PatientQueries();
		String[] descriptionQuery = query.getDescriptionQuery();
		String[] allergyType = query.getAllergyType();
		String[] anyPastRecordQuery = query.getPastRecordQuery();
		String[] whenStartQuery = query.getWhenStartQuery();
		String[] lifeStyleQuery = query.getLifeStyleQuery();

		PatientReplies reply = new PatientReplies();
		Scanner sc = new Scanner(System.in);
		String patientReply = "";

		//------------------------------------------ PROCESS BEGIN FOR E-TEST-----------------------------------------------
		System.out.println("***********************************");
		System.out.println("Welcome to the E-Test care Dignosis");
		System.out.println("***********************************");

		System.out.println("Want to test your disease? (REPLY 'YES/NO')");
		patientReply = sc.next();
		sc.nextLine();
		if (patientReply.equals("YES")||patientReply.equals("y")|| patientReply.equals("yes")) {
			//------------------ asking for user age.-----------------------------------------
			Analysis analyse = new Analysis(descriptionQuery);
			System.out.println("***** GENERAL QUERY *****");
			for (int i = 0; i < descriptionQuery.length; i++) {
				System.out.println("Query: " + analyse.getQuery(i));
				reply.setDescriptionAnswer(sc.next());
			}
			String name = reply.getDescriptionAnswer().get(0);

			//---------------------asking for allergy-type.------------------------------------
			Analysis disease = new Analysis(allergyType);
			System.out.println("***** Type of the disease *****");
			for (int i = 0; i < allergyType.length; i++) {
				System.out.println("Query: " + disease.getQuery(i));
				reply.setAllergicTypeReply(sc.next());
			}
			//-------------------asking for if is any past medicial record.--------------------
			Analysis record = new Analysis(anyPastRecordQuery);
			System.out.println("***** Any Medicial record *****");
			for (int i = 0; i < anyPastRecordQuery.length; i++) {
				System.out.println("Query: " + record.getQuery(i));
				reply.setAnyPastRecordReply(sc.next());
			}
			//-------------------------- asking for when the disease start----------------------
			Analysis start = new Analysis(whenStartQuery);
			System.out.println("***** Disease Start history *****");
			for (int i = 0; i < whenStartQuery.length; i++) {
				System.out.println("Query: " + start.getQuery(i));
				reply.setWhenStartReply(sc.next());
			}
			//----------------------------asking for patient lifeStyle.--------------------------
			Analysis lifestyle = new Analysis(lifeStyleQuery);
			System.out.println("***** patient regular lifestyle *****");
			for (int i = 0; i < lifeStyleQuery.length; i++) {
				System.out.println("Query: " + lifestyle.getQuery(i));
				reply.setLifeStyleReply(sc.next());
			}
			//----------------------------- analysis report---------------------------------------
			AnalysisResult result = new AnalysisResult(reply);
			// display result
			//System.out.println(result.getAnalysisResult());

			//-------------------------- Time for suggestions------------------------------------
			Precautions precaution = new Precautions(reply);

			//give pdf format to the user
			
			pdfReport(result,precaution,name);
		}
		System.out.println("Thank you! Visit again!");

	}
	}
}