package edu;

import java.util.Locale;

public class UpperRandomKeys extends RandomKeys {

    @Override
    public String publicKey() {
        return super.publicKey().toUpperCase();
    }

    @Override
    public String secretKey() {
        return super.secretKey().toUpperCase();
    }
}
