package com.assignments.contactsapp.core;

import io.dropwizard.jackson.JsonSnakeCase;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by anurag on 21/04/15 00:10 AM
 *
 * @author              anurag
 * @version             1.0
 */
@JsonSnakeCase
public class ApiResponse {
    static class HttpHeader {
        private String header;
        private String value;
        public HttpHeader(String header, String value) {
            this.header = header;
            this.value = value;
        }
    }

    private Payload payload;
    private transient Response.Status status;
    private transient List<HttpHeader> headers;

    private ApiResponse() {

    }
    private ApiResponse(Payload payload) {
        this.payload = payload;
    }


    public ApiResponse setStatus(Response.Status status) {
        this.status = status;
        return this;
    }

    public ApiResponse setHeader(String header, String value) {
        headers.add(new HttpHeader(header, value));
        return this;
    }

    public Payload getPayload() {
        return payload;
    }

    public Response.Status getStatus() {
        return status;
    }

    public List<HttpHeader> getHeaders() {
        return headers;
    }

    public static ApiResponse build() {
        return new ApiResponse();
    }

    public  static ApiResponse buildWithPayload(Payload payload) {
        return new ApiResponse(payload);
    }
}
