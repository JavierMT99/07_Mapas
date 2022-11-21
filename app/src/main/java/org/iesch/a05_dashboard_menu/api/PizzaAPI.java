package org.iesch.a05_dashboard_menu.api;

import org.iesch.a05_dashboard_menu.models.Pizza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PizzaAPI {
    @GET("pizzas")
    Call<List<Pizza>> obtenerPizzas();
}

