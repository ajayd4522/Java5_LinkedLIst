// https://leetcode.com/problems/happy-number/
// 202. Happy Number
// Easy.Google.tricky

package java5.leetcode;

public class HappyNumber {

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while(slow != fast);

        if(slow == 1){
            return true;
        }

        return false;
    }

    private int findSquare (int number){
        int ans = 0;

        while(number > 0){
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }

        return ans;
    }
}
