package org.martin;

import java.util.HashMap;

class Solution886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        HashMap<Integer, Boolean> group = new HashMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            if (group.containsKey(a)) {
                if (group.containsKey(b)) {
                    if (!(group.get(a) ^ group.get(b))) {
                        for(int j = 0; j < i; j ++){
                            int d0 = dislikes[j][0];
                            int d1 = dislikes[j][1];
                            
                        }
                        return false;
                    }
                }
                else{
                    boolean ga = group.get(a);
                    group.put(b, !ga);
                }
            } else {
                if(group.containsKey(b)){
                    group.put(a, !group.get(b));
                }
                else{
                    group.put(a, true);
                    group.put(b, false);
                }
            }
        }
        return true;
    }

    private HashMap<Integer, Boolean> partition(HashMap<Integer, Boolean> group, int a, int b) {
        if (group.containsKey(a)) {
            if (group.containsKey(b)) {
                if (!(group.get(a) ^ group.get(b))) {
                    return null;
                }
            }
            else{
                boolean ga = group.get(a);
                group.put(b, !ga);
            }
        } else {
            if(group.containsKey(b)){
                group.put(a, !group.get(b));
            }
            else{
                group.put(a, true);
                group.put(b, false);
            }
        }
        return group;
    }
}