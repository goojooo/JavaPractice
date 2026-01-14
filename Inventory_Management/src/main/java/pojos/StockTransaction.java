package pojos;

import java.sql.Timestamp;

public class StockTransaction {

    private int transactionId;
    private int productId;
    private int changeQty;
    private String transactionType;
    private Timestamp transactionDate;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getChangeQty() {
		return changeQty;
	}
	public void setChangeQty(int changeQty) {
		this.changeQty = changeQty;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

    // getters & setters
    
}
