package com.bbarg.bloodborneargentina.bbarg.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.bbarg.bloodborneargentina.bbarg.Adapters.BasicStatGridAdapter;
import com.bbarg.bloodborneargentina.bbarg.Models.Stat;
import com.bbarg.bloodborneargentina.bbarg.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class basicStatFragment extends Fragment {

    private GridView grid_l;
    private GridView grid_r;
    BasicStatGridAdapter gridlAdapter;
    BasicStatGridAdapter gridrAdapter;
    private Stat stats_l[];
    private Stat stats_r[];

    public basicStatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_basic_stat, container, false);

        Stat statIns = new Stat("Insight", 0, 0, 99, null);
        Stat statVit = new Stat("Vitality", 11, 11, 99, null);
        Stat statEnd = new Stat("Endurance", 10, 10, 99, null);
        Stat statStr = new Stat("Strength", 12, 12, 99, null);
        Stat statSkill = new Stat("Skill", 10, 10, 99, null);
        Stat statBld = new Stat("Bloodtinge", 9, 9, 99, null);
        Stat statArc = new Stat("Arcane", 8, 8, 99, null);

        stats_l = new Stat[3];
        stats_r = new Stat[4];

        stats_l[0] = statIns;
        stats_l[1] = statVit;
        stats_l[2] = statEnd;
        stats_r[0] = statStr;
        stats_r[1] = statSkill;
        stats_r[2] = statBld;
        stats_r[3] = statArc;

        grid_l = view.findViewById(R.id.basic_stat_grid_l);
        gridlAdapter = new BasicStatGridAdapter(this.getContext(), stats_l,
                new BasicStatGridAdapter.OnUpButtonClickListener() {
                    @Override
                    public void onUpClick(int position) {
                        ArrowPressed();
                    }
                },
                new BasicStatGridAdapter.OnDownButtonClickListener() {
                    @Override
                    public void onDownClick(int position) {
                        ArrowPressed();
                    }
                });
        grid_l.setAdapter(gridlAdapter);

        grid_r = view.findViewById(R.id.basic_stat_grid_r);
        gridrAdapter = new BasicStatGridAdapter(this.getContext(), stats_r,
                new BasicStatGridAdapter.OnUpButtonClickListener() {
                    @Override
                    public void onUpClick(int position) {
                        ArrowPressed();
                    }
                },
                new BasicStatGridAdapter.OnDownButtonClickListener() {
                    @Override
                    public void onDownClick(int position) {
                        ArrowPressed();
                    }
                });
        grid_r.setAdapter(gridrAdapter);

        return view;
    }

    void ArrowPressed()
    {
        BasicStatGridAdapter gridlAdapter = new BasicStatGridAdapter(this.getContext(), stats_l,
                new BasicStatGridAdapter.OnUpButtonClickListener() {
                    @Override
                    public void onUpClick(int position) {
                        ArrowPressed();
                    }
                },
                new BasicStatGridAdapter.OnDownButtonClickListener() {
                    @Override
                    public void onDownClick(int position) {
                        ArrowPressed();
                    }
                });
        grid_l.setAdapter(gridlAdapter);

        BasicStatGridAdapter gridrAdapter = new BasicStatGridAdapter(this.getContext(), stats_r,
                new BasicStatGridAdapter.OnUpButtonClickListener() {
                    @Override
                    public void onUpClick(int position) {
                        ArrowPressed();
                    }
                },
                new BasicStatGridAdapter.OnDownButtonClickListener() {
                    @Override
                    public void onDownClick(int position) {
                        ArrowPressed();
                    }
                });
        grid_r.setAdapter(gridrAdapter);

       /* gridlAdapter.notifyDataSetChanged();
        grid_l.setAdapter(gridlAdapter);

        gridrAdapter.notifyDataSetChanged();
        grid_r.setAdapter(gridrAdapter);
*/

    }

}
