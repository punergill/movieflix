package egen.Restful.TitlesService;

import java.util.List;

import egen.Restful.TitlesEntity.Titles;


public interface TitlesService {

	public List<Titles> findAllTitles();
	public Titles findOneTitle(String titlename);

	public Titles create(Titles title);

	public Titles update(String titlename, Titles title);

	public void delete(String titlename);

	
}
