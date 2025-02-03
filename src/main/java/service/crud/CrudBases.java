package service.crud;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CrudBases {

    public void insertar10PokemonsInPokedex(List<Object> objectList){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            for (Object object : objectList) {
                session.save(object);
            }
            transaction.commit();
            System.out.println("Datos insertados correctamente en la base de datos");
        }
    }
}
