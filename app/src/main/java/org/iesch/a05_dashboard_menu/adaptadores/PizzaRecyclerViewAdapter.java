package org.iesch.a05_dashboard_menu.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.iesch.a05_dashboard_menu.databinding.FragmentPizzaBinding;
import org.iesch.a05_dashboard_menu.models.Pizza;

import java.util.List;

public class PizzaRecyclerViewAdapter extends RecyclerView.Adapter<PizzaRecyclerViewAdapter.ViewHolder>{
    private final List<Pizza> mValues;
    private Context ctx;

    public PizzaRecyclerViewAdapter(Context context, List<Pizza> items) {
        mValues = items;
        ctx = context;
    }

    public void añadirPizza(List<Pizza> pizzas) {
        mValues.addAll(pizzas);
        notifyDataSetChanged();
    }

    @Override
    @NonNull
    public PizzaRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPizzaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Pizza pizza = mValues.get(position);
        holder.textViewPizza.setText(pizza.getNombre());
        holder.textViewDescripcion.setText(pizza.getDescripcion());
        Glide.with(ctx)
                .load(pizza.getUrlFoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(holder.imageViewFotoPizza);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textViewPizza;
        public final TextView textViewDescripcion;
        public final ImageView imageViewFotoPizza;

        public ViewHolder(@NonNull FragmentPizzaBinding binding) {
            super(binding.getRoot());
            textViewPizza = binding.textViewPizza;
            textViewDescripcion = binding.textViewDescripcionPizza;
            imageViewFotoPizza = binding.imageViewPizza;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewPizza.getText() + "'";
        }
    }
}
