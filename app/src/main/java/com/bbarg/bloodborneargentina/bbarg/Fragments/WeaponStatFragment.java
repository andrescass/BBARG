package com.bbarg.bloodborneargentina.bbarg.Fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.bbarg.bloodborneargentina.bbarg.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeaponStatFragment extends Fragment {
    boolean leftWeapon;


    public WeaponStatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weapon_stat, container, false);

        Bundle args = getArguments();
        leftWeapon = args.getBoolean("isLeft");

        /**
         * Retrieve wiev resources
         */

        Spinner upWpnSpinner = view.findViewById(R.id.wpn_stat_up);
        EditText upPhyTxt = view.findViewById(R.id.wpn_stat_txt_phys_up);
        EditText upBloodTxt = view.findViewById(R.id.wpn_stat_txt_blood_up);
        EditText upArkTxt = view.findViewById(R.id.wpn_stat_txt_ark_up);
        EditText upFireTxt = view.findViewById(R.id.wpn_stat_txt_fir_up);
        EditText upBoltTxt = view.findViewById(R.id.wpn_stat_txt_bolt_up);

        Spinner downWpnSpinner = view.findViewById(R.id.wpn_stat_down);
        EditText downPhyTxt = view.findViewById(R.id.wpn_stat_txt_phys_down);
        EditText downBloodTxt = view.findViewById(R.id.wpn_stat_txt_blood_down);
        EditText downArkTxt = view.findViewById(R.id.wpn_stat_txt_ark_down);
        EditText downFireTxt = view.findViewById(R.id.wpn_stat_txt_fir_down);
        EditText downBoltTxt = view.findViewById(R.id.wpn_stat_txt_bolt_down);

        if(leftWeapon)
        {
            Resources res = getResources();
            upWpnSpinner.setAdapter(new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item,
                    res.getStringArray(R.array.left_hand_weapons)));
            downWpnSpinner.setAdapter(new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item,
                    res.getStringArray(R.array.left_hand_weapons)));
        }
        else
        {
            Resources res = getResources();
            upWpnSpinner.setAdapter(new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item,
                    res.getStringArray(R.array.right_hand_weapons)));
            downWpnSpinner.setAdapter(new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item,
                    res.getStringArray(R.array.right_hand_weapons)));
        }


        return view;
    }

}
