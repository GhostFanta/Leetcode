class Solution {
    public int minAreaRect(int[][] points) {
        Set<Integer> dic = new HashSet<>();

        for(int i = 0 ; i < points.length ; i++){
            dic.add(points[i][0] * 40001 + points[i][1]);
        }

        int minarea = Integer.MAX_VALUE - 1;

        for(int i = 0 ; i < points.length ; i++){
            for(int j = i + 1 ; j < points.length ; j++){
                // tp1 = (ponts[i][0], points[i][1])
                // tp2 = (ponts[j][0], points[j][1])
                int[] p1 = { points[i][0], points[j][1] };
                int[] p2 = { points[j][0], points[i][1] };
                if(p1[0] * 40001 + p1[1] != p2[0] * 40001 + p2[1] && dic.contains(p1[0] * 40001 + p1[1]) && dic.contains(p2[0] * 40001 + p2[1])){
                    int[] p0 = { points[i][0], points[i][1] };
                    int area = Math.abs(p0[1] - p1[1]) * Math.abs(p0[0] - p2[0]);
                    minarea = area == 0 ? minarea : Math.min(minarea, area);
                }
            }
        }
        return minarea == Integer.MAX_VALUE - 1 ? 0 : minarea; 
    }
}
