package com.example.androidLab.activty;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidLab.R;
import com.example.androidLab.databinding.ActivityBluetoothFileTransferBinding;
import com.example.androidLab.utils.Utils;

public class BluetoothFileTransferActivity extends AppCompatActivity {

    ActivityBluetoothFileTransferBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityBluetoothFileTransferBinding.inflate(getLayoutInflater());
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
        String content = getString(R.string.text_bluetooth_overview);
        String title = getString(R.string.title_bluetooth_overview);
        Utils.createAlertDialog(this, true, title, content);
    }

    private void onLessonOneButtonClicked(View v) {
        String content = getString(R.string.text_bluetooth_basics);
        String title = getString(R.string.title_bluetooth_basics);
        Utils.createAlertDialog(this, true, title, content);
    }

    private void onLessonTwoButtonClicked(View v) {
        String content = getString(R.string.text_bluetooth_interfaces_classes_1);
        String title = getString(R.string.title_bluetooth_interfaces_classes_1);
        Utils.createAlertDialog(this, true, title, content);
    }

    private void onLessonThreeButtonClicked(View v) {
        String content = getString(R.string.text_bluetooth_interfaces_classes_2);
        String title = getString(R.string.title_bluetooth_interfaces_classes_2);
        Utils.createAlertDialog(this, true, title, content);
    }

    private void onLessonFourButtonClicked(View v) {
        String content = getString(R.string.text_bluetooth_transfer_summary);
        String title = getString(R.string.title_summary);
        Utils.createAlertDialog(this, true, title, content);
    }
}