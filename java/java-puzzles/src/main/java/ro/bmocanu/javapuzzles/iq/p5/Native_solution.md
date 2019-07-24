#Java Native Interface solution

For the JNI solution I chose to implement a native method in C, that is called from Java and that has access to the
char array that backs up the "risk" string. This way, even though Java strings are immutable, I can still change
the chars behind the string.

Caveats:
* the DLLs are embedded (and zipped) in Main.java, and are extracted and dynamically linked at runtime (using System.loadLibrary())
* the solution contains the DLLs only for Windows (32bit and 64bit) and VCRedist 2013 needs to be present (in Windows 7
  with latest updated and Windows 8 usually is)
* in C file, the env->GetStringCritical() MIGHT return a copy of the actual char array. It depends on the JVM. In my
  tests always returned the actual char array (so I was able to change it). If it returns a copy, I am busted. Other
  methods provided (env->GetStringChars(), env->GetStringUTFChars()...) all returned a copy to me.
* a Main.dll file remains behind, in the root of the start directory. For the moment I haven't found a viable solution
  to remove this file, since it is dynamically linked at runtime and cannot be deleted until the process is terminated
  (so I could start another Java process, that waits for the current one to terminate, and then deletes the file...)
* I compiled the DLLs using Visual Studio 2015 RC

Below one can find some useful links on this topic:
* Sheng Liang - The Java Native Interface: Programmer’s Guide and Specification (https://www.fer.unizg.hr/_download/repository/jni.pdf) (pag 32)
* http://www.gamasutra.com/view/feature/3347/dirty_java_using_the_java_native_.php?print=1
* https://newcircle.com/bookshelf/java_fundamentals_tutorial/_java_native_interface_jni
* http://www.java-gaming.org/index.php/topic,21036.
* http://www.javaworld.com/article/2077513/learn-java/java-tip-17--integrating-java-with-c--.html
