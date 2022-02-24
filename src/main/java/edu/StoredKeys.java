package edu;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//import com.jogamp.common.net.Uri;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.PublicKey;

public class StoredKeys extends RandomKeys {
    String PublicKey, SecretKey;

    //read
    public StoredKeys(String path) throws IOException {
        String json = Utils.jsonFromFile(path);
        JsonObject jsonRoot = JsonParser.parseString(json).getAsJsonObject();
        PublicKey = jsonRoot.get("public").getAsString();
        SecretKey = jsonRoot.get("secret").getAsString();

    }
    @Override
    public String publicKey() {
        return PublicKey;
    }
    @Override
    public String secretKey() {
        return SecretKey;
    }

    //write
//    public StoredKeys(String path1, String path2) throws IOException {
//        Public = new RandomKeys().publicKey();
//        Secret = new RandomKeys().secretKey();
//        JsonObject object = new JsonObject();
//        object.addProperty("public", Public);
//        object.addProperty("secret", Secret);
//
//        FileWriter file = new FileWriter(path1);
//        try {
//            file.write(object.toString());
//            System.out.println("Success write " + object);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            file.flush();
//            file.close();
//        }
//        PublicKey = jsonRoot.get("public").getAsString());
//        System.out.println("Json parsed keys, secret: " + jsonRoot.get("secret").getAsString());
//    }
}
