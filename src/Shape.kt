sealed class Shape protected constructor(
    private val property: Double,
    private val typeFigure: TypeFigure
) {
    protected abstract val perimeter: Double;
    protected abstract val area: Double;
    init {
        println(this.toString());
    }

    override fun toString() : String {
        return this.typeFigure.toString + "(property=" + this.property + ")";
    }

   fun returnPerimeter(): Double {
        return this.perimeter;
    };
    fun returnArea(): Double {
        return this.area;
    };

    fun getTypeFigure(): TypeFigure {
        return this.typeFigure;
    };
}
