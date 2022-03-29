package com.sprint1.project.service;

import java.time.LocalDateTime;
//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.project.entity.Admin;
import com.sprint1.project.entity.TripBooking;
import com.sprint1.project.exception.AdminNotFoundException;
//import com.sprint1.project.entity.Cab;
//import com.sprint1.project.entity.Driver;
import com.sprint1.project.exception.CustomerNotFoundException;
import com.sprint1.project.repository.IAdminRepository;



/*/*****************************************************************************
 * IAdmin Service Class 
 *
 * Created By: NULU SHIVA TEJA & M.YASHWANTH
 * Date:18/03/2022 
 *******************************************************************************/

@Service
public class IAdminService {
	@Autowired
	IAdminRepository aDao;
	@PersistenceContext
	EntityManager em;
	/*
	public List<Admin> viewAllAdmin() {
		List<Admin> allAdmins = new ArrayList<>();
		Iterable<Admin> admins=aDao.findAll();
		for(Admin admin:admins) {
			allAdmins.add(admin);
		}
		return allAdmins;
	}
	*/
	public Admin insertAdmin(Admin admin) {
		aDao.save(admin);
		return admin;
	}
	
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException {
		
		Admin ad=aDao.save(admin);
		if(ad==null) {
		throw new AdminNotFoundException("Admin Not Found to Update");
		}
		return admin;
	}
	public Admin deleteAdmin(int adminId) {
		/*List<Admin> deletedadmins= new ArrayList<>();
		Iterable<Admin> admins=aDao.findAll();
		for(Admin adminId:admins) {
			deletedadmins.remove(adminId);
		}
		return deletedadmins;
		*/
		Admin ad=aDao.findById(adminId).get();
		aDao.deleteById(adminId);
		return ad;
	}
	
	public Admin getAdminById(int adminId) throws AdminNotFoundException {
		Admin a=aDao.findById(adminId).get();
		if(a==null) {
		throw new AdminNotFoundException("Admin not found!");
		}
		return a;
	}
	
	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException{
		TypedQuery<TripBooking> q=em.createQuery("select e from TripBooking e where e.customer.customerId=:cId",TripBooking.class);
		q.setParameter("cId",customerId);
		List<TripBooking> res=q.getResultList();
		if(res.isEmpty()) {
		throw new CustomerNotFoundException("Not found the customer");
		}
		return res;
	}
	public List<TripBooking> getTripsCabwise(){
		TypedQuery<TripBooking> q=em.createQuery("select e from TripBooking e",TripBooking.class);
		List<TripBooking> res=q.getResultList();
		res.stream().sorted((a,b)-> a.getDriver().getCab().getCabId() - b.getDriver().getCab().getCabId()).collect(Collectors.toList());
		return res;
	}
	public List<TripBooking> getTripsCustomerwise(){
		TypedQuery<TripBooking> q=em.createQuery("select e from TripBooking e",TripBooking.class);
		List<TripBooking> res=q.getResultList();
		res.stream().sorted((a,b)->a.getCustomer().getCustomerId() - b.getCustomer().getCustomerId()).collect(Collectors.toList());
		return res;
	}
	public List<TripBooking> getTripsDatewise(){
		TypedQuery<TripBooking> q=em.createQuery("select e from TripBooking e",TripBooking.class);
		List<TripBooking> res=q.getResultList();
		res.stream().sorted((a,b)-> a.getFromDateTime().compareTo(b.getFromDateTime())).collect(Collectors.toList());
		return res;
	}
	public List<TripBooking> getAllTripsForDays(int customerId,LocalDateTime fromDate,LocalDateTime toDate) throws CustomerNotFoundException{
		TypedQuery<TripBooking>q=em.createQuery("select e from TripBooking e where e.customer.customerId=:cId where e.fromDateTime from :start and :end",TripBooking.class);
		q.setParameter("cId",customerId);
		q.setParameter("start",fromDate);
		q.setParameter("end",toDate);
		List<TripBooking> res=q.getResultList();
		return res;
	}
}