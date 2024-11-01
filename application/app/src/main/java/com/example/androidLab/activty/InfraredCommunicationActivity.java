package com.example.androidLab.activty;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidLab.R;
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
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.buttonLessonZero.setOnClickListener(this::onLessonZeroButtonClicked);
        binding.buttonLessonOne.setOnClickListener(this::onLessonOneButtonClicked);
        binding.buttonLessonTwo.setOnClickListener(this::onLessonTwoButtonClicked);
        binding.buttonLessonThree.setOnClickListener(this::onLessonThreeButtonClicked);
        binding.buttonLessonFour.setOnClickListener(this::onLessonFourButtonClicked);
    }

    private void onLessonZeroButtonClicked(View v) {
        String content = getString(R.string.text_what_is_ir_communication);
        String title = getString(R.string.title_what_is_ir_communication);
        Utils.createAlertDialog(this, false, title, content);
    }

    private void onLessonOneButtonClicked(View v) {
        String content = getString(R.string.text_types_of_ir_communication);
        String title = getString(R.string.title_types_of_ir_communication);
        Utils.createAlertDialog(this, false, title, content);
    }

    private void onLessonTwoButtonClicked(View v) {
        String content = getString(R.string.text_how_does_ir_communication_work);
        String title = getString(R.string.title_how_does_ir_communication_work);
        Utils.createAlertDialog(this, false, title, content);
    }

    private void onLessonThreeButtonClicked(View v) {
        String content = getString(R.string.text_ir_communication_advantage);
        String title = getString(R.string.title_ir_communication_advantages);
        Utils.createAlertDialog(this, false, title, content);
    }

    private void onLessonFourButtonClicked(View v) {
        String content = getString(R.string.text_ir_communication_summary);
        String title = getString(R.string.title_summary);
        Utils.createAlertDialog(this, false, title, content);
    }
}