package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Created by vagrant on 6/23/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@NoArgsConstructor
@Table(name = "ORDER")
public class Order {
    @Id
    @GeneratedValue
    private String id;

    //private Menu menu;
    @Embedded
    //Name of the customer
    private String customerName;
    //ID used to find the restaurant, if there are multiple restaurants with the same name
    private String providerID;
    //Special Instructions
    private String instruction;
    //Location information of the restaurant
    private String address;
    //Total value of this order;
    private double total;
    // Status of this order
    @JsonCreator
    public Order(@JsonProperty("name") String customerName,
                      @JsonProperty("id") String providerID,
                      @JsonProperty("instruction") String instruction,
                      @JsonProperty("address") String address) {
        this.customerName = customerName;
        this.instruction= instruction;
        this.providerID = providerID;
        this.address = address;
    }

}
