package ro.webeet.giveaway.persistence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class CaseDetail extends DBModel {

	private static final long serialVersionUID = -7713279457827769380L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	@JoinColumn(name = "HELP_CASE_ID", nullable = false)
	private HelpCase helpCase;
	private Double currentValue;
	private Double targetValue;

	@ManyToMany(mappedBy = "caseDetails")
	private List<PaymentOption> paymentOptions;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Double getTargetValue() {
		return targetValue;
	}
	public void setTargetValue(Double targetValue) {
		this.targetValue = targetValue;
	}

	public List<PaymentOption> getPaymentOptions() {
		return paymentOptions;
	}

	public void setPaymentOptions(List<PaymentOption> paymentOptions) {
		this.paymentOptions = paymentOptions;
	}
	public HelpCase getHelpCase() {
		return helpCase;
	}

	public void setHelpCase(HelpCase helpCase) {
		this.helpCase = helpCase;
	}

	public Double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}
}
