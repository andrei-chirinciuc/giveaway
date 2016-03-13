package ro.webeet.giveaway.backend.core.component;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;

@SuppressWarnings("serial")
public class ComponentFactory {

	/**
	 * Creates an ajax link.
	 *
	 * @param wicketId
	 *            the wicket id
	 * @param action
	 *            lambda to handle the event
	 *
	 * @return
	 */
	public static AjaxFallbackLink<Void> newAjaxLink(String wicketId, AjaxAction action) {
		final AjaxFallbackLink<Void> link = new AjaxFallbackLink<Void>(wicketId) {
			@Override
			public void onClick(AjaxRequestTarget target) {
				action.onClick(target);
			}
		};
		return link;
	}

}
