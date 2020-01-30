package com.example.homework131;

import androidx.annotation.Nullable;

public class User {
	private String firstName, middleName, lastName;
	private int age;

	public User(String firstName, String middleName, String lastName, int age) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return firstName + " " + middleName + " " + lastName + ", age " + age;
	}

	@Override
	public boolean equals(@Nullable Object obj) {
		if (!(obj instanceof User))
			return false;
		User u = (User) obj;

		if (!u.firstName.equals(firstName))
			return false;
		if (!u.middleName.equals(middleName))
			return false;
		if (!u.lastName.equals(lastName))
			return false;
		return u.age == age;
	}
}
