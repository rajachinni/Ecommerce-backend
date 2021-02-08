/product
1. GET- product
     
     url : /getproduct/{productId}
     url :  http://localhost:8082/product/getproduct/"id"

     method:Product findProduct(@PathVariable("productId") String productId)
        returns product
            {
                "name":"product1"
                "category": "das",
                "stock": 24,
                "attribute": [
                    {
                        "attributeKey": "asdas",
                        "getAttributeValue": "sfece"
                    },
                    {
                        "attributeKey": "vezsa",
                        "getAttributeValue": "ienvr"
                    }
                ],
                "images": [
                    "asdasdasdasd",
                    "asdasd"
                ],
                "productId": "60000dccfd0c4858105824d6"
            }

2. GET /getallproducts/
        
     url:http://localhost:8082/product/getallproducts

        returns List<Product>
            [
                {
                    "name":"product1"
                    "category": "das",
                    "stock": 24,
                    "attribute": [
                        {
                            "attributeKey": "asdas",
                            "getAttributeValue": "sfece"
                        },
                        {
                            "attributeKey": "vezsa",
                            "getAttributeValue": "ienvr"
                        }
                    ],
                    "images": null,
                    "productId": "600007bd395fe70496abb42d"
                },
                {
                    "name":"product2"
                    "category": "das",
                    "stock": 24,
                    "attribute": [
                        {
                            "attributeKey": "asdas",
                            "getAttributeValue": "sfece"
                        },
                        {
                            "attributeKey": "vezsa",
                            "getAttributeValue": "ienvr"
                        }
                    ],
                    "images": [
                        "asdasdasdasd",
                        "asdasd"
                    ],
                    "productId": "60000dccfd0c4858105824d6"
                }
            ]

3. POST-/addproduct
   
   url :     http://localhost:8080/product/addproduct
   input:
       {
            "name":"product2"
             "category":"das",
             "stock":24,
             "attribute":[
                 {
                     "attributeKey": "asdas",
                     "getAttributeValue": "sfece"
                 },
                 {
                     "attributeKey": "vezsa",
                     "getAttributeValue": "ienvr"
                 }
             ],
             "images": [
                 "asdasdasdasd",
                 "asdasd"

             ]
            }
    output: returns added product
            {
                "category": "das",
                "stock": 24,
                "attribute": [
                    {
                        "attributeKey": "asdas",
                        "getAttributeValue": "sfece"
                    },
                    {
                        "attributeKey": "vezsa",
                        "getAttributeValue": "ienvr"
                    }
                ],
                "images": [
                    "asdasdasdasd",
                    "asdasd"
                ],
                "productId": "60000ec0fd0c4858105824d7"
            }

   