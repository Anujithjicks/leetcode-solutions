class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> interval = new ArrayList<>(Arrays.asList(intervals));
        interval.add(newInterval);
        Collections.sort(interval,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList<>();
        int[] current = interval.get(0);
        for(int i=1;i<interval.size(); i++){
            int[] inter = interval.get(i);
            if(current[1]>= inter[0]){
                current[1] = Math.max(current[1],inter[1]);
            }
            else{
                res.add(current);
                current = inter;
            }
        }
        res.add(current);
        return res.toArray(new int[res.size()] []);
    }
}