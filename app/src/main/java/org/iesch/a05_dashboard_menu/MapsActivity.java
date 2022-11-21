package org.iesch.a05_dashboard_menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.iesch.a05_dashboard_menu.databinding.ActivityMapsBinding;
import org.iesch.a05_dashboard_menu.models.Instituto;

import java.util.ArrayList;
import java.util.List;

// Para poder mostrar un mapa necesitamos implementar a esta interfaz
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    // Esto se declara aqui por si el mapa se quiere usar en algun metodo que no sea onMapReady
    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    // 1 - Creamos una lista de Institutos
    private List<Instituto> listaInstitutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 3 - Llenamos la lista de Institutos
        addInstitutos();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    // 2 - Añadimos un metodo para crear Institutos aleatorios
    private void addInstitutos(){
        listaInstitutos = new ArrayList<>();
        listaInstitutos.add(new Instituto("IES Segundo de Chomón", 40.327068999058, -1.09829073116559));
        listaInstitutos.add(new Instituto("IES Vega del Turia", 40.34113626339, -1.10862098513217));
        listaInstitutos.add(new Instituto("IES Francés de Aranda", 40.351484500275, -1.10994890232875));
        listaInstitutos.add(new Instituto("IES Santa Emerenciana", 40.333292385265, -1.10630494465714));
        listaInstitutos.add(new Instituto("CIFP San Blas", 40.3485582660209, -1.1695877158206));
        listaInstitutos.add(new Instituto("CPIFP Escuela de Hostelería y Turismo", 40.3435690247580, -1.10756958883726));
    }







    // Este método ya trae el mapa y ya podemos trabajar con el
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Creamos un objeto de tipo LatLng
        LatLng teruel = new LatLng(40.34215462530947, -1.1071156044052786);

        // 4 - Vamos a crear un marcador para cada Instituto
        for (Instituto r:listaInstitutos){
            LatLng posicion = new LatLng(r.getLatitud(),r.getLongitud());
            String nombre = r.getNombre().toString();
            // 5 - Para añadir un icono personalizado a cada marker

            mMap.addMarker(new MarkerOptions()
                    .position(posicion)
                    .icon(bitmapDescriptorFromVector(this, R.drawable.ic_baseline_account_balance_24))
                    .title(nombre));
        }

        // Para añadir el marcador necesitamos MarkerOptions
        // Le asigna un título, pero podemos asignarle más cosas
        mMap.addMarker(new MarkerOptions().position(teruel).title("TERUEL"));
        // Le dice al mapa que mueva la camara
        // Si queremos que aparaezca mas cerca
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(teruel,14.0f));
    }


    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}