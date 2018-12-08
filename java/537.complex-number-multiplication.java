class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] am = a.split("\\+");
        String[] bm = b.split("\\+");

        int at = Integer.parseInt(am[0]);
        int bt = Integer.parseInt(bm[0]);

        int ac = Integer.parseInt(am[1].split("i")[0]);
        int bc = Integer.parseInt(bm[1].split("i")[0]);

        int rest = at * bt - ac * bc;
        int comp = at * bc + bt * ac;

        return String.valueOf(rest) + "+" +  String.valueOf(comp) + "i";
    }
}
