package com.sprint1.project.service;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.project.entity.TripBooking;
import com.sprint1.project.repository.ITripBookingRepository;

@Service
public class ITripBookingServiceImpl implements ITripBookingService{
	
	@Autowired
	ITripBookingRepository tbDao;
	
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		tbDao.saveAndFlush(tripBooking);
		return tripBooking;
	}
	
	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		return tbDao.saveAndFlush(tripBooking);
	}
	
	
	
	@Override
	public TripBooking deleteTripBooking(TripBooking tripBooking) {
		tbDao.deleteById(tripBooking.getTripBookingId());
		return tripBooking;
	}
	

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		TypedQuery<TripBooking> q = em.createQuery(
				"select tb from TripBooking tb where tb.customer.customerId=:customerId", TripBooking.class);
		q.setParameter("customerId", customerId);
		List<TripBooking> result = q.getResultList();
		return result;
	}
	
	
	@Override
	public float calculateBill(int customerId) {
		TypedQuery<TripBooking> q = em.createQuery(
				"select tb from TripBooking tb where tb.customer.customerId=:customerId", TripBooking.class);
		q.setParameter("customerId", customerId);
		List<TripBooking> list = q.getResultList();
		Optional<Float> result = list.stream().map((tb) -> tb.getBill()).reduce((a, b) -> a + b);
		return result.get();
	}
	
	
	@Override
	public List<TripBooking> viewAllTripsById(int tripbookingId) {
		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb where tb.tripBookingId=:tripId",
				TripBooking.class);
		q.setParameter("tripId", tripbookingId);
		List<TripBooking> result = q.getResultList();
		return result;
	}
	
	

}