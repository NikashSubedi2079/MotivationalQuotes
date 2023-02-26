package com.example.motivationquotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder> {
    Context context;
    ArrayList<model> arrModelQ;

    public QuotesAdapter(Context context, ArrayList<model> arrModelQ) {
        this.context = context;
        this.arrModelQ = arrModelQ;
    }

    @NonNull
    @Override
    public QuotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_lyout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesAdapter.ViewHolder holder, int position) {
            holder.tvQuote.setText("“ "+arrModelQ.get(position).getQuote()+" ”");
            holder.tvAuthor.setText("- "+arrModelQ.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return arrModelQ.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvQuote,tvAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvQuote=itemView.findViewById(R.id.tvQuote);
            tvAuthor=itemView.findViewById(R.id.tvAuthor);
        }
    }
}
