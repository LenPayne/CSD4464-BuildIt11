/*
 * Copyright 2016 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package entities;

import java.io.Serializable;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The Entity for the Product Class
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", 
        query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByName", 
        query = "SELECT p FROM Product p WHERE p.name = :name")})
public class Product implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int productId;
    private String name;
    private String description;
    private int quantity;
    
    public Product () {}
    
    public Product(JsonObject json) {
        // Requires complex conversion as jquery.val() does not set JSON Type
        productId = Integer.parseInt(json.getString("ProductID", "0"));
        name = json.getString("Name");
        description = json.getString("Description");
        quantity = Integer.parseInt(json.getString("Quantity"));
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("ProductID", productId)
                .add("Name", name)
                .add("Description", description)
                .add("Quantity", quantity)
                .build();
    }
}
