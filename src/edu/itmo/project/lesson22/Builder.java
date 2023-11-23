package edu.itmo.project.lesson22;

public class Builder {
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(300).servings(200).fat(80).carbs(50).proteins(777).build();
        System.out.println(nutritionFacts.toString());
    }


}
