package utils

import java.time.format.DateTimeFormatter
import java.time.LocalDateTime

public class ApplicationUtilities {

	public static String convert_to_words(char[] num) {
		int len = num.length;

		String strWord="";

		String[] single_digits=["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
		String[] two_digits=["", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"]
		String[] tens_multiple=["", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]

		if (len == 1) {
			strWord=single_digits[num[0].toString().toInteger()];
			return strWord;
		}

		int x = 0;
		while (x < num.length) {
			if (num[x].toString().toInteger()== 1) {
				int sum = num[x].toString().toInteger()+ num[x+1].toString().toInteger();
				strWord=two_digits[sum];
				return strWord;
			}

			else if (num[x].toString().toInteger() == 2 && num[x + 1].toString().toInteger() == 0) {
				return "twenty";
			}

			else {
				int i = (num[x].toString().toInteger());
				if(i > 0)
					strWord= tens_multiple[i]+" ";
				else
					strWord= "";
				++x;
				if (num[x].toString().toInteger() != 0)
					strWord=strWord+single_digits[num[x].toString().toInteger()];
			}

			++x;
		}

		return strWord;
	}

	//get automated FirstName which return month name
	public static String getAutomated_FirstName() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM");
		LocalDateTime now=LocalDateTime.now();
		return convert_to_words(dtf.format(now).toCharArray());
	}

	//get automated MiddleName
	public static String getAutomated_MiddleName() {
		String MiddleName;
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("mm");
		LocalDateTime now=LocalDateTime.now();
		MiddleName=convert_to_words(dtf.format(now).toCharArray());
		dtf=DateTimeFormatter.ofPattern("ss");
		now=LocalDateTime.now();
		return MiddleName + " " + convert_to_words(dtf.format(now).toCharArray());
	}

	//get automated LastName
	public static String getAutomated_LastName() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd");
		LocalDateTime now=LocalDateTime.now();
		return "Automation" + " " + convert_to_words(dtf.format(now).toCharArray());
	}

	//get automated Email
	public static String getUnique_Automated_Email() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MMddyyyyHHmmss");
		LocalDateTime now=LocalDateTime.now();
		return "Automation_" + dtf.format(now) + "@yopmail.com";
	}

	//get automated Payroll ID
	public static String getUnique_Automated_PayrollID() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MMddyyyyHHmmss");
		LocalDateTime now=LocalDateTime.now();
		return "AT" + dtf.format(now);
	}

	//get automated Provider ID
	public static String getUnique_Automated_ProviderID() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HHmmss");
		LocalDateTime now=LocalDateTime.now();
		return "AT" + dtf.format(now);
	}

	//get automated EMR ID
	public static String getUnique_Automated_EMRID() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MMddyyyyHHmmss");
		LocalDateTime now=LocalDateTime.now();
		return "AT" + dtf.format(now);
	}

	//get automated NPI Number
	public static String getUnique_Automated_NPI() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MMddHHmmss");
		LocalDateTime now=LocalDateTime.now();
		return dtf.format(now);
	}

	//get automated SSN
	public static String getUnique_Automated_SSN() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MMddHHss");
		LocalDateTime now=LocalDateTime.now();
		return dtf.format(now);
	}




}
