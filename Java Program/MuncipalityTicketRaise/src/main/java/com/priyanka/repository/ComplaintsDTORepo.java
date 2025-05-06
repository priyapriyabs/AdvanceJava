package com.priyanka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.priyanka.dto.ComplaintsDTO;

@Repository
public interface ComplaintsDTORepo extends JpaRepository<ComplaintsDTO, Integer> {

	@Query("select c FROM ComplaintsDTO c WHERE c.userId = :userId AND c.status = :status")
	List<ComplaintsDTO> findByUserIdAndStatus(@Param("userId") int userId, @Param("status") String status);

	@Query("select c from ComplaintsDTO c where c.departmentId in "+"(select d.departmentId from DepartmentDTO  d where d.departmentName=:departmentName)")
    List<ComplaintsDTO>  findByDepartmentName(@Param("departmentName")String departmentName);

	@Query("select c from ComplaintsDTO c where c.userId=:userId")
	List<ComplaintsDTO> findComplaintByUserId(@Param("userId") int userId);

	@Query("select c from ComplaintsDTO c where c.type=:type and c.area=:area")
	List<ComplaintsDTO> searchComplaintsByTypeOrArea(@Param("type")String type,@Param("area") String area);

}
