package mountain;

public class Side {
	private Point p1;
	private Point p2;

	public Side(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public boolean usedSide(Point p1, Point p2) {
		if (p1 == this.p1) {
			if (p2 == this.p2) {
				return true;
			}
		}
		if (p2 == this.p1) {
			if (p1 == this.p2) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Side) {
			Side s = (Side) obj;
			if (s.p1.equals(p1) && s.p2.equals(p2)) {
				return true;
			}
			if (s.p1.equals(p2) && s.p2.equals(p1)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return p1.hashCode() + p2.hashCode();
	}
}
