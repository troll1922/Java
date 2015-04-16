package entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User { 

	@Id
	@GeneratedValue  (strategy = GenerationType.IDENTITY, generator = "user_id_seq")
	@SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize=1)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_name")
    private String name;
	
	@Column(name = "money")
	private double money;
	
    @Column(name = "email")
    private String email;
    
    @OneToMany(mappedBy = "user")
    private Set<Buying> buy;
	
	public User () {
	}
	
	public User (String name, double money, String email) {
		this.name = name;
		this.money = money;
		this.email = email;
	}

	public Set<Buying> getBuy() {
		return buy;
	}
	
	public void setBuy(Set<Buying> buy) {
		this.buy = buy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
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
}
