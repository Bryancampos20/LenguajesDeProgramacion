package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func rotateSequence(sequence *[]interface{}, rotations int, direction int) {
	length := len(*sequence)
	rotations = rotations % length

	if rotations < 0 {
		rotations += length
	}

	if direction == 0 {
		*sequence = append((*sequence)[rotations:], (*sequence)[:rotations]...)
	} else if direction == 1 { 
		*sequence = append((*sequence)[length-rotations:], (*sequence)[:length-rotations]...)
	} else {
		fmt.Println("Dirección no válida. Use 0 para izquierda o 1 para derecha.")
	}
}

func main() {
	
	fmt.Println("Ingresa la secuencia de elementos (separados por comas):")
	reader := bufio.NewReader(os.Stdin)
	input, _ := reader.ReadString('\n')
	elements := strings.Split(strings.TrimSpace(input), ",")
	
	sequence := make([]interface{}, len(elements))
	for i, elem := range elements {
		sequence[i] = elem
	}
	
	fmt.Println("Ingresa la cantidad de rotaciones:")
	var rotations int
	fmt.Scanln(&rotations)

	
	fmt.Println("Ingresa la dirección (0 = izq, 1 = der):")
	var direction int
	fmt.Scanln(&direction)
	
	rotateSequence(&sequence, rotations, direction)

	fmt.Println("Secuencia Original =", elements)
	fmt.Println("Secuencia final rotada =", sequence)
}
