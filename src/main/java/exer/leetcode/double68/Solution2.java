package exer.leetcode.double68;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-27 22:24
 */
public class Solution2 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> having = new HashSet<>();
        for(String sup:supplies) having.add(sup);
        boolean newDone = true;
        int n = recipes.length;
        boolean[] v = new boolean[n];
        List<String> res = new ArrayList<>();
        while(newDone){
            newDone = false;
            for(int i = 0;i<n;i++){
                if(!v[i]){
                    int idx = 0;
                    while(idx<ingredients.get(i).size() && having.contains(ingredients.get(i).get(idx))) idx++;

                    if(idx == ingredients.get(i).size()){
                        newDone = true;
                        having.add(recipes[i]);
                        v[i] = true;
                        res.add(recipes[i]);
                    }
                }
            }
        }
        return res;
    }
}
