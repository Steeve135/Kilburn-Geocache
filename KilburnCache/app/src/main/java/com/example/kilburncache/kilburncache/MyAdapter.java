package com.example.kilburncache.kilburncache;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView challengeName;
        TextView challengeLocation;
        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            challengeName = (TextView)itemView.findViewById(R.id.Challenge_name);
            challengeLocation = (TextView)itemView.findViewById(R.id.Challenge_location);
        }
    }

    List<Challenges> challenges;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Challenges> challenges) {
        this.challenges = challenges;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_card_home_page, viewGroup, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.challengeName.setText(challenges.get(position).name);
        holder.challengeLocation.setText(challenges.get(position).location);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return challenges.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

