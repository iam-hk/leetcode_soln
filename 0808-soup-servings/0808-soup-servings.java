class Solution {
    public double fnCalc(int a,int b,Map<String,Double>map)
    {
        if(a<=0&&b<=0)
            return 0.5;
        if(a<=0)
            return 1;
        if(b<=0)
            return 0;
        String tmp=a+" "+b;
        if(map.containsKey(tmp))
            return map.get(tmp);
        double val=0.25*(fnCalc(a-100,b,map)+fnCalc(a-75,b-25,map)+fnCalc(a-50,b-50,map)+fnCalc(a-25,b-75,map)); 
        map.put(tmp,val);
        return val;
    }
    public double soupServings(int n) {
        if(n>4800)
            return 1;
        Map<String,Double>map=new HashMap<>();
        return fnCalc(n,n,map);
    }
}