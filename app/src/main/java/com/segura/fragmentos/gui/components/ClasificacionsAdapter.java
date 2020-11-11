package com.segura.fragmentos.gui.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.segura.fragmentos.R;
import com.segura.fragmentos.model.Clasificacion;

import java.util.List;

public class ClasificacionsAdapter extends RecyclerView.Adapter<ClasificacionsAdapter.ViewHolder> {

    private List<Clasificacion> clasificacions;
    private Context context;

    public ClasificacionsAdapter(List<Clasificacion> clasificacions) {
        this.clasificacions = clasificacions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_clasificacion, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Clasificacion clasificacion = clasificacions.get(position);
        String imgUri = "@drawable/" + clasificacion.getImagen();
        int imgResource = context.getResources().getIdentifier(imgUri,null, context.getPackageName());
        holder.imgClasificacion.setImageResource(imgResource);
        holder.txtTitulo.setText(clasificacion.getTitulo());

    }

    @Override
    public int getItemCount() {
        return clasificacions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private AppCompatImageView imgClasificacion;
        private TextView txtTitulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgClasificacion = itemView.findViewById(R.id.imgen);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            this.view = itemView;
        }
    }
}
