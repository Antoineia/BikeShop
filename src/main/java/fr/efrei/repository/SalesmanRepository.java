package fr.efrei.repository;

//Salesman Repository
import fr.efrei.domain.Salesman;

import java.util.ArrayList;
import java.util.List;

public class SalesmanRepository implements ISalesmanRepository {
    private static ISalesmanRepository repository = null;
    private static List<Salesman> salesmanList;

    private SalesmanRepository(){
        salesmanList = new ArrayList<Salesman>();
    }

    public static ISalesmanRepository getRepository(){
        if(repository == null){
            repository = new SalesmanRepository();
        }
        return repository;
    }

    @Override
    public Salesman create(Salesman salesman){
        boolean success = salesmanList.add(salesman);
        if(success){
            return salesman;
        }
        return null;
    }

    @Override
    public Salesman read(Integer id){
        Salesman salesman = salesmanList.stream()
                .filter(s -> s.getId() == id)
                .findAny()
                .orElse(null);
        return salesman;
    }

    @Override
    public Salesman update(Salesman salesman){
        int id = salesman.getId();
        Salesman salesmanOld = read(id);
        if(salesmanOld == null)
            return null;
        boolean success = delete(id);
        if(success){
            if(salesmanList.add(salesman))
                return salesman;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id){
        Salesman salesmanToDelete = read(id);
        if(salesmanToDelete == null)
            return false;
        return(salesmanList.remove(salesmanToDelete));
    }

    @Override
    public List<Salesman> getall() {
        return salesmanList;
    }

}
