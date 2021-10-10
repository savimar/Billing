package ru.savimar.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.savimar.billing.entity.Bill;
import ru.savimar.billing.entity.User;
import ru.savimar.billing.repository.BillRepository;
import ru.savimar.billing.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class BillService {

    @Autowired
    private BillRepository repository;

    public List<Bill> findAll(){
        List<Bill> result = repository.findAll();
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Bill>();
        }
    }


    public void delete(Integer id){
        repository.deleteById(id);
    }

    public Bill save(Bill bill){
        return repository.save(bill);
    }


    public Bill getBillById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
    public Bill getBillByUser(User user){
        return repository.findBillByUser(user);
    }
}
