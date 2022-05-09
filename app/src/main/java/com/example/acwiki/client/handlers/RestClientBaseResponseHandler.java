package com.example.acwiki.client.handlers;

public interface RestClientBaseResponseHandler {
    /**
     * Handles failure in an HTTP request.
     *
     * @param statusCode The HTTP status code returned by the server.
     *                   If it failed due to a network error, this value will be -1.
     */
    void requestDidFail(int statusCode);
}
