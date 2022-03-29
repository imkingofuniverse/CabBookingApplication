package com.sprint1.project.controller;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.project.entity.Admin;
import com.sprint1.project.entity.Customer;
import com.sprint1.project.entity.TripBooking;
import com.sprint1.project.exception.AdminNotFoundException;
import com.sprint1.project.exception.CustomerNotFoundException;
import com.sprint1.project.service.IAdminService;
import com.sprint1.project.service.ICustomerService;


/*/*****************************************************************************
 * IAdmin Controller Class 
 *
 * Created By: NULU SHIVA TEJA & M.YASHWANTH
 * Date:18/03/2022 
 *******************************************************************************/


@RestController
@RequestMapping("/AdminController")
public class IAdminController {
	@Autowired
	IAdminService ias;
	@Autowired
	ICustomerService  ics;
	
	/*@GetMapping("/viewAllAdmin")
	public List<Admin> viewAllAdmin() {
		return ias.viewAllAdmin();
	}*/
	//INSERT ADMIN=======================================================================	
	@PostMapping("/insertAdmin")//done
	public Admin insertAdmin(@RequestBody Admin admin) {
		return ias.insertAdmin(admin);
	}
	//DELETE ADMIN=======================================================================	
	@DeleteMapping("deleteAdmin/{adminId}")//done
	public Admin deleteAdmin(@PathVariable int adminId) {
		Admin s = new Admin();
		s = ias.deleteAdmin(adminId);
		return s;
	}
	//UPDATE ADMIN=======================================================================	
	@PutMapping("updateAdmin")//done
	public Admin updateAdmin(@RequestBody Admin admin) {
		Admin a = null;

		try {
			//a = ias.getAdminById(admin.getAdminId());
			a=ias.updateAdmin(admin);
		} catch (AdminNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return a;
	}
	//GET ADMIN BY ID=======================================================================	
	@GetMapping("/getAdminById/{adminId}")//done
	public Admin GetAdminById(@PathVariable int adminId) {
		Admin a = null;

		try {
			a = ias.getAdminById(adminId);

		} catch (AdminNotFoundException  e) {
			System.out.println(e.getMessage());
		}
		return a;
	}
	//GET ALL TRIPS=======================================================================
	@GetMapping("/allTrips/{customerId}")//done
	public List<TripBooking> getAllTrips(@PathVariable int customerId) {
		List<TripBooking> l=null;
		Customer c=null;
		try{
			//c=ics.viewCustomer(customerId);
			l=ias.getAllTrips(customerId);
		}
		catch(CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return l;
	}
	//GET ALL TRIPS CABWISE=======================================================================	
	@GetMapping("/allTripsCab")//done
	public List<TripBooking> getTripsCabwise(){
		return ias.getTripsCabwise();
	}
	//GET ALL TRIPS CUSTOMER WISE=======================================================================	
	@GetMapping("/allTripsCustomer")//done
	public List<TripBooking> getTripsCustomerwise(){
		return ias.getTripsCustomerwise();
	}
	//GET ALL TRIPS DATE WISE=======================================================================	
	@GetMapping("/allTripsDate")
	public List<TripBooking> getTripsDatewise(){
		return ias.getTripsDatewise();
	}
	//GET ALL TRIPS DAY WISE=======================================================================	
	@GetMapping("/allTripsDays/{customerId}/{fromDate}/{Todate}")
	public List<TripBooking> getAllTripsForDays(@PathVariable("customerId") int customerId,@PathVariable("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime fromDate,@PathVariable("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")  LocalDateTime toDate) throws CustomerNotFoundException{
		return ias.getAllTripsForDays(customerId,fromDate,toDate);
	}
}
