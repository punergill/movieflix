package egen.Restful.TitlesRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import egen.Restful.TitlesEntity.Titles;


@Repository
public class TitlesRepositoryImp implements TitlesRepository{
@PersistenceContext
private EntityManager em;
	
	
	@Override
	public List<Titles> findAllTitles() {
		TypedQuery<Titles> query = em.createNamedQuery("Titles.findAllTitles", Titles.class); 
	      return query.getResultList();
	 
	}

	@Override
	public Titles findOneTitle(String titlename) {
		
		return em.find(Titles.class , titlename);
	}

	@Override
	public Titles findMyTitlename(String titlename) {
		TypedQuery<Titles> query = em.createNamedQuery("Titles.findMyTitlename", Titles.class); 
		query.setParameter("xyz", titlename);
		List<Titles> titles =  query.getResultList();
	    if(titles.size()==1){   //we know it will be unique
	    	return titles.get(0);
	    }
	    else{
	    	return null;
	    }
	}

	@Override
	public Titles create(Titles title) {
		 em.persist(title);
			return title;
	}

	@Override
	public Titles update(Titles title) {
		
		return em.merge(title);
	}

	@Override
	public void delete(Titles title3) {
		em.remove(title3);
		
	}

}
