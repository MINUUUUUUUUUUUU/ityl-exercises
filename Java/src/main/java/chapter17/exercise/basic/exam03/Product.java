package chapter17.exercise.basic.exam03;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private int pno;
    private String name;
    private String company;
    private int price;
}
