package divij.com.unihyr.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import divij.com.unihyr.CardClasses.ActiveProfiles;
import divij.com.unihyr.R;

public class ActiveProfilesAdapter extends RecyclerView.Adapter<ActiveProfilesAdapter.ActiveProfilesViewHolder> {
    private Context mCtx;
    private List<ActiveProfiles> activeProfiles;
    public ActiveProfilesAdapter(Context mCtx,List<ActiveProfiles> activeProfiles){
        this.mCtx=mCtx;
        this.activeProfiles=new ArrayList<>();
        this.activeProfiles.clear();
        this.activeProfiles.addAll(activeProfiles);
    }
    @NonNull
    @Override
    public ActiveProfilesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.vpp_active_profiles_card, null);
        return new ActiveProfilesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActiveProfilesViewHolder holder, final int position) {
        holder.moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActiveProfiles currItem=activeProfiles.get(position);
                Log.d(PositionsRecyclerAdapter.class.getSimpleName(),"info clicked");
                String moreInfoMessage="\nPhone no: "+currItem.getPhone()
                        +"\n\nCurrent Role: "+currItem.getCurrentRole()
                        +"\n\nCurrent Org: "+currItem.getCurrentOrg()
                        +"\n\nExp.(Yr.): "+currItem.getExp()
                        +"\n\nN P(Days): "+currItem.getNp();
                AlertDialog.Builder builder=new AlertDialog.Builder(mCtx);
                builder.setTitle("More Info");
                builder.setMessage(moreInfoMessage);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
        holder.name.setText(activeProfiles.get(position).getName());
        holder.status.setText(activeProfiles.get(position).getStatus());
        holder.channel.setText(activeProfiles.get(position).getChannel());
        holder.submittedBy.setText(activeProfiles.get(position).getSubmittedBy());
    }

    @Override
    public int getItemCount() {
        return activeProfiles.size();
    }
    class ActiveProfilesViewHolder extends RecyclerView.ViewHolder{
        TextView name, submittedBy, channel, status;
        ImageView moreInfo;
        public ActiveProfilesViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            submittedBy = itemView.findViewById(R.id.tvSubmittedBy);
            channel = itemView.findViewById(R.id.tvChannel);
            status = itemView.findViewById(R.id.tvStatus);
            moreInfo = itemView.findViewById(R.id.btnInfo);
        }
    }
}
