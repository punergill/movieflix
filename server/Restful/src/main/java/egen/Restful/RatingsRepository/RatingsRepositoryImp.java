package egen.Restful.RatingsRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import egen.Restful.RatingsEntity.Ratings;

@Repository
public class RatingsRepositoryImp implements RatingsRepository{
@PersistenceContext
private EntityManager em;


	@Override
	public List<Ratings> findAll() {
		TypedQuery<Ratings> query = em.createNamedQuery("Ratings.findAll", Ratings.class); 
		return query.getResultList();

	}

	@Override
	public Ratings findRatings(int ratings) {
		TypedQuery<Ratings> query = em.createNamedQuery("Ratings.findRatings", Ratings.class); 
		query.setParameter("abc", ratings);
		List<Ratings> rat =  query.getResultList();
	    if(rat.size()==1){   //we know it will be unique
	    	return rat.get(0);
	    }
	    else{
	    	return null;
	    }
	}

	@Override
	public Ratings update(Ratings rat) {
		
		return em.merge(rat);
		}


	@Override
	public void delete(Ratings rat3) {
    em.remove(rat3);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ratings> findOneRating(int ratings, String userId) {

			Query query =em.createNativeQuery("SELECT ratings , userId FROM Ratings",Ratings.class);
		return query.getResultList();
		}

	@Override
	public Ratings create(Ratings rat) {

		em.persist(rat);
		return rat;
	}
}
