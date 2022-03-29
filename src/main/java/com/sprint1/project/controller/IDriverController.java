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

import com.sprint1.project.entity.Driver;
import com.sprint1.project.exception.DriverNotFoundException;
import com.sprint1.project.service.IDriverService;

@RestController
@RequestMapping("/driver")
public class IDriverController {
	
	@Autowired
	IDriverService ids;
	
	/*
	 * @Autowired LoginService ls;
	 * 
	 * @PostMapping("/login") public String validateDriver(@RequestBody Driver
	 * driver) throws InvalidUserOrPasswordException { String response; try {
	 * response = ls.validateCredintials(driver); } catch (Exception e) { throw new
	 * InvalidUserOrPasswordException("Invalid Username/Password"); } return
	 * response; }
	 */ 
	//Remove Block Comment and press ctrl+shift+f
	
//INSERT DRIVER=======================================================================
	@PostMapping(path="/insert")
	public List<Driver> insertDriver(@RequestBody Driver driver){
		return ids.insertDriver(driver);
	}
	
//UPDATE DRIVER=======================================================================
	@PutMapping("/updateDriver")
	public Driver updateDriver(@RequestBody Driver driver) throws DriverNotFoundException {
		Driver d=null;
		try {
			d= ids.updateDriver(driver);
		}
		catch(Exception e) {
			throw new DriverNotFoundException("Driver Not Found to update");
		}
		return d;
	}
	
	
//DELETE DRIVER========================================================================
	@DeleteMapping("/{driverId}")
	public List<Driver> deleteDriver(@PathVariable int driverId) throws DriverNotFoundException {
		List<Driver> d = null;
		try {
			d=ids.deleteDriver(driverId);
		}catch(Exception e) {
			throw new DriverNotFoundException("Driver with id "+ driverId+" not found");
		}
		
		return d;
	}
	
//VIEW BEST DRIVERS========================================================================
	@GetMapping("/bestdrivers")
	public List<Driver> viewBestDriver() throws DriverNotFoundException {
		List<Driver> d = null;
		try {
			d=ids.ViewBestDrivers();
		} catch(Exception e) {
			throw new DriverNotFoundException("Divers not found");
		}
		return d;
	}
	
//VIEW DRIVER===============================================================================
	@GetMapping("/{driverId}")
	public Driver viewDriver(@PathVariable int driverId) throws DriverNotFoundException {
		Driver d = null;
		try {
			d=ids.viewDriver(driverId);
		} catch (Exception e) {
			throw new DriverNotFoundException("Driver not found");
		}
		return d;
		
	}
	

}