package dev.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Items")
public class ItemEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String name;
    @Column(length = 1000)
    private String description;
    private int stockQuantity;
    private String quantityUnit;
    private float price;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Items_Displays",
            joinColumns = @JoinColumn(name = "ITEMID"),
            inverseJoinColumns = @JoinColumn(name = "DISPLAYID") )
    private List <ItemDisplayEntity> itemDisplays = new ArrayList<>();

    public ItemEntity() {
    }

    public ItemEntity(String name, String description, int stockQuantity, String quantityUnit, float price) {
        this.name = name;
        this.description = description;
        this.stockQuantity = stockQuantity;
        this.quantityUnit = quantityUnit;
        this.price = price;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<ItemDisplayEntity> getItemDisplays() {
        return itemDisplays;
    }

    public void setItemDisplays(List<ItemDisplayEntity> itemDisplays) {
        this.itemDisplays = itemDisplays;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public void addItemDisplay(ItemDisplayEntity itemDisplayEntity){
        this.itemDisplays.add(itemDisplayEntity);
    }
}
