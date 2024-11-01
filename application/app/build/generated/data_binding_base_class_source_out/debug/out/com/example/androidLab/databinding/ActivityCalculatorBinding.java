// Generated by view binder compiler. Do not edit!
package com.example.androidLab.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.androidLab.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCalculatorBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatButton buttonAdd;

  @NonNull
  public final ImageButton buttonBackspace;

  @NonNull
  public final Button buttonClearAll;

  @NonNull
  public final AppCompatButton buttonDivide;

  @NonNull
  public final AppCompatButton buttonEight;

  @NonNull
  public final AppCompatButton buttonEqual;

  @NonNull
  public final AppCompatButton buttonFive;

  @NonNull
  public final AppCompatButton buttonFour;

  @NonNull
  public final ImageButton buttonHistory;

  @NonNull
  public final AppCompatButton buttonMultiply;

  @NonNull
  public final AppCompatButton buttonNine;

  @NonNull
  public final AppCompatButton buttonOne;

  @NonNull
  public final AppCompatButton buttonParenthesis;

  @NonNull
  public final AppCompatButton buttonPercent;

  @NonNull
  public final AppCompatButton buttonPoint;

  @NonNull
  public final AppCompatButton buttonSeven;

  @NonNull
  public final AppCompatButton buttonSignPN;

  @NonNull
  public final AppCompatButton buttonSix;

  @NonNull
  public final AppCompatButton buttonSubtract;

  @NonNull
  public final AppCompatButton buttonThree;

  @NonNull
  public final AppCompatButton buttonTwo;

  @NonNull
  public final AppCompatButton buttonZero;

  @NonNull
  public final EditText editTextInputNumber;

  @NonNull
  public final GridLayout gridButtonContainer;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final ConstraintLayout textFieldContainer;

  @NonNull
  public final TextView textViewAnswer;

  @NonNull
  public final TextView textViewPageTitle;

  private ActivityCalculatorBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatButton buttonAdd, @NonNull ImageButton buttonBackspace,
      @NonNull Button buttonClearAll, @NonNull AppCompatButton buttonDivide,
      @NonNull AppCompatButton buttonEight, @NonNull AppCompatButton buttonEqual,
      @NonNull AppCompatButton buttonFive, @NonNull AppCompatButton buttonFour,
      @NonNull ImageButton buttonHistory, @NonNull AppCompatButton buttonMultiply,
      @NonNull AppCompatButton buttonNine, @NonNull AppCompatButton buttonOne,
      @NonNull AppCompatButton buttonParenthesis, @NonNull AppCompatButton buttonPercent,
      @NonNull AppCompatButton buttonPoint, @NonNull AppCompatButton buttonSeven,
      @NonNull AppCompatButton buttonSignPN, @NonNull AppCompatButton buttonSix,
      @NonNull AppCompatButton buttonSubtract, @NonNull AppCompatButton buttonThree,
      @NonNull AppCompatButton buttonTwo, @NonNull AppCompatButton buttonZero,
      @NonNull EditText editTextInputNumber, @NonNull GridLayout gridButtonContainer,
      @NonNull ConstraintLayout main, @NonNull ConstraintLayout textFieldContainer,
      @NonNull TextView textViewAnswer, @NonNull TextView textViewPageTitle) {
    this.rootView = rootView;
    this.buttonAdd = buttonAdd;
    this.buttonBackspace = buttonBackspace;
    this.buttonClearAll = buttonClearAll;
    this.buttonDivide = buttonDivide;
    this.buttonEight = buttonEight;
    this.buttonEqual = buttonEqual;
    this.buttonFive = buttonFive;
    this.buttonFour = buttonFour;
    this.buttonHistory = buttonHistory;
    this.buttonMultiply = buttonMultiply;
    this.buttonNine = buttonNine;
    this.buttonOne = buttonOne;
    this.buttonParenthesis = buttonParenthesis;
    this.buttonPercent = buttonPercent;
    this.buttonPoint = buttonPoint;
    this.buttonSeven = buttonSeven;
    this.buttonSignPN = buttonSignPN;
    this.buttonSix = buttonSix;
    this.buttonSubtract = buttonSubtract;
    this.buttonThree = buttonThree;
    this.buttonTwo = buttonTwo;
    this.buttonZero = buttonZero;
    this.editTextInputNumber = editTextInputNumber;
    this.gridButtonContainer = gridButtonContainer;
    this.main = main;
    this.textFieldContainer = textFieldContainer;
    this.textViewAnswer = textViewAnswer;
    this.textViewPageTitle = textViewPageTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCalculatorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCalculatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_calculator, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCalculatorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_add;
      AppCompatButton buttonAdd = ViewBindings.findChildViewById(rootView, id);
      if (buttonAdd == null) {
        break missingId;
      }

      id = R.id.button_backspace;
      ImageButton buttonBackspace = ViewBindings.findChildViewById(rootView, id);
      if (buttonBackspace == null) {
        break missingId;
      }

      id = R.id.button_clear_all;
      Button buttonClearAll = ViewBindings.findChildViewById(rootView, id);
      if (buttonClearAll == null) {
        break missingId;
      }

      id = R.id.button_divide;
      AppCompatButton buttonDivide = ViewBindings.findChildViewById(rootView, id);
      if (buttonDivide == null) {
        break missingId;
      }

      id = R.id.button_eight;
      AppCompatButton buttonEight = ViewBindings.findChildViewById(rootView, id);
      if (buttonEight == null) {
        break missingId;
      }

      id = R.id.button_equal;
      AppCompatButton buttonEqual = ViewBindings.findChildViewById(rootView, id);
      if (buttonEqual == null) {
        break missingId;
      }

      id = R.id.button_five;
      AppCompatButton buttonFive = ViewBindings.findChildViewById(rootView, id);
      if (buttonFive == null) {
        break missingId;
      }

      id = R.id.button_four;
      AppCompatButton buttonFour = ViewBindings.findChildViewById(rootView, id);
      if (buttonFour == null) {
        break missingId;
      }

      id = R.id.button_history;
      ImageButton buttonHistory = ViewBindings.findChildViewById(rootView, id);
      if (buttonHistory == null) {
        break missingId;
      }

      id = R.id.button_multiply;
      AppCompatButton buttonMultiply = ViewBindings.findChildViewById(rootView, id);
      if (buttonMultiply == null) {
        break missingId;
      }

      id = R.id.button_nine;
      AppCompatButton buttonNine = ViewBindings.findChildViewById(rootView, id);
      if (buttonNine == null) {
        break missingId;
      }

      id = R.id.button_one;
      AppCompatButton buttonOne = ViewBindings.findChildViewById(rootView, id);
      if (buttonOne == null) {
        break missingId;
      }

      id = R.id.button_parenthesis;
      AppCompatButton buttonParenthesis = ViewBindings.findChildViewById(rootView, id);
      if (buttonParenthesis == null) {
        break missingId;
      }

      id = R.id.button_percent;
      AppCompatButton buttonPercent = ViewBindings.findChildViewById(rootView, id);
      if (buttonPercent == null) {
        break missingId;
      }

      id = R.id.button_point;
      AppCompatButton buttonPoint = ViewBindings.findChildViewById(rootView, id);
      if (buttonPoint == null) {
        break missingId;
      }

      id = R.id.button_seven;
      AppCompatButton buttonSeven = ViewBindings.findChildViewById(rootView, id);
      if (buttonSeven == null) {
        break missingId;
      }

      id = R.id.button_signPN;
      AppCompatButton buttonSignPN = ViewBindings.findChildViewById(rootView, id);
      if (buttonSignPN == null) {
        break missingId;
      }

      id = R.id.button_six;
      AppCompatButton buttonSix = ViewBindings.findChildViewById(rootView, id);
      if (buttonSix == null) {
        break missingId;
      }

      id = R.id.button_subtract;
      AppCompatButton buttonSubtract = ViewBindings.findChildViewById(rootView, id);
      if (buttonSubtract == null) {
        break missingId;
      }

      id = R.id.button_three;
      AppCompatButton buttonThree = ViewBindings.findChildViewById(rootView, id);
      if (buttonThree == null) {
        break missingId;
      }

      id = R.id.button_two;
      AppCompatButton buttonTwo = ViewBindings.findChildViewById(rootView, id);
      if (buttonTwo == null) {
        break missingId;
      }

      id = R.id.button_zero;
      AppCompatButton buttonZero = ViewBindings.findChildViewById(rootView, id);
      if (buttonZero == null) {
        break missingId;
      }

      id = R.id.editText_input_number;
      EditText editTextInputNumber = ViewBindings.findChildViewById(rootView, id);
      if (editTextInputNumber == null) {
        break missingId;
      }

      id = R.id.grid_button_container;
      GridLayout gridButtonContainer = ViewBindings.findChildViewById(rootView, id);
      if (gridButtonContainer == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.text_field_container;
      ConstraintLayout textFieldContainer = ViewBindings.findChildViewById(rootView, id);
      if (textFieldContainer == null) {
        break missingId;
      }

      id = R.id.textView_answer;
      TextView textViewAnswer = ViewBindings.findChildViewById(rootView, id);
      if (textViewAnswer == null) {
        break missingId;
      }

      id = R.id.textView_page_title;
      TextView textViewPageTitle = ViewBindings.findChildViewById(rootView, id);
      if (textViewPageTitle == null) {
        break missingId;
      }

      return new ActivityCalculatorBinding((ConstraintLayout) rootView, buttonAdd, buttonBackspace,
          buttonClearAll, buttonDivide, buttonEight, buttonEqual, buttonFive, buttonFour,
          buttonHistory, buttonMultiply, buttonNine, buttonOne, buttonParenthesis, buttonPercent,
          buttonPoint, buttonSeven, buttonSignPN, buttonSix, buttonSubtract, buttonThree, buttonTwo,
          buttonZero, editTextInputNumber, gridButtonContainer, main, textFieldContainer,
          textViewAnswer, textViewPageTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
