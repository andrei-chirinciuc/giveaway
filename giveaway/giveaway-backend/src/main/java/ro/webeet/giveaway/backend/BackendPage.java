/**
 *
 */
package ro.webeet.giveaway.backend;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Template page for front-end application
 *
 */
public class BackendPage extends WebPage {

	private static final long serialVersionUID = -8237599408890177615L;

	public BackendPage() {
		super();
	}

	public BackendPage(IModel<?> model) {
		super(model);
	}

	public BackendPage(PageParameters parameters) {
		super(parameters);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
	}

	@Override
	protected void onAfterRender() {
		super.onAfterRender();
	}

}
