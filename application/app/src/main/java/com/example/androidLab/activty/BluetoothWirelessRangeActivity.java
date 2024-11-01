package com.example.androidLab.activty;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidLab.R;
import com.example.androidLab.databinding.ActivityBluetoothWirelessRangeBinding;
import com.example.androidLab.utils.Utils;

public class BluetoothWirelessRangeActivity extends AppCompatActivity {

    ActivityBluetoothWirelessRangeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityBluetoothWirelessRangeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.buttonLessonZero.setOnClickListener(this::onLessonZeroButtonClicked);
        binding.buttonLessonOne.setOnClickListener(this::onLessonOneButtonClicked);
        binding.buttonLessonTwo.setOnClickListener(this::onLessonTwoButtonClicked);
        binding.buttonLessonThree.setOnClickListener(this::onLessonThreeButtonClicked);
        binding.buttonLessonFour.setOnClickListener(this::onLessonFourButtonClicked);
        binding.buttonLessonFive.setOnClickListener(this::onLessonFiveButtonClicked);
    }

    private void onLessonZeroButtonClicked(View v) {
        String content = getString(R.string.text_setup_bluetooth);
        String title = getString(R.string.title_setup_bluetooth);
        Utils.createAlertDialog(this, false, title, content);
    }

    private void onLessonOneButtonClicked(View v) {
        String content = getString(R.string.text_find_bluetooth_devices);
        String title = getString(R.string.title_find_bluetooth_devices);
        Utils.createAlertDialog(this, false, title, content);
    }

    private void onLessonTwoButtonClicked(View v) {
        String content = getString(R.string.text_connect_bluetooth_devices);
        String title = getString(R.string.title_connect_bluetooth_devices);
        Utils.createAlertDialog(this, false, title, content);
    }

    private void onLessonThreeButtonClicked(View v) {
        String content = getString(R.string.text_transfer_bluetooth_data);
        String title = getString(R.string.title_transfer_bluetooth_data);
        Utils.createAlertDialog(this, false, title, content);
    }

    private void onLessonFourButtonClicked(View v) {
        String content = getString(R.string.text_bluetooth_profiles);
        String title = getString(R.string.title_bluetooth_profiles);
        Utils.createAlertDialog(this, false, title, content);
    }

    private void onLessonFiveButtonClicked(View v) {
        String content = getString(R.string.text_companion_device_pairing);
        String title = getString(R.string.title_company_device_pairing);
        Utils.createAlertDialog(this, false, title, content);
    }
}