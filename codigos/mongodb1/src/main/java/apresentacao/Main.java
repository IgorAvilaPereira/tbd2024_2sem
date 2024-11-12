/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package apresentacao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author iapereira
 */
public class Main {

    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("alunos");
            long qtde = collection.countDocuments();
            System.out.println("Qtde:" + qtde);

//            delete
//            Bson filter1 = eq("nome", "renan");
//            collection.deleteOne(filter1);
            Bson query = eq("nome", "igor avila pereira");
//       Document query = new Document().append("title",  "Cool Runnings 2");
            Bson updates = Updates.combine(
                    Updates.set("nome", "joao"));
//            atualiza ou insere
//            UpdateOptions options = new UpdateOptions().upsert(true);
            try {
                UpdateResult result = collection.updateOne(query, updates);
                System.out.println("Modified document count: " + result.getModifiedCount());
                System.out.println("Upserted id: " + result.getUpsertedId()); // only contains a value when an upsert is performed
            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }

            MongoCursor mongoCursor = collection.find().iterator();

            while (mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }

//          Document document = new Document();
//          document.put("nome", "borges");
//          collection.insertOne(document);
        }

    }
}
