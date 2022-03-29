package com.sprint1.project.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.project.entity.Cab;
import com.sprint1.project.exception.CabNotFoundException;
import com.sprint1.project.repository.ICabRepository;


/*/*****************************************************************************
 * ICab ServiceImpl Class 
 *
 * Created By: Sri Sai Resu
 * Date:18/03/2022 
 *******************************************************************************/


@Service
public class ICabServiceImpl implements ICabService {

	@Autowired
	private ICabRepository icabrepository;
	
	
	/* Method: insertCab
	 * Description: It inserts the cab
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the cab. 
     */
	

	@Override
	public Cab insertCab(Cab cabb) {

		Cab cab = new Cab();
		cab.setCabId(cabb.getCabId());
		cab.setCarType(cabb.getCarType());
		cab.setPerKmRate(cabb.getPerKmRate());
		return icabrepository.save(cab);

	}
	
	
	/* Method: updateCab
	 * Description: It updates the cab
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the cab. 
     */
	

	@Override
	public Cab updateCab(Cab cabb) {

		Cab cab = new Cab();
		cab.setCabId(cabb.getCabId());
		cab.setCarType(cabb.getCarType());
		cab.setPerKmRate(cabb.getPerKmRate());
		return icabrepository.save(cab);

	}
	
	
	/* Method: deleteCab
	 * Description: It deletes the cab
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the cab. 
     */
	

	@Override
	public Cab deleteCab(Cab cab) throws CabNotFoundException {

		icabrepository.delete(cab);
		if (cab == null)
			throw new CabNotFoundException("Cab Not Found Exception");
		return cab;

	}
	
	
	/* Method: viewCabsOfType
	 * Description: It finds all the cabs by specific type
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the list of cabs. 
     */
	

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException {

		List<Cab> cab = icabrepository.findAll();

		return cab.stream().filter((d) -> d.getCarType().equalsIgnoreCase(carType)).collect(Collectors.toList());

	}
	
	
	/* Method: viewCabsOfType
	 * Description: It finds the count of all the cabs of specific type
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns count of specific type of the cab. 
     */
	

	@Override
	public int countCabsOfType(String carType) throws CabNotFoundException {
		List<Cab> cab = icabrepository.findAll();
		List<Cab> c = cab.stream().filter((d) -> d.getCarType().equalsIgnoreCase(carType)).collect(Collectors.toList());
		int n = c.size();

		return n;
	}

}