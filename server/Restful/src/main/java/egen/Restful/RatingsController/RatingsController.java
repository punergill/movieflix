package egen.Restful.RatingsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import egen.Restful.RatingsEntity.Ratings;
import egen.Restful.RatingsService.RatingsService;

@RestController
@RequestMapping(value="ratings" , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RatingsController {

	@Autowired
	private RatingsService service4;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Ratings> findAll(){
		return service4.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET , value="{titlename}")   //titlename gives user and comments
	public List<Ratings> findOneRating(@PathVariable("titlename") int ratings, String userId){
		return service4.findOneRating(ratings, userId);
	}
	
	@RequestMapping(method=RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Ratings create(@RequestBody Ratings ratings){
		return service4.create(ratings);
	}
	@RequestMapping(method=RequestMethod.PUT , value="{ratings}" , consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Ratings update(@PathVariable("comments") int ratings, @RequestBody Ratings rat){
		return service4.update(ratings ,  rat);
	}
	@RequestMapping(method=RequestMethod.DELETE , value="{ratings}")
	public   @ResponseBody void delete(@PathVariable("ratings") int ratings){
		service4.delete(ratings);
	}
	
	
}
