package jonathanHughes.htmlReader.webpage.layout.position;

public class ElementPosition {
	
	private double xStartPoint;
	private double yStartPoint;
	
	public ElementPosition(double xStartPoint, double xEndPoint) {
		super();
		this.xStartPoint = xStartPoint;
		this.yStartPoint = xEndPoint;
	}

	public double getxStartPoint() {
		return xStartPoint;
	}

	public void setxStartPoint(double xStartPoint) {
		this.xStartPoint = xStartPoint;
	}

	public double getyStartPoint() {
		return yStartPoint;
	}

	public void setYStartPoint(double xEndPoint) {
		this.yStartPoint = xEndPoint;
	}

}
