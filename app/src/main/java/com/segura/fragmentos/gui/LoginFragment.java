package com.segura.fragmentos.gui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.segura.fragmentos.R;
import com.segura.fragmentos.databinding.FragmentLoginBinding;
import com.segura.fragmentos.gui.components.NavigationHost;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private View view;
    private Context context;
    private TextInputEditText Edithuser;
    private TextInputEditText edithpassword;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        configGlobals();
        configView(inflater, container);
        configListener();
        return view;

    }

    private void configListener() {
     binding.nextButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Edithuser = view.findViewById(R.id.username_edit);
             edithpassword = view.findViewById(R.id.password_edit);
             if (Edithuser.getText().toString().equals("luissegura507@gmail.com") && edithpassword.getText().toString().equals("segura")) {
                 ((NavigationHost) MainActivity.GLOBALS.get("app")).navigateTo(new TopJuegos(), false);
             } else {
                 Edithuser.setText("");
                 edithpassword.setText("");
                 Toast.makeText(getActivity(), "Error en usuario o contraseña", Toast.LENGTH_SHORT).show();
             }
         }
     });
     binding.cancelButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             System.exit(0);
         }
     });
    }

    private void configGlobals() {
        MainActivity.GLOBALS.put("loginFragment", this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
    binding = FragmentLoginBinding.inflate(inflater, container, false);
    view = binding.getRoot();
    context = container.getContext();
    }

}