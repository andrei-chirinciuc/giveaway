package ro.webeet.giveaway.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends WebPage {

	private static final long serialVersionUID = -5031543042965269269L;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("label", "Hello World!"));
	}
}
