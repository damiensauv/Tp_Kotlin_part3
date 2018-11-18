package mines.objects.Cells

/**
 * class Cellule : Cellule du plateau
 * décrite par une position X, une position Y et un char à afficher
 */
abstract class Cellule {
	abstract var posX : kotlin.Int
	abstract var posY : kotlin.Int
	abstract var toPrint : kotlin.String
	var visible : kotlin.Boolean = true
	var flag : kotlin.Boolean = false
}

/**
 * class Vide : Cellule vide
 * valeur à afficher : "_" (espace)
 */
class Vide (
	override var posX : kotlin.Int,
	override var posY : kotlin.Int,
	override var toPrint : kotlin.String = "-"
) : Cellule()

/**
 * class Nombre : Cellule sans Mine
 * valeur à afficher : nombre de voisins
 */
class Nombre (
	override var posX : kotlin.Int,
	override var posY : kotlin.Int,
	override var toPrint : kotlin.String
) : Cellule()

/**
 * class Mine : Cellule avec une Mine
 * valeur à afficher : "*" (mine)
 */
class Mine (
	override var posX : kotlin.Int,
	override var posY : kotlin.Int,
	override var toPrint : kotlin.String = "*"
) : Cellule()