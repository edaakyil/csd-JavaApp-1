package com.edaakyil.java.app.component.runner;

import com.karandev.io.util.console.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {
    private void optionValues(ApplicationArguments args, String name)
    {
        Console.write("%s ->", name);
        args.getOptionValues(name).forEach(v -> Console.writeLine("\t%s", v));
    }

    @Override
    public void run(ApplicationArguments args)
    {
        Console.writeLine("Component ApplicationRunner");

        Console.writeLine("Option arguments:");
        args.getOptionNames().forEach(n -> optionValues(args, n));

        Console.writeLine("Non-Option arguments:");
        args.getNonOptionArgs().forEach(Console::writeLine);

    }
}

// option arguments --> Spring'in komutsatırı argümanı veriliş biçimi (-- ile verilen biçim)
// non-option arguments --> Normal komutsatırı argümanları

/*
* > java -jar .\ApplicationRunnerApp-1.0.0.jar fatih zeynep ahmet "mehmet sena" --eda="neslihan akyıl" --cevriye=muammer
* veya
* > java -jar .\ApplicationRunnerApp-1.0.0.jar --eda="neslihan akyıl" --cevriye=muammer fatih zeynep ahmet "mehmet sena"
*
* option arguments:
*   --eda=neslihan akyıl"
*   --cevriye=muammer
*
* non-option arguments:
*   fatih
*   zeynep
*   ahmet
*   "mehmet sena"
*
 */
