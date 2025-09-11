package PracticeRest.Assured;
import java.net.InetAddress;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class DNSCheck {
    public static void main(String[] args) throws Exception {
    	
    	RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        InetAddress address = InetAddress.getByName("api.coindesk.com");
        System.out.println("IP Address: " + address.getHostAddress());
    }
}
