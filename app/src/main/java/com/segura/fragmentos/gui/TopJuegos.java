package com.segura.fragmentos.gui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.segura.fragmentos.R;
import com.segura.fragmentos.databinding.FragmentTopJuegosBinding;
import com.segura.fragmentos.gui.components.JuegosAdapter;
import com.segura.fragmentos.gui.components.NavigationHost;
import com.segura.fragmentos.gui.components.NavigationIconClickListener;
import com.segura.fragmentos.model.Juego;
import com.segura.fragmentos.model.Juegos;

import java.util.ArrayList;
import java.util.List;


public class TopJuegos extends Fragment {

    private FragmentTopJuegosBinding binding;
    private View view;
    private Context context;
    private List<Juegos> juegosN = new ArrayList<>();

    private final String PATH_TOP="topJuegos";
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

          configGlobals();
          configView(inflater, container);
          configToolbar();
          configUI();
          configRecycler();


        binding.fabCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NavigationHost)getActivity()).navigateTo(new AddFragment(), true);
            }
        });
          return view;
    }

    private void configGlobals() {
        MainActivity.GLOBALS.put("topJuegosFragment", this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentTopJuegosBinding.inflate(inflater, container, false);
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

        //juegos.add(new Juego(1, "pubg", "PUBG",5, "Un gra juego que al parecer esta siento muy popuplar ya que no requiere mucho para jugarlo"));
        //juegos.add(new Juego(2, "cod", "Call of Duty",5, "Es una serie de videojuegos de disparos en primera persona, de estilo bélico"));
        //juegos.add(new Juego(3, "valorant", "Valorant",5, "Valorant es un videojuego multijugador de disparos tácticos en primera persona"));
        //juegos.add(new Juego(4, "amongus", "Among Us",4, "El juego tiene un grupo de jugadores a bordo de una nave espacial, cada uno de los cuales asume uno de los dos roles y algunos son impostores"));
        //juegos.add(new Juego(5, "fifa", "Fifa 20",5, "FIFA 20 es un videojuego de simulación de fútbol desarrollado por EA Sports"));
        //juegos.add(new Juego(6, "halo", "Halo", 4, "Halo, es un videojuego de disparos en primera"));
        //juegos.add(new Juego(7, "minecraft", "Minecraft", 2, "Minecraft es un videojuego de construcción, de tipo «mundo abierto» o sandbox"));
        //juegos.add(new Juego(8, "spiderman", "Spider-Man", 1, "Es un videojuego de acción y aventuras con un estilo jugable de mundo abierto,"));
        //juegos.add(new Juego(9, "freefire", "Free Fire", 5, " Es un juego móvil de acción-aventura del género battle royale, inspirado en PlayerUnknown's Battlegrounds (PUBG) "));
        //juegos.add(new Juego(10, "cogmobil", "Call of Duty Mobile", 4, "El juego de accion es primera persona y esto surgue en una guerra"));
        binding.rclvTopJuegos.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        binding.rclvTopJuegos.setLayoutManager(layoutManager);
        binding.rclvTopJuegos.setAdapter(new JuegosAdapter(juegosN));

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(PATH_TOP);

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Juegos juegos = snapshot.getValue(Juegos.class);

                if (juegosN.containsAll(juegosN)){
                    juegosN.add(juegos);
                }
                binding.rclvTopJuegos.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Juegos juego = snapshot.getValue(Juegos.class);
                if (juego != null){
                    Log.i("juego","onChildChanged: " + juego.getIdJuegos());
                }

                juegosN.set(juegosN.indexOf(juego),juego);
                binding.rclvTopJuegos.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        }
    }
