// Generated by view binder compiler. Do not edit!
package com.example.projectteam.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projectteam.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatButton btnLogin;

  @NonNull
  public final EditText eid;

  @NonNull
  public final TextView eidValidations;

  @NonNull
  public final ImageView ivEye;

  @NonNull
  public final ConstraintLayout layoutEid;

  @NonNull
  public final ConstraintLayout layoutPassword;

  @NonNull
  public final ConstraintLayout login;

  @NonNull
  public final EditText password;

  @NonNull
  public final TextView passwordValidations;

  @NonNull
  public final ConstraintLayout toolbar;

  @NonNull
  public final TextView tvEid;

  @NonNull
  public final TextView tvHeading;

  @NonNull
  public final TextView tvLogin;

  @NonNull
  public final TextView tvPassword;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatButton btnLogin, @NonNull EditText eid, @NonNull TextView eidValidations,
      @NonNull ImageView ivEye, @NonNull ConstraintLayout layoutEid,
      @NonNull ConstraintLayout layoutPassword, @NonNull ConstraintLayout login,
      @NonNull EditText password, @NonNull TextView passwordValidations,
      @NonNull ConstraintLayout toolbar, @NonNull TextView tvEid, @NonNull TextView tvHeading,
      @NonNull TextView tvLogin, @NonNull TextView tvPassword) {
    this.rootView = rootView;
    this.btnLogin = btnLogin;
    this.eid = eid;
    this.eidValidations = eidValidations;
    this.ivEye = ivEye;
    this.layoutEid = layoutEid;
    this.layoutPassword = layoutPassword;
    this.login = login;
    this.password = password;
    this.passwordValidations = passwordValidations;
    this.toolbar = toolbar;
    this.tvEid = tvEid;
    this.tvHeading = tvHeading;
    this.tvLogin = tvLogin;
    this.tvPassword = tvPassword;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLogin;
      AppCompatButton btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.eid;
      EditText eid = ViewBindings.findChildViewById(rootView, id);
      if (eid == null) {
        break missingId;
      }

      id = R.id.eidValidations;
      TextView eidValidations = ViewBindings.findChildViewById(rootView, id);
      if (eidValidations == null) {
        break missingId;
      }

      id = R.id.ivEye;
      ImageView ivEye = ViewBindings.findChildViewById(rootView, id);
      if (ivEye == null) {
        break missingId;
      }

      id = R.id.layoutEid;
      ConstraintLayout layoutEid = ViewBindings.findChildViewById(rootView, id);
      if (layoutEid == null) {
        break missingId;
      }

      id = R.id.layoutPassword;
      ConstraintLayout layoutPassword = ViewBindings.findChildViewById(rootView, id);
      if (layoutPassword == null) {
        break missingId;
      }

      id = R.id.login;
      ConstraintLayout login = ViewBindings.findChildViewById(rootView, id);
      if (login == null) {
        break missingId;
      }

      id = R.id.password;
      EditText password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      id = R.id.passwordValidations;
      TextView passwordValidations = ViewBindings.findChildViewById(rootView, id);
      if (passwordValidations == null) {
        break missingId;
      }

      id = R.id.toolbar;
      ConstraintLayout toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tvEid;
      TextView tvEid = ViewBindings.findChildViewById(rootView, id);
      if (tvEid == null) {
        break missingId;
      }

      id = R.id.tvHeading;
      TextView tvHeading = ViewBindings.findChildViewById(rootView, id);
      if (tvHeading == null) {
        break missingId;
      }

      id = R.id.tvLogin;
      TextView tvLogin = ViewBindings.findChildViewById(rootView, id);
      if (tvLogin == null) {
        break missingId;
      }

      id = R.id.tvPassword;
      TextView tvPassword = ViewBindings.findChildViewById(rootView, id);
      if (tvPassword == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, btnLogin, eid, eidValidations,
          ivEye, layoutEid, layoutPassword, login, password, passwordValidations, toolbar, tvEid,
          tvHeading, tvLogin, tvPassword);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
