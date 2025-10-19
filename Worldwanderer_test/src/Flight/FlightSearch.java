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
	private boolean isDepAvailable;
	private boolean isDesAvailable;
	public boolean runFlightSearch(String departureDate, String
	departureAirportCode, boolean emergencyRowSeating,
	String returnDate, String
	destinationAirportCode, String seatingClass,
	int adultPassengerCount, int childPassengerCount,
	int infantPassengerCount) {
	boolean valid = true;
	
	
	
	
	//TODO: Validate all the provided parameters.
	// Total passenger count must be between 1 and 9 inclusive 
	int totalPassengerCount;
	totalPassengerCount = adultPassengerCount + childPassengerCount + infantPassengerCount; 
	if (totalPassengerCount < 1 || totalPassengerCount > 9) {
		return false;    
	}
	
	//Children cannot be in emergency rows nor first class
	if ((childPassengerCount > 0 && emergencyRowSeating == true) || (childPassengerCount > 0 && seatingClass.equals("first")) ) {
		return false;
	}
	
	//Infants cannot be in emergency rows nor business class
	if ((infantPassengerCount > 0 && emergencyRowSeating == true) || (infantPassengerCount > 0 && seatingClass.equals("business")) ) {
		return false;
	}
	//child passenger count should be less than or equal to adult passenger count (example: if the child passenger count is 4 adult passenger count should be at least 2)
	if(childPassengerCount > adultPassengerCount * 2 ) {
		return false;
	}
	//One infant per adult
	if (infantPassengerCount > adultPassengerCount) {
		return false;
	}
	
	
	//Dates must be STRICTLY validated in DD/MM/YYYY format and real
    //       calendar dates
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);

    LocalDate departDate; 
    LocalDate retDate;
    LocalDate now = LocalDate.now();
    
   
     try {
		  departDate = LocalDate.parse(departureDate, formatter);
		  retDate = LocalDate.parse(returnDate, formatter);
		    	    	  
	} catch (DateTimeParseException e) {
		   return false;
		   }
    
    //Departure date cannot be on the past 
    if (departDate.isBefore(now)) {
	   return false;
	}
    
    //Departure cannot be before "today"
    
    if (retDate.isBefore(departDate)) {
    	return false;
    }
    
    // Seating class must be one of the allowed values ("economy", "premium economy", "business", "first").
    if(!seatingClass.equals("economy") && !seatingClass.equals("premium economy") && !seatingClass.equals("business") && !seatingClass.equals("first")) {
    	return false;
    }
    
    //Only ECONOMY can have emergency row seating
    if(!seatingClass.equals("economy") && emergencyRowSeating == true) {
    	return false;
    }
    
    //if () {
    	
    //}
    //Departure and destination cannot be the same airport.                                                                                                                                                                                                                       
    
    if(departureAirportCode.equals(destinationAirportCode)) {
  	  return false;
    }
    
    //Only specific airports are available:
        //   "syd", "mel", "lax", "cdg", "del", "pvg", "doh"
    
    String[] airports = {"syd", "mel", "lax", "cdg", "del", "pvg", "doh"};
    
    isDepAvailable = false;
    isDesAvailable = false;
    
          
          for(int i = 0; i < airports.length; ++i) {
        	  if(departureAirportCode.equals(airports[i])) {
        		  isDepAvailable = true;
        	  }
        	  if(destinationAirportCode.equals(airports[i])) {
        		  isDesAvailable = true;
        	  }
          }
          
          if(!isDepAvailable || !isDesAvailable) {
        	  return false;
          }
	
	//if the search parameters meets the given conditions,
	// the function should initialize all the class attributes and return true.
	//else
	// the function should return false
    
    //Initializing class attributes
          this.departureDate = departureDate;
          this.departureAirportCode = departureAirportCode;
          this.emergencyRowSeating = emergencyRowSeating;
          this.returnDate = returnDate;
          this.destinationAirportCode = destinationAirportCode;
          this.seatingClass = seatingClass;
          this.adultPassengerCount = adultPassengerCount;
          this.childPassengerCount = childPassengerCount;
          this.infantPassengerCount = infantPassengerCount;
          
	return valid;
	}
	
	
	//Access methods
	public String getDepartureDate() {
	    return departureDate;
	}	
	                                                           
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}
	
	public boolean getEmergencyRowSeating() {
	    return emergencyRowSeating;
    }
    
	public String getReturnDate() {
	    return returnDate;
	}
	
    public String getDestinationAirportCode() {
    	return destinationAirportCode;
    }
			
    public String getSeatingClass() {
    	return seatingClass;
    }
    
    public int getAdultPassengerCount() {
    	return adultPassengerCount;
    }
    
    public int getChildPassengerCount() {
    	return childPassengerCount;
    }
    
    public int GetInfantPassengerCount() {
    	return infantPassengerCount;
    }
			
    
	
	}



