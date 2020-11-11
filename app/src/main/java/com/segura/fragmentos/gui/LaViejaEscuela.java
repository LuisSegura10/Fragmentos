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
import com.segura.fragmentos.databinding.FragmentLaViejaEscuelaBinding;
import com.segura.fragmentos.gui.components.JuegosAdapter;
import com.segura.fragmentos.gui.components.NavigationIconClickListener;
import com.segura.fragmentos.model.Juego;
import com.segura.fragmentos.model.Juegos;

import java.util.ArrayList;
import java.util.List;


public class LaViejaEscuela extends Fragment {

    private FragmentLaViejaEscuelaBinding binding;
    private View view;
    private Context context;
    private List<Juegos> juegosN = new ArrayList<>();

    private final String PATH_TOP="laViejaEscuela";

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
        MainActivity.GLOBALS.put("topJuegosFragment", this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentLaViejaEscuelaBinding.inflate(inflater, container, false);
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
                view.findViewById(R.id.gridTopGames),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));
    }

    private void configUI(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            view.findViewById(R.id.gridTopGames).setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));
        }
    }
    private void configRecycler() {
        //juegos.add(new Juego(1, "pacman", "Pac-Man",5, "El objetivo del personaje es comer todos los puntos de la pantalla, momento en el que se pasa al siguiente nivel o pantalla."));
       // juegos.add(new Juego(7, "minecraft", "Minecraft", 2, "Minecraft es un videojuego de construcción, de tipo «mundo abierto» o sandbox"));
        //juegos.add(new Juego(10, "mariobros", "Mario Bros", 4, "El juego describe las aventuras de los hermanos Mario y Luigi"));
        //juegos.add(new Juego(4, "super", "Mario Bros 2", 5,"El juego de aventuta esta vez en un mundo diferente"));
        //juegos.add(new Juego(5, "superman", "Super Mario Bros", 4, "El primer capitulo de esta saga de avnetua"));
        //juegos.add(new Juego(6, "crash", "Crash", 3, "Acompaña al zorro crash en este divertido juego"));
        //juegos.add(new Juego(7, "metal", "Metal Slug", 5, "El juego trata de marco y sus amigos tienen un invreible viaje por un mundo demaciado extraño"));
        binding.rclvTopJuegos.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        binding.rclvTopJuegos.setLayoutManager(layoutManager);
        binding.rclvTopJuegos.setAdapter(new JuegosAdapter(juegosN));
    }
}