package parcial2;

import java.util.LinkedList;

import javax.swing.JOptionPane;

class Equipo {
    private String nombreEquipo;
    private LinkedList<Jugador> listaJugadores;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.listaJugadores = new LinkedList<>();
        ;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public LinkedList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    // Metodo agregarJugador---------------
    public void agregarJugador(LinkedList<Jugador> listaJugadores) {
        // Verificar cantidad de jugadores en el equipo seleccionado
        if (this.getListaJugadores().size() >= 5) {
            JOptionPane.showMessageDialog(null, "No pueden ser más de 5 jugadores por equipo.");
            return;
        }

        // Solicitar los datos del jugador
        String nombreJugador;
        boolean flagNombre;
        do {
            flagNombre = false;
            nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador");
            if (nombreJugador.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor");
                flagNombre = true;
            } else {
                for (Jugador jugador : listaJugadores) {
                    if (jugador.getNombreJugador().equalsIgnoreCase(nombreJugador)) {
                        JOptionPane.showMessageDialog(null, "Ya existe un jugador con este nombre");
                        flagNombre = true;
                        break;
                    }
                }
            }
        } while (flagNombre);

        int edad;
        String linea;
        boolean flagEdad;
        do {
            flagEdad = false;

            edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del jugador"));
            if (edad < 13) {
                JOptionPane.showMessageDialog(null, "El jugador debe ser mayor de 13 años");

            } else if (edad >= 60) {
                JOptionPane.showMessageDialog(null, "El jugador debe ser menor a 60 años");
            } else if (edad < 0) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
            } else {
                flagEdad = true;
            }

        } while (!flagEdad);

        boolean flagLinea;
        do {
            flagLinea = false;
            linea = JOptionPane.showInputDialog("Ingrese la línea en la que juega el jugador");
            if (linea.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor");
            } else {
                // Verificar que no se repita la misma linea
                boolean lineaRepetida = false;
                for (Jugador jugador : this.getListaJugadores()) {
                    if (jugador.getLinea().equalsIgnoreCase(linea)) {
                        lineaRepetida = true;
                        break;
                    }
                }
                if (lineaRepetida) {
                    JOptionPane.showMessageDialog(null, "Ya existe un jugador en esta línea. Ingrese otra línea.");
                } else {
                    flagLinea = true;
                }
            }
        } while (!flagLinea);

        // Crear el jugador y agregarlo al equipo seleccionado
        Jugador jugador = new Jugador(nombreJugador, edad, linea, this);
        this.getListaJugadores().add(jugador); // Agregar jugador al equipo
        JOptionPane.showMessageDialog(null,
                "Jugador agregado con éxito al equipo " + this.getNombreEquipo());

    }

    // Metodo eliminarJugador---------------
    public void eliminarJugador() {
        // Verificar si hay jugadores en este equipo
        if (this.getListaJugadores().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay jugadores en este equipo.");
            return;
        }

        // Construir mensaje con los nombres de los jugadores en este equipo
        String mensajeJugadores = "Jugadores en este equipo:\n";
        for (Jugador jugador : this.listaJugadores) {
            mensajeJugadores += jugador.getNombreJugador() + "\n";
        }

        // Solicitar al usuario que seleccione un jugador para eliminar. No se muy bien
        // como funciona este tipo depanel pero es que si no lo uso queda muy desprolijo
        // todo
        String jugadorEliminar = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el jugador que desea eliminar:",
                "Eliminar Jugador",
                JOptionPane.QUESTION_MESSAGE,
                null,
                mensajeJugadores.split("\n"),
                mensajeJugadores.split("\n")[0]);
        // Buscar el jugador en la lista de jugadores en este equipo
        Jugador jugadorAEliminar = null;
        for (Jugador jugador : this.listaJugadores) {
            if (jugador.getNombreJugador().equals(jugadorEliminar)) {
                jugadorAEliminar = jugador;
                break;
            }
        }

        // Verificar si se encontro el jugador
        if (jugadorAEliminar != null) {
            // Eliminar al jugador de la lista de jugadores segun equipo
            this.listaJugadores.remove(jugadorAEliminar);
            JOptionPane.showMessageDialog(null, "Jugador " + jugadorEliminar + " eliminado con éxito.");
        } else {
            // Si no se encontro el jugador, mostrar un mensaje
            JOptionPane.showMessageDialog(null, "El jugador seleccionado no fue encontrado en este equipo.");
        }
    }

    // Metodo buscarJugadorPorNombre---------------
    public void buscarJugadorPorNombre() {
        if (this.listaJugadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay jugadores en la lista");
            return;
        }
        // Construir mensaje con los nombres de los jugadores existentes
        String mensajeJugadores = "Jugadores existentes:\n";
        for (Jugador jugador : listaJugadores) {
            mensajeJugadores += "-" + jugador.getNombreJugador() + "\n";
        }

        // Solicitar al usuario que ingrese el nombre del jugador que desea ver los
        // datos
        String nombreJugadorBuscado = JOptionPane.showInputDialog("Ingrese el nombre "
                + "del jugador que desea ver los datos\n" + mensajeJugadores);
        for (Jugador jugador : listaJugadores) {
            if (jugador.getNombreJugador().equalsIgnoreCase(nombreJugadorBuscado)) {
                // Mostrar la informacion del jugador
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + jugador.toString());
                return;
            }
        }
        // Si no se encuentra el jugador
        JOptionPane.showMessageDialog(null, "El jugador no fue encontrado.");

    }

    // Metodo mostrarListaJugadores---------------
    public void mostrarListaJugadores() {
        if (this.getListaJugadores().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay jugadores en la lista");
        } else {
            // Crear un array de String para almacenar la informacion de los jugadores
            String[] jugadoresArray = new String[this.getListaJugadores().size()];

            // Llenar el array con la informacion de cada jugador
            int cont = 0;
            for (Jugador jugador : this.getListaJugadores()) {
                jugadoresArray[cont] = jugador.toString();
                cont++;
            }

            // Mostrar la lista de jugadores en un cuadro de dialogo
            JOptionPane.showMessageDialog(null, jugadoresArray);
        }
    }

    // Metodo cantidadTotalDeJugadoresEnEquipo---------------
    public void cantidadTotalDeJugadoresEnEquipo() {
        JOptionPane.showMessageDialog(null,
                "El equipo " + this.getNombreEquipo() + " tiene " + this.getListaJugadores().size() + " jugadores.");
        return;

    }

}