package hibernettapp;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "hibernate")//it creates table in database otherwise it takes class name as table name
public class empcrud {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//to generate the value automatically
	private int id;
	private String name;
	private String email;
	private String branch;
	private long phonenum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public long getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(long phonenum) {
		this.phonenum = phonenum;
	}
	public empcrud(int id, String name, String email, String branch, long phonenum) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.branch = branch;
		this.phonenum = phonenum;
	}
	public empcrud() {
		super();
		
	}



}
