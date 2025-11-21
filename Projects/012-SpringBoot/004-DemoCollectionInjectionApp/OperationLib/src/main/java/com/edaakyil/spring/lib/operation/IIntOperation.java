package com.edaakyil.spring.lib.operation;

import java.util.function.IntBinaryOperator;

public interface IIntOperation extends IntBinaryOperator {
    boolean isValid(char op);
}
