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
import com.segura.fragmentos.databinding.FragmentFreeToPlayBinding;
import com.segura.fragmentos.gui.components.JuegosAdapter;
import com.segura.fragmentos.gui.components.NavigationIconClickListener;
import com.segura.fragmentos.model.Juego;
import com.segura.fragmentos.model.Juegos;

import java.util.ArrayList;
import java.util.List;

public class FreeToPlay extends Fragment {

    private FragmentFreeToPlayBinding binding;
    private View view;
    private Context context;
    private List<Juegos> juegosN = new ArrayList<>();

    private final String PATH_TOP="freeToPlay";

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
        MainActivity.GLOBALS.put("freeToPlayFragment", this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentFreeToPlayBinding.inflate(inflater, container, false);
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

        //juegos.add(new Juego(1, "fifa21", "Fifa 21",5, "Entra en el mundo del mejor deporte del mundo"));
        //juegos.add(new Juego(2, "cod", "Call of Duty",5, "Es una serie de videojuegos de disparos en primera persona, de estilo bélico"));
        //juegos.add(new Juego(3, "valorant", "Valorant",5, "Valorant es un videojuego multijugador de disparos tácticos en primera persona"));
        //juegos.add(new Juego(4, "amongus", "Among Us",4, "El juego tiene un grupo de jugadores a bordo de una nave espacial, cada uno de los cuales asume uno de los dos roles y algunos son impostores"));
        //juegos.add(new Juego(5, "freefire", "Free Fire", 5, " Es un juego móvil de acción-aventura del género battle royale, inspirado en PlayerUnknown's Battlegrounds (PUBG) "));
        //juegos.add(new Juego(6, "haloinfiniti", "Halo Infinity", 4, "Entra en un juego de accion en primera persona"));
        //juegos.add(new Juego(7, "cod5", "Call of Duty 5", 5, "Es uno de los mejores juegos de accion en primera persona"));
        //juegos.add(new Juego(7, "cod6", "Call of Duty 6", 5, "La saga continua en en siguiente nivel"));
        //juegos.add(new Juego(7, "cod7", "Call of Duty 7", 5, "Despues de este sera un asta luego para la continuacion de la saga de este juego"));
        binding.rclvTopJuegos.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        binding.rclvTopJuegos.setLayoutManager(layoutManager);
        binding.rclvTopJuegos.setAdapter(new JuegosAdapter(juegosN));
    }
}