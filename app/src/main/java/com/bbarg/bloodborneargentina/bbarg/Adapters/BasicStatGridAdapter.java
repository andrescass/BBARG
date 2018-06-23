package com.bbarg.bloodborneargentina.bbarg.Adapters;

import android.content.Context;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bbarg.bloodborneargentina.bbarg.Models.NumberInputFilter;
import com.bbarg.bloodborneargentina.bbarg.Models.Stat;
import com.bbarg.bloodborneargentina.bbarg.R;

public class BasicStatGridAdapter extends BaseAdapter {

    private final Context context;
    private final Stat[] stats;
    private OnUpButtonClickListener upClikListener;
    private OnDownButtonClickListener downClikListener;

    public BasicStatGridAdapter(Context context, Stat[] stats) {
        this.context = context;
        this.stats = stats;
    }

    public BasicStatGridAdapter(Context context, Stat[] stats, OnUpButtonClickListener upClikListener, OnDownButtonClickListener downClikListener) {
        this.context = context;
        this.stats = stats;
        this.upClikListener = upClikListener;
        this.downClikListener = downClikListener;
    }

    @Override
    public int getCount() {
        return stats.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Stat stat = stats[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.basic_stat_item_layout, null);
        }

        final TextView nameText = convertView.findViewById(R.id.basic_stat_item_name);
        final EditText valueText = convertView.findViewById(R.id.basic_stat_item_value);
        final ImageButton upBtn = convertView.findViewById(R.id.basic_stat_item_up);
        final ImageButton downBtn = convertView.findViewById(R.id.basic_stat_item_down);

        nameText.setText(stat.getName());
        valueText.setFilters(new InputFilter[]{new NumberInputFilter(1, 100)});
        valueText.setText(Integer.toString(stat.getValue()));

        valueText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                stat.setValue(Integer.valueOf(valueText.getText().toString()));
                return false;
            }
        });

        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((stat.getValue()+1) < stat.getMaxValue())
                {
                    stat.setValue(stat.getValue()+1);
                }

                upClikListener.onUpClick(position);
            }
        });

        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((stat.getValue()-1) > stat.getMinValue())
                {
                    stat.setValue(stat.getValue()-1);
                }

                downClikListener.onDownClick(position);
            }
        });

        return convertView;
    }

    public interface OnUpButtonClickListener {
        void onUpClick(int position);
    }

    public interface OnDownButtonClickListener {
        void onDownClick(int position);
    }
}
