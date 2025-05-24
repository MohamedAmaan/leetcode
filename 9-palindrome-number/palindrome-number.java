class Solution {
    public boolean isPalindrome(int x) {
        int reverse=0;
        int temp = x;
        while(x>0){
            int res = x % 10;
            reverse = (reverse * 10) + res;
            x = x/10;
        }
        if(reverse == temp){
            return true;
        }else{
            return false;
        }
    }
}