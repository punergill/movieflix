package egen.Restful.CommentsService;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egen.Restful.CommentsEntity.Comments;
import egen.Restful.CommentsRepository.CommentsRepository;
import egen.Restful.exception.EntityAlreadyExist;

@Service
public class CommentsServiceImp implements CommentsService{

	@Autowired
	private CommentsRepository repository;
	
	@Override
	public List<Comments> findAll() {
		
		return repository.findAll();
	}

	@Override
	public List<Comments> findOne(String comments, String userId ) {
		List<Comments> comm = repository.findOne(comments,userId);
		if(comm==null){
			throw new EntityNotFoundException("Comment not found");
		}
		return  comm;
	}

	@Transactional
	@Override
	public Comments create(Comments comm) {
		Comments comm1 = repository.findOneComment(comm.getComments());
		if(comm1 !=null){
			throw new EntityAlreadyExist("Comment already exist");
		}
		return repository.create(comm);
	}

	@Transactional
	@Override
	public Comments update(String comments, Comments comm) {
 
		Comments comm2 = repository.findOneComment(comments);
		if(comm2==null){
			throw new EntityNotFoundException("Comment not found");
		}
		return repository.update(comm);
	}

	@Transactional
	@Override
	public void delete(String comments) {
	
		Comments comm3 = repository.findOneComment(comments);
		if(comm3 ==null){
			throw new EntityNotFoundException("Comment not found");
		}repository.delete(comm3);
		
	}

	
	

}
