package com.example.androidLab.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.androidLab.models.RegistrationModel;
import com.example.androidLab.repository.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class UserViewModel extends AndroidViewModel
{
    private LiveData<Boolean> userStatusLiveData;
    private final UserRepository userRepository;
    private final LiveData<FirebaseUser> firebaseUserLiveData;

    public UserViewModel(@NonNull Application application)
    {
        super(application);
        userRepository = new UserRepository(application);
        userStatusLiveData = userRepository.getFirebaseUserStatus();
        firebaseUserLiveData = userRepository.getFirebaseUserMutableLiveData();
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

    public LiveData<FirebaseUser> getFirebaseUserLiveData() {
        return firebaseUserLiveData;
    }

    public LiveData<Boolean> getUserStatusLiveData() {
        return userStatusLiveData;
    }
}
