package com.example.androidLab.activty;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidLab.databinding.ActivityHomeBinding;
import com.example.androidLab.models.RegistrationModel;
import com.example.androidLab.repository.UserRepository;


public class HomeActivity extends AppCompatActivity {

    RegistrationModel userInfo;
    ActivityHomeBinding binding;
    UserRepository userRepository;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setUsername();
        binding.buttonLogout.setOnTouchListener(this::onLogoutButtonClicked);
        binding.buttonOpenCalculator.setOnClickListener(this::onOpenCalculatorClicked);
        binding.buttonCountryFlag.setOnClickListener(this::onOpenCountryFlageButtonClicked);
        binding.buttonInfraredCommunication.setOnClickListener(this::onOpenIrCommClicked);
        binding.buttonBluetoothTransfer.setOnClickListener(this::onOpenBluetoothFileTransferButtonClicked);
        binding.buttonBluetoothWireless.setOnClickListener(this::onOpenBluetoothWirelessRangeButtonClicked);
    }

    private void setUsername() {
        userInfo = (RegistrationModel) getIntent().getSerializableExtra("USERINFO");

        assert userInfo != null;
        String firstname = userInfo.getUsername().split(" ")[0];
        String greeting = String.valueOf(binding.textviewGreetingHolder.getText());
        binding.textviewGreetingHolder.setText(String.format("%s %s!", greeting, firstname));
    }

    private boolean onLogoutButtonClicked(View v, MotionEvent motion) {
        if (motion.getAction() != MotionEvent.ACTION_DOWN)
            return true;

        Intent LoginPage = new Intent(HomeActivity.this, LoginActivity.class);
        LoginPage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(LoginPage);

        return false;
    }

    private void onOpenCalculatorClicked(View v){
        Intent Calculator = new Intent(
            HomeActivity.this,
            CalculatorActivity.class
        );
        startActivity(Calculator);
    }

    private void onOpenCountryFlageButtonClicked(View v) {
        Intent CountryFlag = new Intent(
            HomeActivity.this,
            WhatsTheFlagActivity.class
        );
        startActivity(CountryFlag);
    }

    private void onOpenIrCommClicked(View v) {
        Intent IrComm = new Intent(
            HomeActivity.this,
            InfraredCommunicationActivity.class
        );
        startActivity(IrComm);
    }

    private void onOpenBluetoothFileTransferButtonClicked(View v) {
        Intent BluetoothFT = new Intent(
            HomeActivity.this,
            BluetoothFileTransferActivity.class
        );
        startActivity(BluetoothFT);
    }

    private void onOpenBluetoothWirelessRangeButtonClicked(View v) {
        Intent BluetoothWR = new Intent(
            HomeActivity.this,
            BluetoothWirelessRangeActivity.class
        );
        startActivity(BluetoothWR);
    }
}