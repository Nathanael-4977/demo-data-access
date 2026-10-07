package org.sebsy.compta.domain;

import java.util.Objects;

public record Adresse(String rue, String codePostal, String ville) {


    public Adresse {
        Objects.requireNonNull(ville, "La ville est obligatoire");
    }

    public static Adresse ville(String ville) {
        return new Adresse(null, null, ville);
    }
}