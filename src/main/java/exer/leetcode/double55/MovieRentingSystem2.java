package exer.leetcode.double55;

import java.util.*;

class MovieRentingSystem2 {

    // 借出排序:
    // int[]:[shopId,movieId,price]:
    private PriorityQueue<int[]> rentedQueue;
    // 哈希提高查找效率
    private HashMap<Long, Integer> movies;
    private Set<Long> rented;

    // 建立索引(movieId->Set<>shopId)
    private Map<Integer, Set<int[]>> movieId_index;


    public MovieRentingSystem2(int n, int[][] entries) {
        rentedQueue = new PriorityQueue<>((i1, i2) -> {
            if (i1[2] != i2[2]) return i1[2] - i2[2];
            else if(i1[0]!=i2[0]) return i1[0] - i2[0];
            else return i1[1]-i2[1];
        });
        movies = new HashMap<>();
        movieId_index = new HashMap<>();
        rented = new HashSet<>();
        for (int[] entry : entries) {
            movies.put(hash(entry[0], entry[1]), entry[2]);
            movieId_index.putIfAbsent(entry[1], new HashSet<>());
            movieId_index.get(entry[1]).add(new int[]{entry[0], entry[2]});
        }
    }


    public List<Integer> search(int movie) {
        ArrayList<int[]> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        // int[]{shopId,price}
        Set<int[]> shops4movie = movieId_index.get(movie);
        if (shops4movie == null) return res;
        Iterator<int[]> iter = shops4movie.iterator();
        while (iter.hasNext()) {
            int[] shopInfo = iter.next();
            if (!rented.contains(hash(shopInfo[0], movie))) list.add(shopInfo);
        }
        Collections.sort(list, (i1, i2) -> {
            if (i1[1] == i2[1]) return i1[0] - i2[0];
            else return i1[1] - i2[1];
        });

        int size = list.size();
        for (int i = 0; i < Math.min(5, size); i++) {
            res.add(list.get(i)[0]);
        }
        return res;
    }

    public void rent(int shop, int movie) {
        rented.add(hash(shop, movie));
        rentedQueue.offer(new int[]{shop, movie, movies.get(hash(shop, movie))});
    }

    public void drop(int shop, int movie) {
        rented.remove(hash(shop, movie));
    }

    @SuppressWarnings("Duplicates")
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();

        while (res.size() < 5 && !rentedQueue.isEmpty()) {
            int[] shopInfo = rentedQueue.poll();
            if (rented.contains(hash(shopInfo[0], shopInfo[1])) && !res.contains(Arrays.asList(shopInfo[0], shopInfo[1])))
                res.add(Arrays.asList(shopInfo[0], shopInfo[1]));
        }
        for (int i = 0; i < res.size(); i++) {
            Integer shopId = res.get(i).get(0);
            Integer movieId = res.get(i).get(1);
            rentedQueue.offer(new int[]{shopId,movieId,movies.get(hash(shopId,movieId))});
        }
        return res;
    }

    public long hash(int shop, int movie) {
        return (long) shop * 1000001 + movie;
    }

}