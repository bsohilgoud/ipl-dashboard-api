package com.sohil.ipldashboard.userTypes;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class StringArrayType implements UserType {
    private static final int SQL_TYPE = Types.ARRAY;

    @Override
    public int[] sqlTypes() {
        return new int[]{SQL_TYPE};
    }

    @Override
    public Class returnedClass() {
        return List.class; // or List<String> if you prefer
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return (x == y) || (x != null && x.equals(y));
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
        if (resultSet.wasNull()) {
            return null;
        }

        Array array = resultSet.getArray(names[0]);
        if (array == null) {
            return null;
        }

        return List.of((String[]) array.getArray());
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, SQL_TYPE);
        } else {
            List<String> castObject = (List<String>) value;
            String[] strings = castObject.toArray(new String[0]);
            Array array = session.connection().createArrayOf("text", strings);
            st.setArray(index, array);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if (value == null) {
            return null;
        }
        return List.copyOf((List<String>) value);
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
}
