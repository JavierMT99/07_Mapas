package org.iesch.a05_dashboard_menu.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.iesch.a05_dashboard_menu.R;
import org.iesch.a05_dashboard_menu.models.Disco;

import java.util.ArrayList;

public class AdaptadorDiscos extends BaseAdapter {
    // 2 - Creamos algunos atributos necesarios para etsa clase
    private final ArrayList<Disco> listaDiscos;
    private final Context context;

    // 3 - Generamos el constructor
    public AdaptadorDiscos(ArrayList<Disco> listaDiscos, Context context) {
        this.listaDiscos = listaDiscos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDiscos.size();
    }

    @Override
    public Disco getItem(int position) {
        return listaDiscos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 8 Creamos el elemento pelicula
        Disco disco = getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.disco_lista, null);
        // 7 - Vamos a crear cada elemento que va a contener el item
        ImageView imgCartel = convertView.findViewById(R.id.imgCartel);
        TextView tvTitulo = convertView.findViewById(R.id.tvDisco);
        TextView tvArtista = convertView.findViewById(R.id.tvArtista);
        TextView tvAno = convertView.findViewById(R.id.tvAno);

        // 8 - Vamos a llenar con datos cada elemento
        imgCartel.setImageResource(disco.getImgFoto());
        tvTitulo.setText(disco.getTitulo());
        tvArtista.setText(disco.getArtista());
        tvAno.setText(disco.getAno());

        return convertView;
    }
}
