package com.example.sapApp;

public class MajorItem {

    //Private Values that are for Majors offered
    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("majorName")
    private String mMajor;

    @com.google.gson.annotations.SerializedName("bachelors")
    private Boolean mBSBA;

    @com.google.gson.annotations.SerializedName("masters")
    private Boolean mMs;

    @com.google.gson.annotations.SerializedName("doctorate")
    private Boolean mPhd;

    @com.google.gson.annotations.SerializedName("other")
    private Boolean mOther;

    public MajorItem(){} //Default Empty Constructor

    @Override
    public String toString() { return getMajorName();}

    public MajorItem (String ID, String Major, Boolean BSBA, Boolean Ms, Boolean Phd, Boolean Other)
    {
        this.setID(ID);
        this.setMajor(Major);
        this.setBSBA(BSBA);
        this.setMs(Ms);
        this.setPhd(Phd);
        this.setmOther(Other);

    }

    //Simple Getter and Setter methods for the values
    public String getId() {
        return mId;
    }

    public void setID(String ID)
    {
        mId = ID;
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

    public Boolean getmOther()
    {
        return mOther;
    }

    public final void setmOther(Boolean item)
    {
        mOther = item;
    }


}


