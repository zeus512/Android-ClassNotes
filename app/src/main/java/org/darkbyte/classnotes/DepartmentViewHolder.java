package org.darkbyte.classnotes;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class DepartmentViewHolder extends GroupViewHolder {

  private TextView departmentName;
  private ImageView arrow;
  private ImageView icon;

  public DepartmentViewHolder(View itemView) {
    super(itemView);
    departmentName = (TextView) itemView.findViewById(R.id.list_item_department_name);
    arrow = (ImageView) itemView.findViewById(R.id.list_item_department_arrow);
    icon = (ImageView) itemView.findViewById(R.id.list_item_department_icon);
  }

  public void setDepartmentTitle(ExpandableGroup department) {
    if (department instanceof Department) {
      departmentName.setText(department.getTitle());
      icon.setBackgroundResource(((Department) department).getIconResId());
    }

  }

  @Override
  public void expand() {
    animateExpand();
  }

  @Override
  public void collapse() {
    animateCollapse();
  }

  private void animateExpand() {
    RotateAnimation rotate =
        new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(300);
    rotate.setFillAfter(true);
    arrow.setAnimation(rotate);
  }

  private void animateCollapse() {
    RotateAnimation rotate =
        new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(300);
    rotate.setFillAfter(true);
    arrow.setAnimation(rotate);
  }
}
