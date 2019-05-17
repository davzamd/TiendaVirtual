package base.order.persistance;

import base.order.domain.Order;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OrderDAOImp implements OrderDAO {

    private static final String fileName;

    static {
        fileName = "factura.txt";
    }

    @Override
    public boolean UpdateOrder(Order order) {
        try (var writer = Files.newBufferedWriter(Paths.get(fileName))) {
            writer.write(order.generateBill());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
