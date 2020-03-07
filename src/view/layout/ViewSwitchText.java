package view.layout;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewSwitchText extends HBox {
    private final ResourceBundle resources;
    private Text historySwitchText;
    private Text referenceSwitchText;
    private Text variableSwitchText;
    private Text librarySwitchText;
    private Text customizationSwitchText;
    private List<Text> linksList;

    public ViewSwitchText(ResourceBundle resources) {
        this.resources = resources;
        this.linksList = new ArrayList<>();
        createAndAddLinks();
        getStyleClass().add("tabbox");
    }
    private void createAndAddLinks() {
        historySwitchText = new Text(resources.getString("HistoryWindow"));
        referenceSwitchText = new Text(resources.getString("CommandWindow"));
        variableSwitchText = new Text(resources.getString("VariableWindow"));
        librarySwitchText = new Text(resources.getString("LibraryWindow"));
        customizationSwitchText = new Text(resources.getString("CustomizationWindow"));
        linksList.add(historySwitchText);
        linksList.add(referenceSwitchText);
        linksList.add(variableSwitchText);
        linksList.add(librarySwitchText);
        linksList.add(customizationSwitchText);
        this.getChildren().add(historySwitchText);
        this.getChildren().add(referenceSwitchText);
        this.getChildren().add(variableSwitchText);
        this.getChildren().add(librarySwitchText);
        this.getChildren().add(customizationSwitchText);
        addHyperLinkFunction();
    }
    private void addHyperLinkFunction() {
        for (Text link : linksList) {
            link.setOnMouseEntered(event -> animateLink(link));
            link.setOnMouseExited(event -> removeUnderline(link));
            link.getStyleClass().add("tabtext");
        }
    }
    private void animateLink(Text link) {
        link.setUnderline(true);
    }
    private void removeUnderline(Text link) {
        link.setUnderline(false);
    }
    public void updateLanguage(ResourceBundle updatedResources) {
        historySwitchText.setText(updatedResources.getString("HistoryWindow"));
        referenceSwitchText.setText(updatedResources.getString("CommandWindow"));
        variableSwitchText.setText(updatedResources.getString("VariableWindow"));
        librarySwitchText.setText(updatedResources.getString("LibraryWindow"));
        customizationSwitchText.setText(updatedResources.getString("CustomizationWindow"));
    }
    public Node getHistoryTab() {
        return this.historySwitchText;
    }
    public Node getReferenceTab() {
        return this.referenceSwitchText;
    }
    public Node getVariableTab() {
        return this.variableSwitchText;
    }
    public Node getLibraryTab() {
        return this.librarySwitchText;
    }
    public Node getCustomizationTab() {
        return this.customizationSwitchText;
    }

}
