package Product.Model;

public class ProductModel {

	public String product;
	public String category;
	public int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getWeiht() {
		return weiht;
	}

	public void setWeiht(int weiht) {
		this.weiht = weiht;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int weiht;
	public int price;
}
