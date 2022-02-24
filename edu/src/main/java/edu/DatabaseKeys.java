package edu;

import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.SingleOutcome;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;

public class DatabaseKeys implements Keys {
    private String PublicKey, SecretKey;

    public DatabaseKeys(HikariDataSource dataSourceObject) throws SQLException {
        PublicKey = new JdbcSession(dataSourceObject)
                .sql("SELECT state FROM RECEIPTS_AGGRS_FN_LAST WHERE fn = ?")
                .set("9999078900002902")
                .select(new SingleOutcome<String>(String.class));
        SecretKey = new JdbcSession(dataSourceObject)
                .sql("SELECT inn FROM RECEIPTS_AGGRS_FN_LAST WHERE fn = ?")
                .set("9999078900002902")
                .select(new SingleOutcome<String>(String.class));

        //System.out.println("FN state is: " + state); // should show value from file
    }

    public DatabaseKeys(String Driver, String Url, String UserName, String Password) throws SQLException {

    }

    public String publicKey() {
        return PublicKey;
    }

    public String secretKey() {
        return SecretKey;
    }

}
