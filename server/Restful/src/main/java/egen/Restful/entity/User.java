package egen.Restful.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//class example for a sql table
@Entity
@Table  //map each row of table to each of these objects
@NamedQueries({   //can use queries here instead of on entity manager class
		     @NamedQuery(name = "User.findAll", query = "SELECT e FROM User e ORDER BY e.email"),
             @NamedQuery(name = "User.findMyEmail", query = "SELECT e FROM User e WHERE e.email=:xyz")})
public class User {

	
	

@Id//primary key
@Column(unique=true)
private String userid;

private String password;
private String firstname;
private String lastname;

@Column(unique=true)   //column to define columns in db
private String email;

public User(){
	userid = UUID.randomUUID().toString();  //uuid for unique values only 
}
public String getPassword(){
	return password;
}

public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getId() {
	return userid;
}
public void setId(String id) {
	this.userid = id;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "User [userid=" + userid + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname
			+ ", email=" + email + "]";
}
}

