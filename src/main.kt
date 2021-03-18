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

class Flot(vararg _ships: Ship) {

    private val ships = _ships
    private var count = 0

    init {
        for (ship in ships) {
            count++
        }
    }

    fun synchronizedSailOff() {
        for (ship in ships) {
            ship.sailOff()
        }
    }

    fun shipsInFlot() {
        println()
        println("There are $count ships in this flot: ")
        println()
        for (ship in ships) {
            println(ship.typeOfShip)
        }
    }
}