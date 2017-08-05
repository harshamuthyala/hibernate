package com.training.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinTable;
import javax.persistence.OrderColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@IdClass(value = UserId.class)

@Entity
@Table(name = "USR")
@SequenceGenerator(name="userIdGenerator", sequenceName="USR_ID_SEQ", initialValue=1000, allocationSize=1)
//@SecondaryTable(name="USER_DTLS", pkJoinColumns= {@PrimaryKeyJoinColumn(name="EMP_ID")})
//@TableGenerator(name="userIdGenerator", table="SEQ_GEN", pkColumnName="SEQ_KEY", pkColumnValue="USR_KEY", valueColumnName="SEQ_VAL", initialValue=2000, allocationSize=1)
public class User {

	@OrderColumn(name="ORDR")
	@ElementCollection
	private List<String> email = new ArrayList<>();
	
/*	@Column(table="USER_DTLS")
	private String email;*/

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="userIdGenerator")
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private String lastName;
	private String firstName;

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

/*	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
*/
}
