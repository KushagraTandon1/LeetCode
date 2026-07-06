class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] != b[0] ? Integer.compare(a[0],b[0]) : 
        Integer.compare(b[1],a[1]));
        int counter = 1, start = intervals[0][0], end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int a = intervals[i][0];
            int b = intervals[i][1];
            if(a >= start && b <= end) continue;
            start = a;
            end = b;
            counter++;
        }
        return counter;
    }
}