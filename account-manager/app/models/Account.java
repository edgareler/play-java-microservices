package models;

public class Account {
	private Long id;
	private String name;
	private Long customerId;
	private Float balance;
	
	
	public Account(Long id, String name, Long customerId, Float balance) {
		super();
		this.id = id;
		this.name = name;
		this.customerId = customerId;
		this.balance = balance;
	}
	
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
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	
	
}
