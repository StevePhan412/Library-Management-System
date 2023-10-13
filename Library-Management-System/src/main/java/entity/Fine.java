package entity;

import java.util.Date;
import java.util.Objects;

public class Fine {

	private int fineId;
    private int userId;
    private double totalFineAmount;
    private Date lastUpdated;
	
    public int getFineId() {
		return fineId;
	}
	public int getUserId() {
		return userId;
	}
	public double getTotalFineAmount() {
		return totalFineAmount;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setFineId(int fineId) {
		this.fineId = fineId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setTotalFineAmount(double totalFineAmount) {
		this.totalFineAmount = totalFineAmount;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
