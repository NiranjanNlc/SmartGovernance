package com.example.ashok.smartgovernance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {
    private List<modelNotice> listitem;
    private Context ctx;

    public NoticeAdapter(List<modelNotice> listitem, Context ctx) {
        this.listitem = listitem;
        this.ctx = ctx;

    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.noticelist, null);
        return new NoticeAdapter.NoticeViewHolder(view, ctx,listitem);


    }


    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
       modelNotice complain = listitem.get(position);
        Glide.with(ctx)
                .load(complain.getNimg())
                .into(holder.nimg);
        holder.nid.setText(complain.getNtop());
       holder.notic.setText(complain.getNotice() );

    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder{
        TextView  nid,notic;
        ImageView nimg;
        private final List<modelNotice> listitem;
        private final Context ctx;

        public NoticeViewHolder(View itemView, Context ctx, List<modelNotice> listitem) {

            super(itemView);
            this.listitem= listitem;
            this.ctx = ctx;
            nid = (TextView) itemView.findViewById(R.id.nid);
            notic = (TextView)itemView.findViewById(R.id.notic);
            nimg = (ImageView)itemView.findViewById(R.id.nimg);


        }

    }

}



