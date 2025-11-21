package com.edaakyil.spring.lib.operation.component;

import com.edaakyil.spring.lib.operation.IIntOperation;
import org.springframework.stereotype.Component;

@Component
public class MultiplyOperation implements IIntOperation {
    @Override
    public int applyAsInt(int left, int right)
    {
        return left * right;
    }

    @Override
    public boolean isValid(char op)
    {
        return op == '*' || op == 'x';
    }
}
