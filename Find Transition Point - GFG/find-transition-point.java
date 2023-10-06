//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int res=-1;
    int transitionPoint(int arr[], int n) {
        // code here
        int st=0,e=n-1;
          while (st <= e){
        int mid = st + (e-st)/2;
        
        if(arr[mid] == 1){
            res = mid; 
            e = mid-1;
        }else if (arr[mid] == 0){
            st = mid + 1; 
        }else{
            e = mid-1; 
        }
    }
    return res;
    }
}