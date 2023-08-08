package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

// rotateSequence realiza la rotación de la secuencia de elementos en función de la cantidad de movimiento y dirección especificadas.
func rotateSequence(sequence *[]interface{}, rotations int, direction int) {
	length := len(*sequence)
	rotations = rotations % length

	if rotations < 0 {
		rotations += length
	}

	if direction == 0 { // Rotación a la izquierda
		*sequence = append((*sequence)[rotations:], (*sequence)[:rotations]...)
	} else if direction == 1 { // Rotación a la derecha
		*sequence = append((*sequence)[length-rotations:], (*sequence)[:length-rotations]...)
	} else {
		fmt.Println("Dirección no válida. Use 0 para izquierda o 1 para derecha.")
	}
}

func main() {
	// Solicitar la secuencia de elementos al usuario
	fmt.Println("Ingresa la secuencia de elementos (separados por comas):")
	reader := bufio.NewReader(os.Stdin)
	input, _ := reader.ReadString('\n')
	elements := strings.Split(strings.TrimSpace(input), ",")

	// Crear la secuencia original
	sequence := make([]interface{}, len(elements))
	for i, elem := range elements {
		sequence[i] = elem
	}

	// Solicitar la cantidad de rotaciones al usuario
	fmt.Println("Ingresa la cantidad de rotaciones:")
	var rotations int
	fmt.Scanln(&rotations)

	// Solicitar la dirección de rotación al usuario
	fmt.Println("Ingresa la dirección (0 = izq, 1 = der):")
	var direction int
	fmt.Scanln(&direction)

	// Realizar rotación
	rotateSequence(&sequence, rotations, direction)

	// Imprimir secuencia original y secuencia final rotada
	fmt.Println("Secuencia Original =", elements)
	fmt.Println("Secuencia final rotada =", sequence)
}
