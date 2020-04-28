package com.example.sapApp;

/*
    This is the Major item which is called in the majorFragment and majorAdapter.
    This is the item that is stored in the database.
    It has the values of:
            - id
            - majorName
            - bachelors
            - masters
            - doctorate
            - other
    These align with what is on the UWYO Registrar Website.
        -Alice Blair April 28, 2020
 */

public class Major {

    //-------------Initialization of the Values-------------//
    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("majorName")
    private String mMajorName = "";

    @com.google.gson.annotations.SerializedName("bachelors")
    private boolean mBachelors;

    @com.google.gson.annotations.SerializedName("masters")
    private boolean mMasters;

    @com.google.gson.annotations.SerializedName("doctorate")
    private boolean mDoctorate;

    @com.google.gson.annotations.SerializedName("other")
    private boolean mOther;


    public Major() {
    } //AB: Default Empty Constructor

    /**
     * Initializes a new Major
     *
     * @param id        The item id
     * @param major     The Major
     * @param bachelors If a bachelors is offered for that degree
     * @param masters   If a masters is offered for that degree
     * @param doctorate If a doctorate is offered for that degree
     * @param other     If a different thing is offered for that degree
     *                  <p>
     *                  -Alice Blair April 14, 2020
     */
    public Major(String id, String major, Boolean bachelors, Boolean masters, Boolean doctorate, Boolean other) {
        this.setId(id);
        this.setmMajorName(major);
        this.setmBachelors(bachelors);
        this.setmMasters(masters);
        this.setmDoctorate(doctorate);
        this.setmOther(other);

    }

    @Override
    public String toString() {
        return getMajorName();
    }

    //Simple Getter and Setter methods for the values
    public String getId() {
        return mId;
    }

    public void setId(String Id) {
        mId = Id;
    }

    public String getMajorName() {
        return mMajorName;
    }

    public final void setmMajorName(String item) {
        mMajorName = item;
    }

    public boolean getmBachelors() {
        return mBachelors;
    }

    public final void setmBachelors(boolean item) {
        mBachelors = item;
    }

    public boolean getmMasters() {
        return mMasters;
    }

    public final void setmMasters(boolean item) {
        mMasters = item;
    }

    public boolean getmDoctorate() {
        return mDoctorate;
    }

    public final void setmDoctorate(boolean item) {
        mDoctorate = item;
    }

    public boolean getmOther() {
        return mOther;
    }

    public final void setmOther(boolean item) {
        mOther = item;
    }


}

