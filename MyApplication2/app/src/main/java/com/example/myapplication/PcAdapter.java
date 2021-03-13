package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PcAdapter extends RecyclerView.Adapter<PcAdapter.LinearViewHolder> {
    private Context context;
    private View.OnClickListener listener;

    public PcAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.pc_rv,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
            switch (position){
                case 1:
                    holder.imageView.setImageResource(R.drawable.pv1);
                    break;
                case 2:
                    holder.imageView.setImageResource(R.drawable.pv4);
                    break;
                case 3:
                    holder.imageView.setImageResource(R.drawable.pv3);
                    break;
                case 4:
                    holder.imageView.setImageResource(R.drawable.pv2);
                    break;
                case 5:
                    holder.imageView.setImageResource(R.drawable.pv5);
                    break;
                case 6:
                    holder.imageView.setImageResource(R.drawable.pv6);
                    break;
                case 7:
                    holder.imageView.setImageResource(R.drawable.pv3);
                    break;
                case 8:
                    holder.imageView.setImageResource(R.drawable.pv5);
                    break;
                case 9:
                    holder.imageView.setImageResource(R.drawable.pv6);
                    break;
            }


    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }
}
