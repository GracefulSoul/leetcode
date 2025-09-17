package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DesignAFoodRatingSystem {

	// https://leetcode.com/problems/design-a-food-rating-system/submissions/1773784836/
	public static void main(String[] args) {
		FoodRatings foodRatings = new FoodRatings(
				new String[] { "kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi" },
				new String[] { "korean", "japanese", "japanese", "greek", "japanese", "korean" },
				new int[] { 9, 12, 8, 15, 14, 7 });
		System.out.println(foodRatings.highestRated("korean"));		// return "kimchi"
												// "kimchi" is the highest rated korean food with a rating of 9.
		System.out.println(foodRatings.highestRated("japanese"));	// return "ramen"
												// "ramen" is the highest rated japanese food with a rating of 14.
		foodRatings.changeRating("sushi", 16);	// "sushi" now has a rating of 16.
		System.out.println(foodRatings.highestRated("japanese"));	// return "sushi"
												// "sushi" is the highest rated japanese food with a rating of 16.
		foodRatings.changeRating("ramen", 16);	// "ramen" now has a rating of 16.
		System.out.println(foodRatings.highestRated("japanese"));	// return "ramen"
												// Both "sushi" and "ramen" have a rating of 16.
												// However, "ramen" is lexicographically smaller than "sushi".
	}

}

class FoodRatings {

	private Map<String, Queue<FoodRating>> cuisineMap;
	private Map<String, FoodRating> foodMap;

	public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
		this.cuisineMap = new HashMap<>();
		this.foodMap = new HashMap<>();
		for (int i = 0; i < foods.length; i++) {
			FoodRating foodRating = new FoodRating(cuisines[i], foods[i], ratings[i]);
			this.cuisineMap.computeIfAbsent(foodRating.getCuisine(), k -> new PriorityQueue<>(FoodRating::compareTo)).add(foodRating);
			this.foodMap.put(foodRating.getFood(), foodRating);
		}
	}

	public void changeRating(String food, int newRating) {
		FoodRating foodRating = this.foodMap.get(food);
		Queue<FoodRating> queue = this.cuisineMap.get(foodRating.getCuisine());
		queue.remove(foodRating);
		foodRating.setRating(newRating);
		queue.add(foodRating);
	}

	public String highestRated(String cuisine) {
		return this.cuisineMap.get(cuisine).peek().getFood();
	}

}

class FoodRating {
	private final String cuisine;
	private final String food;
	private int rating;

	FoodRating(String cuisine, String food, int rating) {
		this.cuisine = cuisine;
		this.food = food;
		this.rating = rating;
	}

	void setRating(int rating) {
		this.rating = rating;
	}

	String getCuisine() {
		return this.cuisine;
	}

	String getFood() {
		return this.food;
	}

	int getRating() {
		return this.rating;
	}

	int compareTo(FoodRating foodRating) {
		if (this.rating == foodRating.getRating()) {
			return this.food.compareTo(foodRating.getFood());
		} else {
			return foodRating.getRating() - this.rating;
		}
	}

}
/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */