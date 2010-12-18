package com.jaxws.json.codec.doc;

import java.io.IOException;

import com.jaxws.json.codec.JSONCodec;
import com.sun.xml.ws.transport.http.HttpAdapter;
import com.sun.xml.ws.transport.http.WSHTTPConnection;

/**
 * @author Sundaramurthi Saminathan
 * @since JSONWebservice codec version 0.4
 * @version 1.0
 * 
 * Interface for document publisher. 
 * @see DefaultEndpointDocument, ServiceConfigurationServer, JsClientServer, MetaDataModelServer
 */
public interface HttpMetadataProvider {
	/**
	 * If implementing document provider can handle requested query may return true.
	 *  
	 * @param queryString in document request.
	 * @return
	 */
	boolean canHandle(String queryString);
	
	
	/**
	 * Document provider handling queries. Used to format help document urls.
	 * @return
	 */
	String[] getHandlingQueries();
	
	/**
	 * Request handling JSONCodec instance passed.  
	 * @param codec
	 */
	void setJSONCodec(JSONCodec codec);
	
	
	/**
	 * requesting http transport adapter.
	 * @param httpAdapter
	 */
	void setHttpAdapter(HttpAdapter httpAdapter);
	
	/**
	 * @return Content type of document.
	 */
	String getContentType();
	
	/**
	 * Process method invoked before calling doResponse
	 */
	void process();
	
	/**
	 * Write document to output stream.
	 * @param ouStream WSHTTPConnection
	 * @throws IOException
	 * @see WSHTTPConnection
	 */
	void doResponse(WSHTTPConnection ouStream) throws IOException;
}
