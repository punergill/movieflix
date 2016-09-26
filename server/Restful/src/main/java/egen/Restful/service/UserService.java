package egen.Restful.service;

import java.util.List;

import egen.Restful.entity.User;

public interface UserService {

	public List<User> findAll();

	public User findOne(String userId);

	public User create(User use);

	public User update(String userId, User use);

	public void remove(String userId);



}
