package lib;

/**
 * Интерфейс для плагинов
 */
@TypeAnnotation (name="Plugins")
public interface IPlugin {
	
	@ProcessPlugin
	public String process(String str);

}