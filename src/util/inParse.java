package util;

import java.util.regex.*;

public class inParse {

	public static void main(String[] args) {
		String input = "Usd2v";
		System.out.println(beginsUGE(input));
		System.out.println(numberExists(input));
	}
	
	//Parses input
	public static boolean beginsUGE(String input) {
		return input.matches("^[UGE].*$");
	}
	
	public static boolean numberExists(String input) {
		Pattern pattern = Pattern.compile("\\d.*$");
		Matcher matcher = pattern.matcher(input);
		return matcher.find();
	}
	
	public static boolean validCourseID(String input) {
		return input.matches("");
	}
}
