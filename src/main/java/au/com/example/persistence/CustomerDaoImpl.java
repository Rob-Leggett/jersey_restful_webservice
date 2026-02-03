package au.com.example.persistence;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.example.entity.CustomerEntity;

@Singleton
public class CustomerDaoImpl implements CustomerDao {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist-unit");
	
	public CustomerEntity retrieve(Long id) {
		EntityManager em = emf.createEntityManager();

		CustomerEntity entity = null;

		try {
			entity = em.find(CustomerEntity.class, id);
		} finally {
			em.close();
		}
		
		return entity;
	}

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            CustomerEntity entity = em.find(CustomerEntity.class, id);

            if(entity == null) {
                logger.warn("Error Deleting Customer: Customer not found");
            }
            else {
                em.remove(entity);
            }

            transaction.commit();
        } catch (Exception e) {
            logger.error("Error Deleting Customer: {}", e.getMessage());

            transaction.rollback();
        } finally {
            em.close();
        }
    }

	public void save(CustomerEntity customer) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();

            em.merge(customer);

			transaction.commit();
		} catch (Exception e) {
			logger.error("Error Saving Customer: {}", e.getMessage());

			transaction.rollback();
		} finally {
			em.close();
		}
	}
}
