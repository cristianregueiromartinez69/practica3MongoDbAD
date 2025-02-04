package service.crud.postgres;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Clase con las operaciones crud sobre la base de datos de PostgresSQL
 * @author cristian
 * @version 1.0
 */
public class CrudDbPostgres {

    /**
     * Metodo genérico para la inserccion de datos en ,mongo
     * @param list una lista que puede ser de cualquier objeto
     * @param <T> un objeto
     */
    public <T> void insertDataDB(List<T> list) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {


            Transaction tx = session.beginTransaction();
            /*
              Recorremos con un for la lista de objetos que nos lleguen
             */
            for (T object : list) {
                session.save(object);
            }
            tx.commit();
            System.out.println("Datos guardados en la base de datos correctamente");
        }
    }

    /**
     * Metodo genérico para leer información sobre ua tabla de la base de datos de postgresSQL
     * @param query la query que le vamos a pasar
     * @param claseQuery la clase a la que va asociada la query
     * @return una lista con los objetos
     * @param <T> el objeto
     */
    public <T> List<T> getDataFromDB(String query, Class<T> claseQuery) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            //obtenemos en una lista la información de la base de datos
            List<T> list = session.createQuery(query, claseQuery).getResultList();

            tx.commit();

            return list;
        }
    }




}
