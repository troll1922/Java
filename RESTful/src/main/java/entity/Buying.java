package entity;

import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "product_id")
	private int productId;
	
	public Buying() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser() {
		return userId;
	}

	public void setUser(int userId) {
		this.userId = userId;
	}

	public int getProduct() {
		return productId;
	}

	public void setProduct(int productId) {
		this.productId = productId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
