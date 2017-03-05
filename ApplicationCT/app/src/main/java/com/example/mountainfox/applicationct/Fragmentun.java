package com.example.mountainfox.applicationct;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

/**
 * Created by Mountainfox on 09-Feb-17.
 */

public class Fragmentun extends Fragment{
    View myview;
    Spinner spinner;
    TextView txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myview=inflater.inflate(R.layout.second_activity,container,false);
        return myview;


    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        txt = (TextView) myview.findViewById(R.id.TextExtra);




        spinner = (Spinner) myview.findViewById(R.id.spinner);
        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List exempleList = new ArrayList();
        for(int i=0;i<Menu.ListeV.size();i++){
            exempleList.add(Menu.ListeV.get(i).Marque+" "+Menu.ListeV.get(i).Modele+" "+Menu.ListeV.get(i).Immatriculation);
        }


		/*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
		Avec la liste des elements (exemple) */
        ArrayAdapter adapter = new ArrayAdapter(
                getActivity().getBaseContext(),
                android.R.layout.simple_spinner_item,
                exempleList
        );


               /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Enfin on passe l'adapter au Spinner et c'est tout
        spinner.setAdapter(adapter);




        final Button btnSuivant = (Button) myview.findViewById(R.id.btnSui);

        btnSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Menu.numList = spinner.getSelectedItemPosition();
                ((TextView)getActivity().findViewById(R.id.Data_Activity_imat)).setText(Menu.ListeV.get(spinner.getSelectedItemPosition()).Immatriculation);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_frame,new Fragmentdeux());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


    }

}