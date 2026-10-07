package org.sebsy.compta.infra;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;


public class Db {

    private Db(){
    }

    private static final HikariDataSource dataSource = createdDataSource();

    private static HikariDataSource createdDataSource(){
        // Une SEULE instance pour toute l'application. On ne recrée jamais un pool.
        HikariConfig cfg = new HikariConfig();
        cfg.setJdbcUrl(Env.required("DB_URL"));
        cfg.setUsername(Env.required("DB_USER"));
        cfg.setPassword(Env.required("DB_PASSWORD"));

        cfg.setMaximumPoolSize(10);
        cfg.setConnectionTimeout(3_000); // C'est cette ligne qui fait que le code s'arrète au bout de 3 secondes lorsque j'ai fermé le conteneur.
        cfg.setLeakDetectionThreshold(20_000);
        // AutoCloseable : le pool se ferme à l'arrêt de l'application.
        return new HikariDataSource(cfg);
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
