package divij.com.unihyr.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import divij.com.unihyr.CardClasses.ToDoCard;
import divij.com.unihyr.R;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoAdapterViewHolder> {
    private List<ToDoCard> toDoCardList;
    private Context mCtx;

    public ToDoAdapter(List<ToDoCard> toDoCardList, Context mCtx) {
        this.mCtx = mCtx;
        this.toDoCardList=new ArrayList<>();
        this.toDoCardList.clear();
        this.toDoCardList.addAll(toDoCardList);
    }

    @NonNull
    @Override
    public ToDoAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.to_do_card,null);
        return new ToDoAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoAdapterViewHolder holder, int position) {
        holder.name.setText(toDoCardList.get(position).getName());
        holder.position.setText(toDoCardList.get(position).getPosition());
        holder.source.setText(toDoCardList.get(position).getSource());
        holder.since.setText(toDoCardList.get(position).getSince());
    }

    @Override
    public int getItemCount() {
        return toDoCardList.size();
    }

    public class ToDoAdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView name,position,source,since;
        public ToDoAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.nameidToDO);
            position=itemView.findViewById(R.id.positionIdToDO);
            source=itemView.findViewById(R.id.sourceIdToDo);
            since=itemView.findViewById(R.id.sinceIdToDo);
        }
    }
}
