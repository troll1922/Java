package lib;

/**
 * Интерфейс для плагинов
 */
@TypeAnnotation (name="Plugins")
public interface IPlugin {
	
	@InitPlugin
	public void init();
	
	@ProcessPlugin
	public void process(String str);
	
	@DestroyPlugin
	public void destroy();
}