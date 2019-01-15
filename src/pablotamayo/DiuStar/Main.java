/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pablotamayo.DiuStar;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("DiuStar");
        primaryStage.setScene(scene);
        primaryStage.show();
        //ship
        Polygon formship1 = new Polygon(new double[]{
            0, 40,
            0, 70,
            90, 60,
            90, 55});
        Polygon formship2 = new Polygon(new double[]{
            25, 50,
            25, 62,
            50, 55});
        Polygon formship3 = new Polygon(new double[]{
            10, 0,
            30, 0,
            30, 45,
            0, 45});
        Polygon formship4 = new Polygon(new double[]{
            0, 65,
            30, 65,
            30, 115,
            10, 115});
        Polygon formship5 = new Polygon(new double[]{
            15, 5,
            25, 5,
            25, 40,
            5, 40});
        Polygon formship6 = new Polygon(new double[]{
            5, 70,
            25, 70,
            25, 110,
            15, 110});
        Rectangle formship7 = new Rectangle(10, 0, 70, 5);
        Rectangle formship8 = new Rectangle(10, 110, 70, 5);
        Rectangle formship9 = new Rectangle(80, 0, 5, 5);
        Rectangle formship10 = new Rectangle(80, 110, 5, 5);
        formship1.setFill(Color.GRAY);
        formship3.setFill(Color.GRAY);
        formship4.setFill(Color.GRAY);
        formship5.setFill(Color.GRAY);
        formship5.setStroke(Color.RED);
        formship6.setFill(Color.GRAY);
        formship6.setStroke(Color.RED);
        formship9.setFill(Color.RED);
        formship10.setFill(Color.RED);
        // Grupo nave
        Group ship = new Group();
        ship.getChildren().addAll(formship1, formship2, formship3, formship4, formship5, formship6, formship7, formship8, formship9, formship10);
        root.getChildren().addAll(ship);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
