package divij.com.unihyr;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import divij.com.unihyr.Adapters.ToDoAdapter;
import divij.com.unihyr.CardClasses.ToDoCard;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPositionsToDoFragment extends Fragment {
    private Spinner spinner;
    private RecyclerView recyclerView;
    private List<ToDoCard> toDoCardList;
    public ViewPositionsToDoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_view_positions_to_do, container, false);
        spinner=v.findViewById(R.id.todoSpinner);
        recyclerView=v.findViewById(R.id.rvToDo);
        toDoCardList=new ArrayList<>();
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(getActivity(),
                R.array.todo_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toDoCardList.clear();
        toDoCardList.add(new ToDoCard("Vhdasv","-","In-House team","11 Oct 2019"));
        toDoCardList.add(new ToDoCard("Vhdasv","-","In-House team","11 Oct 2019"));
        toDoCardList.add(new ToDoCard("Vhdasv","-","In-House team","11 Oct 2019"));
        toDoCardList.add(new ToDoCard("Vhdasv","-","In-House team","11 Oct 2019"));
        toDoCardList.add(new ToDoCard("Vhdasv","-","In-House team","11 Oct 2019"));
        toDoCardList.add(new ToDoCard("Vhdasv","-","In-House team","11 Oct 2019"));
        toDoCardList.add(new ToDoCard("Vhdasv","-","In-House team","11 Oct 2019"));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ToDoAdapter adapter=new ToDoAdapter(toDoCardList,getActivity());
        recyclerView.setAdapter(adapter);

    }
}
