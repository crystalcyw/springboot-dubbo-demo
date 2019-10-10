package com.robert.dubbo.handler;

import com.robert.dubbo.base.StatusCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 将数据库中的字段自动映射到对应类的枚举属性
 *
 * @author changyuwei
 * @date 2019-10-10
 */
@MappedTypes(value = {StatusCode.class})
public class BaseEnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {

    private Class<E> type;

    public BaseEnumTypeHandler(Class<E> type) {
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            ps.setString(i, parameter.toString());
        } else {
            ps.setObject(i, parameter.name(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return get(rs.getString(columnName));
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return get(rs.getString(columnIndex));
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return get(cs.getString(columnIndex));
    }

    private <E extends Enum<E>> E get(String v) {
        if (v == null) {
            return null;
        }
        if (StringUtils.isNumeric(v)) {
            return (E) get(type, Integer.parseInt(v));
        } else {
            return (E) Enum.valueOf(type, v);
        }
    }

    private <E extends Enum<E>> E get(Class<E> type, int v) {
        Method method = null;
        E result = null;
        try {

            method = type.getMethod("get", int.class);
            result = (E)method.invoke(type, v);

        } catch (NoSuchMethodException e) {

            result = Enum.valueOf(type, String.valueOf(v));
            e.printStackTrace();

        } catch (IllegalAccessException | InvocationTargetException e) {

            e.printStackTrace();

        }

        return result;
    }
}
