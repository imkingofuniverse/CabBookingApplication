package com.sprint1.project.service;

import java.util.List;

import com.sprint1.project.entity.Cab;
import com.sprint1.project.exception.CabNotFoundException;

/*/*****************************************************************************
 * ICab Service Class 
 *
 * Created By: Sri Sai Resu
 * Date:18/03/2022 
 *******************************************************************************/

public interface ICabService {

	public Cab insertCab(Cab cab);

	public Cab updateCab(Cab cab);

	public Cab deleteCab(Cab cab) throws CabNotFoundException;

	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;

	public int countCabsOfType(String carType) throws CabNotFoundException;

}