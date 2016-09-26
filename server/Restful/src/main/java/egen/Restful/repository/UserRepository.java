package egen.Restful.repository;

import java.util.List;

import egen.Restful.entity.User;

public interface UserRepository {  //to handle database , tot talk to database

	public List<User> findAll();

	public User findOne(String userId);

	public User findMyEmail(String email);

	public User create(User use);

	public User update(User use);

	public void delete(User use3);

}
