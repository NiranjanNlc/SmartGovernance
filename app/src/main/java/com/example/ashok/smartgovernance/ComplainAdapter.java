package com.example.ashok.smartgovernance;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ComplainAdapter extends RecyclerView.Adapter<ComplainAdapter.ComplainViewHolder>{
   private List<ComplainModel> listitem;
    private Context ctx;

    public ComplainAdapter(List<ComplainModel> listitem, Context ctx) {
        this.listitem = listitem;
        this.ctx = ctx;
    }




    @NonNull
    @Override
    public ComplainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.complainlist, null);
        return new ComplainViewHolder(view, ctx,listitem);
    }


    @Override
    public void onBindViewHolder(@NonNull ComplainViewHolder holder, int position) {
                 ComplainModel complain = listitem.get(position);
        Glide.with(ctx)
                .load(complain.getCimg())
                .into(holder.cimg);
        holder.cid.setText(complain.getCid());
        holder.ctop.setText(complain.getCtop() );
        holder.cloc.setText(complain.getCloc() );
        holder.name.setText(complain.getCname());
        holder.contact.setText(complain.getContact());
        holder.cgriv.setText(complain.getCgriv() );
      //   holder.textViewTitle.setText(product.getTitle());
    }


    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class ComplainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView  ctop,cloc,cgriv,name,contact ,cid;
        ImageView cimg;
        List<ComplainModel> listitem;
        Context ctx;
        public ComplainViewHolder(View itemView,Context ctx, List<ComplainModel> listitem) {
            super(itemView);
            this.listitem= listitem;
            this.ctx = ctx;
            itemView.setOnClickListener(this);

            ctop = itemView.findViewById(R.id.ctopic);
            cloc = itemView.findViewById(R.id.clocation);
            cgriv = itemView.findViewById(R.id.cgriev);
            cimg = itemView.findViewById(R.id.cimg);
           name = itemView.findViewById(R.id.name);
            contact = itemView.findViewById(R.id.contact);

            cid = itemView.findViewById(R.id.cid);

        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {

  int position = getAdapterPosition();
  ComplainModel c = this.listitem.get(position);
            Intent i = new Intent(this.ctx,RComplain.class);

        //    i.putExtra("img",bitmap);

            i.putExtra("topic",c.getCtop());
       i.putExtra("id",c.getCid());
            i.putExtra("location",c.getCloc());
            i.putExtra("name",c.getCname());
            i.putExtra("contact",c.getContact());
            i.putExtra("griv",c.getCgriv());
            //  images pass garna

            this.ctx.startActivity(i);



        }

    }


}
