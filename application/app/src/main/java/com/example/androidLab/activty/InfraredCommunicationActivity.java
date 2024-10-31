package com.example.androidLab.activty;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidLab.R;
import com.example.androidLab.databinding.ActivityHomeBinding;
import com.example.androidLab.databinding.ActivityInfraredCommunicationBinding;
import com.example.androidLab.utils.Utils;

public class InfraredCommunicationActivity extends AppCompatActivity {

    ActivityInfraredCommunicationBinding binding;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityInfraredCommunicationBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_infrared_communication);

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.buttonLessonOne.setOnClickListener(this::onLessonOneButtonClicked);
    }

    private void onLessonOneButtonClicked(View v) {
        String title = getString(R.string.title_what_is_ir_communication);
        String content = getString(R.string.text_what_is_ir_communication);
        Utils.createAlertDialog(this, title, content);
    }
}