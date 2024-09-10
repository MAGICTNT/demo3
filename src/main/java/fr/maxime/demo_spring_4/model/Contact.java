package fr.maxime.demo_spring_4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {
    public UUID id;
    public String name;
    public String phone;
    private  int age;

}
