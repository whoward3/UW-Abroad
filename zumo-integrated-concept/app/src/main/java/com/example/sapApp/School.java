package com.example.sapApp;

import android.graphics.pdf.PdfDocument;

/**
 * Represents a School in a list
 */
public class School {

    /**
     * Private Values
     */

    @com.google.gson.annotations.SerializedName("country")
    private String mCountry;

    @com.google.gson.annotations.SerializedName("schoolName")
    private String mSchoolName;

    @com.google.gson.annotations.SerializedName("imageURL")
    private String mImageURL;

    @com.google.gson.annotations.SerializedName("pageURL")
    private String mPageURL;

    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    /**
     * School constructor
     */
    public School() {

    }

    @Override
    public String toString() {
        return getSchoolName();
    }

    /**
     * Initializes a new School
     *
     * @param schoolName
     *            The item text
     * @param id
     *            The item id
     *
     * @param country
     *            The item country
     *
     * @param imageURL
     *
     * @param pageURL
     */
    public School(String id, String country, String schoolName, String imageURL, String pageURL) {
        this.setId(id);
        this.setCountry(country);
        this.setSchoolName(schoolName);
        this.setImageURL(imageURL);
        this.setPageURL(pageURL);
    }

    /**
     * Returns the item id
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the item id
     *
     * @param id
     *            id to set
     */
    public final void setId(String id) {
        mId = id;
    }

    /**
     * Returns the country
     */
    public String getCountry() {
        return mCountry;
    }

    /**
     * Sets the country
     *
     * @param country
     *            text to set
     */
    public final void setCountry(String country) {
        mCountry = country;
    }

    /**
     * Returns the SchoolName
     */
    public String getSchoolName() {
        return mSchoolName;
    }

    /**
     * Sets the country
     *
     * @param schoolName
     *            text to set
     */
    public final void setSchoolName(String schoolName) {
        mSchoolName = schoolName;
    }

    /**
     * Returns the country
     */
    public String getImageURL() {
        return mImageURL;
    }

    /**
     * Sets the country
     *
     * @param imageURL
     *            text to set
     */
    public final void setImageURL(String imageURL) {
        mImageURL = imageURL;
    }

    /**
     * Returns the country
     */
    public String getPageURL() {
        return mPageURL;
    }

    /**
     * Sets the country
     *
     * @param pageURL
     *            text to set
     */
    public final void setPageURL(String pageURL) {
        mPageURL = pageURL;
    }

}