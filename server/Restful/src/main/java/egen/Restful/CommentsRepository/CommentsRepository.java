package egen.Restful.CommentsRepository;

import java.util.List;

import egen.Restful.CommentsEntity.Comments;

public interface CommentsRepository {


	public List<Comments> findOne(String comments, String userId);


	public Comments create(Comments comm);

	public Comments findOneComment(String comments);

	public Comments update(Comments comm);

	public void delete(Comments comm3);

	public List<Comments> findAll();










	





}
