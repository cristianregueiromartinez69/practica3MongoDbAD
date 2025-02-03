package service.crud.postgres;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CrudDbPostgres {

    public <T> void insertDataDB(List<T> list) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {


            Transaction tx = session.beginTransaction();

            for (T object : list) {
                session.save(object);
            }
            tx.commit();
            System.out.println("Datos guardados en la base de datos correctamente");
        }
    }

    public <T> List<T> getDataFromDB(String query, Class<T> claseQuery) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            List<T> list = session.createQuery(query, claseQuery).getResultList();

            tx.commit();

            return list;
        }
    }




}
