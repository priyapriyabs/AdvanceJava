package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanka.dto.HistoryDTO;

@Repository
public interface HistoryDTORepo extends JpaRepository<HistoryDTO, Integer>{

}
