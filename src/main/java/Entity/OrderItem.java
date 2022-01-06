package Entity;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private String id;
    private String order_id;
    private String user_id;
    private int restaurant_id;
    private String upload_time;
    private Float order_price;
    private int item_id;
    private int item_amount;
    private int item_taste;
    private int item_environment;
    private int item_service;

    private String item_name;
    private String restaurant_name;

    public OrderItem(String id, String order_id, String user_id, int restaurant_id,
                     String upload_time, Float order_price, int item_id, int item_amount, int item_taste,
                     int item_environment, int  item_service, String item_name, String restaurant_name){
        this.id = id;
        this.order_id = order_id;
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
        this.upload_time = upload_time;
        this.order_price = order_price;
        this.item_id = item_id;
        this.item_amount = item_amount;
        this.item_taste = item_taste;
        this.item_environment = item_environment;
        this.item_service = item_service;
        this.item_name = item_name;
        this.restaurant_name = restaurant_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public Float getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Float order_price) {
        this.order_price = order_price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getItem_amount() {
        return item_amount;
    }

    public void setItem_amount(int item_amount) {
        this.item_amount = item_amount;
    }

    public int getItem_taste() {
        return item_taste;
    }

    public void setItem_taste(int item_taste) {
        this.item_taste = item_taste;
    }

    public int getItem_environment() {
        return item_environment;
    }

    public void setItem_environment(int item_environment) {
        this.item_environment = item_environment;
    }

    public int getItem_service() {
        return item_service;
    }

    public void setItem_service(int item_service) {
        this.item_service = item_service;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }




}
