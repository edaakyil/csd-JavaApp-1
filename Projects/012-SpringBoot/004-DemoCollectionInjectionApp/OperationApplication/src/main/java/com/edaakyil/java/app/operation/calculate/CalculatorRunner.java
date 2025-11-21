package com.edaakyil.java.app.operation.calculate;

import com.edaakyil.spring.lib.operation.IIntOperation;
import com.karandev.io.util.console.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import static com.edaakyil.spring.lib.datetime.constant.BeanName.DATETIME_FORMATTER_TR_BEAN;
import static com.edaakyil.spring.lib.datetime.constant.BeanName.LOCAL_CURRENT_DATETIME_BEAN;

@Component
public class CalculatorRunner implements ApplicationRunner {
    private final LocalDateTime m_currentDateTime;
    private final DateTimeFormatter m_dateTimeFormatter;
    private final Collection<IIntOperation> m_operations;

    public CalculatorRunner(@Qualifier(LOCAL_CURRENT_DATETIME_BEAN) LocalDateTime currentDateTime,
                            @Qualifier(DATETIME_FORMATTER_TR_BEAN) DateTimeFormatter dateTimeFormatter,
                            // IIntOperation arayüzünü implemente eden bütün bean'leri Collection'a enjekte ediyor
                            Collection<IIntOperation> operations)
    {
        m_operations = operations;
        m_currentDateTime = currentDateTime;
        m_dateTimeFormatter = dateTimeFormatter;
    }

    @Override
    public void run(ApplicationArguments args)
    {
        try {
            var operatorValue = args.getOptionValues("operator");
            var leftOptionValue = args.getOptionValues("left");
            var rightOptionValue = args.getOptionValues("right");
            var a = leftOptionValue != null ? Integer.parseInt(leftOptionValue.get(0)) : 67;
            var b = rightOptionValue != null ? Integer.parseInt(rightOptionValue.get(0)) : 67;
            char op = '+';

            if (operatorValue != null && operatorValue.size() == 1)
                op = operatorValue.get(0).charAt(0);

            char operator = op;
            var operations = m_operations.stream().filter(io -> io.isValid(operator)).toList();

            Console.writeLine("Current date time: %s", m_currentDateTime.format(m_dateTimeFormatter));

            if (!operations.isEmpty())
                operations.forEach(o -> Console.writeLine("%d %c %d = %d", a, operator, b, o.applyAsInt(a, b)));
            else
                Console.writeLine("Unsupported operation!...");

        } catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid values!...");
        } catch (Throwable ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
        }
    }
}
