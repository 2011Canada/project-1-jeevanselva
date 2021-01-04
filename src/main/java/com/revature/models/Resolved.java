package com.revature.models;

public class Resolved {
	int reimbursementId;
	String status;
	int resolverId;

	public Resolved() {
		super();

	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	@Override
	public String toString() {
		return "Resolved [reimbursementId=" + reimbursementId + ", status=" + status + ", resolverId=" + resolverId
				+ "]";
	}

}
