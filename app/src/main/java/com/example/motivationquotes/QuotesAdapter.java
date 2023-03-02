package com.example.motivationquotes;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder> {
    ArrayList<model> arrModelQ;
    @NonNull
    Context context;

    public QuotesAdapter(Context context, ArrayList<model> arrModelQ) {
        this.context = context;
        this.arrModelQ = arrModelQ;
    }

    @Override
    public QuotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_lyout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesAdapter.ViewHolder holder, int position) {
        holder.tvQuote.setText("“ " + arrModelQ.get(position).getQuote() + " ”");
        holder.tvAuthor.setText("- " + arrModelQ.get(position).getAuthor());
        holder.copy.setOnClickListener(view -> {
            ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData cd = ClipData.newPlainText("Text", arrModelQ.get(position).getQuote().toString());
            cm.setPrimaryClip(cd);
            Toast.makeText(context, "Quote copied successfully.", Toast.LENGTH_SHORT).show();
        });

        holder.share.setOnClickListener(v->{
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, arrModelQ.get(position).getQuote().toString());
            context.startActivity(Intent.createChooser(shareIntent, "Share via"));
        });


    }

    @Override
    public int getItemCount() {
        return arrModelQ.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvQuote, tvAuthor;
        ImageView share, copy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvQuote = itemView.findViewById(R.id.tvQuote);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            share = itemView.findViewById(R.id.share);
            copy = itemView.findViewById(R.id.copy);
        }
    }
}
