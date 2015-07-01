# How to run
Run the solution with:
java -javaagent:/.../bin/probl2.jar ro.bmocanu.javapuzzles/iq/p2/Probl2A

# Details
I created a java agent that basically waits until the first call to the getExpensiveObject() happens,
after which it replaces the bytecode of the class with the bytecode of a class whose getter simply returns the object.
This is possible via the Instrumentation API, which java agents have access to.

Also, to have this replacement of bytecode working, the bytecode that you provide as replacement needs to have
the name of the class and generally the definition of the class identical to the one your replace.
Ergo, my search and replace of class names in the agent implementation (smile)

You have there the full program if you want to play with, including the Ant file to create the agent jar
(a special set of parameters need to be added to the jar's manifest).

For more details on the subject of Java agents, here are the links I found useful for boostrapping the programming with agents:
* http://stackoverflow.com/questions/29891221/modify-already-loaded-class-with-java-agent
* http://stackoverflow.com/questions/19850695/does-java-have-any-mechanism-for-a-vm-to-trace-method-calls-on-itself-without-u/19912148#19912148
* https://docs.newrelic.com/docs/agents/java-agent/configuration/java-agent-configuration-server-side-config
* https://blog.newrelic.com/2014/09/29/diving-bytecode-manipulation-creating-audit-log-asm-javassist/
* http://stackoverflow.com/questions/19786078/what-is-the-use-of-agentmain-method-in-java-instrumentation