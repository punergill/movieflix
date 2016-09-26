package egen.Restful.RatingsService;

import java.util.List;

import egen.Restful.RatingsEntity.Ratings;

public interface RatingsService {

	public List<Ratings> findAll();

	public List<Ratings> findOneRating(int ratings, String userId);

	public Ratings create(Ratings ratings);

	public Ratings update(int ratings, Ratings rat);

	public void delete(int ratings);

}
