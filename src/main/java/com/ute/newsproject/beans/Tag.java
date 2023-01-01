package com.ute.newsproject.beans;

public class Tag {
    private int tagID;
    private String val;

    public Tag() {
    }

    public Tag(int tagID, String val) {
        this.tagID = tagID;
        this.val = val;
    }

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagID=" + tagID +
                ", val='" + val + '\'' +
                '}';
    }
}
