package edu;

import java.io.IOException;
import java.util.UUID;

// Implementation of Keys type.
// This implementation returns random values
public class RandomKeys implements Keys {
    public static int totalCount = 0;

    // Constructor doesn't have input parameters
    public RandomKeys() {
        totalCount++;
    } //

    @Override
    public String publicKey() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String secretKey() {
        return UUID.randomUUID().toString();
    }

    //private void countCall() {
    //    totalCount++;
    //}

}
