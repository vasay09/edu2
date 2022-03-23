import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.SingleOutcome;
import com.zaxxer.hikari.HikariDataSource;
import edu.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import lombok.extern.log4j.Log4j2;


import java.io.IOException;
import java.sql.SQLException;

//@Log4j2
public class TestsPkg {
    //private static final Logger log = Logger.getLogger(TestsPkg.class);

//    @Test
//    public void testGettingKeysFromJsonFile() throws IOException, SQLException {
//        Keys vKeys = new RandomKeys();
//        vKeys = new RandomKeys();
//        vKeys = new RandomKeys();
//        vKeys = new RandomKeys();
//        //TODO Uncomment this and make it work:
//        System.out.println("How much keys we created? -> " + RandomKeys.totalCount); // how much keys we created. Should show 4 in this example
//        //System.out.println("Random keys, public: " + vKeys.publicKey());
//        //System.out.println("Random keys, secret: " + vKeys.secretKey());
//        //vKeys = new StoredKeys("src/main/resources/GiverV2.keys.json");
//        //System.out.println("Stored keys, public: " + vKeys.publicKey());
//        //System.out.println("Stored keys, secret: " + vKeys.secretKey());
//        //TODO Uncomment this and make it work:
//        HikariDataSource dataSourceObject = new HikariDataSource();
//        dataSourceObject.setDriverClassName("oracle.jdbc.pool.OracleDataSource");
//        dataSourceObject.setJdbcUrl("jdbc:oracle:thin:@192.168.1.123:1521/bdata");
//        dataSourceObject.setUsername("bdatawork");
//        dataSourceObject.setPassword("dev123");
//        vKeys = new DatabaseKeys(dataSourceObject);
//
//        System.out.println("Stored keys, public: " + vKeys.publicKey()); // should show value from db
//        System.out.println("Stored keys, secret: " + vKeys.secretKey()); // should show value from db
//
//    }
//
//    @Test
//    public void testWorkingWithJson() throws IOException {
//        String json = Utils.jsonFromFile("src/main/resources/GiverV2.keys.json");
//        System.out.println(json);
//        JsonObject jsonRoot = JsonParser.parseString(json).getAsJsonObject();
//        //System.out.println("Json parsed keys, public: " + jsonRoot.get("public").getAsString());
//        //System.out.println("Json parsed keys, secret: " + jsonRoot.get("secret").getAsString());
//    }
//
//    @Test
//    public void testGettingKkt() throws SQLException {
//        HikariDataSource ds = new HikariDataSource();
//        ds.setDriverClassName("oracle.jdbc.pool.OracleDataSource");
//        ds.setJdbcUrl("jdbc:oracle:thin:@192.168.1.123:1521/bdata");
//        ds.setUsername("bdatawork");
//        ds.setPassword("dev123");
//
//        String state = new JdbcSession(ds)
//                .sql("SELECT state FROM RECEIPTS_AGGRS_FN_LAST WHERE fn = ?")
//                .set("9999078900002902")
//                .select(new SingleOutcome<String>(String.class));
//
//        System.out.println("FN state is: " + state); // should show value from file
//    }
//
//    @Test
//    public void testExtendingImplementationLev1() throws SQLException, IOException {
//        Keys vKeys = new RandomKeys();
//        System.out.println("Public: " + vKeys.publicKey()); // should show usual, lowercase new UUIDs
//        System.out.println("Secret: " + vKeys.secretKey()); // should show usual, lowercase new UUIDs
//
//        //TODO Level1. Extending parent implementation
//        // Uncomment this and make it work
//        // IMPORTANT!!! Code duplication is not allowed!
//        // UpperRandomKeys should reuse existing implementation of random keys creation
//        // in other words, you can't write "UUID.randomUUID().toString()" in your new class;
//        vKeys = new UpperRandomKeys();
//        System.out.println("Public: " + vKeys.publicKey()); // should show new UUIDs in uppercase
//        System.out.println("Secret: " + vKeys.secretKey()); // should show new UUIDs in uppercase
//        //System.out.println("Upper: " + vKeys.publicKey().toUpperCase()); // over interesting
//    }
//
//    @Test
//    public void testExtendingImplementationLev2() throws SQLException, IOException {
//        Keys vKeys = null;
//        String path = "src/main/resources/GiverV2.keys.json";
//        HikariDataSource dataSourceObject = new HikariDataSource();
//        dataSourceObject.setDriverClassName("oracle.jdbc.pool.OracleDataSource");
//        dataSourceObject.setJdbcUrl("jdbc:oracle:thin:@192.168.1.123:1521/bdata");
//        dataSourceObject.setUsername("bdatawork");
//        dataSourceObject.setPassword("dev123");
//
//
//        for (int i = 0; i < 3; i++) {
//            if (i == 0) {
//                vKeys = new RandomKeys();
//            } else if (i == 1) {
//                vKeys = new DatabaseKeys(dataSourceObject);
//            } else if (i == 2) {
//                vKeys = new StoredKeys(path);
//            }
//            //TODO Level2. Extending any implementation
//            // Uncomment this and make it work
//            vKeys = new UppercasedKeys(vKeys);
//            System.out.println("Public: " + vKeys.publicKey()); // should show result of any keys in uppercase
//            System.out.println("Secret: " + vKeys.secretKey()); // should show result of any keys in uppercase
//        }
//    }

    @Test
    public void testConstructors() throws IOException {
        Keys keys;
        // we add to StoredKeys constructor additional params (customizable tag names instead of jsonRoot.get("public") )
        keys = new StoredKeys("src/main/resources/","GiverV2.keys.json","public","secret");
        // then we should add second constructor that reuses previous constructor to not duplicate json and file parsing code in it
        // this constructor uses default constants from Utils for tags
        keys = new StoredKeys("src/main/resources/","GiverV2.keys.json");

        // same as previous, but wrapped in a static method
        keys = StoredKeys.ofPathAndFilename("src/main/resources/","GiverV2.keys.json");

        // static method that accepts filenames, but uses default path, specified in Utils constant
        keys = StoredKeys.ofFilenameFromDefaultPath("GiverV2.keys.json");

        // static method that uses Utils constant for known Giver keys file
        keys = StoredKeys.ofGiver();
        System.out.println("30 " + keys.publicKey());
        //log.info(keys.publicKey());
        //log.warn(keys.publicKey());
        //log.error(keys.publicKey());
        //log.assertLog(true,"123");
        //log.debug(keys.publicKey());
        // all constructors and static method should have minimum code duplication
        //New info2223
    }

    @Test
    @DisplayName("Learning Gson()")
    public void testGsonBuilder() {
        Gson gson = new Gson();
        Entity entity = new Entity(100, "name");
        entity.random = 1234;
        //System.out.println("123");

        String json = gson.toJson(entity); // {"id":100,"name":"name"}
        Entity read = gson.fromJson(json, Entity.class);
        System.out.println(read.);   // 0
    }

}
