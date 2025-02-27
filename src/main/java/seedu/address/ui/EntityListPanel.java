package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.entity.Entity;

/**
 * Panel containing the list of persons.
 */
public class EntityListPanel extends UiPart<Region> {

    private static final String FXML = "EntityListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(EntityListPanel.class);

    @FXML
    private ListView<Entity> entityListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public EntityListPanel(ObservableList<Entity> entityList) {
        super(FXML);
        entityListView.setItems(entityList);
        entityListView.setCellFactory(listView -> new EntityListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class EntityListViewCell extends ListCell<Entity> {

        @Override
        protected void updateItem(Entity entity, boolean empty) {
            super.updateItem(entity, empty);

            if (empty || entity == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new EntityCard(entity, getIndex() + 1).getRoot());
            }
        }
    }

}
