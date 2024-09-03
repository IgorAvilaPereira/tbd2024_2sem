package keydb;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Main {
    public static void main(String[] args) {
        // https://github.com/redis/jedis
        JedisPool pool = new JedisPool("localhost", 6379);
        try (Jedis jedis = pool.getResource()) {
            jedis.set("clientName", "Jedis2");
          }

    }
}