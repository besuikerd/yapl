package yapl.tool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainRunner {
	private static MainRunner instance;
	
	private URLClassLoader loader;
	
	private Map<String, Class<?>> loadedClasses;

	private MainRunner(){
		loadedClasses = new HashMap<String, Class<?>>();
		this.loader = new URLClassLoader(new URL[0]);
	}
	
	public static MainRunner getInstance(){
		if(instance == null){
			instance = new MainRunner();
		}
		return instance;
	}
	
	public void addToClassPath(String path) throws MalformedURLException{
		path = "file://" + path.replaceAll("\\\\", "/");
		if(!path.endsWith("/")) path = path + "/";
		System.out.println(path);
		this.loader = URLClassLoader.newInstance(new URL[]{new URL(path)}, loader);
	}
	
	public void tryMain(String cls) throws ExecutionException, ClassFunctionException{
		tryMain(cls, new String[0]);
	}
	
	public void tryMain(String cls, String... args) throws ExecutionException, ClassFunctionException{
		tryStatic(cls, "main", (Object) args);
	}
	
	public void tryStatic(String className, String method, Object... args) throws ExecutionException, ClassFunctionException{
		Class<?> cls = loadedClasses.get(className);
		if(cls == null){
			try {
				cls = loader.loadClass(className);
			} catch (ClassNotFoundException e) {
				
				throw new ClassFunctionException("class not found: " + e.getMessage());
			}
			loadedClasses.put(className, cls);
		}
		if(cls != null){
			Class<?>[] classes = Arrays.stream(args).map((arg) -> arg.getClass()).toArray(Class<?>[]::new);
			Method m;
			try {
				m = cls.getMethod(method, classes);
			} catch (NoSuchMethodException | SecurityException e) {
				throw new ClassFunctionException(e.getMessage());
			}
			if(m != null){
				try {
					m.invoke(cls, args);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					throw new ClassFunctionException(e.getMessage());
				}
			}
		}
	}
}
