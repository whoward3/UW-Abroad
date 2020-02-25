package com.example.sapApp;

import android.graphics.pdf.PdfDocument;

/**
 * Represents a School in a list
 */
public class School {

    /**
     * Private Values
     */

    @com.google.gson.annotations.SerializedName("Country")
    private String mCountry;

    @com.google.gson.annotations.SerializedName("SchoolName")
    private String mSchoolName;

    @com.google.gson.annotations.SerializedName("ImageURL")
    private String mImageURL;

    @com.google.gson.annotations.SerializedName("PageURL")
    private String mPageURL;

    @com.google.gson.annotations.SerializedName("Id")
    private String mId;

    /**
     * School constructor
     */
    public School() {

    }

    /**
     * Initializes a new School
     *
     * @param text
     *            The item text
     * @param id
     *            The item id
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
     * @param text
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
     * @param text
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
     * @param text
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
     * @param text
     *            text to set
     */
    public final void setPageURL(String pageURL) {
        mPageURL = pageURL;
    }

}