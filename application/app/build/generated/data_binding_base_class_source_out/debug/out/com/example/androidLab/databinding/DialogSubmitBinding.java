// Generated by view binder compiler. Do not edit!
package com.example.androidLab.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.androidLab.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogSubmitBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonCancelSubmit;

  @NonNull
  public final Button buttonConfirmSubmit;

  @NonNull
  public final TextView textViewSummary;

  @NonNull
  public final TextView textViewTitle;

  private DialogSubmitBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonCancelSubmit, @NonNull Button buttonConfirmSubmit,
      @NonNull TextView textViewSummary, @NonNull TextView textViewTitle) {
    this.rootView = rootView;
    this.buttonCancelSubmit = buttonCancelSubmit;
    this.buttonConfirmSubmit = buttonConfirmSubmit;
    this.textViewSummary = textViewSummary;
    this.textViewTitle = textViewTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogSubmitBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogSubmitBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_submit, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogSubmitBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_cancel_submit;
      Button buttonCancelSubmit = ViewBindings.findChildViewById(rootView, id);
      if (buttonCancelSubmit == null) {
        break missingId;
      }

      id = R.id.button_confirm_submit;
      Button buttonConfirmSubmit = ViewBindings.findChildViewById(rootView, id);
      if (buttonConfirmSubmit == null) {
        break missingId;
      }

      id = R.id.textView_summary;
      TextView textViewSummary = ViewBindings.findChildViewById(rootView, id);
      if (textViewSummary == null) {
        break missingId;
      }

      id = R.id.textView_title;
      TextView textViewTitle = ViewBindings.findChildViewById(rootView, id);
      if (textViewTitle == null) {
        break missingId;
      }

      return new DialogSubmitBinding((ConstraintLayout) rootView, buttonCancelSubmit,
          buttonConfirmSubmit, textViewSummary, textViewTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}