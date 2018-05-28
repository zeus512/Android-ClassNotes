package org.darkbyte.classnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class DepartmentAdapter extends ExpandableRecyclerViewAdapter<DepartmentViewHolder, SemesterViewHolder> {
Context context;
  public DepartmentAdapter(List<? extends ExpandableGroup> groups) {
    super(groups);
  }

  @Override
  public DepartmentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item_department, parent, false);
    return new DepartmentViewHolder(view);
  }

  @Override
  public SemesterViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item_semester, parent, false);
    context=parent.getContext();
    return new SemesterViewHolder(view);
  }

  @Override
  public void onBindChildViewHolder(SemesterViewHolder holder, int flatPosition,
      ExpandableGroup group, int childIndex) {

    final Semester semester = ((Department) group).getItems().get(childIndex);
    holder.setSemesterName(semester.getName());
    holder.onclick(context,semester.getName(),group.getTitle());


  }

  @Override
  public void onBindGroupViewHolder(DepartmentViewHolder holder, int flatPosition,
                                    ExpandableGroup group) {

    holder.setDepartmentTitle(group);
  }
}
