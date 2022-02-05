/**
 * 
 */
package com.musala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.musala.api.MedicationApi;
import com.musala.model.Medication;
import com.musala.service.DroneService;


/**
 * @author mostafaadel
 *
 */
@RestController
public class MedicationController implements MedicationApi {

	@Autowired
	
	DroneService  service;
	
	@Override
	public ResponseEntity<List<Medication>> getMedicationListByDrone(String droneSerialNumber) {
		List<Medication> medictions = service.getMedicationListByDrone(droneSerialNumber);
		
		return new ResponseEntity<>(medictions, HttpStatus.OK);
	}


}
