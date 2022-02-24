package edu;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;

import static edu.Utils.*;

public class StoredKeys extends RandomKeys {
    String PublicKey, SecretKey;

    //read
//    public StoredKeys(String path) throws IOException {
//        String json = Utils.jsonFromFile(path);
//        JsonObject jsonRoot = JsonParser.parseString(json).getAsJsonObject();
//        PublicKey = jsonRoot.get("public").getAsString();
//        SecretKey = jsonRoot.get("secret").getAsString();
//    }

    public StoredKeys(String Path, String Name, String Public, String Secret) throws IOException {
        String json = Utils.jsonFromFile(Path + Name);
        JsonObject jsonRoot = JsonParser.parseString(json).getAsJsonObject();
        PublicKey = jsonRoot.get(Public).getAsString();
        SecretKey = jsonRoot.get(Secret).getAsString();
    }

    public StoredKeys(String Path, String Name) throws IOException {
        this(Path, Name, DEFAULT_JSON_TAG_PUBLIC, DEFAULT_JSON_TAG_SECRET);
    }

    public StoredKeys(String str) throws IOException {
        this(DEFAULT_PATH, str);
    }

    // same as previous, but wrapped in a static method
    public static Keys ofPathAndFilename(String Path, String Name) throws IOException {
        return new StoredKeys(Path, Name);
    }

    public static Keys ofFilenameFromDefaultPath(String Name) throws IOException {
        return ofPathAndFilename(DEFAULT_PATH, Name);
    }

    public static Keys ofGiver() throws IOException {
        return ofFilenameFromDefaultPath(GIVER_FILENAME);
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
