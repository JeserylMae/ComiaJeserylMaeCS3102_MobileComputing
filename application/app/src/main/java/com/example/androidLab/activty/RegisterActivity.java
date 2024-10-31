package com.example.androidLab.activty;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidLab.R;
import com.example.androidLab.databinding.ActivityRegisterBinding;

import java.lang.reflect.Field;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;

import com.example.androidLab.models.RegistrationModel;
import com.example.androidLab.repository.UserRepository;
import com.example.androidLab.utils.Validation;

public class RegisterActivity extends AppCompatActivity
{
    AlertDialog dialog;
    String[] regionArray, stateArray;
    ActivityRegisterBinding binding;
    UserRepository userRepository;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userRepository = new UserRepository(this.getApplication());
        regionArray = getResources().getStringArray(R.array.array_region_dropdown);
        onDropDownClicked(binding.dropdownRegion, regionArray);

        binding.dropdownProvince.setOnFocusChangeListener(this::onStateDropDownFocused);
        binding.dropdownRegion.setOnItemClickListener(this::onCountryClicked);
        binding.editTextBirthdate.setOnTouchListener(this::onBirthDateEditTextClicked);
        binding.editTextBirthtime.setOnTouchListener(this::onBirthTimeEditTextClicked);
        binding.buttonSignup.setOnTouchListener(this::onRegisterButtonClicked);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    // Listener Methods.
    private boolean onConfirmButtonClicked(View v, MotionEvent motionEvent,
                                           RegistrationModel user) {
        if (motionEvent.getAction() != MotionEvent.ACTION_DOWN)
            return true;

        userRepository.register(user);
        clearTextboxes();
        dialog.dismiss();

        return false;
    }

    private boolean onCancelButtonClicked(View v, MotionEvent motion) {
        if (motion.getAction() != MotionEvent.ACTION_DOWN)
            return true;

        dialog.dismiss();
        return false;
    }

    private boolean onRegisterButtonClicked(View view, MotionEvent motion) {
        if (motion.getAction() != MotionEvent.ACTION_DOWN)
            return true;

        RegistrationModel model = setRegistrationModelValues();

        if (Validation.hasNullOrEmptyValue(model)) {
            displayMessage("Registration failed. Some fields are EMPTY.");
            return true;
        }
        showModelInDialog(model);
        return false;
    }

    private void onStateDropDownFocused(View v, boolean hasFocus) {
        if (stateArray != null) return;
        displayMessage("Select a country first.");
    }

    private void onCountryClicked(AdapterView<?> adapterView, View v, int index, long l) {
        String item = adapterView.getItemAtPosition(index).toString();
        stateArray = getStateArray(item);

        onDropDownClicked(binding.dropdownProvince, stateArray);
    }

