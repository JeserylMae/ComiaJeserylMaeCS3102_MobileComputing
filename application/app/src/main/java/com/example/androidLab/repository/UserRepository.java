package com.example.androidLab.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.androidLab.models.RegistrationModel;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRepository
{
    private final FirebaseAuth auth;
    private final Application application;
    private MutableLiveData<FirebaseUser> firebaseUserMutableLiveData;
    private MutableLiveData<Boolean> firebaseUserStatus;

    public UserRepository(Application application)
    {
        this.application = application;
        auth = FirebaseAuth.getInstance();
        firebaseUserStatus = new MutableLiveData<>();
        firebaseUserMutableLiveData = new MutableLiveData<>();

        if (auth.getCurrentUser() != null) {
            firebaseUserMutableLiveData.postValue(auth.getCurrentUser());
        }
    }

    // Getters
    public MutableLiveData<FirebaseUser> getFirebaseUserMutableLiveData() {
        return firebaseUserMutableLiveData;
    }

    public MutableLiveData<Boolean> getFirebaseUserStatus() {
        return firebaseUserStatus;
    }

    // Member methods
    public void register(RegistrationModel user)
    {
        auth.createUserWithEmailAndPassword(
                user.getEmailAddress(),
                user.getPassword()
            ).addOnCompleteListener(task -> onRegisterComplete(task, user));
    }

    public boolean login(String email, String password)
    {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this::onLoginComplete);

        return firebaseUserMutableLiveData != null;
    }

    public void logout()
    {
        auth.signOut();
        firebaseUserStatus.postValue(true);
    }

    // Helper methods
    private void onRegisterComplete (@NonNull Task<AuthResult> task,
                                     RegistrationModel user)
    {
        if (!task.isSuccessful()) {
            displayResult("Registration failed!");
            return;
        }

        FirebaseUser currUser = auth.getCurrentUser();
        firebaseUserMutableLiveData.postValue(currUser);

        assert currUser != null;

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("users")
                .child(currUser.getUid())
                .setValue(user)
                .addOnCompleteListener(this::onComplete);
    }

    private void onLoginComplete(@NonNull Task<AuthResult> task)
    {
        if (task.isSuccessful()) {
            firebaseUserMutableLiveData.postValue(auth.getCurrentUser());
            displayResult("Login Successful!");
        } else {
            firebaseUserMutableLiveData.postValue(null);
            displayResult("Login failed! Ensure all information are correct!");
        }
    }

    private void onComplete(@NonNull Task<Void> task)
    {
        if (task.isSuccessful()){
            displayResult("Registration successful!");
        } else {
            displayResult("Registration failed!");
        }
    }

    private void displayResult(String message)
    {
        Toast.makeText(application, message, Toast.LENGTH_SHORT)
             .show();
    }
}
