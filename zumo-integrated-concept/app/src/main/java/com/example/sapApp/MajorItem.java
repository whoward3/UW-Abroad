package com.example.sapApp;

public class MajorItem {

    //Private Values that are for Majors offered
    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("major")
    private String mMajor;

    @com.google.gson.annotations.SerializedName("bs/ba")
    private Boolean mBSBA;

    @com.google.gson.annotations.SerializedName("ms")
    private Boolean mMs;

    @com.google.gson.annotations.SerializedName("phd")
    private Boolean mPhd;

    public MajorItem(){} //Default Empty Constructor

    @Override
    public String toString() { return getMajorName();}

    public MajorItem (String ID, String Major, Boolean BSBA, Boolean Ms, Boolean Phd)
    {
        this.setMajor(Major);
        this.setBSBA(BSBA);
        this.setMs(Ms);
        this.setPhd(Phd);
    }

    //Simple Getter and Setter methods for the values
    public String getId() {
        return mId;
    }


    public String getMajorName()
    {
        return mMajor;
    }

    public final void setMajor(String item)
    {
        mMajor = item;
    }

    public Boolean getBSBA()
    {
        return mBSBA;
    }

    public final void setBSBA(Boolean item)
    {
        mBSBA = item;
    }

    public Boolean getMS()
    {
        return mMs;
    }

    public final void setMs(Boolean item)
    {
        mMs = item;
    }

    public Boolean getmPhd()
    {
        return mPhd;
    }

    public final void setPhd(Boolean item)
    {
        mPhd = item;
    }

}


