package dev.akash.fakestoreapi.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //after fakestore
    private Date createdAt; //helps us to create a date when this table is created
    private Date lastUpdatedAt;//helps us to update a date when this table has modified
    private boolean isdeleted; //instead of dropping the whole table we can use a boolean value to check if it is deleted or not

    //after fakestore
}
