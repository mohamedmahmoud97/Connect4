//package c4Package;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import java.util.*;

public class mainConnectFour extends Application{
	//arraylist of circles in grid
	ArrayList<Circle> list = new ArrayList<>();
	//arraylist of highlighting rectangles
	ArrayList<Rectangle> list2 = new ArrayList();
	//radius of circles
	int rC = 40;
	//a counter to switch turns
	int turn = 1;
	//a,b,c,d,e,f&g are refering to columns 1,2,3,4,5,6&7 with initial value 5
        //to make first disc be in the last row
	int a=5,b=5,c=5,d=5,e=5,f=5,g=5;
	//win Red and win Blue variables
	int wR=0,wB=0;
	//a label to view the winner
	Label lbl = new Label("Connect 4");
	
	@Override
	public void start(Stage primaryStage){
		Scene scene = new Scene(makePaneShape(),700,650);
		primaryStage.setTitle("Connect Four");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	//method of returning pane with its contents
	private Pane makePaneShape(){
		Pane pane = new Pane();
		lbl.setLayoutX(200);
		lbl.setLayoutY(5);
		lbl.setTextFill(Color.DARKRED);
		lbl.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 60));
		pane.getChildren().add(lbl);
		Shape recSL = new Rectangle(0,400,40,30);
		recSL.setFill(Color.BLUE);
		Shape recSR = new Rectangle(670,400,40,30);
		recSR.setFill(Color.BLUE);
		Shape recVL = new Rectangle(10,400,15,270);
		recVL.setFill(Color.BLUE);
		Shape recVR = new Rectangle(685,400,15,270);
		recVR.setFill(Color.BLUE);
		Shape recGr = new Rectangle(0,635,800,40);
		recGr.setFill(Color.BLUE);
		pane.getChildren().addAll(recSL,recSR,recVL,recVR,recGr);
		Shape rec = new Rectangle(rC,rC+40,(rC*15)+30,(rC*13)+30);
		rec.setStyle("-fx-fill:yellow;-fx-stroke:red;-fx-stroke-width:3px;");
		pane.getChildren().add(rec);
		pane.getChildren().addAll(makeCir());
		pane.getChildren().addAll(makeRec());
		return pane;
	}
	
	//method returning an array list of circles
	ArrayList<Circle> makeCir(){
		for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                Circle circle = new Circle(rC);
                circle.setCenterX(rC+40);
                circle.setCenterY(rC+85);
                circle.setTranslateX(i*(2*rC+5)+(2*rC)/4);
                circle.setTranslateY(j*(2*rC+5)+(2*rC)/4);
                circle.setStyle("-fx-fill:white;-fx-stroke:blue;fx-stroke-width:1.5px;");
                list.add(circle);
            }
        }
		return list;
	}
	
	//method returning an array list of highlighting rectangles
	ArrayList<Rectangle> makeRec(){
        for(int i = 0;i<7;i++){
            Rectangle rec = new Rectangle(40,85,rC*2,(7)*rC*2-20);
            rec.setTranslateX(i*(2*rC + 5)+ (2*rC)/4);
            rec.setFill(Color.TRANSPARENT);
            
            rec.setOnMouseEntered(e ->rec.setFill(Color.rgb(100, 100, 100,0.4)));
            rec.setOnMouseExited(e-> rec.setFill(Color.TRANSPARENT));
            
            final int col =i;
            rec.setOnMouseClicked(e-> putD(col));
            
            list2.add(rec);
        }
        return list2;
	}
	
	//method of putting discs
	void putD(int col){
		if(turn%2!=0 && wR==0 && wB==0){
			if(col==0 && a>=0){
				if(list.get(6*col+a).getFill()==Color.WHITE)
					list.get(6*col+a).setFill(Color.RED);
				a--;
				turn++;
			}
			if(col==1 && b>=0){
				if(list.get(6*col+b).getFill()==Color.WHITE)
					list.get(6*col+b).setFill(Color.RED);
				b--;
				turn++;
			}
			if(col==2 && c>=0){
				if(list.get(6*col+c).getFill()==Color.WHITE)
					list.get(6*col+c).setFill(Color.RED);
				c--;
				turn++;
			}
			if(col==3 && d>=0){
				if(list.get(6*col+d).getFill()==Color.WHITE)
					list.get(6*col+d).setFill(Color.RED);
				d--;
				turn++;
			}
			if(col==4 && e>=0){
				if(list.get(6*col+e).getFill()==Color.WHITE)
					list.get(6*col+e).setFill(Color.RED);
				e--;
				turn++;
			}
			if(col==5 && f>=0){
				if(list.get(6*col+f).getFill()==Color.WHITE)
					list.get(6*col+f).setFill(Color.RED);
				f--;
				turn++;
			}
			if(col==6 && g>=0){
				if(list.get(6*col+g).getFill()==Color.WHITE)
					list.get(6*col+g).setFill(Color.RED);
				g--;
				turn++;
			}
			checkR();
			checkDraw();
		}
		else if(turn%2==0 && wB==0 && wR==0){
			if(col==0 && a>=0){
				if(list.get(6*col+a).getFill()==Color.WHITE)
					list.get(6*col+a).setFill(Color.BLUE);
				a--;
				turn++;
			}
			if(col==1 && b>=0){
				if(list.get(6*col+b).getFill()==Color.WHITE)
					list.get(6*col+b).setFill(Color.BLUE);
				b--;
				turn++;
			}
			if(col==2 && c>=0){
				if(list.get(6*col+c).getFill()==Color.WHITE)
					list.get(6*col+c).setFill(Color.BLUE);
				c--;
				turn++;
			}
			if(col==3 && d>=0){
				if(list.get(6*col+d).getFill()==Color.WHITE)
					list.get(6*col+d).setFill(Color.BLUE);
				d--;
				turn++;
			}
			if(col==4 && e>=0){
				if(list.get(6*col+e).getFill()==Color.WHITE)
					list.get(6*col+e).setFill(Color.BLUE);
				e--;
				turn++;
			}
			if(col==5 && f>=0){
				if(list.get(6*col+f).getFill()==Color.WHITE)
					list.get(6*col+f).setFill(Color.BLUE);
				f--;
				turn++;
			}
			if(col==6 && g>=0){
				if(list.get(6*col+g).getFill()==Color.WHITE)
					list.get(6*col+g).setFill(Color.BLUE);
				g--;
				turn++;
			}
			checkB();
			checkDraw();
		}
	}

	//checking the red player if he wins
	void checkR(){
		//checking vertical
		for(int i=0;i<7;i++){
			for(int j=0;j<3;j++){
				if(list.get(6*i+j).getFill()==list.get(6*i+j+1).getFill() &&
                                        list.get(6*i+j+1).getFill()==list.get(6*i+j+2).getFill() 
						&& list.get(6*i+j+2).getFill()==list.get(6*i+j+3).getFill()
                                        && list.get(6*i+j).getFill()==Color.RED){
					wR=1;
					System.out.println("Player RED wins");
					lbl.setText("Red Wins");
					lbl.setTextFill(Color.RED);
					
				}
			}
		}
		//checking horizontal
		for(int i=0;i<6;i++){
			for(int j=0;j<4;j++){
				if(list.get(i+6*j).getFill()==list.get(i+6*j+6).getFill() &&
                                        list.get(i+6*j+6).getFill()==list.get(i+6*j+12).getFill() 
						&& list.get(i+6*j+12).getFill()==list.get(i+6*j+18).getFill() &&
                                        list.get(i+6*j).getFill()==Color.RED){
					wR=1;
					System.out.println("Player RED wins");
					lbl.setText("Red Wins");
					lbl.setTextFill(Color.RED);
				}
			}
		}
		//checking the diagonal
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(list.get(i+j*6).getFill()==Color.RED &&
                                        list.get(i+j*6+7).getFill()==Color.RED 
						&& list.get(i+j*6+14).getFill()==Color.RED &&
                                        list.get(i+j*6+21).getFill()==Color.RED){
					wR=1;
					System.out.println("Player RED wins");
					lbl.setText("Red Wins");
					lbl.setTextFill(Color.RED);
				}
			}
		}
        //checking the diagonal   
        for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(list.get(i+j*6+3).getFill()==Color.RED &&
                                        list.get(i+j*6+8).getFill()==Color.RED 
						&& list.get(i+j*6+13).getFill()==Color.RED &&
                                        list.get(i+j*6+18).getFill()==Color.RED){
					wR=1;
					System.out.println("Player RED wins");
					lbl.setText("Red Wins");
					lbl.setTextFill(Color.RED);
				}
			}
		}
	}
	
	//checking the blue player if he wins
	void checkB(){
		//checking vertical
		for(int i=0;i<7;i++){
			for(int j=0;j<3;j++){
				if(list.get(6*i+j).getFill()==list.get(6*i+j+1).getFill() &&
                                        list.get(6*i+j+1).getFill()==list.get(6*i+j+2).getFill() 
						&& list.get(6*i+j+2).getFill()==list.get(6*i+j+3).getFill() &&
                                        list.get(6*i+j).getFill()==Color.BLUE){
					wB=1;
					System.out.println("Player BLUE wins");
					lbl.setText("Blue Wins");
					lbl.setTextFill(Color.BLUE);
				}
			}
		}
		//checking horizontal
		for(int i=0;i<6;i++){
			for(int j=0;j<4;j++){
				if(list.get(i+6*j).getFill()==list.get(i+6*j+6).getFill() &&
                                        list.get(i+6*j+6).getFill()==list.get(i+6*j+12).getFill() 
						&& list.get(i+6*j+12).getFill()==list.get(i+6*j+18).getFill() &&
                                        list.get(i+6*j).getFill()==Color.BLUE){
					wR=1;
					System.out.println("Player BLUE wins");
					lbl.setText("Blue Wins");
					lbl.setTextFill(Color.BLUE);
				}
			}
		}
		//checking the diagonal
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(list.get(i+j*6).getFill()==Color.BLUE &&
                                        list.get(i+j*6+7).getFill()==Color.BLUE 
						&& list.get(i+j*6+14).getFill()==Color.BLUE &&
                                        list.get(i+j*6+21).getFill()==Color.BLUE){
					wR=1;
					System.out.println("Player BLUE wins");
					lbl.setText("Blue Wins");
					lbl.setTextFill(Color.BLUE);
				}
			}
		}
        //checking the diagonal       
        for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(list.get(i+j*6+3).getFill()==Color.BLUE &&
                                        list.get(i+j*6+8).getFill()==Color.BLUE 
						&& list.get(i+j*6+13).getFill()==Color.BLUE &&
                                        list.get(i+j*6+18).getFill()==Color.BLUE){
					wR=1;
					System.out.println("Player BLUE wins");
					lbl.setText("Blue Wins");
					lbl.setTextFill(Color.BLUE);
				}
			}
		}
	}
	
	//checking after the draw 
	void checkDraw(){
            int counter =0;
            
		for(int i=0;i<42;i++){
			if(list.get(i).getFill()!=Color.WHITE){
                         counter++;
			}
		}
		if(wR==0 && wB==0 && counter==42){
			lbl.setText("Draw");
			lbl.setTextFill(Color.BLACK);
		}
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
	
	
}
