package com.edaakyil.spring.lib.operation.component;

import com.edaakyil.spring.lib.operation.IIntOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AddWithValueOperation implements IIntOperation {
    @Value("${com.edaakyil.operation.value:0}")
    private int m_value;

    @Override
    public int applyAsInt(int left, int right)
    {
        return left + right + m_value;
    }

    @Override
    public boolean isValid(char op)
    {
        return op == '+';
    }
}
