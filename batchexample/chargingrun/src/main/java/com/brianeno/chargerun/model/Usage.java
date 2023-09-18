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

public class Usage {

	private Long id;

	private String firstName;

	private String lastName;

	private Long minutes;

	private Long wattUsage;

	public Usage() {
	}

	public Usage(Long id, String firstName, String lastName, Long minutes, Long wattUsage) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.minutes = minutes;
		this.wattUsage = wattUsage;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Usage{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", minutes=" + minutes +
				", wattUsage=" + wattUsage +
				'}';
	}
}
