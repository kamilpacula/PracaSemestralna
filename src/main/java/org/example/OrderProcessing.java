package org.example;

import org.example.model.Order;
import org.example.model.Product;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class OrderProcessing {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");

        Order order = new Order();
        order.addProduct(new Product("Product 1", 10.0));
        order.addProduct(new Product("Product 2", 15.0));

        kSession.insert(order);
        kSession.fireAllRules();
        kSession.dispose();

        System.out.println("Total order price: " + order.getTotalPrice());
    }
}