package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.Treatment;

@Repository
public interface DiagnotisticRepo extends JpaRepository<Treatment, Integer> {

	Treatment findByCheckupName(String checkupname);

}
