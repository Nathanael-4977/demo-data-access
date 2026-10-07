package org.sebsy.compta;

public final class Env {

    private Env(){

    }


    public static String required(String name){
        String value = System.getenv(name);
        if (null == value || value.isBlank()){
            throw new IllegalStateException(
                    """
                    La variable "%s" doit être définie avant de lancer l'app!
                    """.formatted(name)
            );
        }
        return value;
    }
}

