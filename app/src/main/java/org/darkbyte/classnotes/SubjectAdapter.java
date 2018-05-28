package org.darkbyte.classnotes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by root on 10/3/17.
 */

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.MyViewHolder>{
    public List<SubjectModel> list;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject, parent, false);
        return new MyViewHolder(itemView);}

    public SubjectAdapter( List<SubjectModel> List) {
        this.list = List;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final SubjectModel subjectModel = list.get(position);
      //  Toast.makeText(holder.subject.getContext(),"edw",Toast.LENGTH_SHORT).show();
        Log.v("dwa","daw");
        holder.subject.setText(subjectModel.getSubjectname());
        final Context context=holder.subject.getContext();
        holder.subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.subject.getContext(),"subjectclicked",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context,chapter.class);
                Bundle extras = new Bundle();
                extras.putString("semester",Subject.sem);
                extras.putString("department",Subject.dep);
                extras.putString("subject",subjectModel.getSubjectname());
                i.putExtra("bundle",extras);

                context.startActivity(i);
            }
        });
    }
    public  void  refresh(List<SubjectModel> list){
        this.list=list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Button subject;
        public MyViewHolder(View itemView) {
            super(itemView);
            subject=(Button)itemView.findViewById(R.id.subjectbutton);
        }
    }
}
