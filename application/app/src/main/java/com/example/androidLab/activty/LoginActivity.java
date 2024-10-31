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
import com.example.androidLab.models.RegistrationModel;
import com.example.androidLab.models.onUserDataFetchedListener;
import com.example.androidLab.repository.UserRepository;
import com.example.androidLab.utils.Validation;

public class LoginActivity extends AppCompatActivity
{
    RegistrationModel userInfo;
    UserRepository userRepository;
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

        userInfo = new RegistrationModel();
        userRepository = new UserRepository(this.getApplication());
        binding.buttonLogin.setOnTouchListener(this::onLoginButtonClicked);
        binding.buttonGotoSignup.setOnTouchListener(this::onGotoSignUpButtonClicked);
        binding.buttonLoginWithGoogle.setOnTouchListener(this::onGoogleLoginButtonClicked);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private boolean onLoginButtonClicked(View v, MotionEvent motion) {
        if (motion.getAction() != MotionEvent.ACTION_DOWN) {
            return true;
        }

        String email, password;
        password = binding.editTextPassword.getText().toString();
        email = binding.editTextEmailAddress.getText().toString();

        if (hasNullOrEmptyValues(email, password)){
            displayMessage("Login failed! Some fields are empty!");
            return false;
        }
        userRepository.login(email, password, this::onLoginComplete);

        return false;
    }

    private void onLoginComplete(Boolean isSuccessful) {
        if (!isSuccessful) {
            Toast.makeText(this,"Login Error! \nEnsure all information are correct",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        getUserCredentials();
    }

    private void getUserCredentials() {
        String userId = userRepository.getUid();
        userRepository.getUserCredentials(userId, this::initializeHomePage);
    }

    private void initializeHomePage(RegistrationModel userInfo) {
        Intent HomePage = new Intent(LoginActivity.this, HomeActivity.class);
        HomePage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        HomePage.putExtra("USERINFO", userInfo);
        startActivity(HomePage);
    }

    private boolean onGoogleLoginButtonClicked(View v, MotionEvent motion) {
        if (motion.getAction() != MotionEvent.ACTION_DOWN) {
            return true;
        }
        displayMessage("Display only.");
        return false;
    }

    private boolean onGotoSignUpButtonClicked(View v, MotionEvent motion) {
        if(motion.getAction() != MotionEvent.ACTION_DOWN) return true;

        Intent signUpPage = new Intent(LoginActivity.this, RegisterActivity.class);
        signUpPage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(signUpPage);

        return false;
    }

    private boolean hasNullOrEmptyValues(String email, String password) {
        return (email == null
            || email.isEmpty()
            || password == null
            || password.isEmpty()
        );
    }

    private void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}