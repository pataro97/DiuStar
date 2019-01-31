/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pablotamayo.DiuStar;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.UP;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class Main extends Application {
    
    // variables asteroides
    int asteroidX;
    int asteroidX2;
    //Variables fondo
    float imageBackgroundX;
    float imageBackgroundX2 = 1199;
    //Nave eje Y
    int naveEjeY = 200;
    int naveEjeX;
    //Nave velocidad
    int velocidad;
    //Nave velocidad X
    int velocidadX;
    //Variable eje x agujero negro
    float holeX = 1200;
    //Variable eje y agujero negro
    int holeY;
    //rotacion asteroides
    int asteroidRotate1;
    //Variables meteorito posicion x
    int meteor1X = 1200;
    //Variables meteorito posicion Y
    int meteor1Y;
    //resta o suma aleatoria eje Y meteorito
    int ramdomMeteor1Y;
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1200, 600);
        primaryStage.setTitle("DiuStar");
        primaryStage.setScene(scene);
        primaryStage.show();
        //Generar numero aleatorio
        Random generadorNum = new Random();
        //-----------------------------------------------------------------------------imagenes----------
        //Agujero negro
        Image hole = new Image(getClass().getResourceAsStream("imagenes/a.gif"));
        ImageView hole1 = new ImageView(hole);
        hole1.setFitHeight(300);
        hole1.setFitWidth(300);
        //posicion aleatoria inicio agujero
        holeY = generadorNum.nextInt(399)+1;
        //posicion aleatoria inicio meteorito
        meteor1Y = generadorNum.nextInt(300)+100;
        //Numero aleatorio ente 0 y 1 para eje Y asteroide
        ramdomMeteor1Y = generadorNum.nextInt(2);
        //Meteorito tipo 1
        Image meteor = new Image(getClass().getResourceAsStream("imagenes/meteor.png"));
        ImageView meteor1 = new ImageView(meteor);
        meteor1.setFitHeight(50);
        meteor1.setFitWidth(50);
        //meteorito tipo 2
        Image meteor2 = new Image(getClass().getResourceAsStream("imagenes/meteor2.png"));
        ImageView meteor3 = new ImageView(meteor2);
        meteor3.setFitHeight(50);
        meteor3.setFitWidth(50);
        //Meteorito tipo 3
        Image meteor4 = new Image(getClass().getResourceAsStream("imagenes/meteor3.png"));
        ImageView meteor5 = new ImageView(meteor4);
        meteor5.setFitHeight(50);
        meteor5.setFitWidth(50);
        //Imagen fondo
        Image image1 = new Image(getClass().getResourceAsStream("imagenes/fondo.gif"));
        ImageView imageBackground = new ImageView(image1);
        imageBackground.setFitHeight(600);
        imageBackground.setFitWidth(1200);
        //Imagen fondo2
        Image image2 = new Image(getClass().getResourceAsStream("imagenes/fondo2.gif"));
        ImageView imageBackground2 = new ImageView(image2);
        imageBackground2.setFitHeight(600);
        imageBackground2.setFitWidth(1200);
        //Asteroide imagen
        Image asteroid = new Image(getClass().getResourceAsStream("imagenes/asteroid1.png"));
        ImageView asteroid1 = new ImageView(asteroid);
        asteroid1.setFitHeight(600);
        asteroid1.setFitWidth(1201);
        //Asteroide imagen2
        Image asteroid3 = new Image(getClass().getResourceAsStream("imagenes/asteroid2.png"));
        ImageView asteroid2 = new ImageView(asteroid3);
        asteroid2.setFitHeight(600);
        asteroid2.setFitWidth(1201);
        //-----------------------------------------------------Formas-------------------------------------
        //rectangulo choque asteroides
        Rectangle asteroidTop = new Rectangle(1200, 95);
        //rectangulo choque asteroides
        Rectangle asteroidDown = new Rectangle(1200, 95);
        asteroidDown.setLayoutY(515);
        //forma choque nave
        Polygon formGlobal = new Polygon(new double[]{
            0, 0,
            90, 0,
            90, 5,
            35, 5,
            35, 40,
            90, 60,
            35, 70,
            35, 110,
            90, 110,
            90, 115,
            0, 115});
        //Forma nave
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
        //Visibilidad formas choque
        formGlobal.setVisible(false);
        asteroidTop.setVisible(false);
        asteroidDown.setVisible(false);
        // Grupo nave
        Group ship = new Group();
        ship.getChildren().addAll(formGlobal, formship1, formship2, formship3, formship4, formship5, formship6, formship7, formship8, formship9, formship10);
        // Tamaño nave
        ship.setScaleX(0.7);
        ship.setScaleY(0.7);
        //-------------------------------------------------------------------------------------------------texto
        Text perdido = new Text("Destruido");
        perdido.setFont(Font.font(100));
        perdido.setX(400);
        perdido.setY(250);
        perdido.setFill(Color.RED);
        //-------------------------------------------------------------------------Animaciones-----------
        // Movimiento asteroides
            //Animacion asteroides
            AnimationTimer animationAsteroid = new AnimationTimer(){
              @Override
              public void handle(long now){
                  asteroid1.setX(asteroidX);
                  // if movimiento asteroides fondo 1
                  if (asteroidX == 0){
                      asteroidX2 = 1200;
                      asteroidX--;
                  }else{
                      asteroidX--;
                  };
                  asteroid2.setX(asteroidX2);
                  //if movimiento asteroides fondo 2
                if (asteroidX2 == 0) {
                    asteroidX = 1200;
                    asteroidX2--;
                  }else{
                  asteroidX2--;
                };
              };
            };
            
        //Background animation
            AnimationTimer animationImageBackground = new AnimationTimer(){
                @Override
                public void handle(long now){
                    imageBackground.setX(imageBackgroundX);
                    //if movimiento fondo
                    if (imageBackgroundX < 0.1 && imageBackgroundX > 0){
                        imageBackgroundX2 = 1199;
                        imageBackgroundX -= 0.1;
                    }else{
                        imageBackgroundX -= 0.1;
                    };
                    imageBackground2.setX(imageBackgroundX2);
                    //if movimiento fondo
                    if (imageBackgroundX2 < 0.1 && imageBackgroundX2 > 0){
                        imageBackgroundX = 1199;
                        imageBackgroundX2 -= 0.1;
                    }else{
                        imageBackgroundX2 -= 0.1 ;
                    };
                };
            };
            
            //Agujero negro animación
             AnimationTimer animationHole = new AnimationTimer(){
                @Override
                public void handle(long now){
                    hole1.setX(holeX);
                    //movimient x agujero negro
                    if (holeX == -300){
                        holeX = 1200;
                        //Posición aleatoria eje Y agujero negro
                        holeY = generadorNum.nextInt(399)+1;
                        hole1.setY(holeY);
                    }else{
                        holeX-=0.5;
                    };
                };
            };
         //Animación nave movimiento eje Y
        AnimationTimer animationShip = new AnimationTimer(){
            @Override
            public void handle(long now){
                //suma de velocidad al eje Y de la nave
                naveEjeY = naveEjeY + velocidad;
                naveEjeX = naveEjeX + velocidadX;
                ship.setLayoutY(naveEjeY);
                ship.setLayoutX(naveEjeX);
            };
        };
