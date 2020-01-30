package com.example.homework131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
	private static final String TAG = "HW131-Welcome";

	private EditText firstNameInput;
	private EditText middleNameInput;
	private EditText lastNameInput;
	private EditText ageInput;
	private Button addBpRecordButton;
	private Button addVitalParametersButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		initViews();

		addBpRecordButton.setOnClickListener(v -> addBPRecord());
		addVitalParametersButton.setOnClickListener(v -> addVitalParametersRecord());
	}

	private void initViews() {
		firstNameInput = findViewById(R.id.firstNameInput);
		middleNameInput = findViewById(R.id.middleNameInput);
		lastNameInput = findViewById(R.id.lastNameInput);
		addBpRecordButton = findViewById(R.id.saveButton);
		ageInput = findViewById(R.id.ageInput);
		addVitalParametersButton = findViewById(R.id.addVitalParametersButton);
	}

	private User getUserdata() {
		String first = firstNameInput.getText().toString(),
				middle = middleNameInput.getText().toString(),
				last = lastNameInput.getText().toString(),
				ageString = ageInput.getText().toString();
		if (first.trim().isEmpty()) {
			Toast.makeText(this, R.string.type_first_name, Toast.LENGTH_SHORT).show();
			return null;
		}
		if (middle.trim().isEmpty()) {
			Toast.makeText(this, R.string.type_middle_name, Toast.LENGTH_SHORT).show();
			return null;
		}
		if (last.trim().isEmpty()) {
			Toast.makeText(this, R.string.type_last_name, Toast.LENGTH_SHORT).show();
			return null;
		}
		if (ageString.trim().isEmpty()) {
			Toast.makeText(this, R.string.type_age, Toast.LENGTH_SHORT).show();
			return null;
		}
		int age;
		try {
			age = Integer.parseInt(ageString);
		} catch (NumberFormatException e) {
			Toast.makeText(this, R.string.invalid_age, Toast.LENGTH_SHORT).show();
			return null;
		}
		return new User(first, middle, last, age);
	}

	private void addBPRecord() {
		User u = getUserdata();
		Log.i(TAG, "Clicked add BP record, user='" + u + "'");
		if (u == null)
			return;
		Records.setCurrentUser(u);
		startActivity(new Intent(this, BloodPressureInputActivity.class));
	}

	private void addVitalParametersRecord() {
		User u = getUserdata();
		Log.i(TAG, "Clicked add vital params record, user='" + u + "'");
		if (u == null)
			return;
		Records.setCurrentUser(u);
		startActivity(new Intent(this, VitalParametersInputActivity.class));
	}
}
