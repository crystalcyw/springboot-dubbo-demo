package com.robert.dubbo.base;

import com.robert.dubbo.util.JsonUtils;

import java.io.Serializable;

/**
 * @author changyuwei
 * @date 2019-09-24
 */
public class BaseBean implements Serializable {
    private static final long serialVersionUID = 3929100196065611348L;

    @Override
    public String toString() {
        return JsonUtils.toString(this);
    }
}
