package fr.valtech.coursDuSoir.mongodb.model;

public class Uploader {

    private String name;
    private String href;

    private Uploader() {
    }

    public Uploader(String name, String href) {
        this.name = name;
        this.href = href;
    }

    public String getName() {
        return this.name;
    }

    public String getHref() {
        return this.href;
    }

}
