import java.util.LinkedHashMap;
import java.util.Random;

public class LRUC {

    public static int cacheSize = 10;

    public static void performCaching(LinkedHashMap<String, Integer> cache, String k, int v)
    {
        // if key is present, then remove it and add it with new value (essentially updating its RU)
        if (cache.get(k) != null)
        {
            cache.remove(k);
            cache.put(k, v);
        }
        // if cache is full, then delete LRU (in this case, the first element in the LinkedHashMap) and insert
        else if (cache.size() == cacheSize)
        {
            cache.remove(cache.keySet().iterator().next());
            cache.put(k, v);
        }
        // if key is not already present and cache is not full, then insert
        else
        {
            cache.put(k, v);
        }
    }

    public static void main(String[] args)
    {
        // Create cache with max size
        LinkedHashMap<String, Integer> LRUCache = new LinkedHashMap<String, Integer>(cacheSize);
        Random rand = new Random();

        for (int i = 0; i < 15; i++)
        {
            // create key and value to be inserted into cache
            String cacheKey = "Info" + rand.nextInt(20);
            int cacheVal = rand.nextInt(20);
            // Simulate LRUC
            performCaching(LRUCache, cacheKey, cacheVal);
        }

        // Display results
        System.out.println(LRUCache.keySet());
    }
}
