package com.example.homework131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VitalParametersInputActivity extends AppCompatActivity {
	private static final String TAG = "HW131-Vital";

	private EditText weightInput;
	private EditText stepsInput;
	private Button saveButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vital_parameters_input);
		initViews();

		saveButton.setOnClickListener(v -> save());
	}

	private void initViews() {
		weightInput = findViewById(R.id.weightInput);
		stepsInput = findViewById(R.id.stepsInput);
		saveButton = findViewById(R.id.saveButton);
	}

	private VitalParametersRecord getRecord() {
		String weight = weightInput.getText().toString();
		String steps = stepsInput.getText().toString();

		if (weight.isEmpty()) {
			Toast.makeText(this, R.string.type_weight, Toast.LENGTH_SHORT).show();
			return null;
		}
		if (steps.isEmpty()) {
			Toast.makeText(this, R.string.type_steps, Toast.LENGTH_SHORT).show();
			return null;
		}

		double weightDouble;
		int stepsInt;
		try {
			weightDouble = Double.parseDouble(weight.replace(',', '.'));
			stepsInt = Integer.parseInt(steps);
		} catch (NumberFormatException e) {
			Toast.makeText(this, R.string.one_of_numbers_invalid, Toast.LENGTH_SHORT).show();
			return null;
		}
		return new VitalParametersRecord(weightDouble, stepsInt);
	}

	private void save() {
		VitalParametersRecord r = getRecord();
		Log.i(TAG, "Clicked save, record='" + r + "'");
		if (r == null)
			return;
		Records.addVitalParametersRecord(r);
		Toast.makeText(this, R.string.vital_params_record_added, Toast.LENGTH_SHORT).show();
		finish();
	}
}
