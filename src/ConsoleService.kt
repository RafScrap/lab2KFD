class BadPropertyException(message : String) : Exception(message)
class  WrongOperationTypeException(message: String) : Exception(message)

interface ConsoleService {
    fun work()
}

object ConsoleServiceImpl : ConsoleService {
    private var operationString : String = "";
    private var propertyString : String = "";
    private var operation : Int = 0;
    private var property : Double = 0.0;
    override fun work() {
        while (true) {
            try {
                println(
                    "Введите тип операции, которую хотите исполнить:\n" +
                            "1) добавить фигуру\n" +
                            "2) получить площадь всех фигур\n" +
                            "3) получить периметр всех фигур\n" +
                            "4) завершить выполнение"
                )
                try {
                    operationString = readln();
                    operation = operationString.toInt()
                } catch (e: NumberFormatException) {
                    throw WrongOperationTypeException("");
                }
                when (operation) {
                    Operation.INSERT.code -> println(addFigure())
                    Operation.GET_AREA.code -> println(FigureServiceImpl.getArea())
                    Operation.GET_PERIMETER.code -> println(FigureServiceImpl.getPerimeter())
                    Operation.EXIT.code -> break
                    else -> throw WrongOperationTypeException("");
                }
            }
            catch(e: WrongOperationTypeException) {
                println("Введен неизвестный тип операции: " + operationString)
            }
        }
    }

    private fun addFigure() {
        try {
            println("\nВведите радиус/длину стороны желаемой фигуры:")
            try {
                propertyString = readln();
                property = propertyString.toDouble()
            } catch (e: NumberFormatException) {
                throw BadPropertyException("");
            }
            if (property <= 0) {
                throw BadPropertyException("");
            }
            println(
                "\nВведите тип фигуры, которую хотите добавить:\n" +
                        "1) Квадрат\n" +
                        "2) Круг"
            )
            try {
                operationString = readln()
                operation = operationString.toInt()
            } catch (e: NumberFormatException) {
                throw WrongOperationTypeException("");
            }
            when (operation) {
                TypeFigure.SQUARE.code -> FigureServiceImpl.addSquare(property)
                TypeFigure.CIRCLE.code -> FigureServiceImpl.addCircle(property)
                else -> throw WrongOperationTypeException("");
            }
        }
        catch(e: WrongOperationTypeException) {
            print("Введено неверное значение параметра property: " + propertyString)
        }
        catch(e: WrongOperationTypeException) {
            print("Введен неизвестный тип операции: " + operationString)
        }
    }
}
