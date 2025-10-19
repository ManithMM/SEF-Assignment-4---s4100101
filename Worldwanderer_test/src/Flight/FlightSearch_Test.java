package Flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FlightSearch_Test {
	
	

	//Testing the condition where the passenger count must be at least 1 and cannot exceed 9. 
	@Test
	void passengerCountTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1));
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",12,1,1));
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",0,0,0));
	}
	
	//Testing the condition in which children cannot be seated in emergency row seating or first class
	@Test
	void childrenSeatingTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1));
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","first",2,1,1)); //first class
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",true,"30-12-2025","syd","economy",2,1,1)); // emergency row
	}
	
	//Testing the condition where infants cannot be seated in emergency row or business class
	@Test
	void infantSeatingTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1));
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","business",2,1,1)); //business class
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","business",2,1,1)); //emergency row
	}
	
	//Testing the condition where the child passenger count should be less than or equal to adult passenger count (example: if the child passenger count is 4 adult passenger count should be at least 2)
	@Test
	void childrenToAdultRatioTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,4,1));
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","business",2,6,1));
	}
	
	//Testing the condition where the infant passenger count should be less than or equal to the adult passenger count (only one infant allowed per adult)
	@Test
	void infantToAdultRatioTest() {
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",3,1,3)); //number of infants equal to number of infants
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",3,1,2)); //number of infants less than number of adults
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","business",4,1,6)); //number of infants  greater than number of adults
	}
	
	//Testing the condition where the departure date must not be in the past (must be a date after the current date in which the runSearchFlight method is being called)
	@Test
	void departureDateTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1));
		assertEquals(false, flight.runFlightSearch("25-08-2025","mel",false,"30-12-2025","syd","economy",2,1,1)); //return date in August 2025
	}
	
	//Testing the condition where the dates must be in the format DD/MM/YYYY 
	@Test
	void dateFormatTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1)); 
		assertEquals(false, flight.runFlightSearch("12-25-2025","mel",false,"2025-12-30","syd","first",2,1,1)); //dates not in DD/MM/YYYY format
		assertEquals(false, flight.runFlightSearch("29/02/2026","mel",false,"15-03-2026","syd","economy",2,1,1));//invalid departure date(not a leap year)
	}
	
	//Testing the condition where the return date must be after the departure date
	@Test
	void departReturnComaparisonTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1));
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"23-12-2025","syd","first",2,1,1)); //return date before the departure date
	}
	
	//Testing the condition where the seating class must be one of ("economy', "premium economy", "business", "first")
	@Test
	void seatingClassTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1));
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","first",2,0,0)); //premium economy class
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","third",2,1,1)); //unidentified class
	}

	//Testing the condition where only economy class seating can have emergency row
	@Test
	void emergencyRowTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",true,"30-12-2025","syd","economy",2,0,0));
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",true,"30-12-2025","syd","first",2,1,1)); //first class
	}
	
	//Testing the condition where the only available airports are, ("syd", "mel", "lax", "cdg", "del", "pvg", "doh")
	@Test
	void availableAirportsTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1));
		assertEquals(false, flight.runFlightSearch("25-12-2025","sin",false,"30-12-2025","syd","economy",2,1,1)); //Unavailable airport
	}
	
	//Testing the condition where the departure airport cannot be the destination airport
    @Test
	void departDestAirportTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1));
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","mel","economy",2,1,1)); 
	}
    
    //Testing all the conditions to be true
    @Test
	void finalValidityTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1));
		assertEquals(true, flight.runFlightSearch("20-11-2025","mel",true,"05-12-2025","lax","economy",1,0,0));
		assertEquals(true, flight.runFlightSearch("10-01-2026","syd",false,"25-01-2026","cdg","premium economy",3,4,2));
		assertEquals(true, flight.runFlightSearch("15-02-2026","del",false,"28-02-2026","pvg","business",2,2,0));

		 
	}
    
    
  
    
 
    
    //Testing for correct initialization
    @Test
    void correctInitialization() {
    	FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","lax",false,"30-12-2025","syd","economy",3,1,1));
		assertEquals("25-12-2025", flight.getDepartureDate());
		assertEquals("lax", flight.getDepartureAirportCode());
		assertEquals(false, flight.getEmergencyRowSeating());
		assertEquals("30-12-2025", flight.getReturnDate());
		assertEquals("syd", flight.getDestinationAirportCode());
		assertEquals("economy", flight.getSeatingClass());
		assertEquals(3, flight.getAdultPassengerCount());
		assertEquals(1, flight.getChildPassengerCount());
		assertEquals(1, flight.GetInfantPassengerCount());
		
		
    }
	
    
    
    
    
	
	
}
