package com.example.homework131;

import androidx.annotation.NonNull;

public class BloodPressureRecord {
	private int systolic, diastolic, pulse;
	private boolean tachycardia;
	private long time;
	private User user;

	public BloodPressureRecord(int systolic, int diastolic, int pulse, boolean tachycardia) {
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.pulse = pulse;
		this.tachycardia = tachycardia;
		time = System.currentTimeMillis();
	}

	public int getSystolic() {
		return systolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public int getPulse() {
		return pulse;
	}

	public boolean getTachycardia() {
		return tachycardia;
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
		return String.format("bp: %d/%d, pul: %d", systolic, diastolic, pulse) +
				(tachycardia ? ", tachycardia" : "");
	}
}
