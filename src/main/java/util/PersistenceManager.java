package util;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    public static final boolean DEBUG = true;

    private static final PersistenceManager singleton = new PersistenceManager();

    protected EntityManagerFactory emf;

    public static PersistenceManager getInstance() {
        return singleton;
    }

    private PersistenceManager() {
    }

    public EntityManagerFactory getEntityManagerFactory() {

        if (emf == null) {
            createEntityManagerFactory();
        }
        return emf;
    }

    public void closeEntityManagerFactory() {

        if (emf != null) {
            emf.close();
            emf = null;
            if (DEBUG) {
                System.out.println("\n n*** Persistence finished at " + new java.util.Date() + "\n");
            }
        }
    }

    protected void createEntityManagerFactory() {

        this.emf = Persistence.createEntityManagerFactory("cestaBasica", configProperty());
        if (DEBUG) {
            System.out.println("n*** Persistence started at " + new java.util.Date());
        }
    }

    public HashMap<String, Object> configProperty() {
        Map<String, Object> prop = new HashMap();

        /**
         * Dados nuvem
         */

         prop.put("javax.persistence.jdbc.user", "adminNshVfJW");       // OPENSHIFT_MYSQL_DB_USERNAME
         prop.put("javax.persistence.jdbc.password", "Barretos@123");  //  OPENSHIFT_MYSQL_DB_PASSWORD



        /**
         * Dados local
         */

        /*
        prop.put("javax.persistence.jdbc.user", "root"); 
        prop.put("javax.persistence.jdbc.password", "Barretos@123");
        */

        return (HashMap<String, Object>) prop;
    }
}
