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


import divij.com.unihyr.CardClasses.driver_ka;
import divij.com.unihyr.CardClasses.driver_upcoming;
import divij.com.unihyr.R;

public class driver_upcomingAdapter extends RecyclerView.Adapter<driver_upcomingAdapter.driver_upcomingAdapterViewHolder> {
    private Context mCtx;
    private List<driver_upcoming> driver_upcoming;

    public driver_upcomingAdapter(Context mCtx, List<driver_upcoming> driver_upcoming) {
        this.mCtx = mCtx;
        this.driver_upcoming.clear();
        this.driver_upcoming = new ArrayList<>();
        this.driver_upcoming.addAll(driver_upcoming);

    }

    @NonNull
    @Override
    public driver_upcomingAdapter.driver_upcomingAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.drver_upcoming_card, null);
        return new driver_upcomingAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull driver_upcomingAdapter.driver_upcomingAdapterViewHolder holder, final int position) {
        holder.infoButton_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                driver_upcoming currentItem=driver_upcoming.get(position);

                Log.d(PositionsRecyclerAdapter.class.getSimpleName(),"info clicked");
                String moreInfoMessage="\nDate & Time: "+currentItem.getDate()
                        +"\n\ncandidates: "+currentItem.getCandidate()
                        +"\n\nShortListed: "+currentItem.getShortlisted()
                        +"\n\nRejected: "+currentItem.getReject()
                        +"\n\nNO.Show: "+currentItem.getNoshow();
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
        holder.drive.setText(driver_upcoming.get(position).getDrive());
        holder.postion.setText(driver_upcoming.get(position).getPosition());
        holder.contact.setText(driver_upcoming.get(position).getCont_person());
        holder.location.setText(driver_upcoming.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return driver_upcoming.size();
    }
    class driver_upcomingAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView drive,location,postion,contact;
        ImageView infoButton_u;
        public driver_upcomingAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
                drive =itemView.findViewById(R.id.udriveId);
                location=itemView.findViewById(R.id.ulocationId);
                postion= itemView.findViewById(R.id.upositionId);
                contact=itemView.findViewById(R.id.usaleId);
                infoButton_u=itemView.findViewById(R.id.infoButton_u);
        }
    }
}