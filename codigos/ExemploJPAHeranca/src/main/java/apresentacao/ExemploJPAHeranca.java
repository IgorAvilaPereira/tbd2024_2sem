/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package apresentacao;

import com.google.gson.Gson;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.PessoaFisica;
import negocio.PessoaJuridica;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

//import json;

/**
 *
 * @author iapereira
 */
public class ExemploJPAHeranca {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Meu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PessoaFisica igor = new PessoaFisica();
        igor.setNome("igor");
        igor.setCpf("1111111");
        em.persist(igor);
        em.getTransaction().commit();

        em.getTransaction().begin();
        PessoaJuridica ifood = new PessoaJuridica();
        ifood.setNome("ifood");
        ifood.setCnpj("iouoiuoiuouo");
        em.persist(ifood);
        em.getTransaction().commit();

        JedisPool pool = new JedisPool("localhost", 6379);
        try (Jedis jedis = pool.getResource()) {
            
            jedis.setex("clientName", 20, new Gson().toJson(igor));
        }

    }
}
