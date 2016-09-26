package egen.Restful.RatingsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import egen.Restful.TitlesEntity.Titles;
import egen.Restful.entity.User;

@Entity
@Table
@NamedQueries({ 
	    @NamedQuery(name = "Ratings.findAll", query = "SELECT c FROM Ratings c ORDER BY c.userId"),
	    @NamedQuery(name="Ratings.findOneRating", query ="SELECT c FROM Ratings c WHERE c.ratings=:abc")})
public class Ratings {

	@Id
	@JoinColumn(unique=true)
	private User userId;
	
	private int ratings;
	private Titles titlename;
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public Titles getTitlename() {
		return titlename;
	}
	public void setTitlename(Titles titlename) {
		this.titlename = titlename;
	}
	@Override
	public String toString() {
		return "Ratings [userId=" + userId + ", ratings=" + ratings + ", titlename=" + titlename + "]";
	}
	
	
	
}
