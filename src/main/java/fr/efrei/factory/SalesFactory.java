package fr.efrei.factory;

import fr.efrei.domain.Sales;
import fr.efrei.domain.Customer;
import fr.efrei.domain.Bicycle;
import fr.efrei.util.Helper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class SalesFactory {
    public static Sales buildSales(int id, Date date, float totalAmount, int idCustomer) {
        if (id <= 0) {
            return null;
        }

        if (date == null) {
            return null;
        }

        if (totalAmount <= 0.0f) {
            return null;
        }

        if (idCustomer <= 0) {
            return null;
        }

        return new Sales.Builder().setId(id)
                    .setDate(date)
                    .setTotalAmount(totalAmount)
                    .setIdCustomer(idCustomer)
                    .setBicycleHashMap(new HashMap<>())
                    .build();
    }
}
