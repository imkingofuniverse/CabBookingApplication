package com.sprint1.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sprint1.project.entity.Admin;


/*/*****************************************************************************
 * IAdmin Repository Class 
 *
 * Created By: NULU SHIVA TEJA & M.YASHWANTH
 * Date:18/03/2022 
 *******************************************************************************/

@Repository
public interface IAdminRepository extends CrudRepository<Admin,Integer>{

}
