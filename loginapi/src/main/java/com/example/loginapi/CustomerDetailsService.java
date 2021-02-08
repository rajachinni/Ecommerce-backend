package com.example.loginapi;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

// Crud Operations
@Service
public class CustomerDetailsService {
    public static final String COL_NAME="users";

    public String saveCustomerDetails(CustomerDetails customerDetails) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(customerDetails.getEmail()).set(customerDetails);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public CustomerDetails getCustomerDetails(String email) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(email);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        CustomerDetails customerDetails = null;

        if(document.exists()) {
            customerDetails = document.toObject(CustomerDetails.class);
            return customerDetails;
        }else {
            return null;
        }
    }

    public String updateCustomerDetails(CustomerDetails customerDetails) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(customerDetails.getEmail()).set(customerDetails);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteCustomer(String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
        try {
            System.out.println("Update time:" + writeResult.get().getUpdateTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "Document with Customer ID "+name+" has been deleted";
    }


}
