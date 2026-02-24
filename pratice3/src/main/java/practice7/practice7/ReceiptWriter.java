package practice7.practice7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static practice7.OrderProcessingException.log;

public class ReceiptWriter implements AutoCloseable {
boolean closed;
    @Override
    public void close() throws Exception {
        log.error("Error closed true");
        closed = true;
    }
    public ReceiptWriter(){

    }
}
class ReceiptService{
    public static void generate(){
        try(ReceiptWriter r = new ReceiptWriter()){
           throw new OrderProcessingException("new error!", null);
        }catch (OrderProcessingException e){
            throw  new OrderProcessingException("new error!", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

     void main() {
        ReceiptService.generate();
    }
}

//class ReceiptGenerationException{
//
//}
