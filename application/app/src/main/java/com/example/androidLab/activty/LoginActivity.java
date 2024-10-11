package com.example.androidLab.activty;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidLab.databinding.ActivityLoginBinding;
import com.example.androidLab.viewModel.UserViewModel;

public class LoginActivity extends AppCompatActivity
{
    UserViewModel userViewModel;
    ActivityLoginBinding binding;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userViewModel = new UserViewModel(this.getApplication());
        binding.buttonLogin.setOnTouchListener(this::onLoginButtonClicked);
        binding.buttonGotoSignup.setOnTouchListener(this::onGotoSignUpButtonClicked);
        binding.buttonLoginWithGoogle.setOnTouchListener(this::onGoogleLoginButtonClicked);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private boolean onLoginButtonClicked(View v, MotionEvent motion)
    {
        if (motion.getAction() != MotionEvent.ACTION_DOWN) {
            return true;
        }

        String email, password;
        password = binding.editTextPassword.getText().toString();
        email = binding.editTextEmailAddress.getText().toString();

        if (hasNullOrEmptyValues(email, password)){
            displayMessage("Login failed! Some fields are empty!");
            return true;
        }

        boolean isLoggedIn = userViewModel.login(email, password);

        if (isLoggedIn) {
            Intent HomePage = new Intent(LoginActivity.this, HomeActivity.class);
            HomePage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(HomePage);
        }

        return false;
    }

    private boolean onGoogleLoginButtonClicked(View v, MotionEvent motion)
    {
        if (motion.getAction() != MotionEvent.ACTION_DOWN){
            return true;
        }

        displayMessage("Display only.");

        return false;
    }

    private boolean onGotoSignUpButtonClicked(View v, MotionEvent motion)
    {
        if(motion.getAction() != MotionEvent.ACTION_DOWN) return true;

        Intent signUpPage = new Intent(LoginActivity.this, RegisterActivity.class);
        signUpPage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(signUpPage);

        return false;
    }

    private boolean hasNullOrEmptyValues(String email, String password)
    {
        return (email == null
            || email.isEmpty()
            || password == null
            || password.isEmpty()
        );
    }

    private void displayMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG)
            .show();
    }
}