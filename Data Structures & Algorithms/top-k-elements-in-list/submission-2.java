class Solution {
    public int[] topKFrequent(int[] nums, int k) { 
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i: nums){
            if(mp.containsKey(i)){
                mp.put(i,mp.get(i)+1);
            }else{
                mp.put(i,1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue((a,b)-> Integer.compare(mp.get(a),mp.get(b)));

        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            if(pq.size()<k){
                pq.add(entry.getKey());
            }else{
                int top = pq.peek();
                if(mp.get(top)<mp.get(entry.getKey())){
                    pq.poll();
                    pq.add(entry.getKey());
                }
            }
        }

        
        
        return pq.stream().mapToInt(Integer::intValue).toArray();
    }
}
