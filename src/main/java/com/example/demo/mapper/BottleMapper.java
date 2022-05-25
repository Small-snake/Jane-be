package com.example.demo.mapper;

import com.example.demo.entity.Bottle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.service.impl.BottleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author smallsnake
 * @since 2022-05-22
 */
@Repository
public interface BottleMapper extends BaseMapper<Bottle> {

}
