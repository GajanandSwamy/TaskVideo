package com.example.manvish.taskvideo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manvish.taskvideo.POJO.Video;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.CustomViewHolder> {
    private List<Video> employees;

    public VideoAdapter(List<Video> employees) {
        this.employees = employees;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.videos_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Video employee = employees.get(position);
//        holder.category.setText(employee.getCategories());
        holder.tittle.setText(employee.getTitle());
        holder.subtittle.setText(employee.getSubtitle());
        holder.desc.setText(employee.getDescription());
//        holder.dob.setText(employee.getDob());
//        holder.contactNumber.setText(employee.getContactNumber());
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView desc, tittle, subtittle,category;
        ImageView imageView;

        public CustomViewHolder(View view) {
            super(view);
            category=view.findViewById(R.id.category_id);
            desc = (TextView) view.findViewById(R.id.description);
            tittle = (TextView) view.findViewById(R.id.tittle);
            subtittle = (TextView) view.findViewById(R.id.subtittle);
            imageView = (ImageView) view.findViewById(R.id.thumbnail);

        }
    }
}
