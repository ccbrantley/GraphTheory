/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTheory;

import GraphTheory.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import GraphTheory.view.ViewType;

/**
 *
 * @author t520
 */
public class GraphTheory extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage _stage) {
        this.setStageSettings(_stage);
        Controller.setStage(_stage);
        Controller.changeView(ViewType.MAIN);
        _stage.show();
    }

    public void setStageSettings(Stage _stage) {
        _stage.setScene(new Scene(new Pane()));
        _stage.setFullScreen(true);
        //_stage.setHeight(1440);
        //_stage.setWidth(1440);
    }

}