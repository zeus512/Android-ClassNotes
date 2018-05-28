package org.darkbyte.classnotes;

/**
 * Created by root on 10/3/17.
 */

public class SubjectModel {
    public SubjectModel(String subjectname) {
        this.subjectname = subjectname;
    }

    public SubjectModel() {
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    String subjectname;

}
