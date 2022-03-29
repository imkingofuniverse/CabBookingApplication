package com.sprint1.project.entity;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="cab")
public class Cab {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int cabId;
	private String carType;
	private float perKmRate;
	@OneToOne
	@JoinColumn(name="driverId")
    private Driver driver;
	
	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cab(int cabId, String carType, float perKmRate) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
	}


	public int getCabId() {
		return cabId;
	}


	public void setCabId(int cabId) {
		this.cabId = cabId;
	}


	public String getCarType() {
		return carType;
	}


	public void setCarType(String carType) {
		this.carType = carType;
	}


	public float getPerKmRate() {
		return perKmRate;
	}


	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	

}