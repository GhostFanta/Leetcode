class Solution {
    public String getHint(String secret, String guess) {
        int[] secreta = new int[10];
        int[] guessa = new int[10];

        int A = 0;
        int B = 0;

        for(int i = 0 ; i < secret.length() ; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                A++;
                continue;
            }
            secreta[Integer.parseInt(Character.toString(secret.charAt(i)))]++;
            guessa[Integer.parseInt(Character.toString(guess.charAt(i)))]++;
        }

        for(int i = 0 ; i < secreta.length ; i++){
            B += Math.min(secreta[i], guessa[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(A);
        sb.append("A");
        sb.append(B);
        sb.append("B");

        return sb.toString();
    }
}
