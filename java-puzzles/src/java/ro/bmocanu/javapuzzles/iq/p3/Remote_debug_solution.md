In my Hole4 solution (the one with remote debug) I used the Java Debug Interface, basically doing the same thing that
an IDE (Eclipse, IDEA) does when you remote debug an application, but programatically. JDI is a nice wrapper over
the Java Debug Wire Protocol and it comes built-in in Java.

More links about this subject (which I also used for crafting the solution):
* http://wayne-adams.blogspot.ro/2011/12/examining-variables-in-jdi.html
* https://mvmn.wordpress.com/2012/10/20/debugging-remove-jvm-from-groovy-shell/
* https://youdebug.kenai.com/user-guide.html
* http://docs.oracle.com/javase/6/docs/technotes/guides/jpda/jdwp-spec.html
* http://docs.oracle.com/javase/8/docs/jdk/api/jpda/jdi/index.html
* http://blog.ioactive.com/2014/04/hacking-java-debug-wire-protocol-or-how.html

As general info, to enable JDWP in any Java application (Eclipse and IDEA are doing this automatically, behind the stage):
```
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=40000,suspend=n Main
```