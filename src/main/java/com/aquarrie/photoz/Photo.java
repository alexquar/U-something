package com.aquarrie.photoz;

public class Photo {
    private String id;
    private String fileName;
    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }
    public Photo(){

    }
    public String getId() {
        return id;
    }
    public String getFileName() {
        return fileName;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
