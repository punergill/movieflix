package egen.Restful.CommentsService;

import java.util.List;

import egen.Restful.CommentsEntity.Comments;

public interface CommentsService {

	public List<Comments> findAll();

	

	public Comments create(Comments comments);

	public Comments update(String comments, Comments comm);

	public void delete(String comments);



	public List<Comments> findOne(String comments, String userId);

	

	

}
