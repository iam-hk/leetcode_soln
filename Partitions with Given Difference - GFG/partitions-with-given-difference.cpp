//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
   int mod = 1e9+7;
    
    int f(int ind, int target, vector<int> &arr, vector<vector<int>> &dp){
        if(target < 0) return 0;
        if(ind < 0) return target == 0;
        
        if(dp[ind][target] != -1) return dp[ind][target];
        int pick = f(ind-1, target-arr[ind], arr, dp) % mod;
        int notPick = f(ind-1, target, arr, dp) % mod;
        return dp[ind][target] = (pick + notPick) % mod;
    }

    int countPartitions(int n, int d, vector<int>& arr) {
        int totalSum = 0;
        for(auto it: arr){
            totalSum = (totalSum+it) % mod;
        }
        if((totalSum+d)%2 != 0) return 0;
        
        int target = ((d+totalSum)/2) % mod;
        vector<vector<int>> dp(n, vector<int>(target+1,-1));
        return f(n-1, target, arr, dp);
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, d;
        cin >> n >> d;
        vector<int> arr;

        for (int i = 0; i < n; ++i) {
            int x;
            cin >> x;
            arr.push_back(x);
        }

        Solution obj;
        cout << obj.countPartitions(n, d, arr) << "\n";
    }
    return 0;
}
// } Driver Code Ends