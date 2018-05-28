package org.darkbyte.classnotes;

import android.os.Parcel;
import android.os.Parcelable;

public class Semester implements Parcelable {

  private String name;
  private boolean isFavorite;

  public Semester(String name, boolean isFavorite) {
    this.name = name;
    this.isFavorite = isFavorite;
  }

  protected Semester(Parcel in) {
    name = in.readString();
  }

  public String getName() {
    return name;
  }

  public boolean isFavorite() {
    return isFavorite;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Semester)) return false;

    Semester artist = (Semester) o;

    if (isFavorite() != artist.isFavorite()) return false;
    return getName() != null ? getName().equals(artist.getName()) : artist.getName() == null;

  }

  @Override
  public int hashCode() {
    int result = getName() != null ? getName().hashCode() : 0;
    result = 31 * result + (isFavorite() ? 1 : 0);
    return result;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<Semester> CREATOR = new Creator<Semester>() {
    @Override
    public Semester createFromParcel(Parcel in) {
      return new Semester(in);
    }

    @Override
    public Semester[] newArray(int size) {
      return new Semester[size];
    }
  };
}

