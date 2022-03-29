package com.sprint1.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.project.entity.Driver;
//import com.sprint1.project.entity.Cab;
import com.sprint1.project.exception.DriverNotFoundException;
import com.sprint1.project.repository.IDriverRepository;
//import com.sprint1.project.repository.ICabRepository;

@Service
public class IDriverServiceImpl implements IDriverService {

	@Autowired
	IDriverRepository dDao;
	@Override
	public List<Driver> insertDriver(Driver driver) {
		//Driver dri =new Driver();
		//dri.getCab().getCabId();
		dDao.saveAndFlush(driver);
		return dDao.findAll();
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverNotFoundException {
		return dDao.saveAndFlush(driver);
	}

	@Override
	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException {
		dDao.deleteById(driverId);
		return dDao.findAll();
	}

	@Override
	public List<Driver> ViewBestDrivers() throws DriverNotFoundException {
		List<Driver> bestDrivers = dDao.findAll();
		return bestDrivers.stream().filter((d) -> d.getRating() >= 4.5).collect(Collectors.toList());
	}

	@Override
	public Driver viewDriver(int driverId) throws DriverNotFoundException {
		return dDao.findById(driverId).get();
	}
	

}