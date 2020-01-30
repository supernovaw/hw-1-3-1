package com.example.homework131;

import androidx.annotation.NonNull;

public class VitalParametersRecord {
	private double weight;
	private int steps;
	private long time;
	private User user;

	public VitalParametersRecord(double weight, int steps) {
		this.weight = weight;
		this.steps = steps;
		time = System.currentTimeMillis();
	}

	public double getWeight() {
		return weight;
	}

	public int getSteps() {
		return steps;
	}

	public long getTime() {
		return time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@NonNull
	@Override
	public String toString() {
		return "w=" + weight + ", steps=" + steps;
	}
}
