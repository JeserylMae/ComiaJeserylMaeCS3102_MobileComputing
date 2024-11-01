package com.example.androidLab.activty;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidLab.R;
import com.example.androidLab.databinding.ActivityWhatsTheFlagBinding;

public class WhatsTheFlagActivity extends AppCompatActivity {

    String[] country_options;
    ActivityWhatsTheFlagBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityWhatsTheFlagBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        country_options = getResources().getStringArray(R.array.array_country_dropdown);
        onDropDownClicked(binding.dropdownSelectCountry, country_options);

        binding.buttonGetFlag.setOnClickListener(this::onGetFlagButtonClicked);
    }

    private void onDropDownClicked(AutoCompleteTextView view, String[] array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.dialog_country_dropdown,
                array
        );
        view.setAdapter(adapter);
    }

    private void onGetFlagButtonClicked(View v) {
        String country = binding.dropdownSelectCountry.getText().toString();
        int flag = getFlag(country);
        binding.imageFlagHolder.setImageResource(flag);
    }

    private int getFlag(String country) {
        switch (country) {
            case "Bolivia": {
                return R.drawable.ic_image_country_bolivia;
            }
            case "Cambodia": {
                return R.drawable.ic_image_country_cambodia;
            }
            case "China": {
                return R.drawable.ic_image_country_china;
            }
            case "Germany": {
                return R.drawable.ic_image_country_germany;
            }
            case "Japan": {
                return R.drawable.ic_image_country_japan;
            }
            case "Mexico": {
                return R.drawable.ic_image_country_mexico;
            }
            case "Philippines": {
                return R.drawable.ic_image_country_philippines;
            }
            case "South Korea": {
                return R.drawable.ic_image_country_south_korea;
            }
            case "Venezuela": {
                return R.drawable.ic_image_country_venezuela;
            }
            case "Vietnam": {
                return R.drawable.ic_image_country_vietnam;
            }
            default: {
                Toast.makeText(this, "Select a country first!", Toast.LENGTH_SHORT)
                    .show();
            }
        }
        return -1;
    }
}