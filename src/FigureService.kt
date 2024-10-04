interface FigureService {
    fun addSquare(property: Double);
    fun addCircle(property: Double)
    fun getPerimeter(): Double
    fun getArea(): Double
}

object FigureServiceImpl : FigureService {
    private val shapes = mutableListOf<Shape>();
    override fun addSquare(property: Double) {
        shapes.add(Square(property));
    }
    override fun addCircle(property: Double) {
        shapes.add(Circle(property));
    }
    override fun getPerimeter(): Double {
        var sum : Double = 0.0;
        for (shape in shapes) {;
            sum += when(shape.getTypeFigure()) {
                TypeFigure.SQUARE -> (shape as Square).returnPerimeter()
                TypeFigure.CIRCLE -> (shape as Circle).returnPerimeter()
            }
        }
        return sum;
    }

    override fun getArea(): Double {
        var sum : Double = 0.0;
        for (shape in shapes) {;
            sum += when(shape.getTypeFigure()) {
                TypeFigure.SQUARE -> (shape as Square).returnArea()
                TypeFigure.CIRCLE -> (shape as Circle).returnArea()
            }
        }
        return sum;
    }

}