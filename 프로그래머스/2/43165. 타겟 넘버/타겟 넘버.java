class Solution {
    static int res = 0;

    public int solution(int[] numbers, int target) {
        
        count(0, 0, target, numbers);
        
        return res;
    }
    
    private void count(int idx, int num, int target, int[] numbers) {
        
        if (idx == numbers.length) {
            if (num == target) {
                res++;
            }
            
            return;
        }
        
        count(idx + 1, num + numbers[idx], target, numbers);
        count(idx + 1, num - numbers[idx], target, numbers);
        
    }
}