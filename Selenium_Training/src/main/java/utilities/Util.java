package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Ordering;

public class Util {
	
	public static void sleep(long msec, String info) {
		if(info != null) {
			System.out.println("Wait: " +msec+ "for " +info);
		}
		
		try {
			Thread.sleep(msec);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void sleep(long msec) {
		sleep(msec, null);
	}
	
	public static String getScreenshotName(String methodName, String browserName) {
		String localDateTime = getCurrentDateTime();
		StringBuilder name = new StringBuilder().append(browserName)
												.append("_")
												.append(methodName)
												.append("_")
												.append(localDateTime)
												.append(".png");
		return name.toString();
	}
	
	public static String getReportName() {
		String localDateTime = getCurrentDateTime();
		StringBuilder name = new StringBuilder().append("AutomationReport_")
												.append(localDateTime)
												.append(".html");
		return name.toString();
	}
	
	public static int getRandomNumber(int min, int max) {
		int diff = max - min;
		int randomNum = (int)(min+Math.random() * diff);
		System.out.println("Random Numder : " +randomNum+ " within range : " +min+ " and : " +max);
		return randomNum;
	}
	
	public static int getRandomNumber(int number) {
		return getRandomNumber(1, number);
	}
	
	public static String getRandomString(int length) {
		StringBuilder sbuilder = new StringBuilder();
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for(int i=0; i<length; i++) {
			int index = (int)(Math.random() * chars.length());
			sbuilder.append(chars.charAt(index));
		}
		String randomString = sbuilder.toString();
		System.out.println("Random string with length : " +length+ " is : " +randomString);
		return randomString;
	}
	
	public static String getRandomString() {
		return getRandomString(10);
	}
	
	public static String getSimpleDateFormat(String format) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String formattedDate = formatter.format(date);
		System.out.println("Date with format : " +format+ " : " +formattedDate);
		return formattedDate;
	}
	
	public static String getCurrentDateTime() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String date = formatter.format(currentDate.getTime()).replace("/", "_");
		date = date.replace(":", "_"); 
		System.out.println("Date and Time: " + date);
		return date;
	}
	
	public static boolean verifyTextContains(String actualText, String expText) {
		if (actualText.toLowerCase().contains(expText.toLowerCase())) {
			System.out.println("Actual Text From Web Application UI --> : "+ actualText);
			System.out.println("Expected Text From Web Application UI --> : "+ expText);
			System.out.println("### Verification Matched !!!");
			return true;
		}
		else{
			System.out.println("Actual Text From Web Application UI --> : "+ actualText); 
			System.out.println("Expected Text From Web Application UI --> : "+ expText);
			System.out.println("### Verification DOES NOT Matched !!!");
			return false;
		}
	}
	
	public static boolean verifyTextMatch(String actualText, String expText) {
		if (actualText.equals(expText)) {
			System.out.println("Actual Text From Web Application UI --> : "+ actualText);
			System.out.println("Expected Text From Web Application UI --> : "+ expText);
			System.out.println("### Verification Matched !!!");
			return true;
		}
		else{
			System.out.println("Actual Text From Web Application UI --> : "+ actualText); 
			System.out.println("Expected Text From Web Application UI --> : "+ expText);
			System.out.println("### Verification DOES NOT Matched !!!");
			return false;
		}
	}
	
	public static Boolean verifyListContains(List<String> actList, List<String> expList) {
		int expListSize = expList.size();
		for (int i=0; i < expListSize; i++) {
			if (!actList.contains(expList.get(i))) {
				return false;
		    }
		}
		System.out.println("Actual List Contains Expected List !!!");
		return true;
	}
	
	public static Boolean verifyListMatch(List<String> actList, List<String> expList) {
		boolean found = false;
		int actListSize = actList.size();
		int expListSize = expList.size();
		if (actListSize != expListSize) {
			return false;
		}

		for (int i = 0; i < actListSize; i++) {
			found = false;
			for (int j = 0; j < expListSize; j++) {
				if (verifyTextMatch(actList.get(i), expList.get(j))) {
					found = true;
					break;
				}
			}
		}
		return found;
	}
	
	public static Boolean verifyItemPresentInList(List<String> actList, String item){
		int actListSize = actList.size();
		for ( int i = 0; i < actListSize; i++) { 
			if (!actList.contains(item)) {
				System.out.println("Item is NOT present in List !!!");
			return false;
			}
		}
		System.out.println("Item is present in List !!!");
		return true;
	}
	
	public static boolean isListAscendingOrder(List<Long> list){
		boolean sorted = Ordering.natural().isOrdered(list); 
		return sorted;
	}
}
