class Solution {
    static int res;
    public int solution(int[] numbers, int target) {
        
        res = 0;
        cal(0, numbers, target, 0);
        
        return res;
    }
    private static void cal(int cur, int[] numbers, int target, int sum){
        if(cur == numbers.length) {
            if(target == sum) {
                res++;
            }
            return;
        }
        
        cal(cur + 1, numbers, target, sum + numbers[cur]);
        cal(cur + 1, numbers, target, sum - numbers[cur]);
    }
}