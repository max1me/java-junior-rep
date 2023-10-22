package edu.itmo.project.homework10.images;

public final class Editor {
    private Drawable drawable;

    public Editor(Drawable drawable) { // конструктор
        setDrawable(drawable);
    }

    public void setDrawable(final Drawable drawable){
        this.drawable = drawable;
    }

    public void show(){
        drawable.draw();
    }
    @Override
    public Editor clone() {
        Editor editorClone = new Editor(this.drawable.clone());
        return editorClone;
    }
}
