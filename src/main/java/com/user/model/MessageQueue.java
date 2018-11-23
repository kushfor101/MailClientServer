package com.user.model;

public class MessageQueue {

	String fromId;
	String toId;
	String subject;
	boolean received;
	
	public MessageQueue(String fromId, String toId, String subject, boolean received) {
		super();
		this.fromId = fromId;
		this.toId = toId;
		this.received = received;
		this.subject = subject;
	}

	public String getFromId() {
		return fromId;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public boolean isReceived() {
		return received;
	}

	public void setReceived(boolean received) {
		this.received = received;
	}
	
}
