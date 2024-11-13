package com.example.androidLab.activty;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidLab.R;
import com.example.androidLab.databinding.ActivityRtMcServicesBinding;
import com.example.androidLab.utils.Utils;

public class RtMcServicesActivity extends AppCompatActivity {

    ActivityRtMcServicesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityRtMcServicesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.buttonLessonZero.setOnClickListener(this::onLessonZeroButtonClicked);
        binding.buttonLessonOne.setOnClickListener(this::onLessonOneButtonClicked);
        binding.buttonLessonTwo.setOnClickListener(this::onLessonTwoButtonClicked);
    }

    private void onLessonZeroButtonClicked(View v) {
        String content = getString(R.string.text_realtime_mc_body_0);
        String title = getString(R.string.title_realtime_mc_body_0);
        Utils.createAlertDialog(this, true, title, content);
    }

    private void onLessonOneButtonClicked(View v) {
        String content = getString(R.string.text_realtime_mc_body_1);
        String title = getString(R.string.title_realtime_mc_body_1);
        Utils.createAlertDialog(this, true, title, content);
    }

    private void onLessonTwoButtonClicked(View v) {
        String content = getString(R.string.text_realtime_mc_body_2);
        String title = getString(R.string.title_realtime_mc_body_2);
        Utils.createAlertDialog(this, true, title, content);
    }
}