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
 * Created by root on 11/3/17.
 */

public class chapterAdapter extends RecyclerView.Adapter<chapterAdapter.MyViewHolder>{
    public List<chapterModel> list;
    @Override
    public chapterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject, parent, false);
        return new chapterAdapter.MyViewHolder(itemView);}

    public chapterAdapter( List<chapterModel> List) {
        this.list = List;
    }

    @Override
    public void onBindViewHolder(final chapterAdapter.MyViewHolder holder, int position) {
        final chapterModel chaptermodel = list.get(position);
      //  Toast.makeText(holder.chapter.getContext(),"edw",Toast.LENGTH_SHORT).show();
        Log.v("dwa","daw");
        holder.chapter.setText(chaptermodel.getchaptername());
        final Context context=holder.chapter.getContext();
        holder.chapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.chapter.getContext(),"chapterclicked",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context,Display.class);
                Bundle extras = new Bundle();
                extras.putString("chapter",chaptermodel.getchaptername());
                extras.putString("semester",chapter.sem);
                extras.putString("department",chapter.dep);
                extras.putString("subject",chapter.subject);
                i.putExtra("bundle",extras);

                context.startActivity(i);
            }
        });
    }
    public  void  refresh(List<chapterModel> list){
        this.list=list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Button chapter;
        public MyViewHolder(View itemView) {
            super(itemView);
            chapter=(Button)itemView.findViewById(R.id.subjectbutton);
        }
    }
}