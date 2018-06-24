package com.ankit.assignment.grabbd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ankit.assignment.grabbd.R;
import com.ankit.assignment.grabbd.model.Section;

import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {

    List<Section> mSectionList;
    Context mContext;

    public SectionAdapter(Context context , List<Section> sectionList){
        this.mContext = context;
        this.mSectionList = sectionList;
    }

    @NonNull
    @Override
    public SectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_list_item , parent , false);
        return new SectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SectionViewHolder holder, int position) {
        holder.mSectionTextView.setText(mSectionList.get(position).getSection());
        holder.mSectionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "chosen section :"+holder.mSectionTextView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSectionList.size();
    }

    public class SectionViewHolder extends RecyclerView.ViewHolder{

        TextView mSectionTextView;

        public SectionViewHolder(View view){
            super(view);

            mSectionTextView = view.findViewById(R.id.tv_section);
        }
    }
}
