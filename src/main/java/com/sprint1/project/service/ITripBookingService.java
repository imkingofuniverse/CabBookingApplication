package com.sprint1.project.service;

import java.util.List;

import com.sprint1.project.entity.TripBooking;


public interface ITripBookingService {
	
	public TripBooking insertTripBooking(TripBooking tripBooking);

	public TripBooking updateTripBooking(TripBooking tripBooking);

	public TripBooking deleteTripBooking(TripBooking tripBooking);

	public List<TripBooking> viewAllTripsCustomer(int customerId);

	public float calculateBill(int customerId);

	public List<TripBooking> viewAllTripsById(int tripbookingId);

}