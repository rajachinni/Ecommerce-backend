package com.example.order_cart.services.impl;

import com.example.order_cart.entity.CartEntity;
import com.example.order_cart.entity.OrderEntity;
import com.example.order_cart.entity.ProductEntity;
import com.example.order_cart.repository.CartRepository;
import com.example.order_cart.repository.OrderRepository;
import com.example.order_cart.services.OrderService;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.websocket.Session;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;

    public String saveOrder(OrderEntity orderEntity){

       OrderEntity o= orderRepository.save(orderEntity);
       return o.get_id();
    }

    public List<OrderEntity> getOrder(String customerEmail){
        Iterable<OrderEntity> list = orderRepository.findAll();
        List<OrderEntity> orderList = new ArrayList<>();
        List<OrderEntity> returnList = new ArrayList<>();
        try {
            list.forEach(orderList::add);
        }catch (Exception e){
            System.out.println("Error: "+e);

        }

        for (OrderEntity o:orderList) {
               if(o.getCustomerEmail().equals(customerEmail))
               {
                   returnList.add(o);
               }
        }
        return returnList;
//        return orderList
//                .stream().filter(e -> {return
//                        e.getCustomerEmail()
//                                .equals(customerEmail);})
//                .collect(Collectors.toList());
    }

    public CartEntity getCart(String customerEmail){
        CartEntity cart;
        try{
            cart = cartRepository.findById(customerEmail).get();
        }catch (Exception e){
            System.out.println("Error: "+e);
            return null;
        }
        return cart;
    }

    public void saveCart(CartEntity cart){
        cartRepository.save(cart);
    }

//    public void updateCart(CartEntity cartEntity){
//        saveCart(cartEntity);
//    }


    @Override
    public OrderEntity getOrderById(String orderId)
    {
        return  orderRepository.findById(orderId).get();
    }

    public String updateCart(ProductEntity productEntity,String customerId)
    {
       CartEntity oldCart= cartRepository.findById(customerId).get();
       List<ProductEntity> productList = oldCart.getProductEntities();
       productList.add(productEntity);
       oldCart.setProductEntities(productList);
       cartRepository.save(oldCart);
       return "Updated";
    }


    public void deleteCart(String customerEmail){
        cartRepository.deleteById(customerEmail);
    }

    @Override
    public void sendEmail(String email,OrderEntity orderEntity) throws Exception{
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");/*
        properties.put("mail.smtp.username","rbkgupta1999@gmail.com");
        properties.put("mail.smtp.passwword","chinni_raja");*/


        javax.mail.Session session = javax.mail.Session.getInstance(properties, new Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("Soundholics3@gmail.com", "#TheSoundOfSoul");
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("Soundholics3@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
        message.setSubject("Invoice of order");
        MimeMultipart multipart = new MimeMultipart();
        BodyPart messageBodyPart = new MimeBodyPart();

        /*String htmlMessage = "<h3>Thanks for shopping in SoundHolics</h3>";
        htmlMessage += "<img src=\"https://yt3.ggpht.com/ytc/AAUvwnjqjNoGf1oIL9Nvt0CtsGWelXEetiOsn9A6_9weBQ=s900-c-k-c0x00ffffff-no-rj\"/>";
        messageBodyPart.setContent(htmlMessage,"text/html");
        multipart.addBodyPart(messageBodyPart);*/
        String htmlHeading = "<h3>Thanks for shopping in SoundHolics<h4>INVOICE!</h4>";
        messageBodyPart.setContent(htmlHeading,"text/html");
        multipart.addBodyPart(messageBodyPart);


           //old-one is orderEntity --->orderEntity.getOrderId()   new is ---->orderEntity.get_Id()
            messageBodyPart = new MimeBodyPart();
            String thread = "<p>"+"Email Id : "+orderEntity.getCustomerEmail()+"</p>"+"<p>"+"order Id: "+orderEntity.get_id()+"</p>"+"<p>"+"Address : "+orderEntity.getAddress()+"</p>"+"<p>"+"Date :"+orderEntity.getDate()+"</p>";
            messageBodyPart.setContent(thread,"text/html");
            multipart.addBodyPart(messageBodyPart);

            for(ProductEntity productEntity:orderEntity.getProductEntities()){

                messageBodyPart = new MimeBodyPart();
                String productDetails = "<p>"+"ProductId : "+productEntity.getProductId()+"</p>"+"<p>"+"merchantId : "+productEntity.getMerchantId()+"</p>"+"<p>"+"Quantity:\n"+productEntity.getQuantity()+"</p>";
                messageBodyPart.setContent(productDetails,"text/html");
                multipart.addBodyPart(messageBodyPart);
            }
            messageBodyPart = new MimeBodyPart();
            //<p><h3>Thanks for Placing Order !!!</h3></p>
            String thread2 = "<p><h3>Your order will be delivered Soon</h3></p>";
            messageBodyPart.setContent(thread2,"text/html");
            multipart.addBodyPart(messageBodyPart);


           /* messageBodyPart = new MimeBodyPart();
            String htmlThread = "<p>"+". "+orderList.+"</p><img src=\""+item.getQuantity()+" Price: "+item.getPrice()+"</p>";
            messageBodyPart.setContent(htmlThread,"text/html");
            multipart.addBodyPart(messageBodyPart);
            i++;
            totalPrice+=item.getQuantity()*item.getPrice();*/


        message.setContent(multipart);
        Transport.send(message);

    }



}




