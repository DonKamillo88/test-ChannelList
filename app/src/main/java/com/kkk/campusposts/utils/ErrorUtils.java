package com.kkk.campusposts.utils;

import com.kkk.campusposts.services.CampusSocietyService;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by DonKamillo on 08.09.2016.
 */

public class ErrorUtils {
    public static APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter = CampusSocietyService.getRetrofit().responseBodyConverter(APIError.class, new Annotation[0]);

        APIError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }

        return error;
    }
}
