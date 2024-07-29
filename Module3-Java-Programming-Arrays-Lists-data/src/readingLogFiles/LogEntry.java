/**
 * Class: ReadingLogFiles
 * 
 * Take the log files from a website and create an object to store the information in which 
 * can be read.
 * 
 * Developer: Keith Kretz
 * Date Created: 7/26/2024
 * Last Updated: 7/26/2024
 */
package readingLogFiles;

import java.util.Date;

public class LogEntry {
	private String ipAddress;
	private Date accessTime;
	private String request;
	private int statusCode;
	private int bytesReturned;
	
	public LogEntry(String ip,Date time,String requestSent,int statusCodeSent,int bytes) {
		
		ipAddress = ip;
		accessTime = time;
		request = requestSent;
		statusCode = statusCodeSent;
		bytesReturned = bytes;
	}
	public String getIpAddress() {
        return ipAddress;
    }
    public Date getAccessTime() {
        return accessTime;
    }   
    public String getRequest() {
        return request;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public int getBytesReturned() {
        return bytesReturned;
    }
    public String toString() {
    	return ipAddress + " " + accessTime + " " + request 
    	           + " " + statusCode + " " + bytesReturned;	
    }
	

}
