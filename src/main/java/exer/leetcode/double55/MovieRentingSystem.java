package exer.leetcode.double55;

import org.junit.Test;

import java.util.*;

class MovieRentingSystem {

    Map<Integer, Shop> shops;
    Set<Long> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        shops = new HashMap<>(n);
        for (int i = 0; i < entries.length; i++) {
            shops.putIfAbsent(entries[i][0], new Shop(new HashMap<>()));
            Shop shop = shops.get(entries[i][0]);
            if (shop.movies == null) shop.movies = new HashMap<>();
            shop.movies.put(entries[i][1], new Movie(entries[i][1], entries[i][2]));
        }
        rented = new HashSet<>();
    }


    public List<Integer> search(int movie) {
        ArrayList<int[]> list = new ArrayList<>();
        Iterator<Map.Entry<Integer, Shop>> iter = shops.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Shop> shopPair = iter.next();
            Integer shopId = shopPair.getKey();
            Shop shop = shopPair.getValue();
            if (shop.movies == null) continue;
            Movie m = shop.movies.get(movie);
            if (m == null) continue;
            if ( !rented.contains(hash(shopId, m.movieId))) list.add(new int[]{shopId, m.price});
        }

        Collections.sort(list, (i1, i2) -> {
            if (i1[1] == i2[1]) return i1[0] - i2[0];
            else return i1[1] - i2[1];
        });
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            res.add(list.get(i)[0]);
        }
        return res;
    }

    public void rent(int shop, int movie) {
        Shop s = shops.get(shop);
        if (s.movies == null) return;
        rented.add(hash(shop, movie));
    }

    public void drop(int shop, int movie) {
        Shop s = shops.get(shop);
        if (s.movies == null) return;
        rented.remove(hash(shop, movie));
    }

    @SuppressWarnings("Duplicates")
    public List<List<Integer>> report() {
        List<int[]> list = new ArrayList<>();
        Iterator<Map.Entry<Integer, Shop>> iter = shops.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Shop> shopPair = iter.next();
            Integer shopId = shopPair.getKey();
            Shop shop = shopPair.getValue();
            Map<Integer, Movie> movies = shop.movies;
            if (movies == null) continue;
            Iterator<Movie> it = movies.values().iterator();
            while (it.hasNext()) {
                Movie m = it.next();
                if ( rented.contains(hash(shopId, m.movieId)))
                    list.add(new int[]{shopId, m.movieId, m.price});
            }
        }
        for (int i = 0; i < shops.size(); i++) {

        }
        Collections.sort(list, (i1, i2) -> {
            if (i1[2] == i2[2]) return i1[0] - i2[0];
            else return i1[2] - i2[2];
        });
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            res.add(Arrays.asList(list.get(i)[0], list.get(i)[1]));
        }
        return res;
    }

    public long hash(int shop, int movie) {
        return (long) shop * 1000001 + movie;
    }

    class Shop {
        Map<Integer, Movie> movies;

        public Shop(Map<Integer, Movie> movies) {
            this.movies = movies;
        }
    }

    class Movie {
        int movieId;
        int price;

        public Movie(int movieId, int price) {
            this.movieId = movieId;
            this.price = price;
        }
    }
}