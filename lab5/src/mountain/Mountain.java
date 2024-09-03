package mountain;

import java.util.HashMap;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {
	private Point p1;
	private Point p2;
	private Point p3;
	private double odev;
	private HashMap<Side, Point> map;

	public Mountain(Point p1, Point p2, Point p3, double dev) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		odev = dev;
		map = new HashMap<Side, Point>();

	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Mountain triangle";
	}

	@Override
	public void draw(TurtleGraphics turtle) {
		fractalTriangle(turtle, order, p1, p2, p3, odev);
	}

	private void fractalTriangle(TurtleGraphics turtle, int order, Point po1, Point po2, Point po3, double dev) {
		if (order == 0) {
			turtle.moveTo(po1.getX(), po1.getY());
			turtle.forwardTo(po2.getX(), po2.getY());
			turtle.forwardTo(po3.getX(), po3.getY());
			turtle.forwardTo(po1.getX(), po1.getY());
		} else {
			Point po12;
			Point po23;
			Point po31;
			if (map.containsKey(new Side(po1, po2))) { //borde vara en metod som kallas på 3 ggr
				po12 = map.get(new Side(po1, po2));
				map.remove(new Side(po1, po2));
			} else {
				po12 = po1.inbetween(po2, dev);
				map.put(new Side(po1, po2), po12);
			}
			if (map.containsKey(new Side(po2, po3))) {
				po23 = map.get(new Side(po2, po3));
				map.remove(new Side(po2, po3));
			} else {
				po23 = po2.inbetween(po3, dev);
				map.put(new Side(po2, po3), po23);
			}
			if (map.containsKey(new Side(po3, po1))) {
				po31 = map.get(new Side(po3, po1));
				map.remove(new Side(po3, po1));
			} else {
				po31 = po3.inbetween(po1, dev);
				map.put(new Side(po3, po1), po31);
			}
			fractalTriangle(turtle, order - 1, po1, po12, po31, dev / 2);
			fractalTriangle(turtle, order - 1, po2, po12, po23, dev / 2);
			fractalTriangle(turtle, order - 1, po3, po23, po31, dev / 2);
			fractalTriangle(turtle, order - 1, po12, po23, po31, dev / 2);

		}
	}

}
