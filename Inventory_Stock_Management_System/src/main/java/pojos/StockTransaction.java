package pojos;

import java.sql.Timestamp;

public class StockTransaction {

	private int txnId;
	private int productId;
	private int changeQty;
	private String txnType;
	private Timestamp txnDate;

	// Default constructor
	public StockTransaction() {
	}

	// Constructor for insert
	public StockTransaction(int productId, int changeQty, String txnType) {
		this.productId = productId;
		this.changeQty = changeQty;
		this.txnType = txnType;
	}

	// Full constructor
	public StockTransaction(int txnId, int productId, int changeQty, String txnType, Timestamp txnDate) {
		this.txnId = txnId;
		this.productId = productId;
		this.changeQty = changeQty;
		this.txnType = txnType;
		this.txnDate = txnDate;
	}

	// Getters and Setters
	public int getTxnId() {
		return txnId;
	}

	public void setTxnId(int txnId) {
		this.txnId = txnId;
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

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Timestamp getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Timestamp txnDate) {
		this.txnDate = txnDate;
	}
}
