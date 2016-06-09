package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main;

interface Funcion<T extends Comparable<T>> {
    void funcion(T dato, Object parametros);
}
