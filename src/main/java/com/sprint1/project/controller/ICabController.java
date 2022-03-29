package com.sprint1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.project.entity.Cab;
import com.sprint1.project.exception.CabNotFoundException;
import com.sprint1.project.service.ICabService;


/*/*****************************************************************************
 * ICab Controller Class 
 *
 * Created By: Sri Sai Resu
 * Date:18/03/2022 
 *******************************************************************************/


@RestController
@RequestMapping("/cab")
public class ICabController {

	@Autowired
	ICabService iCabService;
	
	
	/* Method: insertCab
	 * Description: It allows to add the Cab.
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
     */
	

	@PostMapping("/insertCab")
	public ResponseEntity<Cab> addOrder(@RequestBody Cab cab) {
		Cab cabb = iCabService.insertCab(cab);
		return new ResponseEntity(cabb, HttpStatus.OK);

	}
	
	
	/* Method: updateCab
	 * Description: It allows to update the Cab.
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
     */
	

	@PutMapping("/updateCab")
	public ResponseEntity<Cab> updateCab(@RequestBody Cab cab) {
		Cab cabb = iCabService.updateCab(cab);
		return new ResponseEntity(cabb, HttpStatus.OK);
	}
	
	
	/* Method: deleteCab
	 * Description: It allows to delete the Cab.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URL expression.
     */
	

	@DeleteMapping("/deleteCab")
	public ResponseEntity<Cab> deleteCab(@RequestBody Cab cab) throws CabNotFoundException {
		iCabService.deleteCab(cab);
		return new ResponseEntity(cab, HttpStatus.OK);

	}
	
	/* Method: viewCabsOfType
	 * Description: It allows to view the Cabs of specific type.
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
	 * @PathVariable: It is used to handle template variables in the request URL
     */
	

	@GetMapping("/viewCabsOfType/{cname}")
	public ResponseEntity<List<Cab>> viewCabsOfType(@PathVariable String cname) throws CabNotFoundException {
		List<Cab> cab = iCabService.viewCabsOfType(cname);
		return new ResponseEntity(cab, HttpStatus.OK);
	}
	
	
	/* Method: countCabsOfType
	 * Description: It allows to count the Cabs of specific type.
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
	 * @PathVariable: It is used to handle template variables in the request URL
     */
	

	@GetMapping("/countCabsOfType/{cname}")
	public ResponseEntity<Integer> countCabsOfType(@PathVariable String cname) throws CabNotFoundException {
		int cab = iCabService.countCabsOfType(cname);
		return new ResponseEntity(cab, HttpStatus.OK);
	}

}