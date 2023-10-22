package edu.itmo.project.homework10.images;

public class Gallery implements Drawable, Cloneable {
    private String name;
    private Drawable[] drawables;

    public Gallery(String name, Drawable[] drawables) {
        this.drawables = drawables;
        this.name = name;
    }

    public Drawable[] getImages() {
        return drawables;
    }

    @Override
    public void draw() {
        System.out.println(name);
        for (Drawable drawable : drawables) {
            drawable.draw();
        }
    }

    @Override
    public Gallery clone() {
        Gallery galleryClone = null;
        Drawable[] drawablesClone = new Drawable[drawables.length];
        for (int i = 0; i < drawables.length; i++) {
            drawablesClone[i] = drawables[i].clone();
        }
        galleryClone = new Gallery(this.name, drawablesClone);
        return galleryClone;
    }
}
