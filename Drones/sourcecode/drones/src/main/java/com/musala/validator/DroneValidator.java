/**
 * 
 */
package com.musala.validator;

import java.util.List;

import javax.validation.Valid;

import com.musala.exception.DroneBadRequestException;
import com.musala.model.Drone;
import com.musala.model.Drone.StateEnum;
import com.musala.model.Medication;

/**
 * @author mostafaadel
 *
 */
public class DroneValidator {

	private DroneValidator() {

	}

	public static void validateDrone(Drone drone) {
		if (drone.getSerialNumber().length() > 100) {
			throw new DroneBadRequestException("Serial Number Maximum length is: 100");
		}

		if (drone.getWeight() > 500) {
			throw new DroneBadRequestException("Drone Weight Maximum is: 500gr");
		}

		if (drone.getBatteryCapacity() > 100) {
			throw new DroneBadRequestException("Drone battery capacity can not be greater than 100%");
		}
		if(drone.getState() == StateEnum.LOADED && drone.getWeight() > 500) {
			throw new DroneBadRequestException("Drone Can't be in Loaded state because of drone's weight is greater than 500gr");
		}
		
		if(drone.getState() == StateEnum.LOADING && drone.getBatteryCapacity() < 25) {
			throw new DroneBadRequestException("Drone Can't be in Loading state because of drone's battery capacity is lower than 25%");
		}
		
		validateMedications(drone.getMedications());
	}

	private static void validateMedications(@Valid List<Medication> medications) {
		if (!medications.isEmpty()) {
			for (Medication medication : medications) {
				if (!medication.getName().matches("([A-Za-z0-9\\-\\_]+)")) {
					throw new DroneBadRequestException("Medication Name should be Latters,Numbers,'-', and '_' Only:"
							+ medication.getName() + " is Not Valid");
				}
				
				if (!medication.getCode().matches("([A-Z0-9\\_]+)")) {
					throw new DroneBadRequestException("Medication Code should be upper case letters, underscore and numbers only:"
							+ medication.getCode() + " is Not Valid");
				}
			}
		}
	}
}
