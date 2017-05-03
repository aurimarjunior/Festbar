package festbar.starpro.com.festbar.activity.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

import festbar.starpro.com.festbar.R;
import festbar.starpro.com.festbar.activity.Festas;

public class FragmentFestas extends Fragment {

    private RecyclerView mRecyclerView_listaFestas;
    private DatabaseReference mDatabase;

    public FragmentFestas() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate (R.layout.fragment_festas, container, false);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("festas");

        mRecyclerView_listaFestas = (RecyclerView) view.findViewById(R.id.recyclerView_listaFestas);
        mRecyclerView_listaFestas.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView_listaFestas.setLayoutManager(llm);

        return view;
    }

    @Override
    public void onStart(){
        super.onStart();

        FirebaseRecyclerAdapter<Festas, FestasViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Festas, FestasViewHolder>(
                Festas.class,
                R.layout.item_festas,
                FestasViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(FestasViewHolder viewHolder, Festas model, int position) {
                viewHolder.setNome(model.getNomeDaFesta());
                viewHolder.setLocal(model.getLocalFesta());
                viewHolder.setImagem(getContext(), model.getLogoFesta());
                viewHolder.setData(model.getDataFesta());
                viewHolder.setHorario(model.getHorarioFesta());
                viewHolder.setDistancia(model.getDistanciaFesta());
            }
        };

        mRecyclerView_listaFestas.setAdapter(firebaseRecyclerAdapter);
    }

    public static class FestasViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public FestasViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setNome(String nome){
            TextView textNomeDaFesta = (TextView) mView.findViewById(R.id.textNomeFestas);
            textNomeDaFesta.setText(nome);
        }

        public void setLocal(String local){
            TextView textLocalFesta = (TextView) mView.findViewById(R.id.textLocalFestas);
            textLocalFesta.setText(local);
        }

        public void setImagem(Context ctx, String imagem){
            ImageView logoFestas = (ImageView) mView.findViewById(R.id.logoFestas);
            Picasso.with(ctx).load(imagem).into(logoFestas);
        }

        public void setData(String data){
            TextView textDataDaFesta = (TextView) mView.findViewById(R.id.textDataFestas);
            textDataDaFesta.setText(data);
        }

        public void setHorario(String horario){
            TextView textHorarioDaFesta = (TextView) mView.findViewById(R.id.textHorarioFestas);
            textHorarioDaFesta.setText(horario);
        }

        public void setDistancia(String distancia){
            TextView textDistanciaDaFesta = (TextView) mView.findViewById(R.id.textDistanciaFestas);
            textDistanciaDaFesta.setText(distancia + " km");
        }
    }

}
