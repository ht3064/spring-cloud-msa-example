package com.example.userservice.error;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class OrderFeignErrorDecoder implements ErrorDecoder {
    Environment env;

    @Autowired
    public OrderFeignErrorDecoder(Environment env) {
        this.env = env;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        switch(response.status()) {
            case 400:
                break;
            case 404:
                if (methodKey.contains("getOrders")) {
                    return new ResponseStatusException(HttpStatus.valueOf(response.status()),
//                            "User's orders is empty");
                            env.getProperty("order-service.exception.order-is-empty"));
                }
                break;
            default:
                return new Exception(response.reason());
        }

        return null;
    }
}
