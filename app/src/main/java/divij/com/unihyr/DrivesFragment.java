package divij.com.unihyr;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import divij.com.unihyr.Adapters.PositionsRecyclerAdapter;
import divij.com.unihyr.Adapters.driverCaredAdapter;
import divij.com.unihyr.Adapters.driver_past_Adapter;
import divij.com.unihyr.Adapters.driver_upcomingAdapter;
import divij.com.unihyr.Adapters.offerAdapter_nik;
import divij.com.unihyr.CardClasses.driver_ka;
import divij.com.unihyr.CardClasses.driver_past;
import divij.com.unihyr.CardClasses.driver_upcoming;
import divij.com.unihyr.UtilClasses.Products;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrivesFragment extends Fragment {
    private Spinner spinner;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ArrayList<driver_ka> driver_ka;
    private ArrayList<driver_past> driver_past;
    private ArrayList<driver_upcoming> driver_upcoming;

    public DrivesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_drives, container, false);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        progressBar=v.findViewById(R.id.pbActiveProfiles_driver);
        progressBar.setVisibility(View.VISIBLE);
        spinner=v.findViewById(R.id.spinnerDrives);
        recyclerView=v.findViewById(R.id.recyclerView_driver);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.positions_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        driver_ka.clear();
                        progressBar.setVisibility(View.INVISIBLE);
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0", "1"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0", "1"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0", "1"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0", "1"));
                        driverCaredAdapter recyclerViewAdapter =new driverCaredAdapter(getActivity(),driver_ka);
                        progressBar.setVisibility(View.INVISIBLE);
                        recyclerView.setAdapter(recyclerViewAdapter);
                        break;
                    case 1:
                        driver_upcoming.clear();
                        progressBar.setVisibility(View.INVISIBLE);
                        driver_upcoming.add(new driver_upcoming("analyst", "Delhi", "Senior", "anamika", "5", "05 Oct 2019 10:00AM", "1", "0", "5", "1"));
                        driver_upcoming.add(new driver_upcoming("analyst", "Delhi", "Senior", "anamika", "5", "05 Oct 2019 10:00AM", "1", "0", "5", "1"));
                        driver_upcoming.add(new driver_upcoming("analyst", "Delhi", "Senior", "anamika", "5", "05 Oct 2019 10:00AM", "1", "0", "5", "1"));
                        driver_upcoming.add(new driver_upcoming("analyst", "Delhi", "Senior", "anamika", "5", "05 Oct 2019 10:00AM", "1", "0", "5", "1"));
                        driver_upcomingAdapter recyclerViewAdapter1 =new driver_upcomingAdapter(getActivity(),driver_upcoming);
                        progressBar.setVisibility(View.INVISIBLE);
                        recyclerView.setAdapter(recyclerViewAdapter1);
                        break;
                    case 2:
                        driver_past.clear();
                        progressBar.setVisibility(View.INVISIBLE);
                        driver_past.add(new driver_past("asd", "sdf", "dfg", "ghj", "5", "05 Oct 2019 10:00AM", "1", "2", "3", "4"));
                        driver_past.add(new driver_past("asd", "sdf", "dfg", "ghj", "5", "05 Oct 2019 10:00AM", "1", "2", "3", "4"));
                        driver_past.add(new driver_past("asd", "sdf", "dfg", "ghj", "5", "05 Oct 2019 10:00AM", "1", "2", "3", "4"));
                        driver_past.add(new driver_past("asd", "sdf", "dfg", "ghj", "5", "05 Oct 2019 10:00AM", "1", "2", "3", "4"));
                        driver_past.add(new driver_past("asd", "sdf", "dfg", "ghj", "5", "05 Oct 2019 10:00AM", "1", "2", "3", "4"));
                        driver_past_Adapter recyclerViewAdapter2 =new driver_past_Adapter(getActivity(),driver_past);
                        progressBar.setVisibility(View.INVISIBLE);
                        recyclerView.setAdapter(recyclerViewAdapter2);
                        break;

                }
            }




            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    }

