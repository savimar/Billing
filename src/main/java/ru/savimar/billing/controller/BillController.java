package ru.savimar.billing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import ru.savimar.billing.entity.Bill;
import ru.savimar.billing.entity.User;
import ru.savimar.billing.service.BillService;
import ru.savimar.billing.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BillController {
    @Autowired
    private UserService userService;
    @Autowired
    private BillService billService;

    @RequestMapping(path = "/createBillAndUser", method = RequestMethod.POST)
    public String createBillAndUser(User user, Model model) {

       userService.save(user);
       Bill bill = new Bill(user);
       billService.save(bill);
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "usersbills";
    }
    @RequestMapping(path = "/billForUser/{id}")
    public String getOrdersForUser(Model model, @PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        Bill bill = billService.getBillByUser(user);
        ArrayList<Bill>billList = new ArrayList<Bill>();
        billList.add(bill);
        model.addAttribute("billList", billList);
        model.addAttribute("userId", id);
        return "bills";
    }
    @RequestMapping(path = { "/editBillForUser/{id}"})
    public String editBillById(Model model, @PathVariable("id") Optional<Integer> id/*, @PathVariable("userId") Integer userId*/) {
        if (id.isPresent()) {
           // int billId = Integer.parseInt(id.get());
            Bill entity = billService.getBillById(id.get());
            model.addAttribute("bill", entity);
         //   model.addAttribute("userId", userId);
        } else {
            model.addAttribute("bill", new Bill());
          //  model.addAttribute("userId", userId);
        }

        return "addbill";
    }
    @RequestMapping(path = {"/save", "/save/{id}"})
    public String saveBillById(Model model, @RequestBody Bill bill, @PathVariable("id") Optional<Integer> id) {
        ArrayList<Bill>billList = new ArrayList<Bill>();
        if (id.isPresent()) {
            Bill newBill = billService.getBillById(bill.getId());
            newBill.setAccount(bill.getAccount());
          //  newBill.setUser(/*bill.getUser()*/userService.getUserById(1));
            billService.save(newBill);
            billList.add(newBill);
        } else {
            billService.save(bill);
            billList.add(bill);
        }
        model.addAttribute("billList", billList);
        return "bills";
    }
    @RequestMapping(path = "/createBill", method = RequestMethod.POST)
    public String createOrUpdateBill(Bill bill, Model model /*@PathVariable("userId") Integer userId*/) {
     //  int idUser= Integer.parseInt(userId);
        User user = userService.getUserById(1);
        bill.setUser(user);
        billService.save(bill);
        ArrayList<Bill>billList = new ArrayList<Bill>();
        billList.add(bill);
        model.addAttribute("billList", billList);

        return "bills";
    }
    @RequestMapping(path = "/getBillForUser", method = RequestMethod.POST)
    public int getBill(User user) {
    return billService.getBillByUser(user).getAccount();

    }

}
