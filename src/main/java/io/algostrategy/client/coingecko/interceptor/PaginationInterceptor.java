package io.algostrategy.client.coingecko.interceptor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Map;

/**
 * Interceptor move pagination information from headers to json body.
 */
public class PaginationInterceptor implements Interceptor {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    @SuppressWarnings("NullableProblems")
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        Response response = chain.proceed(request);

        ResponseBody body = response.body();
        Object pageSize = response.headers().get("per-page");
        Object total = response.headers().get("total");

        if (body != null && pageSize != null && total != null) {

            String jsonStr = body.string();
            TypeReference<Map<String, Object>> resultType = new TypeReference<Map<String, Object>>() {
            };

            Map<String, Object> result = OBJECT_MAPPER.readValue(jsonStr, resultType);
            result.put("pageSize", pageSize);
            result.put("total", total);

            String newJsonStr = OBJECT_MAPPER.writeValueAsString(result);

            ResponseBody newBody = ResponseBody.create(body.contentType(), newJsonStr);

            return response.newBuilder().body(newBody).build();
        }

        return response;
    }
}
