package divij.com.unihyr;


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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import divij.com.unihyr.Adapters.PositionsRecyclerAdapter;
import divij.com.unihyr.UtilClasses.Products;


/**
 * A simple {@link Fragment} subclass.
 */
public class PositionsFragment extends Fragment {
    Spinner spinner;
    RecyclerView recyclerView;
    ArrayList<Products> productList;
    ArrayList<Products> tempList;
    FloatingActionButton fab;

    public PositionsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_positions, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        fab=v.findViewById(R.id.positionsFab);
        spinner=v.findViewById(R.id.positionsSpinner);
        recyclerView=v.findViewById(R.id.positionsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy>0){
                    fab.hide();
                    return;
                }
                if(dy<0){
                    fab.show();
                }
            }
        });
        productList = new ArrayList<>();
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,true));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,true));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,false));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,false));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,true));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,true));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,false));
        tempList=new ArrayList<>();
        for(int i=0;i<productList.size();i++){
            tempList.add(productList.get(i));
        }
        final PositionsRecyclerAdapter recyclerAdapter=new PositionsRecyclerAdapter(getActivity(),tempList);
        recyclerView.setAdapter(recyclerAdapter);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.positions_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                initializeTempList();
                if(i==1){
                    int n=tempList.size();
                    for(int j=0;j<n;j++){
                        if(!(tempList.get(j).isActivated())){
                            tempList.remove(j);
                            j--;
                            n--;
                        }
                    }

                }
                else if(i==2){
                    int n=tempList.size();
                    for(int j=0;j<n;j++){
                        if(tempList.get(j).isActivated()){
                            tempList.remove(j);
                            j--;
                            n--;
                        }

                    }
                    for(int j=0;j<tempList.size();j++){
                        Log.d("inActives",Integer.toString(j));
                    }
                }
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void initializeTempList(){
        tempList.clear();
        for(int i=0;i<productList.size();i++){
            tempList.add(productList.get(i));
            Log.d("tempList",Boolean.toString(productList.get(i).isActivated()));
            Log.d("tempList",Boolean.toString(tempList.get(i).isActivated()));
        }
    }
}
