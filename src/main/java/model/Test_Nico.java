package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test_Nico {
		
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private int test_int;
	
	public Test_Nico() {}
		
	public Test_Nico(int test_int) {
		super();
		this.test_int = test_int;
	}
	
	public Test_Nico(int id, int test_int) {
		this.id = id;
		this.test_int = test_int;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTest_int() {
		return test_int;
	}

	public void setTest_int(int test_int) {
		this.test_int = test_int;
	}

	@Override
	public String toString() {
		return "Test_Nico [id=" + id + ", test_int=" + test_int + "]";
	}	

}
