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
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import divij.com.unihyr.Adapters.PositionsRecyclerAdapter;
import divij.com.unihyr.UtilClasses.Products;


/**
 * A simple {@link Fragment} subclass.
 */
public class PositionsFragment extends Fragment{
    public static Spinner spinner;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    FloatingActionButton fab;
    JSONArray result;

    public PositionsFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_positions, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        fab=v.findViewById(R.id.positionsFab);
        progressBar=v.findViewById(R.id.progressBarPositions);
        progressBar.setVisibility(View.VISIBLE);
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
        new fetchDataPositions(new OnPositionsFetched() {
            @Override
            public void OnPositionsFetched() {
                ArrayList<String> positionsArray=new ArrayList<>();
                Log.d(PositionsFragment.class.getSimpleName(),"It executed!");
                progressBar.setVisibility(View.INVISIBLE);
                ArrayList<Products> productList = new ArrayList<>();
                productList.clear();
                result=fetchDataPositions.JA;
                for(int i =0 ;i <result.length(); i++){
                    try {
                        JSONObject JO = (JSONObject) result.get(i);
                        productList.add(new Products(JO.getString("postId"),JO.getString("title"),JO.getString("location"),JO.getString("initiator"),JO.getString("spoc"),JO.getInt("noOfPosts"),JO.getBoolean("active")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                final PositionsRecyclerAdapter recyclerAdapter=new PositionsRecyclerAdapter(getActivity(),productList,getActivity());
                recyclerView.setAdapter(recyclerAdapter);
            }
        }).execute("https://demorms.unihyr.com/demo/api/allpost");
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.positions_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
