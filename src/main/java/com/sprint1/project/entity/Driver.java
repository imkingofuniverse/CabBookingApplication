package com.sprint1.project.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="driver")
public class Driver {


	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int driverId;
	private String licenceNo;
	private float rating;
	private String username;
	private String password;
	private String address;
	private long mobilenumber;
	private String email;
	@OneToOne 
	@JoinColumn(name= "cabId")
	private Cab cab;
	//@OneToMany(mappedBy="driver")
	/*private List<TripBooking> tripBooking;
	public List<TripBooking> getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(List<TripBooking> tripBooking) {
		this.tripBooking = tripBooking;
	}
	*/
	public Driver() {
		
	}
	
	public Driver(int driverId, String licenceNo, float rating, String username, String password, String address,
			long mobilenumber, String email,Cab cab) {
		super();
		this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.rating = rating;
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.cab=cab;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cab getCab() { 
	 		return cab; 
	} 
	public void setCab(Cab cab) { 
	 		this.cab = cab; 
	}

}