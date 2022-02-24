import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.SingleOutcome;
import com.zaxxer.hikari.HikariDataSource;
import edu.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestsPkg {
    private static final Logger log = Logger.getLogger(TestsPkg.class);
  //  @Test
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

//    @Test
//    public void testWorkingWithJson() throws IOException {
//        String json = Utils.jsonFromFile("src/main/resources/GiverV2.keys.json");
//        System.out.println(json);
//        JsonObject jsonRoot = JsonParser.parseString(json).getAsJsonObject();
//        //System.out.println("Json parsed keys, public: " + jsonRoot.get("public").getAsString());
//        //System.out.println("Json parsed keys, secret: " + jsonRoot.get("secret").getAsString());
//    }

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

    @Test
    public void testExtendingImplementationLev1() throws SQLException, IOException {
        Keys vKeys = new RandomKeys();
        System.out.println("Public: " + vKeys.publicKey()); // should show usual, lowercase new UUIDs
        System.out.println("Secret: " + vKeys.secretKey()); // should show usual, lowercase new UUIDs

        //TODO Level1. Extending parent implementation
        // Uncomment this and make it work
        // IMPORTANT!!! Code duplication is not allowed!
        // UpperRandomKeys should reuse existing implementation of random keys creation
        // in other words, you can't write "UUID.randomUUID().toString()" in your new class;
        vKeys = new UpperRandomKeys();
        System.out.println("Public: " + vKeys.publicKey()); // should show new UUIDs in uppercase
        System.out.println("Secret: " + vKeys.secretKey()); // should show new UUIDs in uppercase
        //System.out.println("Upper: " + vKeys.publicKey().toUpperCase()); // over interesting
    }

    @Test
    public void testExtendingImplementationLev2() throws SQLException, IOException {
        Keys vKeys = null;
        String path = "src/main/resources/GiverV2.keys.json";
        HikariDataSource dataSourceObject = new HikariDataSource();
        dataSourceObject.setDriverClassName("oracle.jdbc.pool.OracleDataSource");
        dataSourceObject.setJdbcUrl("jdbc:oracle:thin:@192.168.1.123:1521/bdata");
        dataSourceObject.setUsername("bdatawork");
        dataSourceObject.setPassword("dev123");


        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                vKeys = new RandomKeys();
            } else if (i == 1) {
                vKeys = new DatabaseKeys(dataSourceObject);
            } else if (i == 2) {
                vKeys = new StoredKeys(path);
            }
            //TODO Level2. Extending any implementation
            // Uncomment this and make it work
            vKeys = new UppercasedKeys(vKeys);
            log.info("Public: " + vKeys.publicKey());
            log.info("Secret: " + vKeys.secretKey());
            System.out.println("Public: " + vKeys.publicKey()); // should show result of any keys in uppercase
            System.out.println("Secret: " + vKeys.secretKey()); // should show result of any keys in uppercase
        }
    }

}