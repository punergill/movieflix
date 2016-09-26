package egen.Restful.CommentsRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import egen.Restful.CommentsEntity.Comments;


@Repository
public class CommentsRepositoryImp implements CommentsRepository{
@PersistenceContext
private EntityManager em;

     @Override
    public List<Comments> findAll() {
	TypedQuery<Comments> query = em.createNamedQuery("Comments.findAll", Comments.class); 
	return query.getResultList();

}


	@SuppressWarnings("unchecked")
	@Override
	public List<Comments> findOne(String comments, String userId) {
		Query query =em.createNativeQuery("SELECT comments , userId FROM Comments",Comments.class);
	return query.getResultList();
	}

	@Override
	public Comments create(Comments comm) {
		em.persist(comm);
		return comm;
	}

	@Override
	public Comments findOneComment(String comments) {
	
		TypedQuery<Comments> query = em.createNamedQuery("Comments.findOneComment", Comments.class); 
		query.setParameter("xyz", comments);
		List<Comments> comm =  query.getResultList();
	    if(comm.size()==1){   //we know it will be unique
	    	return comm.get(0);
	    }
	    else{
	    	return null;
	    }
	}

	@Override
	public Comments update(Comments comm) {
		
		return em.merge(comm);
	}

	@Override
	public void delete(Comments comm3) {
		em.remove(comm3);
		
	}


	}




