package org.iesch.a05_dashboard_menu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.iesch.a05_dashboard_menu.adaptadores.PizzaRecyclerViewAdapter;
import org.iesch.a05_dashboard_menu.api.PizzaAPI;
import org.iesch.a05_dashboard_menu.models.Pizza;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PizzaFragment extends Fragment {

    PizzaRecyclerViewAdapter adaptadorPizzas;
    List<Pizza> pizzas;

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    public PizzaFragment() {
        // Required empty public constructor
    }

    public static PizzaFragment newInstance(int columnCount) {
        PizzaFragment fragment = new PizzaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pizza_list, container, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-anon-a4c78fed24-codingpizza.apiary-mock.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            }

            pizzas = new ArrayList<>();
            PizzaAPI pizzaAPI = retrofit.create(PizzaAPI.class);
            Call<List<Pizza>> lstPizzas = pizzaAPI.obtenerPizzas();

            lstPizzas.enqueue(new Callback<List<Pizza>>() {
                @Override
                public void onResponse(Call<List<Pizza>> call, Response<List<Pizza>> response) {
                    adaptadorPizzas.añadirPizza(response.body());
                }

                @Override
                public void onFailure(Call<List<Pizza>> call, Throwable t) {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                }
            });

            adaptadorPizzas = new PizzaRecyclerViewAdapter(getActivity(), pizzas);
            recyclerView.setAdapter(adaptadorPizzas);
        }

        return view;
    }
}