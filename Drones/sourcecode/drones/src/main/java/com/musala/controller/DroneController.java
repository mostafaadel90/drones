/**
 * 
 */
package com.musala.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.musala.api.DroneApi;
import com.musala.model.Drone;
import com.musala.service.DroneService;

/**
 * @author mostafaadel
 *
 */
@RestController
public class DroneController implements DroneApi {

	@Autowired
	
	DroneService  service;
	
	@Override
	public ResponseEntity<Integer> getBatteryLevelByDroneSerialNumber(String serialNumber) {
		
			Integer batteryLevel = service.getBatteryLevelByDroneSerialNumber(serialNumber);
			
		return new ResponseEntity<>(batteryLevel, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Drone> getDroneBySerialNumber(String serialNumber) {
		Drone drone = service.getDroneBySerialNumber(serialNumber);
		return new ResponseEntity<>(drone, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Drone>> getDronesForLoading() {
		List<Drone> drones = service.getDronesForLoading();
		return new ResponseEntity<>(drones, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> postDrone(@Valid Drone drone) {
		service.saveDorne(drone);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}


}
