package com.example.androidLab.utils;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.androidLab.R;

public class Utils {
    public static void createAlertDialog(Context context, Boolean change,
                                         String title, String content){
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.dialog_lesson, null);

        TextView titleView = dialogView.findViewById(R.id.textview_title);
        TextView textView = dialogView.findViewById(R.id.textView_content);
        ImageButton back = dialogView.findViewById(R.id.button_back);

        if (change) {
            textView.setBackgroundResource(R.drawable.ic_background_solid_maroon);
        }
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setVerticalScrollBarEnabled(true);

        titleView.setText(title);
        textView.setText(content);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        back.setOnClickListener((view -> dialog.dismiss()));
        dialog.show();
    }
}
