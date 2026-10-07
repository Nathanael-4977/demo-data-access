package org.sebsy.compta.dao;

import org.sebsy.compta.domain.Fournisseur;
import java.util.List;
import java.util.Optional;

/**
 * Contrat de persistance des fournisseurs — À COMPLÉTER.
 *
 * CONTRAINTE NOTÉE : cette interface ne doit contenir
 *   · aucun type du paquet java.sql
 *   · aucune clause throws SQLException
 *   · aucune chaîne SQL
 *
 * C'est ce qui permettra, au TP 07, de la réimplémenter en JPA sans toucher
 * une seule ligne du code appelant. Si vous devez modifier cette interface au
 * TP 07, c'est ici qu'était l'erreur.
 */
public interface FournisseurDao {

    // TODO: recherche par identifiant. « Absent » est un cas NORMAL — quel type de retour ?
    Optional<Fournisseur> parId(long id);

    // TODO: recherche par nom (colonne UNIQUE).
    Optional<Fournisseur> parNom(String nom);

    // TODO: tous les fournisseurs d'une ville, triés par nom.
    List<Fournisseur> parVille(String ville);

    // TODO: tous les fournisseurs, triés par identifiant.
    List<Fournisseur> toutes();

    // TODO: insertion. Que doit-on renvoyer pour que l'appelant connaisse l'id généré ?
    Fournisseur creer(Fournisseur fournisseur);

    // TODO: renommage. Que renvoyer si aucun fournisseur ne porte cet identifiant ?
    //       Indice : ce n'est pas une exception.
    boolean renommer(long id, String nouveauNom);

    // TODO: suppression. Attention : fk_article_fournisseur est ON DELETE RESTRICT.
    boolean supprimer(long id);
}
