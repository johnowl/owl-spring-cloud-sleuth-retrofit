package com.johnowl.sleuthretrofitconsumer

import org.springframework.context.annotation.Configuration
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.slf4j.MDC
import org.springframework.context.annotation.Bean


@Configuration
class RetrofitConfig {

    constructor() {

        val okHttpClient = OkHttpClient()
                .newBuilder()
                .addInterceptor {
                    val traceIdKey = "X-B3-TraceId"
                    val spanIdKey = "X-B3-SpanId"

                    val newRequest = it
                            .request()
                            .newBuilder()
                            .addHeader(traceIdKey, MDC.get(traceIdKey))
                            .addHeader(spanIdKey, MDC.get(spanIdKey))
                            .build()

                    it.proceed(newRequest)
                }
                .build()

        val gson = GsonBuilder()
                .setLenient()
                .create()

        retrofit = Retrofit.Builder()
                .baseUrl("http://localhost:5001")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
    }

    companion object {
        lateinit var retrofit: Retrofit
    }

    @Bean
    fun consumerClient() = retrofit.create(ConsumerClient::class.java)


}