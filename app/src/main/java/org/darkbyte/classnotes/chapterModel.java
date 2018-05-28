package org.darkbyte.classnotes;



/**
 * Created by root on 11/3/17.
 */

public class chapterModel   {
    public chapterModel(String chaptername) {
        this.chaptername = chaptername;
    }

    public chapterModel() {
    }

    public String getchaptername() {
        return chaptername;
    }

    public void setchaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    String chaptername;
}
