package fr.valtech.coursDuSoir.mongodb.model;

public class Clipart {

    private String title;
    private Uploader uploader;

    protected Clipart() {
    }

    public Clipart(String title, Uploader uploader) {
        this.title = title;
        this.uploader = uploader;
    }

    public String getTitle() {
        return this.title;
    }

    public Uploader getUploader() {
        return this.uploader;
    }

}
