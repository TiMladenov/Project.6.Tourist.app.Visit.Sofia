package io.github.timladenov.visitsofia;

import java.util.ArrayList;

/**
 * Created by tmladenov on 25.06.17.
 */

public class DataHolder {

    private static final DataHolder holder = new DataHolder();
    private ArrayList<DisplayInfo> mInfo;
    private String mString;

    public static DataHolder getInstace() {
        return holder;
    }

    public ArrayList<DisplayInfo> getData() {
        return mInfo;
    }

    public String getmString() {
        return mString;
    }

    public void setArray(ArrayList<DisplayInfo> tmp) {
        this.mInfo = tmp;
    }

    public void setString(String tmp) {
        this.mString = tmp;
    }
}
