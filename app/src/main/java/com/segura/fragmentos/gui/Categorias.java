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
import com.segura.fragmentos.databinding.FragmentCategoriasBinding;
import com.segura.fragmentos.gui.components.ClasificacionsAdapter;
import com.segura.fragmentos.gui.components.JuegosAdapter;
import com.segura.fragmentos.gui.components.NavigationIconClickListener;
import com.segura.fragmentos.model.Clasificacion;

import java.util.ArrayList;
import java.util.List;


public class Categorias extends Fragment {

    private FragmentCategoriasBinding binding;
    private View view;
    private Context context;
    private List<Clasificacion> clasificaciones = new ArrayList<>();

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
        MainActivity.GLOBALS.put("CategoriasFragment", this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentCategoriasBinding.inflate(inflater, container, false);
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
                view.findViewById(R.id.gridCategorias),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));
    }

    private void configUI(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            view.findViewById(R.id.gridCategorias).setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));
        }
    }
    private void configRecycler() {
        clasificaciones.add(new Clasificacion("accion", "Accion"));
        clasificaciones.add(new Clasificacion("ar", "Arcade"));
        clasificaciones.add(new Clasificacion("futbol", "Deportivo"));
        clasificaciones.add(new Clasificacion("estra", "Estrategia"));
        clasificaciones.add(new Clasificacion("simul", "Simulacion"));
        clasificaciones.add(new Clasificacion("mesa", "Juegos de mesa"));
        clasificaciones.add(new Clasificacion("auricular", "Juegos musicales"));

        binding.rclvCategorias.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        binding.rclvCategorias.setLayoutManager(layoutManager);
        binding.rclvCategorias.setAdapter(new ClasificacionsAdapter(clasificaciones));
    }
}