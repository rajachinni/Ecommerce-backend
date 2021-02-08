package com.example.loginapi;

import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/customerUI")
public class CustomerController {
    @Autowired
    CustomerDetailsService customerDetailsService;

//    @GetMapping("/getCustomerDetails")
//    public CustomerDetails getCustomer(@RequestParam String email ) throws InterruptedException, ExecutionException{
//        return customerDetailsService.getCustomerDetails(email);
//    }

    @GetMapping(value = "/{get}")
    public CustomerDetails getCustomer(@PathVariable("get") String email) throws ExecutionException, InterruptedException {
        return customerDetailsService.getCustomerDetails(email);
    }



    @PostMapping("/createCustomer")
    public String createCustomer(@RequestBody CustomerDetails customerDetails ) throws InterruptedException, ExecutionException {

        //
        customerDetailsService.saveCustomerDetails(customerDetails);
        return "done";

    }


//    @PutMapping("/updateCustomer")
//    public String updateCustomer(@RequestBody CustomerDetails customerDetails  ) throws InterruptedException, ExecutionException {
//        return customerDetailsService.updateCustomerDetails (customerDetails);
//    }

    @PutMapping("/updateCustomer/{id}")
    public String updateCustomerDetails(@PathVariable(value = "id") String email,
                                                             @RequestBody CustomerDetails customerDetails) throws ExecutionException, InterruptedException {
        customerDetailsService.updateCustomerDetails(customerDetails);

        customerDetails.setEmail(customerDetails.getEmail());
        customerDetails.setPassword(customerDetails.getPassword());
        customerDetails.setName(customerDetails.getName());
        customerDetails.setAddress(customerDetails.getAddress());
        customerDetails.setPhone(customerDetails.getPhone());

        final String updatedCustomerDetails = customerDetailsService.saveCustomerDetails(customerDetails);
        return updatedCustomerDetails;
    }



    @DeleteMapping("/deleteCustomer/{del}")
    public String deleteCustomer(@PathVariable(value = "del") String Id){
        return customerDetailsService.deleteCustomer(Id);
    }


}
