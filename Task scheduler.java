// Time complexity - 0(n)
// space complexity - 0(n)
// code successfully executed on leetcode.
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0 ) return 0;
        int maxCount = 0; 
        int maxfreq = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            if(!map.containsKey(tasks[i])){
                map.put(tasks[i],0);
            }
            int count = map.get(tasks[i])+1;
            map.put(tasks[i],count);
            maxfreq = Math.max(maxfreq,count);
        }
        for(int val : map.values()){ // getting values from hashmap
            if(val == maxfreq) maxCount++;
        }
        int partitions = maxfreq -1;
        int empty  = (n - (maxCount -1)) * partitions;
        int pendingtasks = tasks.length - (maxfreq*maxCount);
        int idle = Math.max(0,empty-pendingtasks);
        
        return tasks.length + idle;
    }
}