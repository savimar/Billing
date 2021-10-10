package ru.savimar.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.savimar.billing.entity.Bill;
import ru.savimar.billing.entity.User;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    Bill findBillByUser(User user);
}
