package com.kkk.campusposts.utils;

import java.util.List;

/**
 * Created by DonKamillo on 08.09.2016.
 */

public class APIError {
    private String message;
    private List<Error> errors;

    public APIError() {
    }

    public String message() {
        return message;
    }

    public String getMessage() {
        return message;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public class Error {
        private String message;
        private String key;

        public String getMessage() {
            return message;
        }

        public String getKey() {
            return key;
        }
    }

}
