package egen.Restful.CommentsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import egen.Restful.TitlesEntity.Titles;
import egen.Restful.entity.User;

@Entity
@Table
@NamedQueries({   //can use queries here instead of on entity manager class
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c ORDER BY c.userId"),
    @NamedQuery(name = "Comments.findOneComment", query = "SELECT c  FROM Comments c WHERE c.comments=:xyz")})
   
public class Comments {
     
	
	@Id
	@Column(unique=true)
	private String comments;
	private Titles titlename;
	//private String titlename;
	
	private User userId;

	

	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Titles getTitlename() {
		return titlename;
	}
	public void setTitlename(Titles titlename) {
		this.titlename = titlename;
	}
	
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "CommentsRatings [comments=" + comments + ", titlename=" + titlename + ", userId=" + userId + "]";
	}
	
	
	
}
