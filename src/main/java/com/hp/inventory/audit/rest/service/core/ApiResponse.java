/**
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Represents the base class for all the API's responses
 *
 * @author              TCSCODER
 * @version             1.0
 */
public class ApiResponse {
    /**
     * Base Inner class to represent http headers
     */
    static class HttpHeader {
        /**
         * Represents the Header
         */
        private String header;
        /**
         * Represents the value
         */
        private String value;

        /**
         * Constructor, set header and value equal to passed parameters
         * @param header the header
         * @param value the value
         */
        public HttpHeader(String header, String value) {
            this.header = header;
            this.value = value;
        }
    }

    /**
     * Represents the payload instance
     */
    private transient Payload payload;
    /**
     * Represents the HTTP STATUS for the Response
     */
    private transient Response.Status status;
    /**
     * Represents the HTTP Headers for the Response
     */
    private transient List<HttpHeader> headers;

    /**
     * Private Constructor, without payload
     * Don't let anyone instantiate this class
     */
    private ApiResponse() {
    }

    /**
     * Private Constructor, with payload
     * Don't let anyone instantiate this class
     */
    private ApiResponse(Payload payload) {
        this.payload = payload;
    }

    /**
     * Set the HTTP STATUS of this ApiResponse instance
     * @param status the status to set
     * @return this for chaining
     */
    public ApiResponse setStatus(Response.Status status) {
        this.status = status;
        return this;
    }

    /**
     * Add an http header to this ApiResponse instance
     * @param header the header
     * @param value the header value
     * @return this for chaining
     */
    public ApiResponse setHeader(String header, String value) {
        headers.add(new HttpHeader(header, value));
        return this;
    }

    /**
     * Returns the payload to send to client
     * This will return either a list payload or single object
     * @return the payload
     */
    public Object getPayload() {
        if(this.payload.getData() != null) {
            return this.payload.getData();
        }
        return this.payload.getSingle();
    }

    /**
     * Gets the HTTP status associated with this ApiResponse instance
     * @return the http status
     */
    public Response.Status getStatus() {
        return status;
    }

    /**
     * Gets the HTTP Headers associated with this ApiResponse instance
     * @return the list of http headers
     */
    public List<HttpHeader> getHeaders() {
        return headers;
    }

    /**
     * Build the ApiResponse without payload
     * @return the ApiResponse instance
     */
    public static ApiResponse build() {
        return new ApiResponse();
    }

    /**
     * Build the ApiResponse with payload
     * @return the ApiResponse instance with payload set to passed parameter
     */
    public  static ApiResponse buildWithPayload(Payload payload) {
        return new ApiResponse(payload);
    }
}
