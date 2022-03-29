package com.sprint1.project.service;

import java.util.List;

import com.sprint1.project.entity.Driver;
import com.sprint1.project.exception.DriverNotFoundException;

public interface IDriverService {

	public List<Driver> insertDriver(Driver driver);
	
	public Driver updateDriver(Driver driver) throws DriverNotFoundException;
	
	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException;
	
	public List<Driver> ViewBestDrivers() throws DriverNotFoundException;
	
	public Driver viewDriver(int driverId) throws DriverNotFoundException;
}