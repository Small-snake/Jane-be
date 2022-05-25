package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author smallsnake
 * @since 2022-05-24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encryption implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String isencryption;


}
