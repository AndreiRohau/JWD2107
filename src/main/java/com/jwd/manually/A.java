package com.jwd.manually;

public class A { }
// Make the following code working manually.

/* Call the file: start.bat

    javac MyAppStream.java
    java MyAppStream
    del MyAppStream.class
    pause
 */

/* Call the file: MyAppStream.java

    import java.util.Scanner;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.temporal.ChronoUnit;
    import java.util.logging.Logger;

    public class MyAppStream {

        private static final Logger log = Logger.getLogger(MyAppStream.class.getName());

        public static void main(String[] args) {
            log.info("Enter a date to count how much days left to it (ex. format: 2021-11-21)");

            Scanner scanner = new Scanner(System.in);
            String inputValue = scanner.next();
            log.info("inputValue=[" + inputValue + "].");

            LocalDate currentDate = LocalDateTime.now().toLocalDate();
            LocalDate inputDate = LocalDate.parse(inputValue);
            log.info("currentDate=[" + currentDate + "]. inputDate=[" + inputDate+ "].");

            long daysLeft = ChronoUnit.DAYS.between(currentDate, inputDate);
            log.info("Difference in days is =[" + daysLeft + "] days.");
        }
    }
 */

// OR

/* Call file: start.bat
    cd "C:\Users\ACER\Desktop\my-app"
    javac MyApp.java
    java MyApp
    del MyApp.class
    pause
*/
/* Call file: MyApp.java

import java.time.*;
import java.time.temporal.*;
import java.util.*;
import java.util.regex.*;

public class MyApp {
	
	private static final String DATE_PATTERN = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
	
	public static void main(String[] args) {
		
		final String inputValue = getValueFromConsole();
		final LocalDate inputDate = prepareInputDate(inputValue);
		getDaysToDate(inputDate);
		System.out.println("MyApp is closed...");
	}
	
	private static String getValueFromConsole() {
		System.out.println("Enter date to count how much days left to it (ex.: 2021-10-21)");
		final Scanner scanner = new Scanner(System.in);
		final String inputValue = scanner.next();
		scanner.close();
		return inputValue;
	}
	
	private static LocalDate prepareInputDate(final String inputValue) {
		final LocalDate inputDate;
		if (Pattern.compile(DATE_PATTERN).matcher(inputValue).matches()) {
			inputDate = LocalDate.parse(inputValue);
		} else {
			inputDate = null;
			System.out.println("Your inputValue=[" + inputValue + "]. Try again with proper input format.");
		}
		return inputDate;
	}
	
	
	private static void getDaysToDate(final LocalDate inputDate) {	
		if (inputDate != null) {	
			final LocalDate currentDate = LocalDateTime.now().toLocalDate();
			long daysBetween = ChronoUnit.DAYS.between(currentDate, inputDate);
			System.out.println("Difference between currentDate=[" + currentDate + 
							   "] and inputDate=[" + inputDate + "] is [" + daysBetween + "] days.");
			
		}
	}
}
*/
