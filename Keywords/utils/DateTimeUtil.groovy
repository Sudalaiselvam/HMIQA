package utils

import java.text.SimpleDateFormat

import com.kms.katalon.core.annotation.Keyword

import core.HMException
import java.time.temporal.ChronoUnit
import java.time.LocalDate

public class DateTimeUtil {

	/**
	 * This public method is used to get current Date time with a given format
	 * @param format: this is a given format, default value will be "MM/dd/yyyy"
	 * @return String: this returns a current date time string
	 */
	static String getDateTime(String format="MM/dd/yyyy", String timeZoneID=""){
		try{
			Date date = new Date()
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format)
			if(timeZoneID.equals("")){
				simpleDateFormat.setTimeZone(TimeZone.getDefault())
			}else{
				simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneID))//"America/New_York"
			}
			return simpleDateFormat.format(date.getTime())
		}catch(Throwable e){
			throw new HMException("Cannot get current date time",e);
		}
	}

	/**
	 * This public method is used to get Date time after plus with n days
	 * @param days: the days will be plus
	 * @param format: this is a given format, default value will be "MM/dd/yyyy"
	 * @param timeZoneID: this is a TimeZone ID, default value will be local timezone
	 * @return String: this returns a current date time string
	 */
	public static String nextDateTime(int days=5, String format="MM/dd/yyyy", String timeZoneID=getTimeZoneIDOfLocal()){
		try{
			Date date = new Date()
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format)
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneID))
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, days);
			date = c.getTime();
			return simpleDateFormat.format(date.getTime())
		}catch(Throwable e){
			throw new HMException("Cannot get next date time",e);
		}
	}

	/**
	 * This public method is used to get Date time after plus with n days
	 * @param days: the days will be plus
	 * @param format: this is a given format, default value will be "MM/dd/yyyy"
	 * @param timeZoneID: this is a TimeZone ID, default value will be local timezone
	 * @return String: this returns a current date time string
	 */
	public static String nextDateTimeFromAGivenDate(int days=5, String givenDate, String format="MM/dd/yyyy", String timeZoneID=getTimeZoneIDOfLocal()){
		try{

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format)
			Date date = simpleDateFormat.parse(givenDate);
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneID))
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, days);
			date = c.getTime();
			return simpleDateFormat.format(date.getTime())
		}catch(Throwable e){
			throw new HMException("Cannot get next date time",e);
		}
	}

	/**
	 * This public method is used to get current local time-zone ID
	 * @param N/A
	 * @return String: this returns a current local time-zone ID
	 */
	public static String getTimeZoneIDOfLocal(){
		try{
			String timezoneID = Calendar.getInstance().getTimeZone().getID()
			return timezoneID
		}catch(Throwable e){
			throw new HMException("Cannot get Timezone",e);
		}
	}

	@Keyword
	/**
	 * This public method is used to convert a Date String to a Date String with new format
	 * @param dateString: this is a given dateString
	 * @param formatOfDateString: this is a given old format
	 * @param newFormat: this is a given new format, default value will be "MM/dd/yyyy"
	 * @return Date: this returns a date string
	 */
	public static String convertDateStringFormat(String dateString, String formatOfDateString, String newFormat="MM/dd/yyyy"){
		try{
			SimpleDateFormat result = new SimpleDateFormat(formatOfDateString);
			Date date = result.parse(dateString);
			result.applyPattern(newFormat);
			return result.format(date);
		}catch(Throwable e){
			throw new HMException("Cannot convert String to DateTime",e);
		}
	}

	public static String SimpleDateFormatter(Date dateString,String newFormat='M/d/yyyy h:mm:ss aa') {
		try {
			SimpleDateFormat Formatter = new SimpleDateFormat(newFormat);
			return Formatter.format(dateString)
		}catch(Throwable e){
			throw new HMException("Cannot convert String to DateTime",e);
		}
	}

	public static boolean verifyDateInbetween(String StartDate,String EndDate,String CompareDate) {
		SimpleDateFormat sdf=new SimpleDateFormat('MM/dd/yyyy')
		Date dtStart=sdf.parse(StartDate);
		Date dtEnd=sdf.parse(EndDate);
		Date dtCompare=sdf.parse(CompareDate);
		if((dtCompare.after(dtStart) && dtCompare.before(dtEnd)) || (dtCompare.equals(dtStart)) || (dtCompare.equals(dtEnd))) {
			return true
		}else {
			return false
		}
	}

	public static boolean verifyDateEqualsAfterDate(String dateString,String dateCompare) {
		boolean blnCompare
		SimpleDateFormat sdf=new SimpleDateFormat('MM/dd/yyyy')
		Date dtStart=sdf.parse(dateString);
		Date dtCompare=sdf.parse(dateCompare);
		if(dtStart.after(dtCompare) || dtStart.equals(dtCompare))
			blnCompare=true
		return blnCompare
	}

	public static boolean verifyChecktDateTillCompareDate(String CheckDate,String CompareDate) {
		SimpleDateFormat sdf=new SimpleDateFormat('MM/dd/yyyy')
		Date dtCompareDate=sdf.parse(CompareDate)
		Date dtCheckDate=sdf.parse(CheckDate)
		if(dtCompareDate.before(dtCheckDate) || dtCompareDate.equals(dtCheckDate) )
			return true
		else
			return false
	}

	public static long getNoOfDaysBetweenTwoDates(String StartDate,String EndDate) {
		def SDate=StartDate.split('/')
		def EDate=EndDate.split('/')
		return (ChronoUnit.DAYS.between(LocalDate.of(SDate[2].toInteger(), SDate[0].toInteger(),  SDate[1].toInteger()), LocalDate.of(EDate[2].toInteger(), EDate[0].toInteger(),  EDate[1].toInteger())))+1
	}

	public static List<String> getYearsBetweenTwoDates(String StartDate,String EndDate){
		def SDate=StartDate.split('/')
		def EDate=EndDate.split('/')

		long SYear=SDate[2].toLong()
		long EYear=EDate[2].toLong()

		List<String> lstYear=new ArrayList<String>()
		int count=(EYear-SYear)+1
		int i=1
		while(i<=count) {
			lstYear.add(SYear.toString())
			SYear=SYear+1
			i++
		}
		return lstYear
	}
}
