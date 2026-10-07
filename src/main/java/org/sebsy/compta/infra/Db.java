package org.sebsy.compta;

public class Db {
    // Une SEULE instance pour toute l'application. On ne recrée jamais un pool.
    HikariConfig cfg = new HikariConfig();
    cfg.setJdbcUrl(System.getenv("DB_URL"));
    cfg.setUsername(System.getenv("DB_USER"));
    cfg.setPassword(System.getenv("DB_PASSWORD"));

    cfg.setMaximumPoolSize(10); // dimensionné, pas laissé au hasard
    cfg.setConnectionTimeout(3_000); // échouer vite plutôt que pendre
    cfg.setLeakDetectionThreshold(20_000); // dénonce les close() oubliés
    // AutoCloseable : le pool se ferme à l'arrêt de l'application.
    HikariDataSource ds = new HikariDataSource(cfg);


    
}
