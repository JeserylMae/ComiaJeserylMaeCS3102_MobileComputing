// Generated by view binder compiler. Do not edit!
package com.example.androidLab.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.androidLab.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityBluetoothWirelessRangeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton buttonBack;

  @NonNull
  public final ConstraintLayout buttonLessonFive;

  @NonNull
  public final ConstraintLayout buttonLessonFour;

  @NonNull
  public final ConstraintLayout buttonLessonOne;

  @NonNull
  public final ConstraintLayout buttonLessonThree;

  @NonNull
  public final ConstraintLayout buttonLessonTwo;

  @NonNull
  public final ConstraintLayout buttonLessonZero;

  @NonNull
  public final CardView cardViewShadowedContainer;

  @NonNull
  public final ImageView imageviewLessonFive;

  @NonNull
  public final ImageView imageviewLessonFour;

  @NonNull
  public final ImageView imageviewLessonOne;

  @NonNull
  public final ImageView imageviewLessonThree;

  @NonNull
  public final ImageView imageviewLessonTwo;

  @NonNull
  public final ImageView imageviewLessonZero;

  @NonNull
  public final ConstraintLayout layoutHeaderContainer;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView textviewLessonFive;

  @NonNull
  public final TextView textviewLessonFour;

  @NonNull
  public final TextView textviewLessonOne;

  @NonNull
  public final TextView textviewLessonThree;

  @NonNull
  public final TextView textviewLessonTwo;

  @NonNull
  public final TextView textviewLessonZero;

  private ActivityBluetoothWirelessRangeBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageButton buttonBack, @NonNull ConstraintLayout buttonLessonFive,
      @NonNull ConstraintLayout buttonLessonFour, @NonNull ConstraintLayout buttonLessonOne,
      @NonNull ConstraintLayout buttonLessonThree, @NonNull ConstraintLayout buttonLessonTwo,
      @NonNull ConstraintLayout buttonLessonZero, @NonNull CardView cardViewShadowedContainer,
      @NonNull ImageView imageviewLessonFive, @NonNull ImageView imageviewLessonFour,
      @NonNull ImageView imageviewLessonOne, @NonNull ImageView imageviewLessonThree,
      @NonNull ImageView imageviewLessonTwo, @NonNull ImageView imageviewLessonZero,
      @NonNull ConstraintLayout layoutHeaderContainer, @NonNull ConstraintLayout main,
      @NonNull TextView textviewLessonFive, @NonNull TextView textviewLessonFour,
      @NonNull TextView textviewLessonOne, @NonNull TextView textviewLessonThree,
      @NonNull TextView textviewLessonTwo, @NonNull TextView textviewLessonZero) {
    this.rootView = rootView;
    this.buttonBack = buttonBack;
    this.buttonLessonFive = buttonLessonFive;
    this.buttonLessonFour = buttonLessonFour;
    this.buttonLessonOne = buttonLessonOne;
    this.buttonLessonThree = buttonLessonThree;
    this.buttonLessonTwo = buttonLessonTwo;
    this.buttonLessonZero = buttonLessonZero;
    this.cardViewShadowedContainer = cardViewShadowedContainer;
    this.imageviewLessonFive = imageviewLessonFive;
    this.imageviewLessonFour = imageviewLessonFour;
    this.imageviewLessonOne = imageviewLessonOne;
    this.imageviewLessonThree = imageviewLessonThree;
    this.imageviewLessonTwo = imageviewLessonTwo;
    this.imageviewLessonZero = imageviewLessonZero;
    this.layoutHeaderContainer = layoutHeaderContainer;
    this.main = main;
    this.textviewLessonFive = textviewLessonFive;
    this.textviewLessonFour = textviewLessonFour;
    this.textviewLessonOne = textviewLessonOne;
    this.textviewLessonThree = textviewLessonThree;
    this.textviewLessonTwo = textviewLessonTwo;
    this.textviewLessonZero = textviewLessonZero;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBluetoothWirelessRangeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBluetoothWirelessRangeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_bluetooth_wireless_range, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBluetoothWirelessRangeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_back;
      ImageButton buttonBack = ViewBindings.findChildViewById(rootView, id);
      if (buttonBack == null) {
        break missingId;
      }

      id = R.id.button_lesson_five;
      ConstraintLayout buttonLessonFive = ViewBindings.findChildViewById(rootView, id);
      if (buttonLessonFive == null) {
        break missingId;
      }

      id = R.id.button_lesson_four;
      ConstraintLayout buttonLessonFour = ViewBindings.findChildViewById(rootView, id);
      if (buttonLessonFour == null) {
        break missingId;
      }

      id = R.id.button_lesson_one;
      ConstraintLayout buttonLessonOne = ViewBindings.findChildViewById(rootView, id);
      if (buttonLessonOne == null) {
        break missingId;
      }

      id = R.id.button_lesson_three;
      ConstraintLayout buttonLessonThree = ViewBindings.findChildViewById(rootView, id);
      if (buttonLessonThree == null) {
        break missingId;
      }

      id = R.id.button_lesson_two;
      ConstraintLayout buttonLessonTwo = ViewBindings.findChildViewById(rootView, id);
      if (buttonLessonTwo == null) {
        break missingId;
      }

      id = R.id.button_lesson_zero;
      ConstraintLayout buttonLessonZero = ViewBindings.findChildViewById(rootView, id);
      if (buttonLessonZero == null) {
        break missingId;
      }

      id = R.id.cardView_shadowed_container;
      CardView cardViewShadowedContainer = ViewBindings.findChildViewById(rootView, id);
      if (cardViewShadowedContainer == null) {
        break missingId;
      }

      id = R.id.imageview_lesson_five;
      ImageView imageviewLessonFive = ViewBindings.findChildViewById(rootView, id);
      if (imageviewLessonFive == null) {
        break missingId;
      }

      id = R.id.imageview_lesson_four;
      ImageView imageviewLessonFour = ViewBindings.findChildViewById(rootView, id);
      if (imageviewLessonFour == null) {
        break missingId;
      }

      id = R.id.imageview_lesson_one;
      ImageView imageviewLessonOne = ViewBindings.findChildViewById(rootView, id);
      if (imageviewLessonOne == null) {
        break missingId;
      }

      id = R.id.imageview_lesson_three;
      ImageView imageviewLessonThree = ViewBindings.findChildViewById(rootView, id);
      if (imageviewLessonThree == null) {
        break missingId;
      }

      id = R.id.imageview_lesson_two;
      ImageView imageviewLessonTwo = ViewBindings.findChildViewById(rootView, id);
      if (imageviewLessonTwo == null) {
        break missingId;
      }

      id = R.id.imageview_lesson_zero;
      ImageView imageviewLessonZero = ViewBindings.findChildViewById(rootView, id);
      if (imageviewLessonZero == null) {
        break missingId;
      }

      id = R.id.layout_header_container;
      ConstraintLayout layoutHeaderContainer = ViewBindings.findChildViewById(rootView, id);
      if (layoutHeaderContainer == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.textview_lesson_five;
      TextView textviewLessonFive = ViewBindings.findChildViewById(rootView, id);
      if (textviewLessonFive == null) {
        break missingId;
      }

      id = R.id.textview_lesson_four;
      TextView textviewLessonFour = ViewBindings.findChildViewById(rootView, id);
      if (textviewLessonFour == null) {
        break missingId;
      }

      id = R.id.textview_lesson_one;
      TextView textviewLessonOne = ViewBindings.findChildViewById(rootView, id);
      if (textviewLessonOne == null) {
        break missingId;
      }

      id = R.id.textview_lesson_three;
      TextView textviewLessonThree = ViewBindings.findChildViewById(rootView, id);
      if (textviewLessonThree == null) {
        break missingId;
      }

      id = R.id.textview_lesson_two;
      TextView textviewLessonTwo = ViewBindings.findChildViewById(rootView, id);
      if (textviewLessonTwo == null) {
        break missingId;
      }

      id = R.id.textview_lesson_zero;
      TextView textviewLessonZero = ViewBindings.findChildViewById(rootView, id);
      if (textviewLessonZero == null) {
        break missingId;
      }

      return new ActivityBluetoothWirelessRangeBinding((ConstraintLayout) rootView, buttonBack,
          buttonLessonFive, buttonLessonFour, buttonLessonOne, buttonLessonThree, buttonLessonTwo,
          buttonLessonZero, cardViewShadowedContainer, imageviewLessonFive, imageviewLessonFour,
          imageviewLessonOne, imageviewLessonThree, imageviewLessonTwo, imageviewLessonZero,
          layoutHeaderContainer, main, textviewLessonFive, textviewLessonFour, textviewLessonOne,
          textviewLessonThree, textviewLessonTwo, textviewLessonZero);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
