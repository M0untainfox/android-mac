package com.example.mountainfox.applicationct;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mountainfox on 16-Feb-17.
 */

public class Fragment_Home extends Fragment {

    View myview;
    TextView user;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview=inflater.inflate(R.layout.fragment_home,container,false);
        return myview;
    }

    @Override
    public void onStart() {
        super.onStart();

        user = (TextView) myview.findViewById(R.id.home_Username);

        user.setText("Bienvenu "+((TextView)getActivity().findViewById(R.id.Data_Activity_Username)).getText().toString());

    }

}
