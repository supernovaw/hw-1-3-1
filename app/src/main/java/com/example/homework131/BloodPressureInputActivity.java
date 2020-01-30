package com.example.homework131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class BloodPressureInputActivity extends AppCompatActivity {
	private static final String TAG = "HW131-BP";

	private EditText systolicInput;
	private EditText diastolicInput;
	private EditText pulseInput;
	private CheckBox tachycardiaCheckbox;
	private Button saveButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blood_pressure_input);
		initViews();

		saveButton.setOnClickListener(v -> save());
	}

	private void initViews() {
		systolicInput = findViewById(R.id.systolicInput);
		diastolicInput = findViewById(R.id.diastolicInput);
		pulseInput = findViewById(R.id.pulseInput);
		tachycardiaCheckbox = findViewById(R.id.tachycardiaCheckbox);
		saveButton = findViewById(R.id.saveButton);
	}

	private BloodPressureRecord getRecord() {
		String sys = systolicInput.getText().toString();
		String dias = diastolicInput.getText().toString();
		String pulse = pulseInput.getText().toString();
		boolean tachycardia = tachycardiaCheckbox.isChecked();

		if (sys.isEmpty()) {
			Toast.makeText(this,
					R.string.type_systolic, Toast.LENGTH_SHORT).show();
			return null;
		}
		if (dias.isEmpty()) {
			Toast.makeText(this,
					R.string.type_diastolic, Toast.LENGTH_SHORT).show();
			return null;
		}
		if (pulse.isEmpty()) {
			Toast.makeText(this, R.string.type_pulse, Toast.LENGTH_SHORT).show();
			return null;
		}

		int sysInt, diasInt, pulseInt;
		try {
			sysInt = Integer.parseInt(sys);
			diasInt = Integer.parseInt(dias);
			pulseInt = Integer.parseInt(pulse);
		} catch (NumberFormatException e) {
			Toast.makeText(this, R.string.one_of_numbers_invalid,
					Toast.LENGTH_SHORT).show();
			return null;
		}
		return new BloodPressureRecord(sysInt, diasInt, pulseInt, tachycardia);
	}

	private void save() {
		BloodPressureRecord r = getRecord();
		Log.i(TAG, "Clicked save, record='" + r + "'");
		if (r == null)
			return;
		Records.addBPRecord(r);
		Toast.makeText(this, R.string.bp_record_added, Toast.LENGTH_SHORT).show();
		finish();
	}
}
