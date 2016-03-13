package ro.webeet.giveaway.backend.core.component;

import java.io.Serializable;

import org.apache.wicket.ajax.AjaxRequestTarget;

@FunctionalInterface
public interface AjaxAction extends Serializable { // It MUST extends
													// Serializable

	public abstract void onClick(AjaxRequestTarget target);

}
