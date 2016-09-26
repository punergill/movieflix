package egen.Restful.TitlesRepository;

import java.util.List;

import egen.Restful.TitlesEntity.Titles;



public interface TitlesRepository {
	public List<Titles> findAllTitles();

	public Titles findOneTitle(String titlename);

	public Titles findMyTitlename(String titlename);

	public Titles create(Titles title);

	public Titles update(Titles title);

	public void delete(Titles title3);
}
