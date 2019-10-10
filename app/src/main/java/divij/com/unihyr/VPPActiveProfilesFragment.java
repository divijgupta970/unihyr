package divij.com.unihyr;


import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import divij.com.unihyr.Adapters.ActiveProfilesAdapter;
import divij.com.unihyr.CardClasses.ActiveProfiles;


/**
 * A simple {@link Fragment} subclass.
 */
public class VPPActiveProfilesFragment extends Fragment {
    private Spinner selectChannelSpinner;
    private Spinner selectStatusSpinner;
    private RecyclerView recyclerView;
    private List<ActiveProfiles> activeProfiles;
    private ProgressBar progressBar;
    private TextView noOfProfiles;
    public VPPActiveProfilesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_vppactive_profiles, container, false);
        selectChannelSpinner=v.findViewById(R.id.spinnerSelectChannel);
        selectStatusSpinner=v.findViewById(R.id.spinnerSelectStatus);
        progressBar=v.findViewById(R.id.pbActiveProfiles);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView=v.findViewById(R.id.rvActiveProfiles);
        noOfProfiles=v.findViewById(R.id.noOfActiveProfiles);
        activeProfiles=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(getActivity(),
                R.array.select_status_spinner_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.select_chanel_spinner_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectChannelSpinner.setAdapter(adapter2);
        selectStatusSpinner.setAdapter(adapter1);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activeProfiles.clear();
        progressBar.setVisibility(View.INVISIBLE);
        Uri builtUri = Uri.parse("http://sharechat.unihyr.com/demo/api/hrmanagepositionlistapi").buildUpon()
                .appendQueryParameter("postId", ViewPositions.postId)
                .appendQueryParameter("filterBy", "all")
                .appendQueryParameter("selected_channel","0")
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.d("VPPActiveProfiles",url.toString());

        /*activeProfiles.add(new ActiveProfiles("Sumit","Anamika","In-House Team","9999999999","To be offered","--","--",0,0));
        activeProfiles.add(new ActiveProfiles("Sumit","Anamika","In-House Team","9999999999","To be offered","--","--",0,0));
        activeProfiles.add(new ActiveProfiles("Sumit","Anamika","In-House Team","9999999999","To be offered","--","--",0,0));
        activeProfiles.add(new ActiveProfiles("Sumit","Anamika","In-House Team","9999999999","To be offered","--","--",0,0));
        activeProfiles.add(new ActiveProfiles("Sumit","Anamika","In-House Team","9999999999","To be offered","--","--",0,0));
        activeProfiles.add(new ActiveProfiles("Sumit","Anamika","In-House Team","9999999999","To be offered","--","--",0,0));
        activeProfiles.add(new ActiveProfiles("Sumit","Anamika","In-House Team","9999999999","To be offered","--","--",0,0));
        activeProfiles.add(new ActiveProfiles("Sumit","Anamika","In-House Team","9999999999","To be offered","--","--",0,0));
        activeProfiles.add(new ActiveProfiles("Sumit","Anamika","In-House Team","9999999999","To be offered","--","--",0,0));*/
        new fetchDataPositions(new OnPositionsFetched() {
            @Override
            public void OnPositionsFetched() {

            }
        });
        ActiveProfilesAdapter recyclerViewAdapter=new ActiveProfilesAdapter(getActivity(),activeProfiles);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
