/**
 * @author Tihomir Mladenov tihomir.mladenov777@gmail.com
 * Date: 27.06.2017
 *
 * Project 6: Tour Guide App, Android Basics Nanodegree
 */

package io.github.timladenov.visitsofia;

import java.util.ArrayList;

public class DataHolder {

    /**
     * Simple singleton class, mainly used to pass quickly references to custom ArrayList Objects between the activities
     * Also used to quickly change layout / view properties programmatically. An instance variable would be better,
     * but nevertheless I did it for practice and knowledge.
     * */

    private static final DataHolder holder = new DataHolder();
    private ArrayList<DisplayInfo> mInfo;
    private String mString;
    private String mString_2;

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

    public void setString_2(String tmp) {
        this.mString_2 = tmp;
    }

    public String getmString_2() {
        return this.mString_2;
    }
}
