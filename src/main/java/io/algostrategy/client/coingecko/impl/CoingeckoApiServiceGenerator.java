package io.algostrategy.client.coingecko.impl;

import io.algostrategy.client.coingecko.CoingeckoApiError;
import io.algostrategy.client.coingecko.constant.CoingeckoApiConstants;
import io.algostrategy.client.coingecko.exception.CoingeckoApiException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * Generates a Coingecko API implementation based on @see {@link CoingeckoApiService}.
 */
public class CoingeckoApiServiceGenerator {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create(mapper);
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, CoingeckoApiError> errorBodyConverter =
            (Converter<ResponseBody, CoingeckoApiError>) converterFactory.responseBodyConverter(
                    CoingeckoApiError.class, new Annotation[0], null);

    static {
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    private final OkHttpClient client;

    public CoingeckoApiServiceGenerator(OkHttpClient client) {
        this.client = client;
    }

    public <S> S createService(Class<S> serviceClass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CoingeckoApiConstants.API_BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                CoingeckoApiError apiError = getCoingeckoApiError(response);
                throw new CoingeckoApiException(apiError);
            }
        } catch (IOException e) {
            throw new CoingeckoApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static CoingeckoApiError getCoingeckoApiError(Response<?> response) throws IOException, CoingeckoApiException {
        return errorBodyConverter.convert(response.errorBody());
    }
}
