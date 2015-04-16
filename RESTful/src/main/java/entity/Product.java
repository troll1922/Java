package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY, generator = "product_id_seq")
	@SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize=1)
	@Column(name = "id")
	private int id;

	@Column(name = "product_name")
    private String productName;      
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "category")
    private String category;   
	
	@Column(name = "description")
    private String description;

	public Product() {
	}
	
	public Product(String productName, double price, int count, String category, String description) {
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.description = description;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
    public String toString() {
		String str;
		str = "Id_\""+this.getId()+"\" название_\""+this.getProductName()+"\" цена_\""+this.getPrice()+
		 "\" количество_\""+"\" описание_\""+this.getDescription()+"\"";
		return str;
	}
}
