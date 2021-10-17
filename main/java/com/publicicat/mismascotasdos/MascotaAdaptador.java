package com.publicicat.mismascotasdos;

        import android.app.Activity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.inputmethod.ExtractedTextRequest;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.cardview.widget.CardView;
        import androidx.constraintlayout.utils.widget.ImageFilterView;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<ConstructorMascota> mascotas;

    Activity here;

    public MascotaAdaptador(ArrayList<ConstructorMascota> mascotas, Activity here) {
        this.mascotas = mascotas;
        this.here = here;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(vi);

    }
    // mètode onCreateViewHolder: fins aquí

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        ConstructorMascota mascota = mascotas.get(position);


        holder.tvNombreMascota.setText(mascota.getnMascota());
        holder.tvRating.setText(Integer.toString(mascota.getrMascota()));
        //holder.ivFotoMascota.setImageResource(mascota.getFoto());
        holder.ivFotoMascota.setImageResource(mascota.getFoto());

        holder.iv_huesoGris.setOnClickListener(new View.OnClickListener() {
            int n = mascota.getrMascota();
            int z = n + 10;
            @Override
            public void onClick(View v) {
                z = z;
                if ( n <= z) {
                    n = n + 1;
                    holder.tvRating.setText(Integer.toString(n));
                } else {
                    holder.tvRating.setText("hu?");

                }
            }
        });



    }
    //Mètode onBindViewHolder: fins aquí
    int items_length = 5;
    @Override
    public int getItemCount() {
        if (mascotas.size() > items_length ) {
            return items_length;
        } else {
            return mascotas.size();
        }

    } //Mètode int getItemCount(): fins aquí

    //Clase anidada
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        //Let's incialize xml holder names using it's similar tagname
        //CardView cv;
        ImageView ivFotoMascota;
        ImageView iv_huesoGris;
        TextView tvNombreMascota;
        TextView tvRating;
        //private ImageView iv_huesoDorado;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            //cv = (CardView) itemView.findViewById(R.id.cv_mascota);
            //Onc inicialized, let's associate them with xml real id tag
            ivFotoMascota = (ImageView) itemView.findViewById(R.id.iv_fotoMascota);
            iv_huesoGris = (ImageView) itemView.findViewById(R.id.iv_huesoGris);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tv_nombreMascota);
            tvRating = (TextView) itemView.findViewById(R.id.tv_rating);
            //iv_huesoDorado
        }

    }

}//End class MascotaAdaptadorRVMain

