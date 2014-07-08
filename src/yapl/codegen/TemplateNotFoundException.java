package yapl.codegen;

import java.util.List;

/**
 * Exception that is thrown whenever a StringTemplate template is not found
 * @author Nicker
 *
 */
public class TemplateNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -225151621404379158L;

	private String name;

	public TemplateNotFoundException(String name, List<String> properties) {
		super(String.format("codefunction %s not found with properties %s", name, properties));
	}
}
