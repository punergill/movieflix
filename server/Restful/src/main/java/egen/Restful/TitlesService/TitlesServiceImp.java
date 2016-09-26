package egen.Restful.TitlesService;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egen.Restful.TitlesEntity.Titles;
import egen.Restful.TitlesRepository.TitlesRepository;

import egen.Restful.exception.EntityAlreadyExist;

@Service
public class TitlesServiceImp implements TitlesService{
	
	@Autowired
	private TitlesRepository repository;

	@Override
	public List<Titles> findAllTitles() {
		
		return repository.findAllTitles();
	}

	@Override
	public Titles findOneTitle(String titlename) {
		Titles title = repository.findOneTitle(titlename);
		if(title == null){
			throw new EntityNotFoundException("Title not found");
		}return title;
	}
    @Transactional
	@Override
	public Titles create(Titles title) {
    	Titles title1 = repository.findMyTitlename(title.getTitlename());
		if(title1 != null){
			throw new EntityAlreadyExist("Title Already Exist with this email");
		}return repository.create(title);
		
	}
  @Transactional
	@Override
	public Titles update(String titlename, Titles title) {
	  Titles title2 = repository.findOneTitle(titlename);
		if(title2 == null){
			throw new EntityNotFoundException("Title not found");
		}return repository.update(title);
	}
    @Transactional
	@Override
	public void delete(String titlename) {
	
    	Titles title3 = repository.findOneTitle(titlename);
		if(title3 == null){
			throw new EntityNotFoundException("Title not found");
		}repository.delete(title3);
	}

}
