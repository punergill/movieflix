package egen.Restful.repository;

import java.util.List;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import egen.Restful.entity.User;

@Repository
public class UserRepositoryImp implements UserRepository{   //imp=implementation

	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class); 
      return query.getResultList();
 
    }

	@Override
	public User findOne(String userId) {
		
		return em.find(User.class , userId);
	}

	@Override
	public User findMyEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findMyEmail", User.class); 
		query.setParameter("xyz", email);
		List<User> users =  query.getResultList();
	    if(users.size()==1){   //we know it will be unique
	    	return users.get(0);
	    }
	    else{
	    	return null;
	    }
	 }

	@Override
	public User create(User use) {
	 em.persist(use);
		return use;
	}

	@Override
	public User update(User use) {
	return em.merge(use);
		
	}

	@Override
	public void delete(User use3) {
	em.remove(use3);
		
	} 

}










