package egen.Restful.RatingsService;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egen.Restful.RatingsEntity.Ratings;
import egen.Restful.RatingsRepository.RatingsRepository;
import egen.Restful.exception.EntityAlreadyExist;
@Service
public class RatingsServiceImp implements RatingsService{

	@Autowired
	private RatingsRepository repository;
	
	@Override
	public List<Ratings> findAll() {
	
		return repository.findAll();
	}

	@Override
	public List<Ratings> findOneRating(int ratings, String userId) {
		
		List<Ratings> rat = repository.findOneRating(ratings,userId);
		if(rat==null){
			throw new EntityNotFoundException("Rating not found");
		}
		return  rat;
	}
	

	@Transactional
	@Override
	public Ratings create(Ratings rat) {
		Ratings rat1 = repository.findRatings(rat.getRatings());
		if(rat1 !=null){
			throw new EntityAlreadyExist("Ratings already exist");
		}
		return repository.create(rat);
	}

	

	@Transactional
	@Override
	public Ratings update(int ratings, Ratings rat) {
		Ratings rat2 = repository.findRatings(ratings);
		if(rat2==null){
			throw new EntityNotFoundException("Ratings not found");
		}
		return repository.update(rat);
	}

	@Override
	public void delete(int ratings) {

		Ratings rat3 = repository.findRatings(ratings);
		if(rat3 ==null){
			throw new EntityNotFoundException("Comment not found");
		}repository.delete(rat3);
		
	}

		
	}


