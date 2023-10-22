package edu.itmo.project.homework10.images;

public class Image implements Drawable, Cloneable {
    private String path;

    public Image(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void draw() {
        System.out.println(path);
    }

    @Override
    public Image clone() {
        Image imageClone = new Image(this.path);
        return imageClone;
    }
}
