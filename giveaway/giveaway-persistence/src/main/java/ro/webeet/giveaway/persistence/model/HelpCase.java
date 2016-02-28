package ro.webeet.giveaway.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class HelpCase extends DBModel{

	private static final long serialVersionUID = 6961054171482597379L;

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Lob
	private String content;

	@ManyToOne
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	@OneToOne(mappedBy = "helpCase")
	private CaseDetail caseDetail;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public CaseDetail getCaseDetail() {
		return caseDetail;
	}

	public void setCaseDetail(CaseDetail caseDetail) {
		this.caseDetail = caseDetail;
	}

}
