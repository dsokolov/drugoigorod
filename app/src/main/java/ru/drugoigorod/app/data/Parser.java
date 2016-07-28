package ru.drugoigorod.app.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Parser<T> {

    protected static String parse(String s, Pattern pattern) {
        final String r;
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            r = matcher.group(1);
        } else {
            r = "";
        }
        return r;
    }

    public final T parse(@Nullable String s) {
        if (TextUtils.isEmpty(s)) {
            throw new NullPointerException("nothing to parse");
        }
        return onParse(s);
    }

    protected abstract T onParse(@NotNull String s);

}
