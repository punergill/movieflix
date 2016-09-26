package egen.Restful.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egen.Restful.entity.User;
import egen.Restful.exception.EntityAlreadyExist;
import egen.Restful.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {  //imp= implementation, this class handles business logic

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> findAll() {
		
		return repository.findAll();
	}

	@Override
	public User findOne(String userId) {
		User use = repository.findOne(userId);
		if(use == null){
			throw new EntityNotFoundException("User not found");
		}return use;
	}
    @Transactional
	@Override
	public User create(User use) {
		User use1 = repository.findMyEmail(use.getEmail());
		if(use1 != null){
			throw new EntityAlreadyExist("User Already Exist with this email");
		}return repository.create(use);
	}
	
    @Transactional
	@Override
	public User update(String userId, User use) {
	
		User use2 = repository.findOne(userId);
		if(use2 == null){
			throw new EntityNotFoundException("User not found");
		}return repository.update(use);
	}
	
    @Transactional
	@Override
	public void remove(String userId) {
		User use3 = repository.findOne(userId);
		if(use3 == null){
			throw new EntityNotFoundException("User not found");
		}repository.delete(use3);
	}
		
	}  


