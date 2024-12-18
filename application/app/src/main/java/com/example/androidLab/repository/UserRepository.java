package com.example.androidLab.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.androidLab.models.RegistrationModel;
import com.example.androidLab.models.onTaskCompleteListener;
import com.example.androidLab.models.onUserDataFetchedListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserRepository
{
    private final FirebaseAuth auth;
    private final Application application;

    public UserRepository(Application application) {
        this.application = application;
        auth = FirebaseAuth.getInstance();
    }

    // Member methods
    public void register(RegistrationModel user) {
        auth.createUserWithEmailAndPassword(
                user.getEmailAddress(),
                user.getPassword()
            ).addOnCompleteListener(task -> onRegisterComplete(task, user));
    }

    public void login(String email, String password, onTaskCompleteListener taskComplete) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(task -> {taskComplete.onTaskComplete(task.isSuccessful());});
    }

    public void logout() {
        auth.signOut();
    }

    public String getUid() {
        if(auth.getCurrentUser() == null) {
            return null;
        }
        return auth.getCurrentUser().getUid();
    }

    public void getUserCredentials(String userId, onUserDataFetchedListener dataFetched) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) return;

                RegistrationModel userInfo = new RegistrationModel();
                addValueToModel(userInfo, snapshot);
                dataFetched.onDataFetched(userInfo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(application, "Error parsing user.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Helper methods
    private void addValueToModel(RegistrationModel userInfo, DataSnapshot snapshot) {
        userInfo.setGender(snapshot.child("gender").getValue(String.class));
        userInfo.setRegion(snapshot.child("region").getValue(String.class));
        userInfo.setCountry(snapshot.child("country").getValue(String.class));
        userInfo.setUsername(snapshot.child("username").getValue(String.class));
        userInfo.setBirthTime(snapshot.child("country").getValue(String.class));
        userInfo.setInterest(snapshot.child("interest").getValue(String.class));
        userInfo.setPassword(snapshot.child("password").getValue(String.class));
        userInfo.setProvince(snapshot.child("province").getValue(String.class));
        userInfo.setBirthDate(snapshot.child("birthDate").getValue(String.class));
        userInfo.setPhoneNumber(snapshot.child("phoneNumber").getValue(String.class));
        userInfo.setEmailAddress(snapshot.child("emailAddress").getValue(String.class));
    }

    private void onRegisterComplete (@NonNull Task<AuthResult> task, RegistrationModel userInfo) {
        if (!task.isSuccessful()) {
            displayResult("Registration failed!");
            return;
        }

        FirebaseUser user = auth.getCurrentUser();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("users")
                .child(user.getUid())
                .setValue(userInfo)
                .addOnCompleteListener(this::onComplete);
    }

    private void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()){
            displayResult("Registration successful!");
        } else {
            displayResult("Registration failed!");
        }
    }

    private void displayResult(String message) {
        Toast.makeText(application, message, Toast.LENGTH_SHORT)
             .show();
    }
}
