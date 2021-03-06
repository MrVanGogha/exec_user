package com.zkq.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 15:27 2020/7/13
 */
public class BeanConvert {
    public static <T, S> T convertBean(S s, Class<T> tClass){
        if (s == null) {
            return null;
        }
        try {
            T t = tClass.newInstance();
            BeanUtils.copyProperties(s, t);
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T, S> List<T> convertList(Collection<S> s, Class<T> tClass){
        if (CollectionUtils.isEmpty(s)) {
            return Collections.emptyList();
        }
        return s.stream().map(ele -> convertBean(ele, tClass)).collect(Collectors.toList());
    }
}
