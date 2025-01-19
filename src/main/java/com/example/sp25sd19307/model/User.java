package com.example.sp25sd19307.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull(message = "Khong duoc de trong id")
    // vi la integer nen '' khong duoc paser sang kieu so => cho nen phai dung notnull
    private Integer id;

    @NotBlank(message = "Khong duoc de trong ten")
    // blank la dau ''
    // nguoc lai so voi ben tren
    private String name;

    private Integer age;

    private String address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
