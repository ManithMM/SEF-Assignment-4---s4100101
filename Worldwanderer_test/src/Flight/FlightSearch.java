package Flight;
import java.time.LocalTime;
import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class FlightSearch {
	
	private String departureDate;
	private String departureAirportCode;
	private boolean emergencyRowSeating;
	private String returnDate;
	private String destinationAirportCode;
	private String seatingClass;
	private int adultPassengerCount;
	private int childPassengerCount;
	private int infantPassengerCount;
	public boolean runFlightSearch(String departureDate, String
	departureAirportCode, boolean emergencyRowSeating,
	String returnDate, String
	destinationAirportCode, String seatingClass,
	int adultPassengerCount, int childPassengerCount,
	int infantPassengerCount) {
	boolean valid = true;
	
	
	//TODO: Validate all the provided parameters.
	int totalPassengerCount;
	totalPassengerCount = adultPassengerCount + childPassengerCount + infantPassengerCount;
	if (totalPassengerCount < 1 || totalPassengerCount > 9) {
		return false;    
	}
	
	if ((childPassengerCount > 0 && emergencyRowSeating == true) || (childPassengerCount > 0 && seatingClass.equals("first")) ) {
		return false;
	}
	
	if ((infantPassengerCount > 0 && emergencyRowSeating == true) || (infantPassengerCount > 0 && seatingClass.equals("business")) ) {
		return false;
	}
	
	if(childPassengerCount > adultPassengerCount * 2 ) {
		return false;
	}
	
	if (infantPassengerCount > adultPassengerCount) {
		return false;
	}
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy").withResolverStyle(ResolverStyle.STRICT);
;
    LocalDate departDate; 
    LocalDate retDate;
    LocalDate now = LocalDate.now();
    
   
     try {
		  departDate = LocalDate.parse(departureDate, formatter);
		  retDate = LocalDate.parse(returnDate, formatter);
		    	    	  
	} catch (DateTimeParseException e) {
		   return false;
		   }
    
     
    if (departDate.isBefore(now)) {
	   return false;
	}
    
    if (retDate.isBefore(departDate)) {
    	return false;
    }
    
    if(!seatingClass.equals("economy") && !seatingClass.equals("premium economy") && !seatingClass.equals("business") && !seatingClass.equals("first")) {
    	return false;
    }
    
    if(!seatingClass.equals("economy") && emergencyRowSeating == true) {
    	return false;
    }
    
    //if () {
    	
    //}
    
    if (!departureAirportCode.equals(destinationAirportCode)) {
    	return false;
    }
    
    
    
    
    
    
    
    
    
    
	
    
	
	
	
	
	//if the search parameters meets the given conditions,
	// the function should initialize all the class attributes and return true.
	//else
	// the function should return false
	return valid;
	}
	}



