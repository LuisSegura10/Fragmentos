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
import com.segura.fragmentos.databinding.FragmentTopRankedBinding;
import com.segura.fragmentos.gui.components.JuegosAdapter;
import com.segura.fragmentos.gui.components.NavigationIconClickListener;
import com.segura.fragmentos.model.Juego;
import com.segura.fragmentos.model.Juegos;

import java.util.ArrayList;
import java.util.List;

public class TopRanked extends Fragment {

    private FragmentTopRankedBinding binding;
    private View view;
    private Context context;
    private List<Juegos> juegosN = new ArrayList<>();

    private final String PATH_TOP="topRanked";

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
        MainActivity.GLOBALS.put("topRankedFragment", this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentTopRankedBinding.inflate(inflater, container, false);
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

        //juegos.add(new Juego(1, "mk", "Mortal Kombat",5, "Es un juego de peleas y vas pasando de nivel si vences a tus adversarios"));
        //juegos.add(new Juego(2, "mk2", "Mortal Kombat 2",5, "Es un juego de accion despues del primero llega la segunda ediccion"));
        //juegos.add(new Juego(3, "valorant", "Valorant",5, "Valorant es un videojuego multijugador de disparos tácticos en primera persona"));
        //juegos.add(new Juego(4, "mkx", "Mortal Kombat X",4, "Vamos a la edicion x de estes gran juego con nuevos personajes"));
        //juegos.add(new Juego(5, "mkl", "Mortal Kombat legion",5, "La version Legion esta un poco mejor que las demas"));
        //juegos.add(new Juego(6, "haloreah", "Halo Reach", 5, "Vamos a la ediccion Reach de este interesante juego en primera persona de accion"));

        binding.rclvTopJuegos.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        binding.rclvTopJuegos.setLayoutManager(layoutManager);
        binding.rclvTopJuegos.setAdapter(new JuegosAdapter(juegosN));
    }
}