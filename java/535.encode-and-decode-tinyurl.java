public class Codec {

    private HashMap<String, String> store;
    private String head;

    public Codec(){
        this.store = new HashMap<>();
        this.head = "http://tinyurl.com/";
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hashval = String.valueOf(longUrl.hashCode());
        this.store.put(hashval, longUrl);
        return this.head + hashval;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String res = this.store.get(shortUrl.substring(this.head.length()));
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
