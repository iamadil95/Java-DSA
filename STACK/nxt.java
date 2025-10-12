import java.util.*;
public class nxt {
    
public static void main(String[] args) {
    int arr[] = {6,8,0,1,3};
    Stack<Integer> s = new Stack<>();
    int nxtGreater[] = new int[arr.length];
    for(int i=arr.length-1;i>=0;i--)
    {
            // 1 while
while(!s.isEmpty() && arr[s.peek()] <= arr [i])
{
s.pop();
}
            // 2 if-else
if(s.isEmpty())
{
    nxtGreater[i] = -1;
} else {
nxtGreater[i] = arr[s.peek()];
}
            // 3 push in s
            s.push(i);
        }
        for(int i=0;i<nxtGreater.length;i++)
        {
            System.out.print(nxtGreater[i] + " ");
        }
        System.out.println();
    }
}

//Types of these problems

//next greater right
//next greater left - for loop 0 se shuru karke n tak lekar jana hai
//next smaller right - arr[s.peek]>= arr[i] -- just sign change
//next smaller left - both loop reverse and sign change