package com.likejin.spring.annotation.entity;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author 李柯锦
 * @Date 2023/5/28 14:30
 * @Description 测试Book
 */

@Component
public class Book {

    Integer id;
    String name;
    BigDecimal price;
    String author;
    Integer sales;
    Integer stock;
    String img_path;


    public void initBean(){
        System.out.println("BOOK对象初始化");
    }
    public void destroyBean(){
        System.out.println("BOOK对象被销毁");
    }


    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }


    public Book() {
    }

    public Book(Integer id, String name, BigDecimal price, String author, Integer sales, Integer stock, String img_path) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        this.img_path = img_path;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + img_path + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return img_path;
    }

    public void setImgPath(String imgPath) {
        this.img_path = imgPath;
    }

}

