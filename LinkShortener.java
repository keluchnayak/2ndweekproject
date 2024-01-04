import java.util.HashMap;
import java.util.Random;
public class LinkShortener {
        private HashMap<String, String> urlMap;
        private Random random;

        public LinkShortener() {
            urlMap = new HashMap<>();
            random = new Random();
        }

        public String shortenURL(String longURL) {
            String shortURL = generateShortURL();
            while (urlMap.containsKey(shortURL)) {
                shortURL = generateShortURL();
            }
            urlMap.put(shortURL, longURL);
            return shortURL;
        }

        public String expandURL(String shortURL) {
            if (urlMap.containsKey(shortURL)) {
                return urlMap.get(shortURL);
            } else {
                return "Invalid short URL";
            }
        }

        private String generateShortURL() {
            StringBuilder sb = new StringBuilder();
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            int length = 6;

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                sb.append(characters.charAt(index));
            }

            return sb.toString();
        }

        public static void main(String[] args) {
            LinkShortener linkShortener = new LinkShortener();

            // Example usage
            String longURL = "https://www.example.com";
            String shortURL = linkShortener.shortenURL(longURL);
            System.out.println("Shortened URL: " + shortURL);

            String expandedURL = linkShortener.expandURL(shortURL);
            System.out.println("Expanded URL: " + expandedURL);
        }
    }
