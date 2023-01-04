// Generated by view binder compiler. Do not edit!
package com.example.projectteam.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projectteam.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FilterItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ConstraintLayout filter;

  @NonNull
  public final ImageView ivCard;

  @NonNull
  public final TextView tvFilter;

  private FilterItemBinding(@NonNull CardView rootView, @NonNull ConstraintLayout filter,
      @NonNull ImageView ivCard, @NonNull TextView tvFilter) {
    this.rootView = rootView;
    this.filter = filter;
    this.ivCard = ivCard;
    this.tvFilter = tvFilter;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static FilterItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FilterItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.filter_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FilterItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.filter;
      ConstraintLayout filter = ViewBindings.findChildViewById(rootView, id);
      if (filter == null) {
        break missingId;
      }

      id = R.id.ivCard;
      ImageView ivCard = ViewBindings.findChildViewById(rootView, id);
      if (ivCard == null) {
        break missingId;
      }

      id = R.id.tvFilter;
      TextView tvFilter = ViewBindings.findChildViewById(rootView, id);
      if (tvFilter == null) {
        break missingId;
      }

      return new FilterItemBinding((CardView) rootView, filter, ivCard, tvFilter);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
