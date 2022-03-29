package com.sprint1.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.project.entity.Driver;

@Repository
public interface IDriverRepository extends JpaRepository<Driver, Integer> {

}