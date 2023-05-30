package com.likejin.bootplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.likejin.bootplus.pojo.entity.TBook;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Likejin
 * @since 2023-05-30
 */
public interface TBookMapper extends BaseMapper<TBook> {


    List<TBook> selectAll();
}
