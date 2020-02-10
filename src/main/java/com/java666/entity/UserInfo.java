package com.java666.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Date 2020/2/10 21:02
 * @Author JianHui
 */
@Data
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 7291943992082860001L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 200,name = "name")
    private String name;
}
