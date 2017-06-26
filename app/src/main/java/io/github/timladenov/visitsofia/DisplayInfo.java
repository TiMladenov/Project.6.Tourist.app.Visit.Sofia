/**
 * @author Tihomir Mladenov tihomir.mladenov777@gmail.com
 * Date: 27.06.2017
 *
 * Project 6: Tour Guide App, Android Basics Nanodegree
 */

package io.github.timladenov.visitsofia;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class DisplayInfo extends AppCompatActivity {

    /**
     * @param noImageLocation       constant used to determine whether an image resource was entered for the object, checks at {@link DisplayAdapter},
     *                              hides the ImageView if resource is missing
     * @param mImageLocation        reference to image resource
     * @param mColorBack            reference to background color
     * @param mHideSeparator        reference to separator view, used to hide it at {@link DisplayAdapter}
     * @param mCompanyName          reference to company name
     * @param mTelefonNum           reference to company phone
     * @param mCompany              used to programmatically update the text to the textview "Company" to something else
     * @param actionBar             reference to actionbar in activities to change its color in {@link DisplayAdapter}
     * */

    private final int noImageLocation = -1;
    private int mImageLocation = -1;
    private int mColorBack = 0;
    private boolean mHideSeparator = false;
    private String mCompanyName;
    private String mTelefonNum;
    private String mCompany = DataHolder.getInstace().getmString();
    private ActionBar actionBar;

    DisplayInfo() {
        this.mImageLocation = 0;
        this.mCompanyName = new String();
        this.mTelefonNum = new String();
        this.mColorBack = 0;
        this.mCompany = new String();
        this.mHideSeparator = false;
    }

    DisplayInfo(String mCompanyName, String mTelefonNum) {
        this.mCompanyName = mCompanyName;
        this.mTelefonNum = mTelefonNum;
    }

    DisplayInfo(String mCompanyName, String mTelefonNum, int mImageLocation, int mColorBack) {
        this.mImageLocation = mImageLocation;
        this.mCompanyName = mCompanyName;
        this.mTelefonNum = mTelefonNum;
        this.mColorBack = mColorBack;
    }

    DisplayInfo(String mCompanyName, String mTelefonNum, String mCompany, int mImageLocation, int mColorBack) {
        this.mImageLocation = mImageLocation;
        this.mCompanyName = mCompanyName;
        this.mTelefonNum = mTelefonNum;
        this.mCompany = mCompany;
        this.mColorBack = mColorBack;
    }

    DisplayInfo(String mCompanyName, String mTelefonNum, String mCompany, int mImageLocation, int mColorBack, boolean mHideSeparator, ActionBar actionBar) {
        this.mImageLocation = mImageLocation;
        this.mCompanyName = mCompanyName;
        this.mTelefonNum = mTelefonNum;
        this.mCompany = mCompany;
        this.mColorBack = mColorBack;
        this.mHideSeparator = mHideSeparator;
        this.actionBar = actionBar;
    }



    public String getmCompanyName() {
        return this.mCompanyName;
    }

    public String getmTelefonNum() {
        return this.mTelefonNum;
    }

    public String getmCompany() {
        return this.mCompany;
    }

    public boolean hasImage() {
        if (mImageLocation == noImageLocation) {
            return false;
        } else {
            return true;
        }
    }

    public int getmImageLocation() {
        return this.mImageLocation;
    }

    public int getmColorBack() {
        return this.mColorBack;
    }

    public boolean canHideSeparator() {
        return this.mHideSeparator;
    }

    public ActionBar getmActionbar() {
        return this.actionBar;
    }
}
