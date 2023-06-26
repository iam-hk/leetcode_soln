class Solution {
    public class Pair implements Comparable<Pair>{
        int val;
        int rob;
        Pair(int val,int rob)
        {
            this.val=val;
            this.rob=rob;
        }
        public int compareTo(Pair o)
        {
            return this.val-o.val;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String dir) {
        Stack<Pair>q=new Stack<>();
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<positions.length;i++)
        {
            pq.add(new Pair(positions[i],i));
        }
        int index=0;
        while(pq.size()!=0)
        {
            Pair p=pq.poll();
            positions[index++]=p.rob;
        }
        // for(int i=0;i<positions.length;i++)
        // System.out.print(positions[i]+" ");
        // System.out.println();
        char arr[]=new char[healths.length];
        int r=0;
        for(int i=0;i<dir.length();i++)
        {
            char ch=dir.charAt(i);
            if(ch=='R')
                ++r;
            arr[i]=ch;
        }
        
        int flag=0;
        for(int i=0;i<positions.length;i++)
        {
            int cur=positions[i];
            int hlt=healths[cur];
            if(arr[cur]=='R')
                q.push(new Pair(healths[cur],cur));
            else
            {
                if(q.size()==0)
                    q.push(new Pair(-1*healths[cur],cur));
                else
                {
                    int check=0;
                    while(q.size()!=0&&q.peek().val>0)
                    {
                        Pair tmp=q.peek();
                        int val=tmp.val;
                        if(val==hlt)
                        {
                            flag=1;
                            q.pop();
                            check=1;
                            break;
                        }
                        else if(val>hlt)
                        {
                            flag=1;
                            Pair tmp1=q.pop();
                            int pos=tmp1.rob;
                            val-=1;
                            check=1;
                            q.push(new Pair(val,pos));
                            break;
                            
                        }
                        else
                        {
                            flag=1;
                            q.pop();
                            hlt-=1;   
                        }
                    }
                    if(check==0)
                    q.add(new Pair(-1*hlt,cur));
                }
            }  
        }
         ArrayList<Integer>ans=new ArrayList<>();
        if(flag==0)
        {
          for(int i=0;i<healths.length;i++)
            {
                ans.add(healths[i]);
            }
            return ans;   
        }
            int ind=0;
        Arrays.fill(healths,-1);
            while(q.size()!=0)
            {
                Pair tmp=q.pop();
                int val=tmp.val;
                int rob=tmp.rob;
                val=Math.abs(val);
                healths[rob]=val;

            }
            for(int i=0;i<positions.length;i++)
            {
                if(healths[i]!=-1)
                    ans.add(healths[i]);
            }
            return ans;
    }
}