    private void onDropDownClicked(AutoCompleteTextView view, String[] array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.dialog_country_dropdown,
                array
        );
        view.setAdapter(adapter);
    }

    private boolean onBirthDateEditTextClicked(View v, MotionEvent motion) {
        if (motion.getAction() != MotionEvent.ACTION_DOWN)
            return true;

        LocalDate currentDate = LocalDate.now();
        DatePickerDialog calendar = new DatePickerDialog(
            this,
            R.style.CustomDatePickerTheme,
            this::onDateSet,
            currentDate.getYear(),
            currentDate.getMonthValue()-1,
            currentDate.getDayOfMonth()
        );
        calendar.show();
        return false;
    }

    private boolean onBirthTimeEditTextClicked(View v, MotionEvent motion) {
        if (motion.getAction() != MotionEvent.ACTION_DOWN)
            return true;

        LocalTime currentTime = LocalTime.now();

        TimePickerDialog clock = new TimePickerDialog(
            this,
            R.style.CustomTimePickerTheme,
            this::onTimeSet,
            currentTime.getHour(),
            currentTime.getMinute(),
            false
        );
        clock.show();
        return false;
    }

    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String monthName = new DateFormatSymbols().getMonths()[datePicker.getMonth()];

        @SuppressLint("DefaultLocale") String date = String.format(
            "%s %d, %d",
            monthName,
            datePicker.getDayOfMonth(),
            datePicker.getYear()
        );
        binding.editTextBirthdate.setText(date);
    }

    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        String time = convertMilitaryTime(
            timePicker.getHour(),
            timePicker.getMinute()
        );
        binding.editTextBirthtime.setText(time);
    }


    // Helper Methods.
    @SuppressLint("ClickableViewAccessibility")
    private void showModelInDialog(RegistrationModel model) {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_submit, null);

        TextView textViewName = dialogView.findViewById(R.id.textView_summary);
        Button buttonCancelSubmit = dialogView.findViewById(R.id.button_cancel_submit);
        Button buttonConfirmSubmit = dialogView.findViewById(R.id.button_confirm_submit);

        String summary = formatInformationSummary(model);
        textViewName.setText(summary);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        dialog = builder.create();
        dialog.show();

        buttonCancelSubmit.setOnTouchListener(this::onCancelButtonClicked);
        buttonConfirmSubmit.setOnTouchListener(
            (view, motionEvent) -> onConfirmButtonClicked(view, motionEvent, model)
        );
    }

    private String[] getStateArray(String selectedCountry) {
        switch (selectedCountry) {
            case "Region I - Ilocos Region":
                return getResources().getStringArray(R.array.array_region_i_dropdown);
            case "Region II - Cagayan Valley":
                return getResources().getStringArray(R.array.array_region_ii_dropdown);
            case "Region III - Central Luzon":
                return getResources().getStringArray(R.array.array_region_iii_dropdown);
            case "Region IV-A - CALABARZON":
                return getResources().getStringArray(R.array.array_region_iv_a_dropdown);
            case "Region IV-B - MIMAROPA":
                return getResources().getStringArray(R.array.array_region_iv_b_dropdown);
            case "Region V - Bicol Region":
                return getResources().getStringArray(R.array.array_region_v_dropdown);
            case "Region VI Western Visayas":
                return getResources().getStringArray(R.array.array_region_vi_dropdown);
            case "Region VII Central Visayas":
                return getResources().getStringArray(R.array.array_region_vii_dropdown);
            case "Region VIII Eastern Visayas":
                return getResources().getStringArray(R.array.array_region_viii_dropdown);
            case "Region IX - Zamboanga Peninsula":
                return getResources().getStringArray(R.array.array_region_ix_dropdown);
            case "Region X - Northern Mindanao":
                return getResources().getStringArray(R.array.array_region_x_dropdown);
            case "Region XI - Davao Region":
                return getResources().getStringArray(R.array.array_region_xi_dropdown);
            case "Region XII - SOCCSKSARGEN":
                return getResources().getStringArray(R.array.array_region_xii_dropdown);
            case "Region XIII - Caraga":
                return getResources().getStringArray(R.array.array_region_xiii_dropdown);
            case "NCR - National Capital Region":
                return getResources().getStringArray(R.array.array_region_ncr_dropdown);
            case "CAR - Cordillera Administrative Region":
                return getResources().getStringArray(R.array.array_region_car_dropdown);
            case "BARMM - Bangsamoro Autonomous Region in Muslim Mindanao":
                return getResources().getStringArray(R.array.array_region_barmm_dropdown);
            default:
                return new String[0];
        }
    }

    private String convertMilitaryTime(int hour, int minute) {
        String amPm;
        int newHour;

        if (hour > 12) {
            amPm = "PM"; newHour = hour % 12;
        } else if (hour == 12) {
            amPm = "PM"; newHour = 12;
        } else if (hour > 0) {
            amPm = "AM";
            newHour = hour;
        } else {
          amPm = "AM"; newHour = 12;
        }

        @SuppressLint("DefaultLocale") String formattedTime = String.format(
            "%02d:%02d %s", newHour, minute, amPm
        );
        return formattedTime;
    }

    private RegistrationModel setRegistrationModelValues() {
        RegistrationModel model;

        model = new RegistrationModel();
        model.setUsername(binding.editTextUsername.getText().toString());
        model.setPassword(binding.editTextPassword.getText().toString());
        model.setEmailAddress(binding.editTextEmail.getText().toString());
        model.setPhoneNumber(binding.editTextPhoneNumber.getText().toString());
        model.setCountry(binding.dropdownCountryContainer.getText().toString());
        model.setRegion(binding.dropdownRegion.getText().toString());
        model.setProvince(binding.dropdownProvince.getText().toString());
        model.setBirthDate(binding.editTextBirthdate.getText().toString());
        model.setBirthTime(binding.editTextBirthtime.getText().toString());
        model.setInterest(binding.editTextInterest.getText().toString());

        String gender = binding.radioGroupGender.getCheckedRadioButtonId()
            == binding.radioButtonMale.getId()
            ? binding.radioButtonMale.getText().toString()
            : binding.radioButtonFemale.getText().toString();
        model.setGender(gender);

        return model;
    }

    private void clearTextboxes() {
        binding.editTextUsername.setText(null);
        binding.editTextPassword.setText(null);
        binding.editTextEmail.setText(null);
        binding.editTextPhoneNumber.setText(null);
        binding.dropdownRegion.setSelected(false);
        binding.dropdownRegion.setSelected(false);
        binding.radioButtonMale.setChecked(false);
        binding.radioButtonFemale.setChecked(false);
        binding.editTextInterest.setText(null);
        binding.editTextBirthdate.setText(null);
        binding.editTextBirthtime.setText(null);
    }

    private String formatInformationSummary(RegistrationModel model) {
        return "USERNAME: " + model.getUsername() + "\n"
            + "PASSWORD: " + model.getPassword() + "\n"
            + "EMAIL ADDRESS: " + model.getEmailAddress() + "\n"
            + "PHONE NUMBER: " + model.getPhoneNumber() + "\n"
            + "COUNTRY: " + model.getCountry() + "\n"
            + "REGION: " + model.getRegion() + "\n"
            + "PROVINCE: " + model.getProvince() + "\n"
            + "GENDER: " + model.getGender() + "\n"
            + "INTEREST: " + model.getInterest() + "\n"
            + "BIRTH DATE: " + model.getBirthDate() + "\n"
            + "BIRTH TIME: " + model.getBirthTime();
    }

    private void displayMessage(String message) {
        Toast.makeText(
            RegisterActivity.this,
             message,
            Toast.LENGTH_LONG
        ).show();
    }
}