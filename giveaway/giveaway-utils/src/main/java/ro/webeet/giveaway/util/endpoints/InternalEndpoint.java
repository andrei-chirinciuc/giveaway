/**
 * 
 */
package ro.webeet.giveaway.util.endpoints;

/**
 * @author andrei
 *
 */
public enum InternalEndpoint {
	
	PERSISTENCE("http","localhost","8080","giveaway-persistence");
	
	private String schema;
	private String hostname;
	private String port;
	private String contextRoot;

	InternalEndpoint(final String contextRoot){
		this.contextRoot = contextRoot;
	}
	
	InternalEndpoint(final String schema, final String hostname, String port, final String contextRoot){
		this.schema=schema;
		this.hostname=hostname;
		this.port=port;
		this.contextRoot=contextRoot;
	}
	
	public StringBuffer getEndpointAddress(){
		StringBuffer sb = new StringBuffer();
		sb.append(schema==null?"http":schema).append("://");
		sb.append(hostname==null?"localhost":hostname).append(":");
		sb.append(port==null?"8080":port).append("/");
		sb.append(contextRoot).append("/");
		return sb;
	}
	
}
