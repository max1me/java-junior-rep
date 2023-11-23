package edu.itmo.project.lesson22;

public class NutritionFacts {
    private int calories;
    private int servings;
    private int fat;
    private int proteins;
    private int carbs;

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    private NutritionFacts() {
    }

    private NutritionFacts(int calories, int servings, int fat, int proteins, int carbs) {
        this.calories = calories;
        this.servings = servings;
        this.fat = fat;
        this.proteins = proteins;
        this.carbs = carbs;
    }

    public static class Builder {
        private int calories;
        private int servings;
        private int fat;
        private int proteins;
        private int carbs;

        public Builder(int calories) {
            this.calories = calories;
        }

        public Builder servings(int servings) {
            this.servings = servings;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder proteins(int proteins) {
            this.proteins = proteins;
            return this;
        }
        public Builder carbs(int carbs) {
            this.carbs = carbs;
            return this;
        }

        NutritionFacts build() {
            return new NutritionFacts(this.calories, this.servings, this.fat, this.proteins, this.carbs);
        }

    }
}