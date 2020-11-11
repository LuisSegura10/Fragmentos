package com.segura.fragmentos.gui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.segura.fragmentos.R;
import com.segura.fragmentos.databinding.FragmentMisJuegosBinding;
import com.segura.fragmentos.gui.components.MisJuegosAdapter;
import com.segura.fragmentos.gui.components.NavigationIconClickListener;
import com.segura.fragmentos.model.MiJuego;

import java.util.ArrayList;
import java.util.List;

public class MisJuegos extends Fragment {

    private FragmentMisJuegosBinding binding;
    private View view;
    private Context context;
    private List<MiJuego> MisJuegos = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        configGlobals();
        configView(inflater, container);
        configToolbar();
        configUI();
        configRecycler();

        return view;
    }

    private void configGlobals() {
        MainActivity.GLOBALS.put("MisJuegosFragment", this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentMisJuegosBinding.inflate(inflater, container, false);
        view = binding.getRoot();
        context = container.getContext();
    }

    private void configToolbar() {
        AppCompatActivity activity = (AppCompatActivity)getActivity();
        if (activity!=null){
            activity.setSupportActionBar(binding.appBar);
        }
        binding.appBar.setNavigationOnClickListener(new NavigationIconClickListener(
                context,
                view.findViewById(R.id.gridMisJuegos),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));
    }

    private void configUI(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            view.findViewById(R.id.gridMisJuegos).setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));
        }
    }
    private void configRecycler() {
        //MisJuegos.add(new MiJuego(1, "cod", "Call of Duty", 5, "chido"));
        //MisJuegos.add(new MiJuego(1, "cod2", "Call of Duty", 5, "chido"));
        //MisJuegos.add(new MiJuego(1, "cod3", "Call of Duty", 5, "chido"));
        //MisJuegos.add(new MiJuego(1, "cod4", "Call of Duty", 5, "chido"));
        //MisJuegos.add(new MiJuego(1, "cod5", "Call of Duty", 5, "chido"));
        //MisJuegos.add(new MiJuego(1, "cod6", "Call of Duty", 5, "chido"));
        //MisJuegos.add(new MiJuego(1, "cod7", "Call of Duty", 5, "chido"));
        binding.rclvMisJuegos.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        binding.rclvMisJuegos.setLayoutManager(layoutManager);
        binding.rclvMisJuegos.setAdapter(new MisJuegosAdapter(MisJuegos));
    }
}