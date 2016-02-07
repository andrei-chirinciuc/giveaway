package ro.webeet.giveaway.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

	private static final long serialVersionUID = -5031543042965269269L;

	public HomePage() {
		super();
	}

	public HomePage(PageParameters params) {
		super(params);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("label", "Hello World!"));
	}
}
