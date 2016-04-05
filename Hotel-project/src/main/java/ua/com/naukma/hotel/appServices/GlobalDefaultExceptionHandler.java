package ua.com.naukma.hotel.appServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ResponseStatus(reason = "please contact the application's support team for more information")
    @ExceptionHandler(value = Exception.class )
    public void handleError(Exception e){
       LOGGER.error(e.getLocalizedMessage(),e);
    }
}
