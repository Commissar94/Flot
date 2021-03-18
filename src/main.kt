fun main() {

    val militaryShip1 = Ship.MilitaryShip()
    val militaryShip2 = Ship.MilitaryShip()
    val passengerShip = Ship.PassengerShip()
    val passengerShip2 = Ship.PassengerShip()
    val cargoShip = Ship.CargoShip()

    val flot = Flot(militaryShip1, militaryShip2, passengerShip, passengerShip2, cargoShip)
    flot.synchronizedSailOff()
    flot.shipsInFlot()
}

open class Ship() {
    open val speed: Double = 0.0
    open val passengerCapacity: Int = 0
    open val typeOfShip = ""

    open fun sailOff() {
        println("*Ship is silently sailing off*")
    }

    class MilitaryShip : Ship() {
        override val speed: Double = 20.0
        override val passengerCapacity: Int = 100
        override val typeOfShip: String = "Military Ship"
        val canons = 20
        override fun sailOff() {
            println("*Ship starts shooting to the sky and sail off*")
        }
    }

    class CargoShip : Ship() {
        override val speed: Double = 15.0
        override val passengerCapacity: Int = 20
        override val typeOfShip: String = "Cargo Ship"
        val cargoCapacity = 100
    }

    class PassengerShip : Ship() {
        override val speed: Double = 15.0
        override val passengerCapacity: Int = 300
        override val typeOfShip: String = "Passenger Ship"
        override fun sailOff() {
            println("*Ship beeps and sail off*")
        }
    }
}

class Flot(_ship1: Ship, _ship2: Ship, _ship3: Ship, _ship4: Ship, _ship5: Ship) {

    private val ship1 = _ship1
    private val ship2 = _ship2
    private val ship3 = _ship3
    private val ship4 = _ship4
    private val ship5 = _ship5

    fun synchronizedSailOff() {
        ship1.sailOff()
        ship2.sailOff()
        ship3.sailOff()
        ship4.sailOff()
        ship5.sailOff()
    }

    fun shipsInFlot() {
        println()
        println("There are 5 ships in this flot: ")
        println()
        println(ship1.typeOfShip)
        println(ship2.typeOfShip)
        println(ship3.typeOfShip)
        println(ship4.typeOfShip)
        println(ship5.typeOfShip)
    }
}