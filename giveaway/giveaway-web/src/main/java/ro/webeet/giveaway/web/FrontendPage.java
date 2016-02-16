/**
 *
 */
package ro.webeet.giveaway.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Template page for front-end application
 *
 */
public class FrontendPage extends WebPage {

	private static final long serialVersionUID = -8237599408890177615L;

	public FrontendPage() {
		super();
	}

	public FrontendPage(IModel<?> model) {
		super(model);
	}

	public FrontendPage(PageParameters parameters) {
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
