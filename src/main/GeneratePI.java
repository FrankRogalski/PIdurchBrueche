package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GeneratePI extends Application {
	private Canvas c;
	private GraphicsContext gc;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane p = new BorderPane();
		Scene s = new Scene(p, 300, 150);
		stage.setTitle("PI berechnen");
		c = new Canvas(s.getWidth(), s.getHeight());
		gc = c.getGraphicsContext2D();
		
		p.setCenter(c);

		stage.setScene(s);
		stage.show();
		
		double frac = 0;
		long i;
		long max = (long) Math.pow(10, 9);
		for (i = 1; i < max; i++) {
			frac += 1.0 / (i * i);
		}
		final double pi = Math.sqrt(frac * 6);
		gc.clearRect(0, 0, c.getWidth(), c.getHeight());
		gc.fillText("Max: ", 10, 15);
		gc.fillText(i + "", 100, 15);
		
		gc.fillText("Pi geraten: ", 10, 30);
		gc.fillText(pi + "", 100, 30);
		
		gc.fillText("Pi: ", 10, 45);
		gc.fillText(Math.PI + "", 100, 45);
		
		gc.fillText("Gleiche Stellen: ", 10, 60);
		gc.fillText(gleich(Math.PI, pi), 100, 60);
	}
	
	private String gleich(String s1, String s2) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < s1.length() && s1.charAt(i) == s2.charAt(i); i++) {
			sb.append(s1.charAt(i));
		}
		return sb.toString();
	}
	
	private String gleich(double z1, double z2) {
		return gleich(String.valueOf(z1), String.valueOf(z2));
	}
}