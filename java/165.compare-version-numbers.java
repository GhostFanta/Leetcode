class Solution {
    public int compareVersion(String version1, String version2) {

        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");

        int indexa = 0;
        int indexb = 0;

        while(indexa < a.length && indexb < b.length){
            if(Integer.parseInt(a[indexa]) == Integer.parseInt(b[indexb])){
                ++indexa;
                ++indexb;
            } else if(Integer.parseInt(a[indexa]) > Integer.parseInt(b[indexb])){
                return 1;
            } else {
                return -1;
            }
        }
        while(indexa < a.length ){
            if(Integer.parseInt(a[indexa++]) != 0){
                return 1;
            }
        }
        while(indexb < b.length){
            if(Integer.parseInt(b[indexb++]) != 0){
                return -1;
            }
        }

        return 0;
    }
   
}
