# Calculate Fee Rules

Calculate Fee Rules is a rule-based API for calculating the fees according to input. Its purpose is to decouple the complex logic associated with calculating a fee for a right due to the many variables that affect it. The API uses [Drools](https://www.drools.org/) as its rules engine.

## Getting started

To install this locally, clone this repo and at the root directory run this Maven command:

```bash
mvn clean install
```

To run the API, run this:

```bash
mvn spring-boot:run
```

The API should be available to take requests at http://localhost:8080/ipo/FeeCalculationRule.

## Requesting Fees

```http
POST http://localhost:8080/ipo/FeeCalculationRule
```

A fee can be requested by sending a `POST` request to http://localhost:8080/ipo/FeeCalculationRule. Examples:

### Trademark

Request body:

```json
{

        "feeCalculation": [
            {
                "productRight": "TRADEMARK",
                "DateTime": "2020-08-17T00:00:00.000+0000",
                "paymentOption": "PAY_NOW",
                "paymentChannel": "BANK_TRANSFER",
                "productService": "APPLICATION_TO_REGISTER_A_TRADE_MARK",
                "productVariant": [
                    {
                        "name": "Class1"
                    },
                    {
                        "name": "Class2"
                    }
                ],
                "productData": []
            }
        ]
    
}
```

Response:

```json
{

        "feeCalculation": [
            {
                "productRight": "TRADEMARK",
                "productService": "APPLICATION_TO_REGISTER_A_TRADE_MARK",
                "DateTime": "2020-08-17T00:00:00.000+0000",
                "paymentChannel": "BANK_TRANSFER",
                "paymentOption": "PAY_NOW",
                "productVariant": [
                    {
                        "name": "Class1"
                    },
                    {
                        "name": "Class2"
                    }
                ],
                "productData": [],
                "feeBreakdown": [
                    {
                        "name": "Trademark Registration Fee",
                        "value": 170,
                        "description": ""
                    },
                    {
                        "name": "Class 1",
                        "value": 50,
                        "description": ""
                    },
                    {
                        "name": "Class 2",
                        "value": 50,
                        "description": ""
                    }
                ]
            }
        ]
    
}
```

### Design

Request body:

```json
{

        "feeCalculation": [
            {
                "productRight": "DESIGN",
                "DateTime": "2020-08-17T00:00:00.000+0000",
                "paymentOption": "PAY_NOW",
                "paymentChannel": "BANK_TRANSFER",
                "productService": "APPLICATION_TO_REGISTER_ONE_OR_MORE_DESIGNS",
                "productData": []
            }
        ]
    
}
```

Response:

```json
{

        "feeCalculation": [
            {
                "productRight": "DESIGN",
                "productService": "APPLICATION_TO_REGISTER_ONE_OR_MORE_DESIGNS",
                "DateTime": "2020-08-17T00:00:00.000+0000",
                "paymentChannel": "BANK_TRANSFER",
                "paymentOption": "PAY_NOW",
                "productVariant": null,
                "productData": [],
                "feeBreakdown": [
                    {
                        "name": "Design Registration Fee",
                        "value": 120,
                        "description": ""
                    }
                ]
            }
        ]
    
}
```

### Patent

Request for grant of a patent

Request body:

```json
{

            "feeCalculation": [
                {
                    "productRight": "PATENT",
                    "DateTime": "2020-08-17T00:00:00.000+0000",
                    "paymentOption": "PAY_NOW",
                    "paymentChannel": "BANK_TRANSFER",
                    "productService": "REQUEST_FOR_GRANT_OF_A_PATENT",
                    "productVariant": [],
                    "productData": []
                }
            ]
    
}
```

Response:

```json
{

            "feeCalculation": [
                {
                    "paymentChannel": "BANK_TRANSFER",
                    "paymentOption": "PAY_NOW",
                    "Fee": "60.00",
                    "DateTime": "2020-08-17T00:00:00.000+0000",
                    "productRight": "PATENT",
                    "productService": "REQUEST_FOR_GRANT_OF_A_PATENT",
                    "productVariant": [],
                    "productData": [],
                    "feeBreakdown": [
                        {
                            "name": "Patent Registration Fee",
                            "value": 60,
                            "description": ""
                        }
                    ]
                }
            ]

}
```

Request for grant and search 1 - 30 claims.

Request body:

```json
{
   
        "feeCalculation": [
            {
                "productRight": "PATENT",
                "productService": "REQUEST_A_SEARCH_FOR_A_UK_APPLICATION",
                "DateTime": "2020-08-17T00:00:00.000+0000",
                "paymentChannel": "BANK_TRANSFER",
                "paymentOption": "PAY_NOW",
                "productVariant": [],
                "productData": [
                    {
                        "name": "number-of-claims",
                        "value": 25
                    }
                ]
            }
        ]
    
}
```

Response:

```json
{
    

            "feeCalculation": [
                {
                    "paymentChannel": "BANK_TRANSFER",
                    "paymentOption": "PAY_NOW",
                    "Fee": "210.00",
                    "DateTime": "2020-08-17T00:00:00.000+0000",
                    "productRight": "PATENT",
                    "productService": "REQUEST_A_SEARCH_FOR_A_UK_APPLICATION",
                    "productVariant": [],
                    "productData": [
                        {
                            "name": "number-of-claims",
                            "value": 25
                        }
                    ],
                    "feeBreakdown": [
                        {
                            "name": "Patent Registration Fee",
                            "value": 60,
                            "description": ""
                        },
                        {
                            "name": "Patent Search",
                            "value": 150,
                            "description": ""
                        }
                    ]
                }
            ]
        
    
}
```


## Run all tests

```bash
mvn test
```