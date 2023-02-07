package jpa.entitymodels;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

@Entity
@Table

//Using @NamedQuery for single  HQL
@NamedQueries({ @NamedQuery(name = "getAllStudents", query = "from Student s"),
		@NamedQuery(name = "get_Student_by_email", query = "from Student s where s.sEMail=:email"),
//@NamedQuery(name="validate_student", query="select s.sPass from Student s where s.sEMail=:email")

})
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "email", length = 50)
	private String sEMail;
	@Column(name = "name", length = 50, nullable = false)
	private String sName;
	@Column(name = "password", length = 50, nullable = false)
	private String sPass;
	@ManyToMany(targetEntity = Course.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "sName") }, inverseJoinColumns = {
			@JoinColumn(name = "cID") })

	private List<Course> sCourses;

	public Student() {
		// sCourses=new ArrayList<Integer>();
	}

	public Student(String sEMail, String sName, String sPass, List<Course> sCourses) {
		this();
		this.sEMail = sEMail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}

	public String getsEMail() {
		return sEMail;
	}

	public void setsEMail(String sEMail) {
		this.sEMail = sEMail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sCourses == null) ? 0 : sCourses.hashCode());
		result = prime * result + ((sEMail == null) ? 0 : sEMail.hashCode());
		result = prime * result + ((sName == null) ? 0 : sName.hashCode());
		result = prime * result + ((sPass == null) ? 0 : sPass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (sCourses == null) {
			if (other.sCourses != null)
				return false;
		} else if (!sCourses.equals(other.sCourses))
			return false;
		if (sEMail == null) {
			if (other.sEMail != null)
				return false;
		} else if (!sEMail.equals(other.sEMail))
			return false;
		if (sName == null) {
			if (other.sName != null)
				return false;
		} else if (!sName.equals(other.sName))
			return false;
		if (sPass == null) {
			if (other.sPass != null)
				return false;
		} else if (!sPass.equals(other.sPass))
			return false;
		return true;
	}

}
