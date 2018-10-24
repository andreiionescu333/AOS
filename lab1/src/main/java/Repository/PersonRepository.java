package Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Person;

public class PersonRepository {
	
	
	
	public void insert(Person p) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public boolean emailAvailable(String email) {
		boolean available;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<Person> query = em.createQuery(
		        "SELECT p FROM Person p WHERE p.email = :email", Person.class);
		     if(query.setParameter("email", email).getResultList().isEmpty())
		    	 available=true;
		     else
		    	 available=false;
		    em.getTransaction().commit();
			em.close();
			emf.close();
			return available;
	}
	
}
