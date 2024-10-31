package com.example.androidLab.activty;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidLab.R;
import com.example.androidLab.databinding.ActivityCalculatorBinding;
import com.example.androidLab.dialog.Item;
import com.example.androidLab.dialog.ItemAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalculatorActivity extends AppCompatActivity {

    TextView textViewAnswer;
    ActivityCalculatorBinding binding;
    Double finalAnswer;
    EditText editTextInputNumber;
    String currentInput;
    Boolean hasAddedSignPN;
    Boolean hasAddedParenthesis;
    Boolean hasClickedEqualButton;
    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpWindowInsets();
        setUpInputFields();
        setUpNumberButton();
        setUpOperatorButton();
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent(this, HomeActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//    }

    private void setUpWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setUpInputFields() {
        currentInput = "";
        hasAddedSignPN = false;
        hasAddedParenthesis = false;
        hasClickedEqualButton = false;
        items = new ArrayList<>();

        textViewAnswer = binding.textViewAnswer;
        editTextInputNumber = binding.editTextInputNumber;

        Objects.requireNonNull(binding.editTextInputNumber).setShowSoftInputOnFocus(false);

        editTextInputNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                editTextInputNumber.setSelection(editTextInputNumber.getText().length());
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setUpNumberButton() {

        binding.buttonZero.setOnTouchListener(this::onButtonZeroClicked);
        binding.buttonParenthesis.setOnTouchListener(this::onParenthesisButtonClicked);

        binding.buttonOne.setOnTouchListener((v, motion)
                -> onNumberButtonClicked(v, motion, String.valueOf(binding.buttonOne.getText()))
        );
        binding.buttonTwo.setOnTouchListener((v, motion)
                -> onNumberButtonClicked(v, motion, String.valueOf(binding.buttonTwo.getText()))
        );
        binding.buttonThree.setOnTouchListener((v, motion)
                -> onNumberButtonClicked(v, motion, String.valueOf(binding.buttonThree.getText()))
        );
        binding.buttonFour.setOnTouchListener((v, motion)
                -> onNumberButtonClicked(v, motion, String.valueOf(binding.buttonFour.getText()))
        );
        binding.buttonFive.setOnTouchListener((v, motion)
                -> onNumberButtonClicked(v, motion, String.valueOf(binding.buttonFive.getText()))
        );
        binding.buttonSix.setOnTouchListener((v, motion)
                -> onNumberButtonClicked(v, motion, String.valueOf(binding.buttonSix.getText()))
        );
        binding.buttonSeven.setOnTouchListener((v, motion)
                -> onNumberButtonClicked(v, motion, String.valueOf(binding.buttonSeven.getText()))
        );
        binding.buttonEight.setOnTouchListener((v, motion)
                -> onNumberButtonClicked(v, motion, String.valueOf(binding.buttonEight.getText()))
        );
        binding.buttonNine.setOnTouchListener((v, motion)
                -> onNumberButtonClicked(v, motion, String.valueOf(binding.buttonNine.getText()))
        );
        binding.buttonPoint.setOnTouchListener((v, motion)
                -> onNumberButtonClicked(v, motion, String.valueOf(binding.buttonPoint.getText()))
        );
        binding.buttonPercent.setOnTouchListener((v, motion)
                -> onNumberButtonClicked(v, motion, String.valueOf(binding.buttonPercent.getText()))
        );
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setUpOperatorButton() {
        binding.buttonAdd.setOnTouchListener((v, motion)
                -> onOperatorButtonClicked(v, motion, "+")
        );
        binding.buttonSubtract.setOnTouchListener((v, motion)
                -> onOperatorButtonClicked(v, motion, "-")
        );
        binding.buttonMultiply.setOnTouchListener((v, motion)
                -> onOperatorButtonClicked(v, motion, "*")
        );
        binding.buttonDivide.setOnTouchListener((v, motion)
                -> onOperatorButtonClicked(v, motion, "/")
        );
        binding.buttonSignPN.setOnTouchListener(this::onSignPNClicked);
        binding.buttonEqual.setOnTouchListener(this::onEqualButtonClicked);
        binding.buttonClearAll.setOnTouchListener(this::onClearAllButtonClicked);
        binding.buttonBackspace.setOnTouchListener(this::onBackspaceButtonClicked);
        binding.buttonHistory.setOnTouchListener(this::onHistoryButtonClicked);
    }

    private boolean onHistoryButtonClicked(View v, MotionEvent motion) {
        Runnable executeDialog = () -> {
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.dialog_history, null);

            RecyclerView historyView = dialogView.findViewById(R.id.view_history);

            historyView.setLayoutManager(new LinearLayoutManager(this));
            historyView.setAdapter(new ItemAdapter(getApplicationContext(), items));

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setContentView(dialogView);

            bottomSheetDialog.show();
        };
        simulateButtonClicked(v, motion, executeDialog);

        return false;
    }

    private boolean onSignPNClicked(View v, MotionEvent motion){
        Runnable addSignPN = () -> {
            if (currentInput.isEmpty()) {
                currentInput += "-";
                hasAddedSignPN = true;

                editTextInputNumber.setText(currentInput);

                return;
            }
            if(isNumber(getLastCharacter(currentInput))) return;

            if(!hasAddedSignPN){
                if (getLastCharacter(currentInput) != '-') {
                    currentInput += "-";
                } else {
                    int length = currentInput.length();
                    String substring = currentInput.substring(length-2, length-1);

                    if (substring.equals("--") || substring.equals("+-") ||
                            substring.equals("*-") || substring.equals("/-")) {
                        currentInput = popBackCharacter(currentInput);
                    } else {
                        currentInput += '-';
                    }
                }
                hasAddedSignPN = true;
                editTextInputNumber.setText(currentInput);
            }
        };
        simulateButtonClicked(v, motion, addSignPN);

        return false;
    }

    private boolean onParenthesisButtonClicked(View v, MotionEvent motion) {
        Runnable addParenthesis = () -> {
            if (hasAddedParenthesis){
                currentInput += ")";
                hasAddedParenthesis = false;
            } else {
                currentInput += "(";
                hasAddedSignPN = false;
                hasAddedParenthesis = true;
            }
            editTextInputNumber.setText(currentInput);
        };
        simulateButtonClicked(v, motion, addParenthesis);

        return false;
    }

    private boolean onClearAllButtonClicked(View v, MotionEvent motion) {
        Runnable executeClear = () -> {
            currentInput = "";
            hasAddedSignPN = false;
            hasAddedParenthesis = false;
            hasClickedEqualButton = true;

            textViewAnswer.setText(currentInput);
            editTextInputNumber.setText(currentInput);
        };
        simulateButtonClicked(v, motion, executeClear);

        return false;
    }

    private boolean onBackspaceButtonClicked(View v, MotionEvent motion) {
        if (currentInput.isEmpty()) return true;

        Runnable executeClear = () -> {
            currentInput = popBackCharacter(currentInput);
            editTextInputNumber.setText(currentInput);

            if (currentInput.isEmpty()) {
                textViewAnswer.setText("");
            } else if (isNumber(getLastCharacter(currentInput))) {
                calculateResult();
            } else if (getLastCharacter(currentInput) == '('){
                hasAddedParenthesis = false;
            }
        };
        simulateButtonClicked(v, motion, executeClear);
        return false;
    }

    private boolean onEqualButtonClicked(View v, MotionEvent motion) {
        Runnable executeEqual = () -> {
            hasAddedSignPN = false;
            hasAddedParenthesis = false;
            hasClickedEqualButton = true;

            items.add(new Item(currentInput, String.valueOf(finalAnswer)));
            currentInput = String.valueOf(finalAnswer);

            textViewAnswer.setTextSize(36);
            editTextInputNumber.setTextSize(20);
            textViewAnswer.setTextColor(getResources().getColor(R.color.beige));
            editTextInputNumber.setTextColor(getResources().getColor(R.color.pink));
        };
        simulateButtonClicked(v, motion, executeEqual);
        return false;
    }

    private void changedTextColorSize() {
        if (!hasClickedEqualButton) return;

        textViewAnswer.setTextSize(20);
        editTextInputNumber.setTextSize(35);
        textViewAnswer.setTextColor(getResources().getColor(R.color.pink));
        editTextInputNumber.setTextColor(getResources().getColor(R.color.beige));
    }

    private boolean onOperatorButtonClicked(View v, MotionEvent motion, String operator) {
        Runnable executeOperator = () -> {
            if (currentInput.isEmpty()) return;
            if (isNumber(getLastCharacter(currentInput)) ||
                    getLastCharacter(currentInput) == ')') {

                currentInput += operator;
                editTextInputNumber.setText(currentInput);

                changedTextColorSize();
                calculateResult();
            }
        };
        simulateButtonClicked(v, motion, executeOperator);

        return false;
    }

    private void calculateResult() {
        try {
            if (currentInput.lastIndexOf('%') != -1) {
                currentInput = currentInput.replaceAll("(\\d+)%", "($1/100)");
            }
            Expression expression = new ExpressionBuilder(currentInput).build();
            finalAnswer = expression.evaluate();
            textViewAnswer.setText(String.valueOf(finalAnswer));
        } catch (Exception e) {
            textViewAnswer.setText("");
        }
    }

    private boolean onButtonZeroClicked(View v, MotionEvent motion) {
        Runnable addZeroToEditText = () -> {
            if (!currentInput.isEmpty()) {
                hasAddedSignPN = false;
                currentInput   += binding.buttonZero.getText();
                editTextInputNumber.setText(currentInput);

                changedTextColorSize();
                calculateResult();
            }
        };
        simulateButtonClicked(v, motion, addZeroToEditText);
        return false;
    }

    private boolean onNumberButtonClicked(View v, MotionEvent motion, String number) {
        Runnable addNumberToEditText = () -> {
            currentInput   += number;
            hasAddedSignPN = false;
            editTextInputNumber.setText(currentInput);

            changedTextColorSize();
            calculateResult();
        };
        simulateButtonClicked(v, motion, addNumberToEditText);
        return false;
    }

    private void simulateButtonClicked(View v, MotionEvent motion, Runnable action){
        switch (motion.getAction())
        {
            case MotionEvent.ACTION_DOWN: {
                action.run();
            } break;
            case MotionEvent.ACTION_UP: {
                v.performClick();
            } break;
        }
    }

    private char getLastCharacter(String text) {
        return text.charAt(text.length() - 1);
    }

    private String popBackCharacter(String text) {
        return text.substring(0, text.length()-1);
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}