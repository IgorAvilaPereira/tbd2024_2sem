/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package apresentacao;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import static org.neo4j.driver.Values.parameters;

/**
 *
 * @author iapereira
 */
public class Neo4aula1 {
    
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687",
                AuthTokens.basic("neo4j", "password"));
        
        try (Session session = driver.session()) {
//            Result result = session.run("CREATE (p:Pessoa{cpf:$cpf})", parameters("cpf", "333.333.333-33"));
//            System.out.println(result.consume().counters().nodesCreated());
            Result result = session.run("MATCH (p:Pessoa) RETURN *");
            while (result.hasNext()) {
                System.out.println(result.next().get(0).get("nome"));
            }
//             result.list().forEach(r -> System.out.println(r.get(0).asNode().values()));

        } finally {
            driver.close();
        }
    }
}
