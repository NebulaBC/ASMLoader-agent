package b100;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.getProperties().putIfAbsent("b100.instrumentation", instrumentation);
    }

    public static Instrumentation getInstrumentation() {
        Instrumentation instrumentation = (Instrumentation) System.getProperties().get("b100.instrumentation");
        if(instrumentation == null) {
            throw new NullPointerException("No instrumentation instance found in system properties.");
        }
        return instrumentation;
    }

}