package ro.webeet.giveaway.persistence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;

import ro.webeet.giveaway.persistence.model.property.PaymentItem;
import ro.webeet.giveaway.persistence.model.property.UnitMeasureType;

@Entity
public class PaymentOption extends DBModel {

	private static final long serialVersionUID = -7974115256190401740L;

	@Id
	@GeneratedValue
	private Long id;
	private Integer numberOfItems;

	@Enumerated(EnumType.STRING)
	private UnitMeasureType unitMeasureType;

	@ManyToMany
	@JoinTable(name = "PAYMENT_CASE", joinColumns = {
			@JoinColumn(name = "PAYMENT_OPTION_ID", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "CASE_DETAIL_ID", nullable = false) })
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<CaseDetail> caseDetails;

	@Enumerated(EnumType.STRING)
	private PaymentItem paymentItem;
	private String accountNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentItem getPaymentItem() {
		return paymentItem;
	}

	public void setPaymentItem(PaymentItem paymentItem) {
		this.paymentItem = paymentItem;
	}

	public List<CaseDetail> getCaseDetails() {
		return caseDetails;
	}

	public void setCaseDetails(List<CaseDetail> caseDetails) {
		this.caseDetails = caseDetails;
	}

	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public UnitMeasureType getUnitMeasureType() {
		return unitMeasureType;
	}

	public void setUnitMeasureType(UnitMeasureType unitMeasureType) {
		this.unitMeasureType = unitMeasureType;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

}
