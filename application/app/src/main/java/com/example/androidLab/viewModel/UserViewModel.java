package com.example.androidLab.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.androidLab.models.RegistrationModel;
import com.example.androidLab.repository.UserRepository;

public class UserViewModel extends AndroidViewModel
{
    private RegistrationModel userInfo;
    private final UserRepository userRepository;

    public UserViewModel(@NonNull Application application)
    {
        super(application);
        userRepository = new UserRepository(application);
    }

    public void register(RegistrationModel user) {
        userRepository.register(user);
    }

    public boolean login(String email, String password) {
        return userRepository.login(email, password);
    }

    public void logout() {
        userRepository.logout();
    }

    public String getUid() {
        return userRepository.getUid();
    }

    public RegistrationModel getUserCredentials(String userId) {
        return userRepository.getUserCredentials(userId);
    }
}
