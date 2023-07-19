package com.pault.example.functionalinterface;

import lombok.extern.java.Log;

import java.util.function.Supplier;

@Log
public class _Supplier {

    public static void main(String[] args) {

        log.info(getDBConnectorURL());
        log.info(getDBConnectorURLSupplier.get());
    }

    static String getDBConnectorURL() {
        return "jdbc://localhost:5432/users";
    }

    static Supplier<String> getDBConnectorURLSupplier = () -> "jdbc://localhost:5432/users";

}
