package com.example.mountainfox.applicationct;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Mountainfox on 27-Feb-17.
 */


public class Fragment_AjoutVehicule extends Fragment {

    View myview;
    EditText Mark,Mod,Imat,Ann,KM;
    Button btnAjou;
    Spinner spinnerType;
    int year,tav,tap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview=inflater.inflate(R.layout.fragment_ajoutvehicule,container,false);
        return myview;
    }

    @Override
    public void onStart() {
        super.onStart();

        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);

        Mark = (EditText) myview.findViewById(R.id.editTextMarque);
        Mod = (EditText) myview.findViewById(R.id.editModele);
        Ann = (EditText) myview.findViewById(R.id.editAnnee);
        KM = (EditText) myview.findViewById(R.id.editTextKm);
        Imat = (EditText) myview.findViewById(R.id.editTextImat);
        spinnerType = (Spinner) myview.findViewById(R.id.SpinnerType);
        btnAjou = (Button)myview.findViewById(R.id.btnAjout);

        List LsType;

        LsType = new ArrayList();
        for(int i=0;i<Menu.ListeC.size();i++){
            LsType.add(Menu.ListeC.get(i).nom);
        }


        List exempleList = new ArrayList();
        for(int i=0;i<LsType.size();i++){
            exempleList.add(LsType.get(i));
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
        spinnerType.setAdapter(adapter);



        btnAjou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Integer.parseInt(Ann.getText().toString())<1900){
                    Ann.setText("1900");
                    Toast.makeText(getActivity(), "Année mini 1900", Toast.LENGTH_SHORT).show();
                }

                if(Integer.parseInt(Ann.getText().toString())>2018){
                    Ann.setText("2018");
                    Toast.makeText(getActivity(), "Année max 2018", Toast.LENGTH_SHORT).show();
                }




                if(Mark.getText().toString().equals("") || Mod.getText().toString().equals("") || Imat.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Erreur dans les saisie", Toast.LENGTH_SHORT).show();
                }
                else{
                    Menu.ajouterListV(Mark.getText().toString(),Mod.getText().toString(),Imat.getText().toString(),Integer.parseInt(Ann.getText().toString()),Integer.parseInt(KM.getText().toString()),spinnerType.getSelectedItemPosition());
                    Mark.setText("");
                    Mod.setText("");
                    Imat.setText("");
                    Ann.setText("");
                    KM.setText("");
                    spinnerType.setSelection(0);
                    Toast.makeText(getActivity(), "Véhicule inseré", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}


