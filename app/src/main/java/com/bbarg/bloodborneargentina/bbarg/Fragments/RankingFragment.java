package com.bbarg.bloodborneargentina.bbarg.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbarg.bloodborneargentina.bbarg.Adapters.RankingAdapter;
import com.bbarg.bloodborneargentina.bbarg.Models.hunters;
import com.bbarg.bloodborneargentina.bbarg.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingFragment extends Fragment {

    List<hunters> hunts;
    RecyclerView rankRec;

    public RankingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ranking, container, false);

        hunts = new ArrayList<>();

        hunters hunter3 = new hunters(3, "Grillo la frente", 1, 20, 1);
        hunters hunter2 = new hunters(2, "Bode Tusk", 2, 15, 0);
        hunters hunter1 = new hunters(1, "carlaga come travas", 3, 10, 1);
        hunters hunter4 = new hunters(4, "Kahrl escoria", 4, 10, 4);
        hunters hunter5 = new hunters(5, "A ver Gaston", 5, 45, 4);
        hunters hunter6 = new hunters(6, "Alejandro Lopez", 6, 56, 7);
        hunters hunter7 = new hunters(7, "Shair bailador", 7, 45, 7);
        hunters hunter8 = new hunters(8, "Juan fastShot", 8, 45, 0);

        hunts.add(hunter3);
        hunts.add(hunter2);
        hunts.add(hunter1);
        hunts.add(hunter4);
        hunts.add(hunter5);
        hunts.add(hunter6);
        hunts.add(hunter7);
        hunts.add(hunter8);

        rankRec = view.findViewById(R.id.rank_frag_rec);
        RankingAdapter rankingAdapter = new RankingAdapter(hunts, R.layout.ranking_item_layout);
        rankRec.setHasFixedSize(true);
        rankRec.setItemAnimator(new DefaultItemAnimator());
        rankRec.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rankRec.setAdapter(rankingAdapter);

        return view;
    }

}
