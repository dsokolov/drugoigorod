package ru.drugoigorod.app.data;

import android.text.TextUtils;

public abstract class Parser<T> {

    public final T parse(String s) {
        if (TextUtils.isEmpty(s)) {
            throw new NullPointerException("nothing to parse");
        }
        return onParse(s);
    }

    protected abstract T onParse(String s);

}
