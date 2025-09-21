package gracefulsoul.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DesignMovieRentalSystem {

	// https://leetcode.com/problems/design-movie-rental-system/submissions/1777982239/
	public static void main(String[] args) {
		MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, new int[][] {
			{ 0, 1, 5 },
			{ 0, 2, 6 },
			{ 0, 3, 7 },
			{ 1, 1, 4 },
			{ 1, 2, 7 },
			{ 2, 1, 5 }
		});
		System.out.println(movieRentingSystem.search(1));	// return [1, 0, 2], Movies of ID 1 are unrented at shops 1, 0, and 2. Shop 1 is cheapest; shop 0 and 2 are the same price, so order by shop number.
		movieRentingSystem.rent(0, 1);						// Rent movie 1 from shop 0. Unrented movies at shop 0 are now [2,3].
		movieRentingSystem.rent(1, 2);						// Rent movie 2 from shop 1. Unrented movies at shop 1 are now [1].
		System.out.println(movieRentingSystem.report());	// return [[0, 1], [1, 2]]. Movie 1 from shop 0 is cheapest, followed by movie 2 from shop 1.
		movieRentingSystem.drop(1, 2);						// Drop off movie 2 at shop 1. Unrented movies at shop 1 are now [1,2].
		System.out.println(movieRentingSystem.search(2));	// return [0, 1]. Movies of ID 2 are unrented at shops 0 and 1. Shop 0 is cheapest, followed by shop 1.
	}

}

class MovieRentingSystem {

	private Map<Integer, Set<int[]>> movies;
	private Map<Integer, Map<Integer, Integer>> inventory;
	private Set<int[]> rented;

	public MovieRentingSystem(int n, int[][] entries) {
		Comparator<int[]> comparator = (a, b) -> a[2] != b[2] ? a[2] - b[2] : (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
		this.movies = new HashMap<>();
		this.inventory = new HashMap<>();
		this.rented = new TreeSet<>(comparator);
		for (int[] entry : entries) {
			int shop = entry[0];
			int movie = entry[1];
			int price = entry[2];
			this.movies.computeIfAbsent(movie, k -> new TreeSet<>(comparator));
			this.movies.get(movie).add(entry);
			this.inventory.computeIfAbsent(shop, k -> new HashMap<>());
			this.inventory.get(shop).put(movie, price);
		}
	}

	public List<Integer> search(int movie) {
		return this.movies.getOrDefault(movie, Collections.emptySet())
				.stream().limit(5).map(entry -> entry[0])
				.collect(Collectors.toList());
	}

	public void rent(int shop, int movie) {
		int[] entry = { shop, movie, this.inventory.get(shop).get(movie) };
		this.movies.get(movie).remove(entry);
		this.rented.add(entry);
	}

	public void drop(int shop, int movie) {
		int[] entry = { shop, movie, this.inventory.get(shop).get(movie) };
		this.movies.get(movie).add(entry);
		this.rented.remove(entry);
	}

	public List<List<Integer>> report() {
		return this.rented.stream().limit(5).map(entry -> List.of(entry[0], entry[1])).collect(Collectors.toList());
	}

}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */