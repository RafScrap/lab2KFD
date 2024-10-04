class Square (property: Double): Shape(property, TypeFigure.SQUARE) {
    override val perimeter: Double = property * 4;
    override val area: Double = property * property;
}