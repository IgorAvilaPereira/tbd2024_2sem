package apresentacao;

import java.time.LocalDate;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import negocio.LocalDateTypeAdapter;
import negocio.Pessoa;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Main {
    public static void main(String[] args) {

      Gson gson = new GsonBuilder()
.registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
    .create();

        JedisPool pool = new JedisPool("localhost", 6379);
        try (Jedis jedis = pool.getResource()) {
            jedis.select(0);

            // jedis.flushDB();

            // Pessoa igorHavan = new Pessoa();
            // igorHavan.setNome("igor havan");
            // igorHavan.setDataNascimento(LocalDate.of(1987, 01, 20));
            // jedis.set(igorHavan.getId().toString(), gson.toJson(igorHavan));
            // System.out.println(jedis.getDB());
            // jedis.set("clientName", "Jedis");
            // System.out.println(jedis.get("luis"));
            // jedis.expire("luis", 10);
            // jedis.setex("igor", 5, "igor pereira");

            Iterator<String> todos = jedis.keys("*").iterator();
            while(todos.hasNext()){
                String uuid = todos.next();
                Pessoa p = gson.fromJson(jedis.get(uuid), Pessoa.class);
                System.out.println(p);
            }
        }
    }
}