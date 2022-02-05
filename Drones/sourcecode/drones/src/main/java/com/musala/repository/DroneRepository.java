package com.musala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musala.entity.DroneEntity;
import com.musala.enums.State;

@Repository
public interface DroneRepository extends JpaRepository<DroneEntity, String>{

	DroneEntity getBySerialNumber(String serialNumber);

	List<DroneEntity> getByState(State state);

	
}
