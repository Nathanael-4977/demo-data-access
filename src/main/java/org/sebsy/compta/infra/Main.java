package org.sebsy.compta.infra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try(Connection cnx = Db.getDataSource().getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM fournisseur")){

            System.out.println("Classe de la connexion : " + cnx.getClass().getName());
            System.out.println("Version de la DB : " + cnx.getMetaData().getDatabaseProductVersion());
            if (rs.next()) {
                System.out.println("Nombre de fournisseurs : " + rs.getInt(1));
            }
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
            //Le message d'erreur lors de la suppression de DB_PASSWORD est très clair. Il dis que DB_PASSWORD n'est pas le bon car il ne contient pas la valeur "app".
        }
    }
}
