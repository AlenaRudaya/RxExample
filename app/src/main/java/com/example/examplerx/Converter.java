package com.example.examplerx;

import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by Helen_Rudaya on 5/6/2017.
 */


@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);


    @RequiresApi(api = Build.VERSION_CODES.N)
    default T fuuu(F from) {
        return null;
    }
}
