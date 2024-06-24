
package parcial2;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class Main {

    public static void main(String[] args) {
    	
    	Partido partido = new Partido();
        GestorEquipos gestor = new GestorEquipos();
        AgregarEquiposPredeterminados(gestor);
        
        // Menú de opciones
        String[] opciones = {
                "Agregar jugador",
                "Eliminar jugador",
                "Buscar jugador por nombre",
                "Obtener cantidad total de jugadores en un equipo",
                "Mostrar lista de jugadores",
                "Agregar equipo",
                "Eliminar equipo",
                "Buscar equipo por nombre",
                "Obtener cantidad total de equipos",
                "Mostrar lista de equipos",
                "Jugar partido",
                "Salir"
        };
        // Esto la verdad no se como funciona pero es que si no no queda bien
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JComboBox<String> comboBox = new JComboBox<>(opciones);
        panel.add(comboBox);

        Equipo equipo = null;
        int opcion;
        do {
            JOptionPane.showMessageDialog(null, panel, "Menú de opciones", JOptionPane.PLAIN_MESSAGE);
            opcion = comboBox.getSelectedIndex();

            switch (opcion) {
                case 0:
                    equipo = gestor.obtenerEquipo();
                    equipo.agregarJugador(gestor.getListaJugadoresGlobal());
                    break;
                case 1:
                    equipo = gestor.obtenerEquipo();
                    equipo.eliminarJugador();
                    break;
                case 2:
                    equipo = gestor.obtenerEquipo();
                    equipo.buscarJugadorPorNombre();
                    break;
                case 3:
                    equipo = gestor.obtenerEquipo();
                    equipo.cantidadTotalDeJugadoresEnEquipo();
                    break;
                case 4:
                    equipo = gestor.obtenerEquipo();
                    equipo.mostrarListaJugadores();
                    break;
                // comienzo de funciones de la clase GestorEquipos
                case 5:
                    gestor.agregarEquipo();
                    break;
                case 6:
                    gestor.eliminarEquipo();
                    break;
                case 7:
                    gestor.buscarEquipoPorNombre();
                    break;
                case 8:
                    gestor.cantidadTotalDeEquipos();
                    break;
                case 9:
                    gestor.mostrarListaDeEquipos();
                    break;
                case 10:
                    partido.jugarPartida(gestor.getListaEquipos(), gestor.getListaJugadoresGlobal());
                    break;
                case 11:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Inténtelo de nuevo.");
            }

        } while (opcion != 11);
    }

    private static void AgregarEquiposPredeterminados(GestorEquipos gestor) {
        Equipo equipo1 = new Equipo("SKT");
        AgregarJugadoresPredeterminadosSK(equipo1);
        gestor.getListaEquipos().add(equipo1);

        Equipo equipo2 = new Equipo("FNATIC");
        AgregarJugadoresPredeterminadosFNC(equipo2);
        gestor.getListaEquipos().add(equipo2);
        
        Equipo equipo3 = new Equipo("G2E");
        AgregarJugadoresPredeterminadosG2(equipo3);
        gestor.getListaEquipos().add(equipo3);
        
        Equipo equipo4 = new Equipo("DWG");
        AgregarJugadoresPredeterminadosDWG(equipo4);
        gestor.getListaEquipos().add(equipo4);
        
        Equipo equipo5 = new Equipo("TL1");
        AgregarJugadoresPredeterminadosTL(equipo5);
        gestor.getListaEquipos().add(equipo5);
        
        Equipo equipo6 = new Equipo("CL9");
        AgregarJugadoresPredeterminadosC9(equipo6);
        gestor.getListaEquipos().add(equipo6);
        
        Equipo equipo7 = new Equipo("RNG");
        AgregarJugadoresPredeterminadosRNG(equipo7);
        gestor.getListaEquipos().add(equipo7);
        
        Equipo equipo8 = new Equipo("EDG");
        AgregarJugadoresPredeterminadosEDG(equipo8);
        gestor.getListaEquipos().add(equipo8);
    }

    private static void AgregarJugadoresPredeterminadosSK(Equipo equipo) {
        equipo.getListaJugadores().add(new Jugador("Faker", 22, "mid", equipo));
        equipo.getListaJugadores().add(new Jugador("Zeus", 22, "top", equipo));
        equipo.getListaJugadores().add(new Jugador("Oner", 22, "jg", equipo));
        equipo.getListaJugadores().add(new Jugador("Upset", 22, "adc", equipo));
        equipo.getListaJugadores().add(new Jugador("Keria", 22, "supp", equipo));
    }

    private static void AgregarJugadoresPredeterminadosFNC(Equipo equipo) {
        equipo.getListaJugadores().add(new Jugador("Humanoid", 22, "mid", equipo));
        equipo.getListaJugadores().add(new Jugador("Oscarinin", 22, "top", equipo));
        equipo.getListaJugadores().add(new Jugador("Razork", 22, "jg", equipo));
        equipo.getListaJugadores().add(new Jugador("Gumayusi", 22, "adc", equipo));
        equipo.getListaJugadores().add(new Jugador("Hylissang", 22, "supp", equipo));
    }

    private static void AgregarJugadoresPredeterminadosG2(Equipo equipo) {
        equipo.getListaJugadores().add(new Jugador("Caps", 22, "mid", equipo));
        equipo.getListaJugadores().add(new Jugador("BrokenBlade", 22, "top", equipo));
        equipo.getListaJugadores().add(new Jugador("Yike", 22, "jg", equipo));
        equipo.getListaJugadores().add(new Jugador("Hans Sama", 22, "adc", equipo));
        equipo.getListaJugadores().add(new Jugador("Mikyx", 22, "supp", equipo));
    }

    private static void AgregarJugadoresPredeterminadosDWG(Equipo equipo) {
        equipo.getListaJugadores().add(new Jugador("ShowMaker", 22, "mid", equipo));
        equipo.getListaJugadores().add(new Jugador("Nuguri", 22, "top", equipo));
        equipo.getListaJugadores().add(new Jugador("Canyon", 22, "jg", equipo));
        equipo.getListaJugadores().add(new Jugador("deokdam", 22, "adc", equipo));
        equipo.getListaJugadores().add(new Jugador("Kellin", 22, "supp", equipo));
    }

    private static void AgregarJugadoresPredeterminadosTL(Equipo equipo) {
        equipo.getListaJugadores().add(new Jugador("APA", 22, "mid", equipo));
        equipo.getListaJugadores().add(new Jugador("Summit", 22, "top", equipo));
        equipo.getListaJugadores().add(new Jugador("Pyosik", 22, "jg", equipo));
        equipo.getListaJugadores().add(new Jugador("Yeon", 22, "adc", equipo));
        equipo.getListaJugadores().add(new Jugador("CoreJJ", 22, "supp", equipo));
    }

    private static void AgregarJugadoresPredeterminadosC9(Equipo equipo) {
        equipo.getListaJugadores().add(new Jugador("EMENES", 22, "mid", equipo));
        equipo.getListaJugadores().add(new Jugador("Fudge", 22, "top", equipo));
        equipo.getListaJugadores().add(new Jugador("Blaber", 22, "jg", equipo));
        equipo.getListaJugadores().add(new Jugador("Berserker", 22, "adc", equipo));
        equipo.getListaJugadores().add(new Jugador("Zven", 22, "supp", equipo));
    }

    private static void AgregarJugadoresPredeterminadosRNG(Equipo equipo) {
        equipo.getListaJugadores().add(new Jugador("Xiaohu", 22, "mid", equipo));
        equipo.getListaJugadores().add(new Jugador("Breathe", 22, "top", equipo));
        equipo.getListaJugadores().add(new Jugador("Wei", 22, "jg", equipo));
        equipo.getListaJugadores().add(new Jugador("Gala", 22, "adc", equipo));
        equipo.getListaJugadores().add(new Jugador("Ming", 22, "supp", equipo));
    }

    private static void AgregarJugadoresPredeterminadosEDG(Equipo equipo) {
        equipo.getListaJugadores().add(new Jugador("FoFo", 22, "mid", equipo));
        equipo.getListaJugadores().add(new Jugador("Ale", 22, "top", equipo));
        equipo.getListaJugadores().add(new Jugador("Jiejie", 22, "jg", equipo));
        equipo.getListaJugadores().add(new Jugador("Leave", 22, "adc", equipo));
        equipo.getListaJugadores().add(new Jugador("Meiko", 22, "supp", equipo));
    }


}