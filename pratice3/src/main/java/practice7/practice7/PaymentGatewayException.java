package practice7.practice7;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.classfile.attribute.DeprecatedAttribute;

public class PaymentGatewayException  {
    public PaymentGatewayException(String message) throws IOException {
        super();
    }
}

class AppException extends RuntimeException {
    public AppException(String message, Throwable cause) { super(message, cause); }
    public AppException(String message) { super(message); }
}

class OrderProcessingException extends AppException {
    static final Logger log = LoggerFactory.getLogger(Order.class);
    public OrderProcessingException(String message, Throwable cause) {
        super(message, cause);
        try{
            log.error("Error!", cause);
        } catch (Exception e) {
            log.error("Error!", cause);
            throw new OrderProcessingException("Error!", e);
        }
    }
}
class Main{
    static void main() {
        throw new OrderProcessingException("Error error!", new IOException());
    }
}
