package ro.webeet.giveaway.backend.component.repeater;

import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.OddEvenItem;
import org.apache.wicket.model.IModel;

public class SimpleDataTable<T, S> extends DataTable<T, S> {

	private static final long serialVersionUID = 1597279559351023217L;

	public SimpleDataTable(final String id, final List<? extends IColumn<T, S>> columns,
			final ISortableDataProvider<T, S> dataProvider, final int rowsPerPage) {
		super(id, columns, dataProvider, rowsPerPage);

		addTopToolbar(new HeadersToolbar<>(this, dataProvider));
	}

	@Override
	protected Item<T> newRowItem(final String id, final int index, final IModel<T> model) {
		return new OddEvenItem<>(id, index, model);
	}


}
