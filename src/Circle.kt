import kotlin.math.PI

class Circle (property: Double): Shape(property, TypeFigure.CIRCLE) {
    override val perimeter: Double = 2 * PI * property;
    override val area: Double = PI * property * property;
}