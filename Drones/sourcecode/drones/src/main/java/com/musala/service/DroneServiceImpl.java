package com.musala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musala.entity.DroneEntity;
import com.musala.enums.State;
import com.musala.exception.DroneNotFoundException;
import com.musala.model.Drone;
import com.musala.model.Medication;
import com.musala.repository.DroneRepository;
import com.musala.validator.DroneValidator;
import java.util.Collections;

@Service
public class DroneServiceImpl implements DroneService {

	@Autowired
	DroneRepository repository;
	@Override
	public Integer getBatteryLevelByDroneSerialNumber(String serialNumber) {
		
		DroneEntity drone = repository.getBySerialNumber(serialNumber);
		
		return drone.getBatteryCapacity();
	}

	@Override
	public Drone getDroneBySerialNumber(String serialNumber) {
		DroneEntity droneEntity = repository.getBySerialNumber(serialNumber);
		if(droneEntity == null)
			throw new DroneNotFoundException("Drone with Serial Number " +serialNumber + " is not found");
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		return mapper.convertValue(droneEntity, Drone.class);
	}

	@Override
	public List<Drone> getDronesForLoading() {
		List<DroneEntity> dronesEntities = repository.getByState(State.IDLE);
		if(!dronesEntities.isEmpty()) {
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			return mapper.convertValue(dronesEntities, new TypeReference<List<Drone>>(){});
			}
		
		return Collections.emptyList();
	}

	@Override
	public void saveDorne(com.musala.model.Drone drone) {
		DroneValidator.validateDrone(drone);
		ObjectMapper mapper = new ObjectMapper();
		DroneEntity droneEntity = mapper.convertValue(drone, DroneEntity.class);
		repository.save(droneEntity);
	}

	@Override
	public List<Medication> getMedicationListByDrone(String droneSerialNumber) {
		DroneEntity drone = repository.getBySerialNumber(droneSerialNumber);
		if(drone != null) {
		if(!drone.getMedications().isEmpty()) {
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			return mapper.convertValue(drone.getMedications(), new TypeReference<List<Medication>>(){});
			}
		
		return Collections.emptyList();
	}
		throw new DroneNotFoundException("Drone with Serial Number " +droneSerialNumber + " is not found");
	}
	

}
