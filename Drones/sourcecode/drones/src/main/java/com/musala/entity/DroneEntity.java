/**
 * 
 */
package com.musala.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import com.musala.enums.Model;
import com.musala.enums.State;

/**
 * @author mostafaadel
 *
 */
@Entity
@Table(name = "Drone")
public class DroneEntity {
	@Id
	@Max(value = 100,message="Max serial Number length is: 100")
	String serialNumber;
	Model model;
	BigInteger weight;
	Integer batteryCapacity;
	State state;
	@OneToMany(targetEntity = Medication.class,cascade =  CascadeType.ALL)
	List<Medication> medications;

public DroneEntity() {
}

	public DroneEntity(@Max(value = 100, message = "Max serial Number length is: 100") String serialNumber, Model model,
		BigInteger weight, Integer batteryCapacity, State state, List<Medication> medications) {
	this.serialNumber = serialNumber;
	this.model = model;
	this.weight = weight;
	this.batteryCapacity = batteryCapacity;
	this.state = state;
	this.medications = medications;
}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	@Max(value = 500,message="Max Drone Weight is : 500")
	public BigInteger getWeight() {
		return weight;
	}

	public void setWeight(BigInteger weight) {
		this.weight = weight;
	}

	public Integer getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(Integer batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Medication> getMedications() {
		return medications;
	}

	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}

}
