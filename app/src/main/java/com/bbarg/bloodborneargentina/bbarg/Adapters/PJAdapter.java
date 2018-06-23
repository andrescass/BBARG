package com.bbarg.bloodborneargentina.bbarg.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bbarg.bloodborneargentina.bbarg.Models.Stat;
import com.bbarg.bloodborneargentina.bbarg.R;

public class PJAdapter extends BaseAdapter{

    private final Context context;
    private final Stat[] stats;

    public PJAdapter(Context context, Stat[] stats) {
        this.context = context;
        this.stats = stats;
    }

    @Override
    public int getCount() {
        return stats.length;
    }

    @Override
    public Object getItem(int position) {
        return stats[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Stat stat = stats[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.pj_stat_layout, null);
        }

        final TextView nameText = convertView.findViewById(R.id.pj_stat_name);
        final TextView valueText = convertView.findViewById(R.id.pj_stat_value);

        nameText.setText(stat.getName());
        valueText.setText(Integer.toString(stat.getValue()));

        return convertView;
    }
}
