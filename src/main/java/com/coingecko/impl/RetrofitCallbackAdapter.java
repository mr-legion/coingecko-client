package com.coingecko.impl;

import com.coingecko.CoingeckoApiError;
import com.coingecko.exception.CoingeckoApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static com.coingecko.impl.CoingeckoApiServiceGenerator.getCoingeckoApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                CoingeckoApiError apiError = getCoingeckoApiError(response);
                onFailure(call, new CoingeckoApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new CoingeckoApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof CoingeckoApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new CoingeckoApiException(t));
        }
    }
}
