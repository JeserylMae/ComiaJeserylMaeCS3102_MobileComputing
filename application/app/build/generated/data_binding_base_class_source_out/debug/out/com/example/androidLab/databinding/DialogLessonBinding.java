// Generated by view binder compiler. Do not edit!
package com.example.androidLab.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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

public final class DialogLessonBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton buttonBack;

  @NonNull
  public final CardView cardViewShadowedContainer;

  @NonNull
  public final TextView textViewContent;

  @NonNull
  public final TextView textviewTitle;

  private DialogLessonBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton buttonBack,
      @NonNull CardView cardViewShadowedContainer, @NonNull TextView textViewContent,
      @NonNull TextView textviewTitle) {
    this.rootView = rootView;
    this.buttonBack = buttonBack;
    this.cardViewShadowedContainer = cardViewShadowedContainer;
    this.textViewContent = textViewContent;
    this.textviewTitle = textviewTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogLessonBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogLessonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_lesson, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogLessonBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_back;
      ImageButton buttonBack = ViewBindings.findChildViewById(rootView, id);
      if (buttonBack == null) {
        break missingId;
      }

      id = R.id.cardView_shadowed_container;
      CardView cardViewShadowedContainer = ViewBindings.findChildViewById(rootView, id);
      if (cardViewShadowedContainer == null) {
        break missingId;
      }

      id = R.id.textView_content;
      TextView textViewContent = ViewBindings.findChildViewById(rootView, id);
      if (textViewContent == null) {
        break missingId;
      }

      id = R.id.textview_title;
      TextView textviewTitle = ViewBindings.findChildViewById(rootView, id);
      if (textviewTitle == null) {
        break missingId;
      }

      return new DialogLessonBinding((ConstraintLayout) rootView, buttonBack,
          cardViewShadowedContainer, textViewContent, textviewTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}