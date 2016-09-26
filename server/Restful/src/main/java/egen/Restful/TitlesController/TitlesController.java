package egen.Restful.TitlesController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import egen.Restful.TitlesEntity.Titles;
import egen.Restful.TitlesService.TitlesService;
@RestController
@RequestMapping(value = "titles" , produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TitlesController {

	
	
	
	
@Autowired
private TitlesService service2;

	@RequestMapping(method= RequestMethod.GET)
public List<Titles> findAllTitles(){
	return service2.findAllTitles();
 }

	@RequestMapping(method= RequestMethod.GET , value = "{titlename}")
public Titles findOneTitle(@PathVariable("titlename") String titlename){   
	return service2.findOneTitle(titlename);
}
@RequestMapping(method =RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
public Titles create(@RequestBody Titles title) { 
	return service2.create(title);
}

@RequestMapping(method=RequestMethod.PUT, value ="{titlename}" , consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
public Titles update(@PathVariable("titlename") String titlename, @RequestBody  Titles title){
	return service2.update(titlename, title);
}

@RequestMapping(method=RequestMethod.DELETE , value = "{titlename}" )
public @ResponseBody void delete(@PathVariable("titlename") String titlename){
	service2.delete(titlename);
}





}
