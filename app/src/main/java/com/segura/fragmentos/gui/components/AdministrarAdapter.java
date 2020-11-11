package com.segura.fragmentos.gui.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.segura.fragmentos.R;
import com.segura.fragmentos.model.Juego;
import com.segura.fragmentos.model.Juegos;

import java.util.List;

public class AdministrarAdapter extends RecyclerView.Adapter<AdministrarAdapter.ViewHolder> {

    private List<Juegos> administrar;
    private Context context;

    public AdministrarAdapter(List<Juegos> administrar) {
        this.administrar = administrar;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_administrar, parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Juegos admin = administrar.get(position);
        String imgUri = admin.getImagenJ();
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .centerCrop();

        Glide.with(context)
                .load(imgUri)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error_24)
                .apply(options)
                .into(holder.imgJuego);
        holder.txtTitulo.setText(admin.getTitulo());
        holder.rblClasificacion.setRating(admin.getClasificacion());
        holder.txtDescripcion.setText(admin.getDescripcio());
    }

    @Override
    public int getItemCount() {
        return administrar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private AppCompatImageView imgJuego;
        private TextView txtTitulo;
        private AppCompatRatingBar rblClasificacion;
        private TextView txtDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgJuego = itemView.findViewById(R.id.imgJuegoadmin);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            rblClasificacion = itemView.findViewById(R.id.rbClasificacion);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
            this.view = itemView;
        }
    }
}