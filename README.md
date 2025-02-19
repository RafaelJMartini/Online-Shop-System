Requirements:

Create an abstract class Product with the attributes name and price and the abstract method priceWithDiscount()
Implement concrete classes Electronics and Clothing that extend Product. The implementations of the concrete classes will determine the discount for each category
An order relates a Customer with a list of products and quantities and must have a method to calculate the total value of the order (it is not necessary to do inventory control)
Use a Persistence interface to define how customer, product and order data will be saved and loaded. Make at least one concrete implementation of Persistence
Throw exceptions for attempts to add
existing products (with the same name)
products with an invalid price
existing customers (with the same CPF)
Override the toStrint() and equals() methods for Product and Customer. Use these methods to display products and customers and to check if a product or customer has already been registered before
Implement a user interface to:
add customers
add electronics and clothing
place orders by entering the customer's CPF, selecting the products and indicating the quantities
display registered customers
display registered products
display the orders: customer, products and total order value (using precoComDesconto() )
Implement constructors for the Product, Customer and Order classes
It is essential to implement the classes considering the principles of encapsulation and that each class should only stick to its own responsibilities!
Don't forget to properly throw exceptions and handle them where necessary
Persistence

The data can be retrieved at the moment the program starts running and saved (all of it) in it only when the user chooses the "Exit" option (suggestion: implementing persistence this way is simpler using the serialization mechanism)
