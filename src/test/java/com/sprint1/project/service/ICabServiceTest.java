package com.sprint1.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sprint1.project.entity.Cab;
import com.sprint1.project.repository.ICabRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICabServiceTest {
	
	@InjectMocks
	private ICabServiceImpl icabrepository;
	
	@Mock
	private ICabRepository cabrepository;
	
	public void insertCabTest() {
		
		Cab cab=new Cab();
		cab.setCabId(1);
		cab.setCarType("sedan");
		cab.setPerKmRate(100);
		
		Mockito.doReturn(cab).when(cabrepository).save(Mockito.any());
		assertEquals(cab.getCabId(), icabrepository.insertCab(cab).getCabId());
		assertEquals(cab.getCarType(), icabrepository.insertCab(cab).getCarType());
		assertEquals(cab.getPerKmRate(), icabrepository.insertCab(cab).getPerKmRate());
		

	}
	
	public void updateCabTest() {
		
		Cab cab=new Cab();
		cab.setCabId(1);
		cab.setCarType("sedan");
		cab.setPerKmRate(100);
		
		Mockito.doReturn(cab).when(cabrepository).save(Mockito.any());
		assertEquals(cab.getCabId(), icabrepository.updateCab(cab).getCabId());
		assertEquals(cab.getCarType(), icabrepository.updateCab(cab).getCarType());
		assertEquals(cab.getPerKmRate(), icabrepository.updateCab(cab).getPerKmRate());
		

	}
	
	

}
