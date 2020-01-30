package com.example.homework131;

import java.util.ArrayList;

public class Records {
	private static User currentUser;
	private static ArrayList<BloodPressureRecord> bpRecords = new ArrayList<>();
	private static ArrayList<VitalParametersRecord> vitalParametersRecords = new ArrayList<>();

	public static void addBPRecord(BloodPressureRecord r) {
		r.setUser(currentUser);
		bpRecords.add(r);
	}

	public static void addVitalParametersRecord(VitalParametersRecord r) {
		r.setUser(currentUser);
		vitalParametersRecords.add(r);
	}

	public static void setCurrentUser(User u) {
		currentUser = u;
	}
}
