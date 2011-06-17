package server;

public class ReceiveResult {
	private Boolean receiveStatus;
	private int bytesRead;
	
	public ReceiveResult(Boolean receiveStatus, int bytesRead){
		this.receiveStatus = receiveStatus;
		this.bytesRead = bytesRead;
	}
	
	public Boolean getReceiveStatus(){
		return receiveStatus;
	}
	
	public int getBytesRead(){
		return bytesRead;
	}
}
