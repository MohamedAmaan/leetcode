class Solution {
    public boolean search(int[] nums, int target) {
        // int n = nums.length;
        // int count = 0;
        // for(int i =0;i<n;i++){
        //     if(nums[i] == target){
        //         count ++;
        //         break;
        //     }else{
        //         count =0;
        //     }
        // }
        // if(count == 1){
        //     return true;
        // }else{
        //     return false;
        // }
        for (int num:nums){
            if(num==target){
                return true;
            }
        }
        return false;
    }
}