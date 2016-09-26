package egen.Restful.RatingsRepository;

import java.util.List;

import egen.Restful.RatingsEntity.Ratings;

public interface RatingsRepository {

	public List<Ratings> findAll();

	

	public Ratings findRatings(int ratings);

	public Ratings update(Ratings rat);

	public void delete(Ratings rat3);

	public List<Ratings> findOneRating(int ratings, String userId);



	public Ratings create(Ratings rat);

	

}
