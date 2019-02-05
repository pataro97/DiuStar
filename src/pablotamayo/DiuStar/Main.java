/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pablotamayo.DiuStar;

import java.io.File;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
    //-----------------------------------Variables Nave
    //Nave eje Y
    int naveEjeY = 200;
    int naveEjeX;
    //Nave velocidad
    int velocidad;
    //Nave velocidad X
    int velocidadX;
    //-----------------------------Variables nave enemiga
    int enemyShipY = 250;
    int enemyShipY1 = 0;
    int enemyShipX = 1200;
    //Disparo
    int enemyShotY;
    int enemyShotX;
    int visibleShot;
    int enemyShotYEstado;
    int ramdomEnemyShot;
    //------------------------------Variables agujero negro
    //Variable eje x agujero negro
    float holeX = 1200;
    //Variable eje y agujero negro
    int holeY;
    //rotacion asteroides
    int asteroidRotate1;
    //---------------------------------------Variables meteorito 1
    //Variable meteorito posicion x
    int meteor1X = 1200;
    //Variable meteorito posicion Y
    int meteor1Y;
    //resta o suma aleatoria eje Y meteorito
    int ramdomMeteor1Y;
    //---------------------------------------Variables meteorito 2
    //Variable meteorito posicion x
    int meteor2X = 1200;
    //Variable meteorito posicion Y
    int meteor2Y;
    //resta o suma aleatoria eje Y meteorito
    //velocidad
    int ramdomMeteor2Y;
    int velocidadMeteorid2;
    //---------------------------------------Variables meteorito 3
    //Variable meteorito posicion x
    int meteor3X = 1200;
    //Variable meteorito posicion Y
    int meteor3Y;
    //resta o suma aleatoria eje Y meteorito
    //velocidad
    int ramdomMeteor3Y;
    int velocidadMeteorid3;
    //Score
    int score;
    int marcador;
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1200, 600);
        primaryStage.setTitle("DiuStar");
        primaryStage.setScene(scene);
        primaryStage.show();
        //Generar numero aleatorio
        Random generadorNum = new Random();
        //posicion aleatoria inicio agujero
        holeY = generadorNum.nextInt(300)+100;
        //Numero aleatorio ente 0 y 2 para eje Y asteroide---------- 1
        ramdomMeteor1Y = generadorNum.nextInt(3);
        //posicion aleatoria inicio meteorito
        meteor1Y = generadorNum.nextInt(300)+100;
        //Numero aleatorio ente 0 y 2 para eje Y asteroide---------- 2
        ramdomMeteor2Y = generadorNum.nextInt(3);
        //posicion aleatoria inicio meteorito
        meteor2Y = generadorNum.nextInt(300)+100;
        //Velocidad aleatoria de inicio asteroide 2
        velocidadMeteorid2 = generadorNum.nextInt(3)+1;
        //Numero aleatorio ente 0 y 2 para eje Y asteroide---------- 3
        ramdomMeteor3Y = generadorNum.nextInt(3);
        //posicion aleatoria inicio meteorito
        meteor3Y = generadorNum.nextInt(300)+100;
        //Velocidad aleatoria de inicio asteroide 3
        velocidadMeteorid3 = generadorNum.nextInt(3)+1;
        //-----------------------------------------------------------------------------imagenes----------
        //Agujero negro
        Image hole = new Image(getClass().getResourceAsStream("imagenes/hole.gif"));
        ImageView hole1 = new ImageView(hole);
        hole1.setFitHeight(300);
        hole1.setFitWidth(300);
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
        //Asteroide explosion
        Image explosion = new Image(getClass().getResourceAsStream("imagenes/explosion.png"));
        ImageView explosion2 = new ImageView(explosion);
        explosion2.setFitHeight(100);
        explosion2.setFitWidth(100);
        //Enemy Ship
        Image enemy = new Image(getClass().getResourceAsStream("imagenes/enemyship.png"));
        ImageView enemyShipImg = new ImageView(enemy);
        enemyShipImg.setFitHeight(70);
        enemyShipImg.setFitWidth(70);
        //-----------------------------------------------------Formas-------------------------------------
        //Disparos nave enemiga
        Rectangle enemyShot = new Rectangle(50, 10);
        //rectangulo choque asteroides
        Rectangle asteroidTop = new Rectangle(1200, 95);
        //rectangulo choque asteroides
        Rectangle asteroidDown = new Rectangle(1200, 95);
        //Limite izquierda
        Line limitLeft = new Line(0, 0, 0, 600);
        //Limite izquierda
        Line limitRight = new Line(1200, 0, 1200, 600);
        asteroidDown.setLayoutY(515);
        //circulo asteroide choque
        Circle circleMeteor1 = new Circle(30, 25, 20);
        //circulo asteroide 2 choque
        Circle circleMeteor2 = new Circle(30, 25, 20);
        //circulo asteroide 3 choque
        Circle circleMeteor3 = new Circle(30, 25, 20);
        //circulo agujero absorcion
        Circle holeCircle = new Circle(150, 150, 200);
        //circulo agujero choque centro
        Circle holeCircleCenter = new Circle(150, 150, 40);
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
        //forma choque nave enemiga
        Polygon formGlobalEnemy = new Polygon(new double[]{
            70, 0,
            0, 0,
            0, 5,
            35, 15,
            35, 30,
            0, 35,
            35, 50,
            35, 60,
            0, 65,
            0, 70,
            70, 70});
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
        //Color disparo enemigo
        enemyShot.setFill(Color.GREEN);
        //Visibilidad formas choque
        formGlobal.setVisible(false);
        asteroidTop.setVisible(false);
        asteroidDown.setVisible(false);
        circleMeteor1.setVisible(false);
        circleMeteor2.setVisible(false);
        circleMeteor3.setVisible(false);
        explosion2.setVisible(false);
        holeCircle.setVisible(false);
        holeCircleCenter.setVisible(false);
        formGlobalEnemy.setVisible(false);
        enemyShot.setVisible(false);
        //Grupo asteroide 1
        Group meteorColision1 = new Group();
        meteorColision1.getChildren().addAll(circleMeteor1, meteor1);
        //Grupo asteroide 2
        Group meteorColision2 = new Group();
        meteorColision2.getChildren().addAll(circleMeteor2, meteor3);
        //Grupo asteroide 3
        Group meteorColision3 = new Group();
        meteorColision3.getChildren().addAll(circleMeteor3, meteor5);
        //Grupo agujero
        Group holeColision = new Group();
        holeColision.getChildren().addAll(holeCircle, hole1, holeCircleCenter);
        //Grupo Nave Enemiga
        Group enemyShip = new Group();
        enemyShip.getChildren().addAll(enemyShot, formGlobalEnemy, enemyShipImg);
        // Grupo nave
        Group ship = new Group();
        ship.getChildren().addAll(formGlobal, formship1, formship2, formship3, formship4, formship5, formship6, formship7, formship8, formship9, formship10, explosion2);
        // Tamaño nave
        ship.setScaleX(0.7);
        ship.setScaleY(0.7);
        //-------------------------------------------------------------------------------------------------texto
        Text perdido = new Text("Game Over");
        perdido.setFont(Font.font(100));
        perdido.setX(400);
        perdido.setY(250);
        perdido.setFill(Color.RED);
        //Texto
        Text marcadorScore = new Text("Score: ");
        marcadorScore.setFont(Font.font(50));
        marcadorScore.setY(50);
        marcadorScore.setFill(Color.RED);
        //Marcador
        Text marcadorText = new Text("0");
        marcadorText.setFont(Font.font(50));
        marcadorText.setY(50);
        marcadorText.setX(150);
        marcadorText.setFill(Color.RED);
        //Música
        Media media = new Media(getClass().getResource("sounds/sound.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        //------------------------------------------Musica Juego
        mediaPlayer.play();
        //Música explosion
        Media mediaex = new Media(getClass().getResource("sounds/explosion.mp3").toExternalForm());
        MediaPlayer mediaPlayerEx = new MediaPlayer(mediaex);
        
        
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
                    //-------------------------
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
            //Animación nave movimiento
            AnimationTimer animationShip = new AnimationTimer(){
                @Override
                public void handle(long now){
                    //suma de velocidad al eje Y de la nave
                    naveEjeY = naveEjeY + velocidad;
                    naveEjeX = naveEjeX + velocidadX;
                    ship.setLayoutY(naveEjeY);
                    ship.setLayoutX(naveEjeX);
                    //Marcador-------------------
                    marcador ++;
                    marcadorText.setText(String.valueOf(marcador));
                };
                
            };
            //Agujero negro animación
             AnimationTimer animationHole = new AnimationTimer(){
                @Override
                public void handle(long now){
                    holeColision.setLayoutX(holeX);
                    //movimient x agujero negro
                    if (holeX == -300){
                        holeX = 1200;
                        //Posición aleatoria eje Y agujero negro
                        holeY = generadorNum.nextInt(300)+100;
                        
                        
                    }else{
                        holeX-=0.5;
                    };
                    holeColision.setLayoutY(holeY);
                    //Absorcion agujero negro eje Y
                    Shape shapeHole = Shape.intersect(formGlobal, holeCircle);
                    boolean abHole = shapeHole.getBoundsInLocal().isEmpty();
                    if (abHole == false){
                      if(naveEjeY > holeY +100){
                          naveEjeY--;
                      }else{
                          naveEjeY++;
                      };
                    };
                    //Absorcion agujero negro eje X
                    Shape shapeHoleX = Shape.intersect(formGlobal, holeCircle);
                    boolean abHoleX = shapeHoleX.getBoundsInLocal().isEmpty();
                    if (abHoleX == false){
                      if(naveEjeX > holeX -100){
                          naveEjeX--;
                      }else{
                          naveEjeX++;
                      };
                    };
                    //Choque centro agujero negro eje Y
                    Shape shapeHoleC = Shape.intersect(formGlobal, holeCircleCenter);
                    boolean centerHole = shapeHoleC.getBoundsInLocal().isEmpty();
                    if (centerHole == false){
                        root.getChildren().addAll(perdido);
                        animationShip.stop();
                        animationAsteroid.stop();
                        animationImageBackground.stop();
                        //------------------------------------------Parar Musica
                        mediaPlayer.stop();
                        this.stop();
                    };
                };
            };
         
        //Animacion choque asteroides y bordes
        AnimationTimer animationColision = new AnimationTimer(){
                @Override
                public void handle(long now){
                    //Colision asteroides arriba
                    Shape shapeAsteroid1 = Shape.intersect(formGlobal, asteroidTop);
                    boolean colisionTop = shapeAsteroid1.getBoundsInLocal().isEmpty();
                    if (colisionTop == false){
                        root.getChildren().addAll(perdido);
                        explosion2.setVisible(true);
                        animationShip.stop();
                        animationAsteroid.stop();
                        animationImageBackground.stop();
                        animationHole.stop();
                        //------------------------------------------Parar Musica
                        mediaPlayer.stop();
                        //Explosion
                        mediaPlayerEx.play();
                        this.stop();
                    };
                    //Colision asteroides abajo
                    Shape shapeAsteroid2 = Shape.intersect(formGlobal, asteroidDown);
                    boolean colisionDown = shapeAsteroid2.getBoundsInLocal().isEmpty();
                    if (colisionDown == false){
                        root.getChildren().addAll(perdido);
                        explosion2.setVisible(true);
                        animationShip.stop();
                        animationAsteroid.stop();
                        animationImageBackground.stop();
                        animationHole.stop();
                        //------------------------------------------Parar Musica
                        mediaPlayer.stop();
                        //Explosion
                        mediaPlayerEx.play();
                        this.stop();
                    };
                    //Limite izquierda
                    Shape shapeLine = Shape.intersect(formGlobal, limitLeft);
                    boolean limitL = shapeLine.getBoundsInLocal().isEmpty();
                    if (limitL == false){
                      velocidadX = 0;
                    };
                    //Limite derecha
                    Shape shapeLine2 = Shape.intersect(formGlobal, limitRight);
                    boolean limitR = shapeLine2.getBoundsInLocal().isEmpty();
                    if (limitR == false){
                      velocidadX = 0;
                    };
                };
            };
        //Nave Enemiga animación
            AnimationTimer animationEnemyShip = new AnimationTimer(){
                @Override
                public void handle(long now){
                    //Nave enemiga eje X
                    if (enemyShipX < -70){
                        enemyShipX = 1200;
                    }else{
                        enemyShipX--;
                    };
                    //Nave enemiga eje Y
                    if(enemyShipY < 100){
                        enemyShipY1 = 0;
                        enemyShotYEstado = 0;
                        
                    }else{
                        if(enemyShipY > 430){
                            enemyShipY1 = 1;
                            enemyShotYEstado = 1;
                            //Cuando Toque abajo genera un numero aleatorio para disparo
                            ramdomEnemyShot = generadorNum.nextInt(300)+100;
                        };
                    };
                    if (enemyShipY1 == 0){
                        enemyShipY++;
                    }else{
                        enemyShipY--;
                    };
                    enemyShip.setLayoutX(enemyShipX);
                    enemyShip.setLayoutY(enemyShipY);
                    //--------------------------------colisión nave enemiga
                    Shape shapeEnemy = Shape.intersect(formGlobal, formGlobalEnemy);
                    boolean enemyColision = shapeEnemy.getBoundsInLocal().isEmpty();
                    if (enemyColision == false){
                      root.getChildren().addAll(perdido);
                      explosion2.setVisible(true);
                      animationShip.stop();
                        animationAsteroid.stop();
                        animationImageBackground.stop();
                        animationHole.stop();
                        animationColision.stop();
                        //------------------------------------------Parar Musica
                        mediaPlayer.stop();
                        //Explosion
                        mediaPlayerEx.play();
                        this.stop();
                    };
                    //--------------------------------colisión tiro nave enemiga
                    Shape shapeShot = Shape.intersect(formGlobal, enemyShot);
                    boolean enemyShotA = shapeShot.getBoundsInLocal().isEmpty();
                    if (enemyShotA == false){
                      root.getChildren().addAll(perdido);
                      explosion2.setVisible(true);
                      animationShip.stop();
                        animationImageBackground.stop();
                        animationHole.stop();
                        animationColision.stop();
                        //------------------------------------------Parar Musica
                        mediaPlayer.stop();
                        //Explosion
                        mediaPlayerEx.play();
                        this.stop();
                    };
                    //------------------------------------Disparo
                    if(enemyShipY == ramdomEnemyShot){
                        enemyShot.setVisible(true);
                        visibleShot = 1;
                    };
                    if(visibleShot == 1){
                        if (enemyShotYEstado ==0){
                            enemyShotY--;
                        } else{
                            enemyShotY++;
                        };
                    enemyShotX = enemyShotX -5;
                    };
                    if(enemyShotX < -1200){
                        enemyShot.setVisible(false);
                        visibleShot = 0;
                        enemyShotY = 0;
                        enemyShotX = 0;
                    };
                    enemyShot.setLayoutX(enemyShotX);
                    enemyShot.setLayoutY(enemyShotY);
                    
                };
            };
        AnimationTimer asteroiAnimation = new AnimationTimer(){
            @Override
                public void handle(long now){
                    //Animaciones giro asteroides
                    asteroidRotate1++;
                    meteorColision1.setRotate(asteroidRotate1);
                    meteorColision2.setRotate(asteroidRotate1);
                    meteorColision3.setRotate(asteroidRotate1);
                    //-------------------------------------------------------------animación meteorito1 movimiento, aleatoriedad en eje Y y rebote
                    //animacion en posición x
                    if (meteor1X < -50){
                        meteor1X = 1200;
                        //posicion aleatoria en pantalla eje Y entre 100 y 400
                        meteor1Y = generadorNum.nextInt(300)+100;
                        //Numero aleatorio ente 0 = continua recto, 1 = sube y 2 = baja 
                        ramdomMeteor1Y = generadorNum.nextInt(3);
                        
                    }else{
                        //Resta eje x
                        meteor1X -= 2;
                        //Resta o suma eje Y dependiendo del numero aleatorio
                        if (ramdomMeteor1Y == 1){
                            meteor1Y -= 2;
                        }else{
                            if (ramdomMeteor1Y == 2){
                                meteor1Y += 2;
                            };
                        };
                    };
                    //Rebote meteorito arriba
                    Shape shapeMeteor1 = Shape.intersect(circleMeteor1, asteroidTop);
                    boolean meteorColisionTop = shapeMeteor1.getBoundsInLocal().isEmpty();
                    if (meteorColisionTop == false){
                      ramdomMeteor1Y = 2;
                    };
                    //Rebote meteorito abajo
                    Shape shapeMeteor1s2 = Shape.intersect(circleMeteor1, asteroidDown);
                    boolean meteorColisionDown = shapeMeteor1s2.getBoundsInLocal().isEmpty();
                    if (meteorColisionDown == false){
                      ramdomMeteor1Y = 1;
                    };
                    //Colision meteorito con la nave
                    Shape shapeAsteroid1s3 = Shape.intersect(formGlobal, circleMeteor1);
                    boolean meteorColision = shapeAsteroid1s3.getBoundsInLocal().isEmpty();
                    if (meteorColision == false){
                      root.getChildren().addAll(perdido);
                      explosion2.setVisible(true);
                      animationShip.stop();
                      animationShip.stop();
                        animationAsteroid.stop();
                        animationImageBackground.stop();
                        animationHole.stop();
                        animationColision.stop();
                        animationEnemyShip.stop();
                        //------------------------------------------Parar Musica
                        mediaPlayer.stop();
                        //Explosion
                        mediaPlayerEx.play();
                        this.stop();
                    };
                    //--------------------------colision de meteoritos entre meteorito 1 y 2
                    Shape shapeAsteroid4s1 = Shape.intersect(circleMeteor1, circleMeteor2);
                    boolean meteorColisionS4 = shapeAsteroid4s1.getBoundsInLocal().isEmpty();
                    if (meteorColisionS4 == false){
                    //Si la posicion de el meteorito 1 es mayor que la del meteorito 2 le resta en eje Y al meteorito 1
                      if(meteor1Y > meteor2Y){
                            ramdomMeteor2Y = 1;
                            ramdomMeteor1Y = 2;
                        }else{
                            ramdomMeteor2Y = 2;
                            ramdomMeteor1Y = 1;
                        };
                    };
                    //-------------------------colision de meteoritos entre meteorito 1 y 3
                    Shape shapeAsteroid5s1 = Shape.intersect(circleMeteor1, circleMeteor3);
                    boolean meteorColisionS5 = shapeAsteroid5s1.getBoundsInLocal().isEmpty();
                    if (meteorColisionS5 == false){
                      if(meteor1Y > meteor3Y){
                            ramdomMeteor3Y = 1;
                            ramdomMeteor1Y = 2;
                        }else{
                            ramdomMeteor3Y = 2;
                            ramdomMeteor1Y = 1;
                        };
                    };
                    meteorColision1.setLayoutX(meteor1X);
                    meteorColision1.setLayoutY(meteor1Y);
                    //-----------------------------------------------------------------------------animación meteorito2 movimiento, aleatoriedad en eje Y y rebote
                    //animacion en posición x
                    if (meteor2X < -50){
                        meteor2X = 1200;
                        //posicion aleatoria en pantalla eje Y entre 100 y 400
                        meteor2Y = generadorNum.nextInt(300)+100;
                        //Numero aleatorio ente 0 = continua recto, 1 = sube y 2 = baja 
                        ramdomMeteor2Y = generadorNum.nextInt(3);
                        //Velocidad aleatoria
                        velocidadMeteorid2 = generadorNum.nextInt(3)+1;
                        
                    }else{
                        //Resta eje x
                        meteor2X -= velocidadMeteorid2;
                        //Resta o suma eje Y dependiendo del numero aleatorio
                        if (ramdomMeteor2Y == 1){
                            meteor2Y -= 2;
                        }else{
                            if (ramdomMeteor2Y == 2){
                                meteor2Y += 2;
                            };
                        };
                    };
                    //Rebote meteorito arriba
                    Shape shapeMeteor2 = Shape.intersect(circleMeteor2, asteroidTop);
                    boolean meteorColisionTop2 = shapeMeteor2.getBoundsInLocal().isEmpty();
                    if (meteorColisionTop2 == false){
                      ramdomMeteor2Y = 2;
                    };
                    //Rebote meteorito abajo
                    Shape shapeMeteor2s2 = Shape.intersect(circleMeteor2, asteroidDown);
                    boolean meteorColisionDown2 = shapeMeteor2s2.getBoundsInLocal().isEmpty();
                    if (meteorColisionDown2 == false){
                      ramdomMeteor2Y = 1;
                    };
                    //Colision meteorito con la nave
                    Shape shapeAsteroid2s3 = Shape.intersect(formGlobal, circleMeteor2);
                    boolean meteorColisionS2 = shapeAsteroid2s3.getBoundsInLocal().isEmpty();
                    if (meteorColisionS2 == false){
                      root.getChildren().addAll(perdido);
                      //------------------------------------------Parar Musica
                      mediaPlayer.stop();
                      //Explosion
                       mediaPlayerEx.play();
                      this.stop();
                        explosion2.setVisible(true);
                        animationShip.stop();
                        animationAsteroid.stop();
                        animationImageBackground.stop();
                        animationHole.stop();
                        animationColision.stop();
                        animationEnemyShip.stop();
                        
                    };
                    meteorColision2.setLayoutX(meteor2X);
                    meteorColision2.setLayoutY(meteor2Y);
                    //-------------------------colision de meteoritos entre meteorito 2 y 3
                    Shape shapeAsteroid6s1 = Shape.intersect(circleMeteor2, circleMeteor3);
                    boolean meteorColisionS6 = shapeAsteroid6s1.getBoundsInLocal().isEmpty();
                    if (meteorColisionS6 == false){
                      if(meteor2Y > meteor3Y){
                            ramdomMeteor3Y = 1;
                            ramdomMeteor2Y = 2;
                        }else{
                            ramdomMeteor3Y = 2;
                            ramdomMeteor2Y = 1;
                        };
                    };
                    //-----------------------------------------------------------------------------animación meteorito3 movimiento, aleatoriedad en eje Y y rebote
                    //animacion en posición x
                    if (meteor3X < -50){
                        meteor3X = 1200;
                        //posicion aleatoria en pantalla eje Y entre 100 y 400
                        meteor3Y = generadorNum.nextInt(300)+100;
                        //Numero aleatorio ente 0 = continua recto, 1 = sube y 2 = baja 
                        ramdomMeteor3Y = generadorNum.nextInt(3);
                        //Velocidad aleatoria
                        velocidadMeteorid3 = generadorNum.nextInt(3)+1;
                        
                    }else{
                        //Resta eje x
                        meteor3X -= velocidadMeteorid3;
                        //Resta o suma eje Y dependiendo del numero aleatorio
                        if (ramdomMeteor3Y == 1){
                            meteor3Y -= 2;
                        }else{
                            if (ramdomMeteor3Y == 2){
                                meteor3Y += 2;
                            };
                        };
                    };
                    //Rebote meteorito arriba
                    Shape shapeMeteor3 = Shape.intersect(circleMeteor3, asteroidTop);
                    boolean meteorColisionTop3 = shapeMeteor3.getBoundsInLocal().isEmpty();
                    if (meteorColisionTop3 == false){
                      ramdomMeteor3Y = 2;
                    };
                    //Rebote meteorito abajo
                    Shape shapeMeteor3s2 = Shape.intersect(circleMeteor3, asteroidDown);
                    boolean meteorColisionDown3 = shapeMeteor3s2.getBoundsInLocal().isEmpty();
                    if (meteorColisionDown3 == false){
                      ramdomMeteor3Y = 1;
                    };
                    //Colision meteorito con la nave
                    Shape shapeAsteroid3s3 = Shape.intersect(formGlobal, circleMeteor3);
                    boolean meteorColisionS3 = shapeAsteroid3s3.getBoundsInLocal().isEmpty();
                    if (meteorColisionS3 == false){
                      root.getChildren().addAll(perdido);
                        explosion2.setVisible(true);
                        animationShip.stop();
                        animationAsteroid.stop();
                        animationImageBackground.stop();
                        animationHole.stop();
                        animationColision.stop();
                        animationEnemyShip.stop();
                        //------------------------------------------Parar Musica
                        mediaPlayer.stop();
                        //Explosion
                        mediaPlayerEx.play();
                        this.stop();
                    };
                    meteorColision3.setLayoutX(meteor3X);
                    meteorColision3.setLayoutY(meteor3Y);
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
                break;
               case ENTER:
                   marcador = 0;
                   root.getChildren().remove(perdido);
                   explosion2.setVisible(false);
                   enemyShot.setVisible(false);
                   animationShip.start();
                    animationAsteroid.start();
                    animationImageBackground.start();
                    animationHole.start();
                    animationColision.start();
                    asteroiAnimation.start();
                    animationEnemyShip.start();
                    // variables asteroides
                    asteroidX = 0;
                    asteroidX2 = 0;
                    //Variables fondo
                    imageBackgroundX = 0;
                    imageBackgroundX2 = 1199;
                    //-----------------------------------Variables Nave
                    //Nave eje Y
                    naveEjeY = 200;
                    naveEjeX = 0;
                    //Nave velocidad
                    velocidad = 0;
                    //Nave velocidad X
                    velocidadX = 0;
                    //-----------------------------Variables nave enemiga
                    enemyShipY = 250;
                    enemyShipY1 = 0;
                    enemyShipX = 1200;
                    //Disparo
                    enemyShotY = 0;
                    enemyShotX = 0;
                    visibleShot = 0;
                    enemyShotYEstado = 0;
                    ramdomEnemyShot = 0;
                    //------------------------------Variables agujero negro
                    //Variable eje x agujero negro
                    holeX = 1200;
                    //---------------------------------------Variables meteorito 1
                    //Variable meteorito posicion x
                    meteor1X = 1200;
                    //---------------------------------------Variables meteorito 2
                    //Variable meteorito posicion x
                    meteor2X = 1200;
                    //---------------------------------------Variables meteorito 3
                    //Variable meteorito posicion x
                    meteor3X = 1200;
                    //posicion aleatoria inicio agujero
                    holeY = generadorNum.nextInt(399)+1;
                    //Numero aleatorio ente 0 y 2 para eje Y asteroide---------- 1
                    ramdomMeteor1Y = generadorNum.nextInt(3);
                    //posicion aleatoria inicio meteorito
                    meteor1Y = generadorNum.nextInt(300)+100;
                    //Numero aleatorio ente 0 y 2 para eje Y asteroide---------- 2
                    ramdomMeteor2Y = generadorNum.nextInt(3);
                    //posicion aleatoria inicio meteorito
                    meteor2Y = generadorNum.nextInt(300)+100;
                    //Velocidad aleatoria de inicio asteroide 2
                    velocidadMeteorid2 = generadorNum.nextInt(3)+1;
                    //Numero aleatorio ente 0 y 2 para eje Y asteroide---------- 3
                    ramdomMeteor3Y = generadorNum.nextInt(3);
                    //posicion aleatoria inicio meteorito
                    meteor3Y = generadorNum.nextInt(300)+100;
                    //Velocidad aleatoria de inicio asteroide 3
                    velocidadMeteorid3 = generadorNum.nextInt(3)+1;
                    //Explosion
                    mediaPlayer.play();
                    //Explosion
                    mediaPlayerEx.stop();
                    
               break;
           }
        });
        //Control nave no pulsa tecla
        scene.setOnKeyReleased((KeyEvent) -> {
            velocidad = 0;
        });
        root.getChildren().addAll(imageBackground, imageBackground2, ship, enemyShip, meteorColision1, meteorColision2, meteorColision3, asteroidTop, asteroidDown, holeColision, asteroid1, asteroid2, marcadorScore, marcadorText);
        animationAsteroid.start();
        animationImageBackground.start();
        animationShip.start();
        animationHole.start();
        animationColision.start();
        asteroiAnimation.start();
        animationEnemyShip.start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
