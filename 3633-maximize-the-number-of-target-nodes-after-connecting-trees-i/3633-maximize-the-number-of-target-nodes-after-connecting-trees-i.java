class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {

        int n = edges1.length+1;
        int m = edges2.length+1;
        
        List<List<Integer>> tree1 =buildGraph(edges1,n); 
        List<List<Integer>> tree2 =buildGraph(edges2,m); 
        
        List<Set<Integer>> allcombi = new ArrayList<>();
        for(int i=0;i<m;i++){
            Set<Integer> ans = bfs(tree2,i,k-1);
            allcombi.add(ans);
        }

        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            Set<Integer> reach = bfs(tree1,i,k);
            int maxi = Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                maxi = Math.max(reach.size() + allcombi.get(j).size(),maxi );
            }
            ans[i]=maxi;
        }
        return ans;
    }
    public Set<Integer> bfs(List<List<Integer>> list, int start, int k){
        HashSet<Integer> set = new HashSet<>();
        if (k < 0) return set;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start,0});
        set.add(start);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int val[] = q.poll();
                int node = val[0];
                int level = val[1];

                if(level == k) continue;
                for(int neigbor : list.get(node)){
                    if(!set.contains(neigbor)){
                        q.offer(new int[]{neigbor,level+1});
                        set.add(neigbor);
                    }
                }
            }
        }
        return set;
    }
    private List<List<Integer>> buildGraph(int[][] edges, int size) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < size; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}