package ru.drugoigorod.app.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.drugoigorod.app.R;


public class NDrawerFragment extends Fragment {


    private View view;

    private static final int LAYOUT = R.layout.nav_drawer_fragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        setRetainInstance(true);

        return view;

    }
}
