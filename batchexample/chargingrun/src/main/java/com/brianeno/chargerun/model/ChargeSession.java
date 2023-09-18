/*
 * Copyright 2019 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.brianeno.chargerun.model;

public class ChargeSession {

	private Long id;

	private String firstName;

	private String lastName;

	private Long wattUsage;

	private Long minutes;

	private Double billAmount;

	public ChargeSession(Long id, String firstName, String lastName, Long wattUsage, Long minutes, Double billAmount) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.wattUsage = wattUsage;
		this.minutes = minutes;
		this.billAmount = billAmount;
		this.id = id;
	}

	public ChargeSession() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getWattUsage() {
		return wattUsage;
	}

	public void setWattUsage(Long wattUsage) {
		this.wattUsage = wattUsage;
	}

	public Long getMinutes() {
		return minutes;
	}

	public void setMinutes(Long minutes) {
		this.minutes = minutes;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
