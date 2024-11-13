package com.example.androidLab.activty;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.androidLab.R;
import com.example.androidLab.databinding.ActivityWhatsTheFlagBinding;
import com.example.androidLab.utils.FlagFetcher;

import java.util.Map;

public class WhatsTheFlagActivity extends AppCompatActivity {

    private Map<String, String> countryMap;
    private ActivityWhatsTheFlagBinding binding;

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

        FlagFetcher.fetchCountryCodes(new FlagFetcher.CountryCodeCallback() {
            @Override
            public void onCountryCodesFetched(Map<String, String> fetchedCountryMap) {
                countryMap = fetchedCountryMap;

                if (countryMap != null && !countryMap.isEmpty()) {
                    String[] countryNames = countryMap.values().toArray(new String[0]);
                    onDropDownClicked(binding.dropdownSelectCountry, countryNames);
                } else {
                    Toast.makeText(WhatsTheFlagActivity.this, "No country data available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.buttonGetFlag.setOnClickListener(v -> {
            String selectedCountryName = binding.dropdownSelectCountry.getText().toString();

            if (!selectedCountryName.isEmpty()) {
                String countryCode = getCountryCodeFromName(selectedCountryName);
                if (countryCode != null) {
                    String flagUrl = "https://flagcdn.com/256x192/" + countryCode.toLowerCase() + ".png";
                    // Load the image using Glide
                    Glide.with(WhatsTheFlagActivity.this)
                            .load(flagUrl)
                            .placeholder(R.drawable.ic_image_country_flag_2)
                            .error(R.drawable.ic_image_country_flag_2)
                            .into(binding.imageFlagHolder);
                } else {
                    Toast.makeText(WhatsTheFlagActivity.this, "Country code not found", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(WhatsTheFlagActivity.this, "Please select a country", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getCountryCodeFromName(String countryName) {
        for (Map.Entry<String, String> entry : countryMap.entrySet()) {
            if (entry.getValue().equals(countryName)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private void onDropDownClicked(AutoCompleteTextView view, String[] array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dialog_country_dropdown, array);
        view.setAdapter(adapter);
    }
}
