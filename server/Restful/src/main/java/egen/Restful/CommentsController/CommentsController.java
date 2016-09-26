package egen.Restful.CommentsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import egen.Restful.CommentsEntity.Comments;
import egen.Restful.CommentsService.CommentsService;

@RestController
@RequestMapping(value="comments" , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentsController {

	@Autowired
	private CommentsService service3;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Comments> findAll(){
		return service3.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET , value="{titlename}")   //titlename gives user and comments
	public List<Comments> findOne(@PathVariable("titlename") String comments, String userId){
		return service3.findOne(comments, userId);
	}
	
	@RequestMapping(method=RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comments create(@RequestBody Comments comments){
		return service3.create(comments);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT , value="{comments}" , consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comments update(@PathVariable("comments") String comments, @RequestBody Comments comm){
		return service3.update(comments ,  comm);
	}
	
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="{comments}")
	public @ResponseBody void delete(@PathVariable("comments") String comments){
		service3.delete(comments);
	}
	
}
