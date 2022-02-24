package edu;
//
public class UppercasedKeys implements Keys {
    private Keys vKeys;

    public UppercasedKeys(Keys vKeys) {
        this.vKeys = vKeys;
    }

    public String publicKey() {
        return this.vKeys.publicKey().toUpperCase();
    }

    public String secretKey() {
        return this.vKeys.secretKey().toUpperCase();
    }

}
