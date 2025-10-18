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
	}
	
	//Testing the condition in which children cannot be seated in emergency row seating or first class
	@Test
	void childrenSeatingTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1));
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","first",2,1,1));
	}
	
	//Testing the condition where infants cannot be seated in emergency row or business class
	@Test
	void infantSeatingTest() {
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,1,1));
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","business",2,1,1));
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
		//fail("Not yet implemented");
		FlightSearch flight = new FlightSearch();
		assertEquals(true, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","economy",2,4,1));
		assertEquals(false, flight.runFlightSearch("25-12-2025","mel",false,"30-12-2025","syd","business",2,6,1));
	}

	
}
