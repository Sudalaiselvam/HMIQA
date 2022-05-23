package utils

import java.text.NumberFormat

public class CurrencyUtility {

	public static String getCurrencyValue(double Amount,String Currency) {
		Locale locale
		switch(Currency) {
			case "USD":
				locale=new Locale("en","US")
				break
			case "EUR":
				locale=new Locale("de","DE")
				break
		}
		NumberFormat numberFormat=NumberFormat.getCurrencyInstance(locale)
		return numberFormat.format(Amount)
	}
}
