import java.util.*;
class large_sum_cycle{
    static int max=-1;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int edge[]=new int[n];
        for(int i=0;i<n;i++)
            edge[i]=s.nextInt();
        boolean v[]=new boolean[n];
        boolean st[]=new boolean[n];
        for(int i=0;i<n;i++)
            sumcycle(i,edge,v,st,new ArrayList<>());
        System.out.print(max);
    }
    static void sumcycle(int i,int[] edge,boolean[] v,boolean[] st,ArrayList<Integer> list){
        if(i==-1)
            return;
        if(st[i]){
            int index=list.indexOf(i);
            if(index!=-1){
                int len=list.size()-index;
                if(len>max)
                    max=len;
            }
        }
        if(v[i])
            return;
        st[i]=true;
        v[i]=true;
        list.add(i);
        sumcycle(edge[i],edge,v,st,list);
        st[i]=false;
        list.remove(list.size()-1);
    }
}
