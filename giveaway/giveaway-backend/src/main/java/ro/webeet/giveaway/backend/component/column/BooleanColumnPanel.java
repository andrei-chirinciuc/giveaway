package ro.webeet.giveaway.backend.component.column;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class BooleanColumnPanel extends Panel {

	private static final long serialVersionUID = 9069598174287984814L;

	public BooleanColumnPanel(String id) {
		super(id);
	}

	public BooleanColumnPanel(String id, IModel<Boolean> model) {
		super(id, model);
	}

	@Override
	protected void onInitialize() {

		final Boolean value = (Boolean) getDefaultModelObject();
		super.onInitialize();
		final Label booleanLabel = new Label("booleanLabel", value != null && value ? "Yes" : "No");
		booleanLabel.add(AttributeModifier.append("class", value != null && value ? "green-text" : "red-text"));
		add(booleanLabel);
	}

}
