package egen.Restful.controller;
//we should have one controller per entity/table(user/address etc)
// class to create CRUD methods(REST operation)
//this class provides end points to do anything with employee(front end can call back end)
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import egen.Restful.entity.User;
import egen.Restful.service.UserService;

@RestController //return response of following/map responses to http response obj using jackson etc 
//to map END POINTS
//either use following requestmapping format or use here as - @RequestMapping(value="employees" , produces=etc..) and delete value="employee" and produces from following
@RequestMapping(value = "users" , produces= MediaType.APPLICATION_JSON_UTF8_VALUE)

public class UserController {
	
	@Autowired
	private UserService service; //take reference to interface employeeservice
	
     @RequestMapping(method= RequestMethod.GET) //to make http get request to employee,produces to convert to json
	public List<User> findAll(){
    	return service.findAll();
     }
     @RequestMapping(method= RequestMethod.GET, value="{id}" )
	public User findOne(@PathVariable("id") String userId){  //to return employee using his/her id , pathvariable to match user input id with empid
		return service.findOne(userId);
	}
     @RequestMapping(method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE) //consumes because we get the obj body when we make post request
	public User create(@RequestBody User use) { //requestbody to convert into employee obj
		return service.create(use);
	}
     @RequestMapping(method= RequestMethod.PUT, value="{id}", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String userId, @RequestBody  User use){
		return service.update(userId, use);
	}
     @RequestMapping(method= RequestMethod.DELETE , value="{id}")
	public @ResponseBody void delete(@PathVariable("id") String userId){
		service.remove(userId);
	}
	
}
