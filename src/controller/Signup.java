package controller;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup {
	// private static final String PASSWORD_PATTERN =
	// "((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private static Pattern pattern;
	private static Matcher matcher1;
	private static Matcher matcher2;

	// In this method we get the user details.......
	public static void userDetails() throws IOException {
		System.out.println("--------------------------------------------");
		System.out.println("WELCOME TO THE HEALTH CARE MANAGEMENT SYSTEM");
		System.out.println("--------------------------------------------");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// for name
		System.out.println("Please enter your name");
		String name = br.readLine();

		// for email
		System.out.println("Please enter your email");
		String email = br.readLine();

		// for password
		System.out.println("Please enter password");
		String password = br.readLine();

		// for confirmpassword
		System.out.println("confirm your password");
		String confirmPassword = br.readLine();

		// checking enter details are valid?

		if (validEmail(email) && validPassword(password, confirmPassword)) {
			System.out.println("You Have Successfully Registerd!!! ");
			System.out.println("Please go to the login process");

			SignupAndLogin s = new SignupAndLogin(email, password);
			s.check();
		} else {
			System.out.println("Invalid Email and Password");
			System.out.println("Please Sign up Again");
			userDetails();
		}
	}

	// check that entered password is valid or not.
	public static boolean validPassword(String password, String confirmPassword) {
		if (password.length() == 0)
			return false;
		if (!(password.contentEquals(confirmPassword)))
			return false;
		if (!((password.length() > 8) && (password.length() <= 20)))
			return false;

		char a[] = password.toCharArray();
		int capital = 0;
		int lower = 0;
		int num = 0;
		int special = 0;

		for (int i = 0; i < password.length(); i++) {
			if ((a[i] >= 65) && (a[i] <= 90))
				capital++;
			else if ((a[i] >= 97) && (a[i] <= 122))
				lower++;
			else if ((a[i] >= 48) && (a[i] <= 58))
				num++;
			else
				special++;
		}
		if ((capital > 0) && (lower > 0) && (num > 0))
			return true;
		else
			return false;

	}

	// regex for valid email.

	public static boolean validEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
}
