# Java Persistence API

Some examples using jQuery, RESTful Web Services in Java Persistence API

Provided is the `Product.sql` file for loading a Database

Significant steps must be taken to set up the conversation between GlassFish and
the database.

## Steps to Initialize Database on N208 Computers

1. Turn on Apache and MySQL under XAMPP
2. Navigate to http://localhost:8081/phpMyAdmin or Use MySQL Command Line 
   (C:\xampp\mysql\bin\mysql.exe)
3. Execute the entire Product.sql script
4. Start the GlassFish Server in NetBeans by Running the Project (this will fail to Deploy)
5. Navigate to the GlassFish Admin Console (http://localhost:4848/)
6. Expand the Resources->JDBC Node and select JDBC Connection Pools
7. Create a New JDBC Connection Pool. Pool Name: `mysql_products_rootPool`, 
   Resource Type: `javax.sql.DataSource`, Database Driver Vendor: `MySQL`
8. Configure the properties: URL: `jdbc:mysql://localhost:3306/products?zeroDateTimeBehavior=convertToNull`,
   User: `root`, Password: `password`
9. Under the Resources->JDBC Node select JDBC Resources
10. Create a New JDBC Resource. JNDI Name: `datasource`, Pool Name: `mysql_products_rootPool`
11. Back in phpMyAdmin and/or MySQL Command Line, run the following SQL to change 
    the root password: `SET PASSWORD FOR 'root'@'localhost' = PASSWORD('password');`
12. Run the Application in NetBeans again. This time it should work.