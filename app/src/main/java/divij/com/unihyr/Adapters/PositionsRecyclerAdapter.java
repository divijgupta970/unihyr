package divij.com.unihyr.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import divij.com.unihyr.R;
import divij.com.unihyr.UtilClasses.Products;
import divij.com.unihyr.ViewPositions;

public class PositionsRecyclerAdapter extends RecyclerView.Adapter<PositionsRecyclerAdapter.ProductViewHolder> implements Filterable {
    private Context mCtx;
    private ArrayList<Products> productList;
    private Context context;
    public ArrayList<Products> productListfiltered;

    public PositionsRecyclerAdapter(Context mCtx, ArrayList<Products> productList,Context context) {
        this.productList=new ArrayList<>();
        this.productList.clear();
        this.mCtx = mCtx;
        this.productList.addAll(productList);
        this.context=context;
        this.productListfiltered=productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.positions_cardview, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
        Products product = productListfiltered.get(position);
        holder.textViewPosition.setText(product.getPosition());
        holder.textViewLocation.setText(product.getLocation());
        holder.textViewInitiator.setText(product.getInitiator());
        holder.textViewId.setText(product.getId());
        if(product.isActivated()){
            holder.deactivateButton.setVisibility(View.VISIBLE);
            holder.activatedButton.setVisibility(View.INVISIBLE);
            holder.editButton.setVisibility(View.VISIBLE);
        }
        else{
            holder.deactivateButton.setVisibility(View.INVISIBLE);
            holder.activatedButton.setVisibility(View.VISIBLE);
            holder.editButton.setVisibility(View.INVISIBLE);
        }
        holder.deactivateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(mCtx);
                builder.setTitle("Deactivation");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        productListfiltered.get(position).setActivated(false);
                        //PositionsFragment.productList.get(position).setActivated(false);
                        notifyDataSetChanged();
                        Toast.makeText(mCtx, "Deactivated", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
            }
        });
        holder.activatedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(mCtx);
                builder.setTitle("Activation");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        productListfiltered.get(position).setActivated(true);
                        //PositionsFragment.productList.get(position).setActivated(true);
                        notifyDataSetChanged();
                        Toast.makeText(mCtx, "Activated", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
            }
        });
        holder.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Products currItem=productListfiltered.get(position);
                Log.d(PositionsRecyclerAdapter.class.getSimpleName(),"info clicked");
                String moreInfoMessage="\nHiring SPOC: "+currItem.getHiringSpoc()+"\n\nTotalProfiles: "+currItem.getTotalProfiles();
                AlertDialog.Builder builder=new AlertDialog.Builder(mCtx);
                builder.setTitle("More Info");
                builder.setMessage(moreInfoMessage);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
        holder.inHouseTeamIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageViewCompat.setImageTintList(holder.inHouseTeamIcon, ContextCompat.getColorStateList(context, R.color.colorAccent));

            }
        });
        holder.socialMediaIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageViewCompat.setImageTintList(holder.socialMediaIcon, ContextCompat.getColorStateList(context, R.color.colorAccent));
            }
        });
        holder.careerPageIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageViewCompat.setImageTintList(holder.careerPageIcon, ContextCompat.getColorStateList(context, R.color.colorAccent));
            }
        });
        holder.referralIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageViewCompat.setImageTintList(holder.referralIcon, ContextCompat.getColorStateList(context, R.color.colorAccent));
            }
        });
        holder.internalJobPortalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageViewCompat.setImageTintList(holder.internalJobPortalIcon, ContextCompat.getColorStateList(context, R.color.colorAccent));
            }
        });
        holder.externalConsultantIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageViewCompat.setImageTintList(holder.externalConsultantIcon, ContextCompat.getColorStateList(context, R.color.colorAccent));
            }
        });

    }


    @Override
    public int getItemCount() {
        return productListfiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String key =constraint.toString();
                if (key.isEmpty())
                {
                    productListfiltered=productList;
                }
                else
                {
                    ArrayList<Products> lstFiltered = new ArrayList<>();
                    for(Products row:productList)
                    {
                        if (row.getPosition().toLowerCase().contains(key.toLowerCase())){
                            lstFiltered.add(row);
                        }
                    }
                    productListfiltered= lstFiltered;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values= productListfiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                productListfiltered = (ArrayList<Products>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView textViewPosition, textViewLocation, textViewInitiator, textViewId;
        ImageView editButton,activatedButton,deactivateButton,infoButton,inHouseTeamIcon,socialMediaIcon,careerPageIcon,referralIcon,internalJobPortalIcon,externalConsultantIcon;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewPosition = itemView.findViewById(R.id.textViewPosition);
            textViewLocation = itemView.findViewById(R.id.textViewLocation);
            textViewInitiator = itemView.findViewById(R.id.textViewInitiator);
            textViewId=itemView.findViewById(R.id.positionId);
            editButton=itemView.findViewById(R.id.editButton);
            activatedButton=itemView.findViewById(R.id.activateButton);
            deactivateButton=itemView.findViewById(R.id.deactivateButton);
            infoButton=itemView.findViewById(R.id.infoButton);
            inHouseTeamIcon=itemView.findViewById(R.id.inHouseTeamIcon);
            socialMediaIcon=itemView.findViewById(R.id.socialMediaIcon);
            careerPageIcon=itemView.findViewById(R.id.careerPageIcon);
            referralIcon=itemView.findViewById(R.id.referralIcon);
            internalJobPortalIcon=itemView.findViewById(R.id.internalJobPortalIcon);
            externalConsultantIcon=itemView.findViewById(R.id.externalConsultantIcon);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(PositionsRecyclerAdapter.class.getSimpleName(),"Card clicked");
                    Intent intent=new Intent(mCtx.getApplicationContext(),ViewPositions.class);
                    intent.putExtra("json object",productListfiltered.get(getLayoutPosition()).getJsonObject().toString());
                    mCtx.startActivity(intent);
                }
            });
        }
    }
}
