package io.github.timladenov.visitsofia;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by tmladenov on 25.06.17.
 */

public class DisplayInfo extends AppCompatActivity {
    private int mImageLocation = -1;
    private final int noImageLocation = -1;
    private String mCompanyName;
    private String mTelefonNum;
    private String mCompany = DataHolder.getInstace().getmString();

    DisplayInfo() {
        this.mImageLocation = 0;
        this.mCompanyName = new String();
        this.mTelefonNum = new String();
        this.mCompany = new String();
    }

    DisplayInfo(String mCompanyName, String mTelefonNum) {
        this.mCompanyName = mCompanyName;
        this.mTelefonNum = mTelefonNum;
    }

    DisplayInfo(String mCompanyName, String mTelefonNum, int mImageLocation) {
        this.mImageLocation = mImageLocation;
        this.mCompanyName = mCompanyName;
        this.mTelefonNum = mTelefonNum;
    }

    //TODO Add below the image locator int mImageLocation!!!
    DisplayInfo(String mCompanyName, String mTelefonNum, String mCompany) {
//        this.mImageLocation = mImageLocation;
        this.mCompanyName = mCompanyName;
        this.mTelefonNum = mTelefonNum;
        this.mCompany = mCompany;
    }

//    public int getImg() {
//        return this.mImageLocation;
//    }

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
        if(mImageLocation == noImageLocation) {
            return false;
        } else {
            return true;
        }
    }

    public int getmImageLocation() {
        return this.mImageLocation;
    }
}
