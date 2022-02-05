/**
 * 
 */
package com.musala.service;

import java.util.List;

import com.musala.model.Drone;
import com.musala.model.Medication;


/**
 * @author mostafaadel
 *
 */
public interface DroneService {

	public Integer getBatteryLevelByDroneSerialNumber(String serialNumber);

	public Drone getDroneBySerialNumber(String serialNumber);

	public List<Drone> getDronesForLoading();

	public void saveDorne(Drone drone);

	public List<Medication> getMedicationListByDrone(String droneSerialNumber);
}
