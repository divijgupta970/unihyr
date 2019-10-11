package divij.com.unihyr.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import divij.com.unihyr.CardClasses.ActiveProfiles;
import divij.com.unihyr.CardClasses.offer_nik;
import divij.com.unihyr.R;

public class offerAdapter_nik extends RecyclerView.Adapter<offerAdapter_nik.offerAdapter_nikViewHolder>{
    private Context mCtx;
    private List<offer_nik> offer_nik;
    public offerAdapter_nik (Context mCtx,List<offer_nik> offer_nik)
    {
        this.mCtx=mCtx;
        this.offer_nik=new ArrayList<>();
        this.offer_nik.clear();
        this.offer_nik.addAll(offer_nik);
    }

    @NonNull
    @Override
    public offerAdapter_nik.offerAdapter_nikViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.offercard, null);
                return new offerAdapter_nikViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull offerAdapter_nik.offerAdapter_nikViewHolder holder, final int position) {
        holder.more_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offer_nik currentItem=offer_nik.get(position);

               Log.d(PositionsRecyclerAdapter.class.getSimpleName(),"info clicked");
                String moreInfoMessage="\nLocation: "+currentItem.getLocation()
                        +"\n\nDate: "+currentItem.getDate()
                        +"\n\nSource: "+currentItem.getSource();
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
        holder.name.setText(offer_nik.get(position).getName());
        holder.position.setText(offer_nik.get(position).getPosition());
        holder.user.setText(offer_nik.get(position).getUser());
        holder.status.setText(offer_nik.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return offer_nik.size();
    }

    public class offerAdapter_nikViewHolder extends RecyclerView.ViewHolder {
        TextView name,position,user,status;
        ImageView more_info;
        public offerAdapter_nikViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.nameid);
            position=itemView.findViewById(R.id.positionId);
            user=itemView.findViewById(R.id.userId);
            status=itemView.findViewById(R.id.statusId);
            more_info=itemView.findViewById(R.id.btnInfo_offer);



        }
    }
}
