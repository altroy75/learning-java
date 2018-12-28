package assignments.issuetracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ConsoleInputProvider implements InputProvider {
	
	//System.console() doesn't work well in IDE and Scanner doesn't work well when reading from console
	
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public String getStringValue(String name, String message) {
		if(message.trim().length()!=0) {
			System.out.print(String.format("Please enter %s (%s):\n>",name, message));
		}else if(name.trim().length()!=0) {
			System.out.print(String.format("Please enter %s:\n>",name));
		}
		
	    try {
	        return input.readLine();
	    } catch (IOException e) {
	        throw new RuntimeException("Unexpected IO Error",e);
	    }
	}

	@Override
	public int getIntValue(String name, String message) {
		int retVal;
		while(true) {
			try {
				String val = getStringValue(name, message);
				retVal = Integer.parseInt(val);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Should be an integer number, please try again");
			}
		}
		return retVal;
	}

	@Override
	public LocalDate getDateValue(String name, String message) {
		LocalDate retVal = null;
		
		while(true) {
			try {
				String val = getStringValue(name, message);
				retVal = LocalDate.parse(val);
				break;
			} catch (DateTimeParseException e) {
				System.out.println("Should be a date. e.g. 2011-12-03, please try again");
			}
		}
		return retVal;
	}

	@Override
	public int getIntValue() {
		return getIntValue("","");
	}

	@Override
	public String getStringValue(String message) {
		System.out.println(message);
	    try {
	        return input.readLine();
	    } catch (IOException e) {
	        throw new RuntimeException("Unexpected IO Error",e);
	    }
	}

}
