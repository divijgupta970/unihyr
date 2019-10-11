package divij.com.unihyr;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import divij.com.unihyr.Adapters.ActiveProfilesAdapter;
import divij.com.unihyr.Adapters.offerAdapter_nik;
import divij.com.unihyr.CardClasses.offer_nik;


/**
 * A simple {@link Fragment} subclass.
 */
public class offer_fragment_nik extends Fragment {
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private List<offer_nik> offer_nik;

    public offer_fragment_nik() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_offer_fragment_nik, container, false);
        progressBar=v.findViewById(R.id.pbActiveProfiles_offer);
        offer_nik=new ArrayList<>();
        progressBar.setVisibility(View.VISIBLE);
        recyclerView=v.findViewById(R.id.recylerview_offer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        offer_nik.clear();
        progressBar.setVisibility(View.INVISIBLE);
        offer_nik.add(new offer_nik("sumit","senior","anamika","goa","Inhouse","04 oct 2019","offer_Granted"));
        offer_nik.add(new offer_nik("sumit","senior","anamika","goa","Inhouse","04 oct 2019","offer_Granted"));
        offer_nik.add(new offer_nik("sumit","senior","anamika","goa","Inhouse","04 oct 2019","offer_Granted"));
        offer_nik.add(new offer_nik("sumit","senior","anamika","goa","Inhouse","04 oct 2019","offer_Granted"));
        offer_nik.add(new offer_nik("sumit","senior","anamika","goa","Inhouse","04 oct 2019","offer_Granted"));
        offer_nik.add(new offer_nik("sumit","senior","anamika","goa","Inhouse","04 oct 2019","offer_Granted"));
        offerAdapter_nik recyclerViewAdapter = new offerAdapter_nik(getActivity(),offer_nik);
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

}
