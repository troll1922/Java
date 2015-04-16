package entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "buyings")
public class Buying {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY, generator = "buy_id_seq")
	@SequenceGenerator(name = "buy_id_seq", sequenceName = "buy_id_seq", allocationSize=1)
	@Column(name = "id")
	private int id;
	
	@Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
	
	@Column(name = "count")
	private int count;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public Buying() {
	}

	public int getId() {
		return id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