//        //Animacion choque asteroides bordes
        AnimationTimer animationColision = new AnimationTimer(){
                @Override
                public void handle(long now){
                    //Colision asteroides arriba
                    Shape shapeAsteroid1 = Shape.intersect(formGlobal, asteroidTop);
                    boolean colisionTop = shapeAsteroid1.getBoundsInLocal().isEmpty();
                    if (colisionTop == false){
                      root.getChildren().addAll(perdido);
                      animationShip.stop();
                    };
                    //Colision asteroides abajo
                    Shape shapeAsteroid2 = Shape.intersect(formGlobal, asteroidDown);
                    boolean colisionDown = shapeAsteroid2.getBoundsInLocal().isEmpty();
                    if (colisionDown == false){
                      root.getChildren().addAll(perdido);
                      animationShip.stop();
                    };
                };
            };
        AnimationTimer asteroiAnimation = new AnimationTimer(){
            @Override
                public void handle(long now){
                    //Animaciones giro asteroides
                    asteroidRotate1++;
                    meteor1.setRotate(asteroidRotate1);
                    meteor3.setRotate(asteroidRotate1);
                    meteor5.setRotate(asteroidRotate1);
                    //animación meteorito movimiento, aleatoriedad en eje Y y rebote
                    //animacion en posición x
                    if (meteor1X < -50){
                        meteor1X = 1200;
                        //posicion aleatoria en pantalla eje Y entre 100 y 400
                        meteor1Y = generadorNum.nextInt(300)+100;
                        //Numero aleatorio ente 0 y 1 para 
                        ramdomMeteor1Y = generadorNum.nextInt(2);
                        
                    }else{
                        meteor1X -= 2;
                        //Resta o suma dependiendo del numero aleatorio
                        if (ramdomMeteor1Y == 1){
                            meteor1Y -= 2;
                        }else{
                            meteor1Y += 2;
                        };
                    }
                    meteor1.setLayoutX(meteor1X);
                    meteor1.setY(meteor1Y);
                    
                };
        };
        //------------------------------------------------------------------Controles--------------------
        //Control nave pulsa tecla
        scene.setOnKeyPressed((KeyEvent pulsatecla) -> {
           switch(pulsatecla.getCode()) {
               case UP:
                   //Pulsa tecla arriba
                   velocidad = -5;
               break;
               case DOWN:
                   //Pulsa tecla abajo
                   velocidad = 5;
               break;
               case LEFT:
                   //Pulsa tecla izquierda
                   velocidadX = -5;
               break;
               case RIGHT:
                   //Pulsa tecla derecha
                   velocidadX = 5;
           }
        });
        //Control nave no pulsa tecla
        scene.setOnKeyReleased((KeyEvent) -> {
            velocidad = 0;
        });
        root.getChildren().addAll(imageBackground, imageBackground2, asteroidTop, asteroidDown, ship, hole1, asteroid1, asteroid2, meteor5, meteor3, meteor1);
        animationAsteroid.start();
        animationImageBackground.start();
        animationShip.start();
        animationHole.start();
        animationColision.start();
        asteroiAnimation.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
