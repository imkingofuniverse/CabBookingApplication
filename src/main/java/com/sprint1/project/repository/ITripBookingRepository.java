package com.sprint1.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.sprint1.project.service.ITripBookingDao;
import com.sprint1.project.entity.TripBooking;

//@Repository("tbDao")
@Repository
public interface ITripBookingRepository  extends JpaRepository<TripBooking, Integer> {
	
	

}