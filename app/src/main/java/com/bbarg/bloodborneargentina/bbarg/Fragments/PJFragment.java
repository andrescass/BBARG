package com.bbarg.bloodborneargentina.bbarg.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.bbarg.bloodborneargentina.bbarg.Adapters.PJAdapter;
import com.bbarg.bloodborneargentina.bbarg.Adapters.PJPageAdapter;
import com.bbarg.bloodborneargentina.bbarg.Models.Stat;
import com.bbarg.bloodborneargentina.bbarg.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PJFragment extends Fragment {

    private ViewPager pjViewPager;
    private PagerAdapter pjPagerAdapter;

    public PJFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pj, container, false);

        /**
         * ***************** UPPER VIEW **********************
         */

        Stat stat1 = new Stat("HP", 594, "");
        Stat stat8 = new Stat("Phys Def", 10, "");
        Stat stat2 = new Stat("Stamina", 91, "");
        Stat stat9 = new Stat("Slow Pois Def", 30, "");
        Stat stat3 = new Stat("Discovery", 100, "");
        Stat stat10 = new Stat("Fast Pois Def", 40, "");
        Stat stat4 = new Stat("R-Hand WPN1", 0, "");
        Stat stat11 = new Stat("Fren Def", 0, "");
        Stat stat5 = new Stat("R-Hand WPN2", 0, "");
        Stat stat12 = new Stat("Beasthood", 0, "");
        Stat stat6 = new Stat("L-Hand WPN1", 0, "");
        Stat stat7 = new Stat("L-Hand WPN2", 0, "");
        Stat[] stats_l = {stat1, stat2, stat3, stat4, stat5, stat6, stat7};
        Stat[] stats_r = {stat8, stat9, stat10, stat11, stat12};

        Stat statRed1 = new Stat("Physical", 0, "");
        Stat statRed2 = new Stat("  vs. Blunt", 0, "");
        Stat statRed3 = new Stat("  vs. Thrust", 0, "");
        Stat statRed4 = new Stat("Blood", 0, "");
        Stat statRed5 = new Stat("Arcane", 0, "");
        Stat statRed6 = new Stat("Fire", 0, "");
        Stat statRed7 = new Stat("Bolt", 0, "");

        Stat[] stats_dl = {statRed1, statRed2, statRed3, statRed4};
        Stat[] stats_dr = {statRed5, statRed6, statRed7};


        GridView gridView_l = view.findViewById(R.id.pj_grid_l);
        PJAdapter pjGridAdapter_l = new PJAdapter(this.getContext(), stats_l);
        gridView_l.setAdapter(pjGridAdapter_l);

        GridView gridView_r = view.findViewById(R.id.pj_grid_r);
        PJAdapter pjGridAdapter_r = new PJAdapter(this.getContext(), stats_r);
        gridView_r.setAdapter(pjGridAdapter_r);

        GridView gridView_dl = view.findViewById(R.id.pj_grid_dl);
        PJAdapter pjGridAdapter_dl = new PJAdapter(this.getContext(), stats_dl);
        gridView_dl.setAdapter(pjGridAdapter_dl);

        GridView gridView_dr = view.findViewById(R.id.pj_grid_dr);
        PJAdapter pjGridAdapter_dr = new PJAdapter(this.getContext(), stats_dr);
        gridView_dr.setAdapter(pjGridAdapter_dr);

        /* *************************************************************************** */

        /**
         * ***************** LOWER VIEW **********************
         */

        pjViewPager = view.findViewById(R.id.stat_pager);
        pjPagerAdapter = new PJPageAdapter(getChildFragmentManager());
        pjViewPager.setAdapter(pjPagerAdapter);



        return view;
    }

}
