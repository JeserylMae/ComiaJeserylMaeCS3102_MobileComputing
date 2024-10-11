package com.example.androidLab.dialog;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidLab.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView calculationView, answerView;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        calculationView = itemView.findViewById(R.id.textView_calculation);
        answerView = itemView.findViewById(R.id.textView_finalAnswer);
    }
}
