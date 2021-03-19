fun main() {

    val flot = Flot()
    flot.addShips(Ship.PassengerShip(), Ship.PassengerShip())
    flot.addShips(Ship.MilitaryShip(), Ship.MilitaryShip())
    flot.addShips(Ship.CargoShip())
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

class Flot() {

    private var ships = listOf<Ship>()
    private var lastAddedShips: MutableList<Ship> = mutableListOf<Ship>()
    private var count = 0
    private var cargo = 0
    private var military = 0
    private var passenger = 0

    fun addShips(vararg _ships: Ship) {

        lastAddedShips = _ships.toMutableList()
        ships += lastAddedShips

        for (ship in lastAddedShips) {
            when (ship.typeOfShip) {
                "Cargo Ship" -> cargo++
                "Military Ship" -> military++
                "Passenger Ship" -> passenger++
            }
            count++
        }
        lastAddedShips.clear()
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
        println("Military ships: $military")
        println("Passenger ships: $passenger")
        println("Cargo ships: $cargo")
    }
}