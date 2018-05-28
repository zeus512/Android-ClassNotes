package org.darkbyte.classnotes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;


public class SemesterViewHolder extends ChildViewHolder{

  private TextView childTextView;



    public SemesterViewHolder(View itemView) {
    super(itemView);

    childTextView = (TextView) itemView.findViewById(R.id.list_item_semester_name);
  }

  public void setSemesterName(String name) {
    childTextView.setText(name);
  }
  public void onclick(final Context context, final String name, final String depname){
    childTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
       // Toast.makeText(context, name+depname, Toast.LENGTH_SHORT).show();
          Intent i = new Intent(context,Subject.class);
          Bundle extras = new Bundle();
          extras.putString("semester",name);
          extras.putString("department",depname);
          i.putExtra("bundle",extras);
          context.startActivity(i);

      }
    });
  }
}
