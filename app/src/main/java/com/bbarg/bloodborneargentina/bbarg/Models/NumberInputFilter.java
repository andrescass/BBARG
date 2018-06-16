package com.bbarg.bloodborneargentina.bbarg.Models;

import android.text.InputFilter;
import android.text.Spanned;

public class NumbreInputFilter implements InputFilter {
    private int min, max;

    public NumbreInputFilter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public NumbreInputFilter(String min, String max) {
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
    }


    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        return null;
    }
}
