package com.bbarg.bloodborneargentina.bbarg.Fragments;


import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.bbarg.bloodborneargentina.bbarg.Activities.loreItemActivity;
import com.bbarg.bloodborneargentina.bbarg.Adapters.LoreRecyclerAdapter;
import com.bbarg.bloodborneargentina.bbarg.Models.LoreBodies;
import com.bbarg.bloodborneargentina.bbarg.Models.LoreModel;
import com.bbarg.bloodborneargentina.bbarg.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment {

    private List<LoreModel> lores;
    private RecyclerView loreRec;


    public CardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        lores = new ArrayList<LoreModel>();

        LoreBodies lorBod = new LoreBodies();

        LoreModel lore1 = new LoreModel(0, "Byrgemwerth", lorBod.getLore_1(), R.drawable.byrgenwerth);
        LoreModel lore2 = new LoreModel(1, "Iglesia de la Sanación", lorBod.getLore_2(), R.drawable.iglesia);

        lores.add(lore1);
        lores.add(lore2);



        loreRec = view.findViewById(R.id.card_frag_rec);
        LoreRecyclerAdapter loreRecAd = new LoreRecyclerAdapter(lores, R.layout.lore_item_layout, new LoreRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(LoreModel lore, int position) {
                android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack(null).commit();
                Intent intent = new Intent(getActivity(), loreItemActivity.class);
                intent.putExtra("loreID", lore.getID());
                startActivity(intent);
            }
        });
        loreRec.setHasFixedSize(true);
        loreRec.setItemAnimator(new DefaultItemAnimator());
        loreRec.setLayoutManager(new LinearLayoutManager(this.getContext()));
        loreRec.setAdapter(loreRecAd);

        return view;
    }

}
