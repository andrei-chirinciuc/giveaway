package ro.webeet.giveaway.backend.component.column;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import ro.webeet.giveaway.backend.core.component.ComponentFactory;

public abstract class EditDeleteColumnPanel<T> extends Panel {

	private static final long serialVersionUID = -691103915243000854L;

	public EditDeleteColumnPanel(String id, IModel<T> model) {
		super(id, model);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void onInitialize() {
		super.onInitialize();

		final AjaxFallbackLink<Void> editLink = ComponentFactory.newAjaxLink("editLink",
				target -> onEdit(target, (IModel<T>) getDefaultModel()));
		final AjaxFallbackLink<Void> deleteLink = ComponentFactory.newAjaxLink("deleteLink",
				target -> onDelete(target, (IModel<T>) getDefaultModel()));

		add(editLink);
		add(deleteLink);
	}

	public abstract void onEdit(final AjaxRequestTarget target, final IModel<T> iModel);

	public abstract void onDelete(final AjaxRequestTarget target, final IModel<T> model);

}
