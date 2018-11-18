package Gui

import mines.objects.Board
import java.awt.Dimension
import java.awt.EventQueue
import java.awt.GridLayout
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JPanel

class MainGui(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(700, 700)
        setLocationRelativeTo(null)
    }
}

private fun updateGui(board: Board, table: Array<Array<CellGui?>?>) {

    val mines = board.mines

    for (x in 0 until mines.size) {
        for (y in 0 until mines[x]?.size!!) {
			
            // TODO : Personnalisez l'affichage de vos Cellules !
        
		}
    }
}

private fun dialog(msg: String, frame: MainGui) {

    val options1 = arrayOf<Any>("Rejouer", "Quitter")
    val panel = JPanel()
    panel.add(JLabel("$msg voulez-vous recommencez ?"))

    val result = JOptionPane.showOptionDialog(
        null, panel, "Demineur",
        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
        options1, null
    )

    if (result == JOptionPane.YES_OPTION) {
        frame.dispose()
        createAndShowGUI()
    } else if (result == JOptionPane.NO_OPTION) {
        System.exit(0);
    }
}

private fun createAndShowGUI() {
	
    val frame = MainGui("Démineur")
    val buttonPanel = JPanel()
    val containerPanel = JPanel()
    
	// Info : vous pouvez ici personnaliser la taille de votre démineur !

		val board = Board(10, 10)
    buttonPanel.layout = GridLayout(10, 10)

    val table: Array<Array<CellGui?>?> = arrayOfNulls(10)
    var tableX: Array<CellGui?>

    val mines = board.mines

    // Init the grid of Game
    for (x in 0 until 10) {
        tableX = arrayOfNulls(10)

        for (y in 0 until 10) {
            val cg = CellGui()

            cg.cellule = mines[x]?.get(y)!!

            val but = JButton("")
            but.addMouseListener(object : MouseAdapter() {
                override fun mouseClicked(e: MouseEvent?) {
					
                    // TODO : au clic de souris, on va avoir deux possibilités :
					//	- si c'est un clic gauche, alors on ouvre la Cellule,
					//	  on vérifie également la fin de partie (perdu ou gagné, il faut afficher quelque chose, sinon rien)
					//	- si c'est un clic droit, alors on flag la Cellule
					
                }
            })

            cg.button = but
            tableX[y] = cg
        }

        table[x] = tableX
    }

    for (x in 0 until 10) {
        for (y in 0 until 10) {
            // On ajoute le JButton de la Cellule au JPanel !
        }
    }

    buttonPanel.preferredSize = Dimension(700, 700)
    containerPanel.add(buttonPanel)

    frame.contentPane.add(containerPanel)
    frame.pack()
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}