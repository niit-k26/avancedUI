package vn.com.demobroadcast.avancedui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentAbout extends Fragment {
    public static FragmentAbout newInstance() {

        Bundle args = new Bundle();

        FragmentAbout fragment = new FragmentAbout();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_about,null);
        return v;
    }
}
