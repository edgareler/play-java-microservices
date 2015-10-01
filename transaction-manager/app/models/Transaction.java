package models;

import java.util.Date;

public class Transaction {
	private Long id;
	private Long accountId;
	private Date date;
	private Float amount;
	private String type;
	
	public Transaction(Long id, Long accountId, Date date, Float amount,
			String type) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.date = date;
		this.amount = amount;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
