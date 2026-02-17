package practice6.task1;

public class GodShopService {
    // TODO: split responsibilities into separate services.
    public void registerUser(String email) {
    }

    public void addProduct(String name, double price) {
    }

    public void createOrder(String userEmail, String productName) {
    }

    public void payOrder(long orderId) {
    }

    public void sendEmail(String email, String message) {
    }

    public void exportReport(String fromDate, String toDate) {
    }
}

class ShopUserService{
    public void registerUser(String email) {
    }

}

class ShopOrderService{
    public void addProduct(String name, double price) {
    }

    public void createOrder(String userEmail, String productName) {
    }

    public void payOrder(long orderId) {
    }
}

class ShopReportingService{
    public void exportReport(String fromDate, String toDate) {
    }
}

class ShopNotificationService{
    public void sendEmail(String email, String message) {
    }
}
