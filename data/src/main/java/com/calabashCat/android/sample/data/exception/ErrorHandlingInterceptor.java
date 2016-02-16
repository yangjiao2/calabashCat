package com.calabashCat.android.sample.data.exception;

import com.calabashCat.android.sample.data.exception.exceptions.AreaTooLarge;
import com.calabashCat.android.sample.data.exception.exceptions.BadCategory;
import com.calabashCat.android.sample.data.exception.exceptions.BusinessUnavailable;
import com.calabashCat.android.sample.data.exception.exceptions.ExceededReqs;
import com.calabashCat.android.sample.data.exception.exceptions.InvalidOAuthCredentials;
import com.calabashCat.android.sample.data.exception.exceptions.InvalidOAuthUser;
import com.calabashCat.android.sample.data.exception.exceptions.InvalidParameter;
import com.calabashCat.android.sample.data.exception.exceptions.InvalidSignature;
import com.calabashCat.android.sample.data.exception.exceptions.MissingParameter;
import com.calabashCat.android.sample.data.exception.exceptions.MultipleLocations;
import com.calabashCat.android.sample.data.exception.exceptions.SSLRequired;
import com.calabashCat.android.sample.data.exception.exceptions.UnavailableForLocation;
import com.calabashCat.android.sample.data.exception.exceptions.UnexpectedAPIError;
import com.calabashCat.android.sample.data.exception.exceptions.UnspecifiedLocation;
import com.calabashCat.android.sample.data.exception.exceptions.YelpAPIError;
import com.calabashCat.android.sample.data.exception.exceptions.InternalError;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;


import java.io.IOException;

/**
 * {@link Interceptor} to parse and transform the HTTP errors.
 */
public class ErrorHandlingInterceptor implements Interceptor {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Intercept HTTP responses and raise a {@link YelpAPIError} if the response code is not 2xx.
     *
     * @param chain {@link Chain} object for sending the HTTP request.
     * @return response
     * @throws IOException {@link YelpAPIError} generated depends on the response error id.
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if (!response.isSuccessful()) {
            throw parseError(
                    response.code(),
                    response.message(),
                    response.body() != null ? response.body().string() : null
            );
        }
        return response;
    }

    private YelpAPIError parseError(int code, String message, String responseBody) throws IOException {
        if (responseBody == null) {
            return new UnexpectedAPIError(code, message);
        }

        JsonNode errorJsonNode = objectMapper.readTree(responseBody).path("error");
        String errorId = errorJsonNode.path("id").asText();
        String errorText = errorJsonNode.path("text").asText();

        if (errorJsonNode.has("field")) {
            errorText += ": " + errorJsonNode.path("field").asText();
        }

        switch (errorId) {
            case "AREA_TOO_LARGE":
                return new AreaTooLarge(code, message, errorId, errorText);
            case "BAD_CATEGORY":
                return new BadCategory(code, message, errorId, errorText);
            case "BUSINESS_UNAVAILABLE":
                return new BusinessUnavailable(code, message, errorId, errorText);
            case "EXCEEDED_REQS":
                return new ExceededReqs(code, message, errorId, errorText);
            case "INTERNAL_ERROR":
                return new InternalError(code, message, errorId, errorText);
            case "INVALID_OAUTH_CREDENTIALS":
                return new InvalidOAuthCredentials(code, message, errorId, errorText);
            case "INVALID_OAUTH_USER":
                return new InvalidOAuthUser(code, message, errorId, errorText);
            case "INVALID_PARAMETER":
                return new InvalidParameter(code, message, errorId, errorText);
            case "INVALID_SIGNATURE":
                return new InvalidSignature(code, message, errorId, errorText);
            case "MISSING_PARAMETER":
                return new MissingParameter(code, message, errorId, errorText);
            case "MULTIPLE_LOCATIONS":
                return new MultipleLocations(code, message, errorId, errorText);
            case "SSL_REQUIRED":
                return new SSLRequired(code, message, errorId, errorText);
            case "UNAVAILABLE_FOR_LOCATION":
                return new UnavailableForLocation(code, message, errorId, errorText);
            case "UNSPECIFIED_LOCATION":
                return new UnspecifiedLocation(code, message, errorId, errorText);
            default:
                return new UnexpectedAPIError(code, message, errorId, errorText);
        }
    }
}
