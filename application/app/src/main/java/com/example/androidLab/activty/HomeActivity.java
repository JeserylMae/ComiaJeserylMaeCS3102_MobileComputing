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

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

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

        binding.buttonLogout.setOnTouchListener(this::onLogoutButtonClicked);
        binding.buttonOpenCalculator.setOnTouchListener(this::onOpenCalculatorClicked);
    }

    private boolean onLogoutButtonClicked(View v, MotionEvent motion) {
        if (motion.getAction() != MotionEvent.ACTION_DOWN)
            return true;

        Intent LoginPage = new Intent(HomeActivity.this, LoginActivity.class);
        LoginPage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(LoginPage);

        return false;
    }

    private boolean onOpenCalculatorClicked(View v, MotionEvent motion){
        if (motion.getAction() != MotionEvent.ACTION_DOWN)
            return true;

        Intent Calculator = new Intent(HomeActivity.this, CalculatorActivity.class);
        Calculator.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(Calculator);

        return false;
    }
}