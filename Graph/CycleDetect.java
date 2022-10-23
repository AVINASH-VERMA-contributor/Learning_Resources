import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CycleDetect {
    public static void main(String[] args) {
        int n=11;
        int m=10;

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }


        Scanner sc=new Scanner(System.in);
       
        for(int i=0;i<m;i++){
            int u,v;
            u=sc.nextInt();
            v=sc.nextInt();
            addEdge(adj, u, v);
        }
        sc.close();

        System.out.print(isCycle(n,adj));
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj,int s,boolean vis[]){
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(s, -1));
        vis[s]=true;

        while(!q.isEmpty()){
            int node=q.peek().first;
            int par=q.peek().second;
            q.remove();
        
            for(Integer it:adj.get(node)){
                if(vis[it]==false){
                    q.add(new Node(it,node));
                        vis[it]=true;
                    
                }
                else if(par!=it){
                    return true;
                }
            }
        
        }
        
return false;
    }


    public static boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] vis=new boolean[V+1];
        Arrays.fill(vis,false);
        
        for(int i=1;i<=V;i++){
            if(vis[i]==false){
                if(checkForCycle(adj, i, vis)){
                    return true;
                }
            }
        }
    return false;
}

}

class Node{
    int first;
    int second;
    public Node(int first,int second){
        this.first=first;
        this.second=second;
    }
}

