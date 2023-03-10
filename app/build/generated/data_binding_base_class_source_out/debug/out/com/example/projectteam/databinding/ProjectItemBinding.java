// Generated by view binder compiler. Do not edit!
package com.example.projectteam.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projectteam.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProjectItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout card;

  @NonNull
  public final TextView pname;

  @NonNull
  public final TextView tname;

  private ProjectItemBinding(@NonNull ConstraintLayout rootView, @NonNull ConstraintLayout card,
      @NonNull TextView pname, @NonNull TextView tname) {
    this.rootView = rootView;
    this.card = card;
    this.pname = pname;
    this.tname = tname;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProjectItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProjectItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.project_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProjectItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout card = (ConstraintLayout) rootView;

      id = R.id.pname;
      TextView pname = ViewBindings.findChildViewById(rootView, id);
      if (pname == null) {
        break missingId;
      }

      id = R.id.tname;
      TextView tname = ViewBindings.findChildViewById(rootView, id);
      if (tname == null) {
        break missingId;
      }

      return new ProjectItemBinding((ConstraintLayout) rootView, card, pname, tname);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
