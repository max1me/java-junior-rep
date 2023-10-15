package edu.itmo.project.lesson07;

public class Cat {
    private String name;
    private int weigth;
    private int victories;
    public Cat(int weigth) {
        setWeigth(weigth);
        setName("Мурзик");
    }
    public void setName(String name) {
        String formattedName = name.replaceAll("\\s", "");
        if (name != null && formattedName.length() > 2) {
            this.name = name;
        } else throw new IllegalArgumentException("Недопустимое имя");
    }

    public String getName() {
        return name;
    }

    public int getWeigth() {
        return weigth;
    }

    public int getVictories() {
        return victories;
    }

    public void setWeigth(int weigth) {
        if (weigth >= 1 && weigth < 9) {
            this.weigth = weigth;
        } else throw new IllegalArgumentException("Недопустимый вес");
    }
    private void increseVictories() {
        this.victories++;
    }

    public boolean attack (Cat cat) {
        if (cat != null) {
            if (this.weigth > cat.getWeigth()) {
                this.increseVictories();
                return true;
            } else if (this.weigth < cat.getWeigth()) {
                cat.increseVictories();
                return false;
            }
        }
        return false;
    }
}
