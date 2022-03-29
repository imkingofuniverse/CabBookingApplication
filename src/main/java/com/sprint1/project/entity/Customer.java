package com.sprint1.project.entity;

import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer extends AbstractUser {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	@OneToOne
	@JoinColumn(name="tripBookingId")
	private TripBooking tripBooking;
	public TripBooking getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(TripBooking tripBooking) {
		this.tripBooking = tripBooking;
	}

	@Override
	public String toString() {
		return "customerId=" + customerId + " getUsername=" + getUsername() + " getPassword="
				+ getPassword() + " getMobileNumber=" + getMobileNumber() + " getEmail=" + getEmail();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Customer() {

	}

	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}

}