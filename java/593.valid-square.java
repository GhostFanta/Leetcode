class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int[][] array = new int[4][2];
        array[0] = p1;
        array[1] = p2;
        array[2] = p3;
        array[3] = p4;

        Arrays.sort(array, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1]; 
                }
                return a[0] - b[0];
            }
        });

        boolean res = true;
        int dist1 = dist(array[0], array[3]); 
        int dist2 = dist(array[1], array[2]); 

        res &= (dist1 != 0) & (dist2 != 0);
        res &= (dist(array[0], array[1]) == dist(array[0], array[2]));
        res &= (dist(array[3], array[1]) == dist(array[3], array[2]));
        res &= (dist(array[3], array[1]) == dist(array[3], array[2]));
        res &= (dist(array[0], array[3]) == dist(array[2], array[1]));

        return  res;
    }

    public int dist(int[] pointa, int[] pointb){
        return (pointa[0] - pointb[0]) * (pointa[0] - pointb[0]) + (pointa[1] - pointb[1]) * (pointa[1] - pointb[1]);
    }
}
