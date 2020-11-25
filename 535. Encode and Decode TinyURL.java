/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/submissions/
 */
public class Codec {
    
    Map<String, String> urlToTiny = new HashMap();
    Map<String, String> tinyToUrl = new HashMap();
    
    static final String HOST = "http://tinyurl.com/";
    static final String SEED = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlToTiny.containsKey(longUrl)) {
            return HOST + urlToTiny.get(longUrl);
        }
        
        StringBuilder shortUrl;
        
        do {
            shortUrl = new StringBuilder();
            
            for (int i = 0; i < 6; i++) {
                Random random = new Random();
                int r = random.nextInt(SEED.length());
                
                shortUrl.append(SEED.charAt(r));
            }
        } while (tinyToUrl.containsKey(shortUrl.toString()));
        
        
        urlToTiny.put(longUrl, shortUrl.toString());
        tinyToUrl.put(shortUrl.toString(), longUrl);

        return HOST + shortUrl.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        shortUrl = shortUrl.replace(HOST, "");
        
        return tinyToUrl.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));