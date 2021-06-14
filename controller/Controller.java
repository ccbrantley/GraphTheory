/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTheory.controller;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import GraphTheory.view.Demo;
import GraphTheory.view.ViewType;
/**
 *
 * @author t520
 */
public class Controller {
    private static Stage stage;

    private Controller (Stage _stage) { }

    public static void changeView (ViewType _viewType) {
        Controller.stage.getScene().setRoot(Controller.getView(_viewType));
        Controller.stage.getScene().getRoot().toFront();

    }

    private static Pane getView (ViewType _viewType) {
        switch (_viewType) {
            case MAIN:
                return new Demo().getParentPane();
            default:
                return new Pane();
        }
    }

    public static void setStage (Stage _stage) { Controller.stage = _stage; }

    public static Stage getStage () { return Controller.stage; }

}