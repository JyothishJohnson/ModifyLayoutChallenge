package com.jyothishjohnson.dmusics.gmail_clone.utils;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.jyothishjohnson.dmusics.gmail_clone.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> mArrayList;

    public MyAdapter(ArrayList<Model> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


        final boolean[] play = {false};

        holder.mailSender.setText(mArrayList.get(position).getSubject());
        holder.mailSubject.setText(mArrayList.get(position).getSender());
        holder.mailContent.setText(mArrayList.get(position).getContent());
        holder.firstLetter.setText(mArrayList.get(position).getFirstLetter());
        holder.mailTime.setText(mArrayList.get(position).getTime());
        holder.circleImageView.setImageResource(mArrayList.get(position).getImageResource());
        /*if(mArrayList.get(position).getStarred()) {
            holder.checkStarred.setImageResource(R.drawable.ic_star_black_24dp);
            holder.lottieAnimationView
        }else{
            holder.checkStarred.setImageResource(R.drawable.ic_star_border_black_24dp);

        }*/

        holder.lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!play[0]){
                    holder.lottieAnimationView.setSpeed(1);
                    holder.lottieAnimationView.playAnimation();
                    play[0]=true;
                  /*  if(mArrayList.get(position).getStarred()) {
                        holder.checkStarred.setImageResource(R.drawable.ic_star_black_24dp);
                    }else{
                        holder.checkStarred.setImageResource(R.drawable.ic_star_border_black_24dp);

                    }*/
                }else {
                    holder.lottieAnimationView.setSpeed(-1);
                    holder.lottieAnimationView.playAnimation();
                    play[0]=false;
                    /*if(mArrayList.get(position).getStarred()) {
                        holder.checkStarred.setImageResource(R.drawable.ic_star_black_24dp);
                    }else{
                        holder.checkStarred.setImageResource(R.drawable.ic_star_border_black_24dp);

                    }*/
                }

            }
        });


        if(mArrayList.get(position).getBold()){
            holder.mailSender.setTypeface(null, Typeface.BOLD);
            holder.mailSubject.setTypeface(null, Typeface.BOLD);
            holder.mailTime.setTypeface(null, Typeface.BOLD);

        }else{
            holder.mailSender.setTypeface(null, Typeface.NORMAL);
            holder.mailSubject.setTypeface(null, Typeface.NORMAL);
            holder.mailTime.setTypeface(null, Typeface.NORMAL);
            holder.mailTime.setTextColor(Color.parseColor("#9b9a9a"));
            holder.mailSubject.setTextColor(Color.parseColor("#9b9a9a"));
        }
    }


    @Override
    public int getItemCount() {
        return mArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mailSender, mailSubject, mailContent, mailTime,firstLetter;
        private LottieAnimationView lottieAnimationView;
        private CircleImageView circleImageView;
        MyViewHolder(View view) {
            super(view);
            mailSubject = view.findViewById(R.id.subject);
            mailSender = view.findViewById(R.id.sender);
            mailContent = view.findViewById(R.id.content);
            mailTime = view.findViewById(R.id.time);
            lottieAnimationView = view.findViewById(R.id.star);
            firstLetter = view.findViewById(R.id.logoLetter);
            circleImageView = view.findViewById(R.id.profile_image);

        }
    }


}
