package com.example.demo.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Repository
public class DiaryResult {
    String state;
    String msg;
}
