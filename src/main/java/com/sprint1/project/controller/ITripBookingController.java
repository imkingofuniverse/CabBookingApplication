package com.sprint1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.project.entity.Customer;
import com.sprint1.project.entity.TripBooking;
import com.sprint1.project.service.ITripBookingService;

@RestController
@RequestMapping("/tripbooking")
public class ITripBookingController {
	@Autowired
	ITripBookingService itbs;

	//done
	@PostMapping("/insert")
	public TripBooking insertTripBooking(@RequestBody TripBooking tripBooking) {
		return itbs.insertTripBooking(tripBooking);
	}

	

	@PutMapping("/update")
	public TripBooking updateTripBooking(@RequestBody TripBooking tripBooking) {
		return itbs.updateTripBooking(tripBooking);
	}

	

	@DeleteMapping("/delete")
	public TripBooking deleteTripBooking(@RequestBody TripBooking tripBooking) {
		return itbs.deleteTripBooking(tripBooking);
	}

	
	//not came  /looping
	@GetMapping("/all/{customerId}")
	public List<TripBooking> viewAllTripsCustomer(@PathVariable int customerId) {
		return itbs.viewAllTripsCustomer(customerId);
	}

	//done
	@GetMapping("/calculate/{customerId}")
	public float calculateBill(@PathVariable int customerId) {
		return itbs.calculateBill(customerId);
	}

	//not came /looping
	@GetMapping("/ById/{tripBookingId}")
	public List<TripBooking> viewAllTripsById(@PathVariable int tripBookingId) {
		return itbs.viewAllTripsById(tripBookingId);
	}
	

}