package com.edaakyil.spring.lib.operation.component;

import com.edaakyil.spring.lib.operation.IIntOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AddOperation implements IIntOperation {
    @Override
    public int applyAsInt(int left, int right)
    {
        log.warn("AddOperation::applyAsInt invoked via: {}, {}", left, right);

        return left + right;
    }

    @Override
    public boolean isValid(char op)
    {
        log.warn("AddOperation::isValid invoked via: {}", op);

        return op == '+';
    }
}
