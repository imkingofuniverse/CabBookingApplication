package com.sprint1.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.project.entity.Cab;


/*/*****************************************************************************
 * ICab Repository Class 
 *
 * Created By: Sri Sai Resu
 * Date:18/03/2022 
 *******************************************************************************/

@Repository
public interface ICabRepository extends JpaRepository<Cab, Integer> {
	
}