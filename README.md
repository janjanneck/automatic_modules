# automatic_modules

Build using ./gradlew build

Run with Java 11 or 14: java -p lib -m de.renew.pluginLoader/de.renew.pluginLoader.PluginLoader

Result is

```
java.lang.reflect.InvocationTargetException
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)
	at de.renew.pluginLoader/de.renew.pluginLoader.PluginLoader.main(PluginLoader.java:42)
Caused by: java.lang.IllegalAccessError: class de.renew.pluginA.PluginAStarter (in module de.renew.pluginA) cannot access class org.freehep.graphicsbase.util.UserProperties (in module freehep.graphicsbase) because module de.renew.pluginA does not read module freehep.graphicsbase
	at de.renew.pluginA/de.renew.pluginA.PluginAStarter.<init>(PluginAStarter.java:12)
	... 6 more
  
  ```
