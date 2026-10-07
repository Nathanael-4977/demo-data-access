package org.sebsy.compta.dao.jdbc;

import org.sebsy.compta.dao.PersistenceFailure;
import org.sebsy.compta.infra.Db;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Frontière technique des DAO JDBC — À COMPLÉTER.
 *
 * Objectif du TP 02 : emprunter une connexion, exécuter un travail, et ENVELOPPER
 * toute SQLException dans une PersistenceFailure — de sorte qu'aucun appelant
 * n'ait jamais besoin d'importer java.sql.
 *
 * Au TP 03, cette classe gérera en plus les transactions et la participation
 * d'une DAO à une transaction déjà ouverte. Écrivez-la en pensant à cette suite.
 */
public final class Tx {

    private Tx() {
    }

    @FunctionalInterface
    public interface SqlWork<R> {
        R apply(Connection connection) throws SQLException;
    }

    /**
     * Exécute {@code work} avec une connexion empruntée au pool.
     *
     * @param description ce qu'on tentait de faire — sert au message d'erreur
     */
    static <R> R with(String description, SqlWork<R> work) {
        // TODO: emprunter une connexion au pool (Db.dataSource()), dans un try-with-resources.
        // TODO: exécuter work.apply(connexion) et renvoyer son résultat.
        // TODO: capturer SQLException et la relancer enveloppée dans PersistenceFailure,
        //       en y joignant `description` — un message d'erreur doit dire QUOI a échoué.
        throw new UnsupportedOperationException("TODO TP 02");
    }
}
