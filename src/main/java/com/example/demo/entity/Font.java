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
 * @since 2022-05-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Font implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String font;

    private String src;


}
