class Solution {
    static boolean[] flag;
    static int[] index;
    static int health;
    static int res;
        
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        flag = new boolean[dungeons.length];
        index = new int[dungeons.length];
        health = k;
        
        res = 0;
        perm(k, dungeons, 0, 0);
        
        return res;
    }
    
    public static void perm(int k, int[][] dungeons, int cnt, int sum) {
        if(dungeons.length == cnt) {
            for (int idx : index){
                if (dungeons[idx][0] > k) {
                   break; 
                }
                k -= dungeons[idx][1];
                sum++;
            }
            res = Math.max(sum, res);
            k = health;
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (flag[i]) {
                continue;
            }
            
            flag[i] = true;
            index[cnt] = i;
            perm(k, dungeons, cnt+1, sum);
            flag[i] = false;
        }
    }
}